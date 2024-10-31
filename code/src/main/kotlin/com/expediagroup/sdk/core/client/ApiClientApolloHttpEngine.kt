package com.expediagroup.sdk.core.client

import com.apollographql.apollo.api.http.HttpHeader
import com.apollographql.apollo.api.http.HttpRequest
import com.apollographql.apollo.api.http.HttpResponse
import com.apollographql.apollo.exception.ApolloNetworkException
import com.apollographql.java.client.ApolloDisposable
import com.apollographql.java.client.network.http.HttpCallback
import com.apollographql.java.client.network.http.HttpEngine
import com.expediagroup.sdk.core.request.Request
import com.google.api.client.http.HttpHeaders
import okio.buffer
import okio.source


/**
 * Implementation of the `HttpEngine` interface that uses an `ApiClient` instance to execute HTTP requests.
 *
 * @constructor Creates an `ApiClientApolloHttpEngine` with the specified `ApiClient`.
 *
 * @param client The instance of `ApiClient` used to execute the HTTP requests.
 */
class ApiClientApolloHttpEngine(
    private val client: ApiClient
) : HttpEngine {
    /**
     * Executes an HTTP request using the provided `ApiClient` and handles the response or failure via the specified callback.
     *
     * @param request The GraphQL HTTP request containing method, URL, body, and headers.
     * @param callback The callback to handle the HTTP response or failure.
     * @param disposable The disposable resource associated with the request, allowing cancellation if necessary.
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
            callback.onFailure(ApolloNetworkException(platformCause = e))
        }
    }

    /**
     * Disposes of any resources held by the `ApiClientApolloHttpEngine`.
     *
     * This implementation is a no-op as there are no resources to be disposed of in this class.
     * Typically, this method would be used to clean up resources, such as closing network connections.
     */
    override fun dispose() {
        // no-op
    }

    /**
     * Converts `HttpHeaders` into a list of `HttpHeader` objects.
     *
     * This method iterates through the key-value pairs in the `HttpHeaders`, converting each key-value pair
     * into `HttpHeader` instances.
     * If the value is an `Iterable`, each item is used to create an `HttpHeader`.
     * Otherwise, a single `HttpHeader` with the value is created.
     *
     * @return A list of `HttpHeader` objects.
     */
    private fun HttpHeaders.toApolloHeaders(): List<HttpHeader> {
        val self = this@toApolloHeaders

        return buildList {
            self.forEach { key, value ->
                when (value) {
                    is Iterable<*> -> this.addAll(value.map { HttpHeader(key, value.toString()) })
                    else -> this.add(HttpHeader(key, value.toString()))
                }
            }
        }
    }
}
