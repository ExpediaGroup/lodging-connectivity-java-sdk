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


/**
 * Implementation of the `HttpEngine` interface that uses an `ApiClient` instance to execute HTTP requests.
 *
 * This class provides a method to execute HTTP requests and handle the response or any exceptions that
 * might occur during the request lifecycle. It leverages the `ApiClient` to configure and send the requests.
 *
 * @constructor Creates an `ApiClientApolloHttpEngine` with the specified `ApiClient`.
 *
 * @param client The instance of `ApiClient` used to execute the HTTP requests.
 */
class ApiClientApolloHttpEngine(
    private val client: ApiClient
) : HttpEngine {
    /**
     * Executes the provided HTTP request using the given `HttpClient` instance and handles the response or exceptions.
     *
     * @param request The HTTP request to be executed.
     * @param callback The callback to handle the response or errors.
     * @param disposable The disposable to be used for request cleanup.
     */
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

    /**
     * Disposes of any resources associated with the `ApiClientApolloHttpEngine`.
     *
     * This method is currently a no-op, but it can be overridden by subclasses to
     * release any resources or perform other cleanup operations when the engine
     * is no longer needed.
     */
    override fun dispose() {
        // no-op
    }
}
