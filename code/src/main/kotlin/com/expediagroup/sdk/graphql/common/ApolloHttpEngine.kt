package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.http.HttpHeader
import com.apollographql.apollo.api.http.HttpMethod
import com.apollographql.apollo.exception.ApolloNetworkException
import com.apollographql.java.client.ApolloDisposable
import com.apollographql.java.client.network.http.HttpCallback
import com.apollographql.java.client.network.http.HttpEngine
import com.expediagroup.sdk.core.client.HttpClientExecutor
import com.expediagroup.sdk.core.http.HttpRequest
import com.expediagroup.sdk.core.http.HttpRequestBody
import com.expediagroup.sdk.core.http.HttpResponse
import com.expediagroup.sdk.core.http.MediaType
import java.io.IOException
import okio.BufferedSink

class ApolloHttpEngine(private val httpClientExecutor: HttpClientExecutor) : HttpEngine {
    override fun execute(request: ApolloHttpRequest, callback: HttpCallback, disposable: ApolloDisposable) {
        try {
            val sdkResponse = httpClientExecutor.execute(buildSdkRequestFromApolloRequest(request))
            callback.onResponse(buildApolloResponseFromSdkResponse(sdkResponse))
        } catch (e: Exception) {
            callback.onFailure(ApolloNetworkException(platformCause = e))
        }
    }

    override fun dispose() {
        TODO("Not yet implemented")
    }

    private fun buildSdkRequestFromApolloRequest(apolloRequest: ApolloHttpRequest): HttpRequest {
        return HttpRequest.Builder()
            .url(apolloRequest.url)
            .let {
                addSdkRequestHeadersFromApolloRequest(apolloRequest, it)
                addSdkRequestBodyFromApolloRequest(apolloRequest, it)
                it.build()
            }
    }

    private fun buildApolloResponseFromSdkResponse(sdkHttpResponse: HttpResponse): ApolloHttpResponse {
        return ApolloHttpResponseBuilder(sdkHttpResponse.code).let {
            addApolloResponseHeadersFromSdkResponse(sdkHttpResponse, it)
            addApolloResponseBodyFromSdkResponse(sdkHttpResponse, it)
            it.build()
        }
    }

    private fun addSdkRequestHeadersFromApolloRequest(
        request: ApolloHttpRequest,
        sdkRequestBuilder: HttpRequest.Builder
    ) {
        request.headers.forEach { apolloHeader ->
            sdkRequestBuilder.addHeader(apolloHeader.name, apolloHeader.value)
        }
        sdkRequestBuilder.addHeader("Content-Type", "application/json")
    }

    private fun addSdkRequestBodyFromApolloRequest(request: ApolloHttpRequest, sdkRequestBuilder: HttpRequest.Builder) {
        if (request.method != HttpMethod.Post) return // GraphQL request are POST requests (conventionally)

        request.body?.let { requestBody ->
            sdkRequestBuilder.method("POST", object : HttpRequestBody() {
                override fun contentType(): MediaType? {
                    return MediaType.parse(requestBody.contentType)
                }

                override fun contentLength(): Long {
                    return requestBody.contentLength
                }

                @Throws(IOException::class)
                override fun writeTo(sink: BufferedSink) {
                    requestBody.writeTo(sink)
                }
            })
        }
    }

    private fun addApolloResponseHeadersFromSdkResponse(
        sdkHttpResponse: HttpResponse,
        apolloHttpResponseBuilder: ApolloHttpResponseBuilder
    ) {
        sdkHttpResponse.headers.names().map {
            HttpHeader(name = it, value = sdkHttpResponse.headers.get(it) ?: "")
        }.also {
            apolloHttpResponseBuilder.headers(it)
        }
    }

    private fun addApolloResponseBodyFromSdkResponse(
        sdkHttpResponse: HttpResponse,
        apolloHttpResponseBuilder: ApolloHttpResponseBuilder
    ) {
        sdkHttpResponse.body?.let {
            apolloHttpResponseBuilder.body(it.source())
        }
    }
}
