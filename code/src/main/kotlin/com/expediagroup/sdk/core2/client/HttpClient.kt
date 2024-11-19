package com.expediagroup.sdk.core2.client

import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpResponse
import java.io.IOException

/**
 * Interface representing an HTTP client wrapper that can be implemented to integrate custom HTTP client libraries
 * with the SDK.
 *
 * This interface allows users to plug in their own HTTP client implementation by providing a method to execute HTTP
 * requests and return responses in a format compatible with the SDK. It abstracts away the specifics of the HTTP
 * client being used, enabling flexibility and customization.
 */
interface HttpClient {
    /**
     * Executes the given HTTP request and returns the corresponding HTTP response.
     *
     * Users implementing this method are responsible for converting their HTTP client's request/response model
     * into the SDK [HttpRequest] and [HttpResponse] abstractions. This ensures compatibility with the SDK
     * networking layer.
     *
     * @param request The [HttpRequest] to be executed, representing the HTTP request to be sent.
     * @return The [HttpResponse] resulting from the execution of the request, representing the HTTP response received.
     * @throws IOException If an I/O error occurs during request execution.
     */
    @Throws(IOException::class)
    fun execute(request: HttpRequest): HttpResponse
}
