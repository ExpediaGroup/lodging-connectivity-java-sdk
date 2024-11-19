package com.expediagroup.sdk.core2.interceptor.common

import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpResponse
import java.io.IOException

/**
 * Represents an interceptor for modifying or augmenting HTTP requests and responses within the SDK.
 *
 * An `SDKInterceptor` allows pre-processing of requests and post-processing of responses as they pass
 * through the HTTP execution pipeline. This can be used for various purposes such as logging, authentication,
 * retry logic, or adding custom headers.
 */
interface SDKInterceptor {
    /**
     * Intercepts an HTTP request and optionally modifies it or processes its corresponding response.
     *
     * Implementations of this method can inspect and modify the request before it is sent, or inspect
     * and modify the response after it is received. The request is forwarded to the next interceptor in the chain
     * by calling [Chain.proceed].
     *
     * @param chain The [Chain] containing the request to process and the logic to continue the chain.
     * @return The [HttpResponse] resulting from the processed request.
     * @throws IOException If an I/O error occurs during request execution or interception.
     */
    @Throws(IOException::class)
    fun intercept(chain: Chain): HttpResponse

    /**
     * Represents a chain of interceptors and the ability to proceed with an HTTP request.
     *
     * Each interceptor in the chain can call [proceed] to pass the request to the next interceptor or
     * handle the request and response directly.
     */
    interface Chain {
        /**
         * Retrieves the current HTTP request.
         *
         * @return The [HttpRequest] that is currently being processed.
         */
        fun request(): HttpRequest

        /**
         * Proceeds with the HTTP request, invoking the next interceptor in the chain or the final request execution.
         *
         * Interceptors use this method to pass the request down the chain. The returned response
         * is the result of either the next interceptor or the HTTP client execution.
         *
         * @param request The [HttpRequest] to proceed with.
         * @return The [HttpResponse] resulting from the request execution.
         * @throws IOException If an I/O error occurs during request execution.
         */
        @Throws(IOException::class)
        fun proceed(request: HttpRequest): HttpResponse
    }
}
