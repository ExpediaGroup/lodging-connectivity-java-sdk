package com.expediagroup.sdk.v2.core.client

import com.apollographql.apollo.api.http.HttpRequest
import com.apollographql.apollo.api.http.HttpResponse
import com.apollographql.apollo.exception.ApolloNetworkException
import com.apollographql.java.client.ApolloDisposable
import com.apollographql.java.client.network.http.HttpCallback
import com.apollographql.java.client.network.http.HttpEngine
import com.expediagroup.sdk.v2.core.request.Request
import com.expediagroup.sdk.v2.core.client.util.toApolloHeaders
import okio.buffer
import okio.source


class ApiClientApolloHttpEngine(
    private val client: ApiClient
) : HttpEngine {
    override fun execute(request: HttpRequest, callback: HttpCallback, disposable: ApolloDisposable) {
        try {
            Request(
                client,
                graphQLRequest = request,
                responseType = Any::class.java
            ).executeUnparsed().let { response ->
                HttpResponse.Builder(statusCode = response.statusCode).apply {
                    body(response.content.source().buffer())
                    headers(response.headers.toApolloHeaders())
                }.also {
                    callback.onResponse(it.build())
                }
            }
        } catch (e: Exception) {
            callback.onFailure(ApolloNetworkException(e.message, e))
        }
    }

    override fun dispose() {
        // no-op
    }
}
