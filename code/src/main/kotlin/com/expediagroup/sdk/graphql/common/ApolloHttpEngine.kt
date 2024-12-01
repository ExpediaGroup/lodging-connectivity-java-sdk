package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.http.HttpHeader
import com.apollographql.apollo.api.http.HttpMethod
import com.apollographql.apollo.exception.ApolloNetworkException
import com.apollographql.java.client.ApolloDisposable
import com.apollographql.java.client.network.http.HttpCallback
import com.apollographql.java.client.network.http.HttpEngine
import com.expediagroup.sdk.core.client.RequestExecutor
import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.http.Response
import java.io.IOException
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicBoolean
import okio.BufferedSink

class ApolloHttpEngine(
    private val requestExecutor: RequestExecutor
) : HttpEngine {
    private val activeRequests = ConcurrentHashMap<String, ApolloDisposable>()
    private val isDisposed = AtomicBoolean(false)

    override fun execute(request: ApolloHttpRequest, callback: HttpCallback, disposable: ApolloDisposable) {
        if (isDisposed.get()) {
            callback.onFailure(ApolloNetworkException("HTTP engine has been disposed"))
            return
        }

        val requestId = UUID.randomUUID().toString()
        activeRequests[requestId] = disposable

        try {
            validateRequest(request)
            val sdkResponse = requestExecutor.execute(buildSdkRequestFromApolloRequest(request))

            if (!isDisposed.get()) {
                callback.onResponse(buildApolloResponseFromSdkResponse(sdkResponse))
            }
        } catch (e: Exception) {
            callback.onFailure(ApolloNetworkException("Unexpected error occurred", e))
        } finally {
            activeRequests.remove(requestId)
        }
    }

    override fun dispose() {
        if (isDisposed.compareAndSet(false, true)) {
            activeRequests.values.forEach { it.dispose() }
            activeRequests.clear()
        }
    }

    private fun buildSdkRequestFromApolloRequest(apolloRequest: ApolloHttpRequest): Request {
        return Request.Builder()
            .url(apolloRequest.url)
            .apply {
                addSdkRequestHeadersFromApolloRequest(apolloRequest, this)
                addSdkRequestBodyFromApolloRequest(apolloRequest, this)
            }
            .build()
    }

    private fun buildApolloResponseFromSdkResponse(sdkHttpResponse: Response): ApolloHttpResponse {
        return ApolloHttpResponseBuilder(sdkHttpResponse.code).apply {
            addApolloResponseHeadersFromSdkResponse(sdkHttpResponse, this)
            addApolloResponseBodyFromSdkResponse(sdkHttpResponse, this)
        }.build()
    }

    private fun addSdkRequestHeadersFromApolloRequest(
        request: ApolloHttpRequest,
        sdkRequestBuilder: Request.Builder
    ) {
        request.headers.forEach { apolloHeader ->
            sdkRequestBuilder.addHeader(apolloHeader.name, apolloHeader.value)
        }
        sdkRequestBuilder.addHeader("Content-Type", "application/json")
    }

    private fun addSdkRequestBodyFromApolloRequest(request: ApolloHttpRequest, sdkRequestBuilder: Request.Builder) {
        if (request.method != HttpMethod.Post) {
            throw UnsupportedOperationException("Only POST requests are supported for GraphQL")
        }

        request.body?.let { requestBody ->
            sdkRequestBuilder.method("POST", object : RequestBody() {
                override fun contentType(): MediaType? = MediaType.parse(requestBody.contentType)
                override fun contentLength(): Long = requestBody.contentLength

                @Throws(IOException::class)
                override fun writeTo(sink: BufferedSink) = requestBody.writeTo(sink)
            })
        }
    }

    private fun addApolloResponseHeadersFromSdkResponse(
        sdkHttpResponse: Response,
        apolloHttpResponseBuilder: ApolloHttpResponseBuilder
    ) {
        sdkHttpResponse.headers.names().mapNotNull { headerName ->
            sdkHttpResponse.headers.get(headerName)?.let { headerValue ->
                HttpHeader(name = headerName, value = headerValue)
            }
        }.let {
            apolloHttpResponseBuilder.headers(it)
        }
    }

    private fun addApolloResponseBodyFromSdkResponse(
        sdkHttpResponse: Response,
        apolloHttpResponseBuilder: ApolloHttpResponseBuilder
    ) {
        sdkHttpResponse.body?.let {
            apolloHttpResponseBuilder.body(it.source())
        }
    }

    private fun validateRequest(request: ApolloHttpRequest) {
        require(request.url.isNotBlank()) { "Request URL cannot be blank" }
        require(request.method == HttpMethod.Post) { "Only POST requests are supported for GraphQL" }
    }
}
