package com.expediagroup.sdk.core.interceptor

import com.expediagroup.sdk.core.client.AsyncTransport
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import java.util.concurrent.CompletableFuture

class AsyncInterceptorsChainExecutor(
    private val asyncTransport: AsyncTransport,
    private val interceptors: List<AsyncInterceptor>,
    private var index: Int = 0,
    private var request: Request
) : AsyncInterceptor.Chain {

    /**
     * Retrieves the current [Request] being processed by the chain.
     *
     * @return The current [Request].
     */
    override fun request(): Request = request

    /**
     * Proceeds with the HTTP request asynchronously by invoking the next [AsyncInterceptor] in the chain or
     * executing the final request through the [AsyncTransport] if all interceptors have been processed.
     *
     * Each interceptor in the chain can modify the request or response as needed. If this is the last
     * interceptor, the request is passed to the [AsyncTransport] for actual execution.
     *
     * @param request The [Request] to proceed with.
     * @return A [CompletableFuture] representing the [Response] resulting from the next interceptor
     * or the final HTTP client execution.
     */
    override fun proceed(request: Request): CompletableFuture<Response> {
        this.request = request

        // If all interceptors are processed, execute the request using the transport
        if (index >= interceptors.size) {
            return asyncTransport.execute(request)
        }

        // Get the next interceptor in the chain and proceed asynchronously
        val interceptor = interceptors[index++]
        return interceptor.interceptAsync(this)
    }
}