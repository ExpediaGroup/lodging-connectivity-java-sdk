package com.expediagroup.sdk.v2.core.request.extended

import com.google.api.client.http.HttpExecuteInterceptor
import com.google.api.client.http.HttpRequest

/**
 * ChainedHttpExecuteInterceptor is an implementation of HttpExecuteInterceptor
 * that allows chaining multiple HttpExecuteInterceptor instances in sequence.
 *
 * @constructor Creates a ChainedHttpExecuteInterceptor with an optional list of interceptors.
 * @param interceptors Initial list of HttpExecuteInterceptor instances to be chained.
 */
class ChainedHttpExecuteInterceptor(
    private var interceptors: List<HttpExecuteInterceptor> = emptyList()
): HttpExecuteInterceptor {
    /**
     * Intercepts the given HTTP request by sequentially applying
     * each interceptor in the chain and extends the chain with
     * three new instances of `ChainedHttpExecuteInterceptor`.
     *
     * @param request The HTTP request to be intercepted.
     */
    override fun intercept(request: HttpRequest?) {
        interceptors.forEach { it.intercept(request) }
    }

    /**
     * Adds the provided HttpExecuteInterceptor instances to the existing chain of interceptors.
     *
     * @param interceptors Variable number of HttpExecuteInterceptor instances to be added to the chain.
     * @return New instance of ChainedHttpExecuteInterceptor with the combined list of interceptors.
     */
    fun extend(vararg interceptors: HttpExecuteInterceptor) = ChainedHttpExecuteInterceptor(
        interceptors.toList().plus(this.interceptors)
    )
}
