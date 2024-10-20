package com.expediagroup.sdk.v2.core.request.extended

import com.expediagroup.sdk.v2.core.request.initializer.AttachInterceptorRequestInitializer
import com.expediagroup.sdk.v2.core.request.initializer.DisableInternalLoggingRequestInitializer
import com.expediagroup.sdk.v2.core.request.interceptor.HttpRequestLoggingInterceptor
import com.expediagroup.sdk.v2.core.request.interceptor.HttpResponseLoggingInterceptor
import com.google.api.client.http.HttpRequest
import com.google.api.client.http.HttpRequestInitializer

/**
 * A composite HttpRequestInitializer that chains multiple initializers together.
 *
 * This class allows combining multiple HttpRequestInitializer instances and applying them sequentially to a request.
 * It also adds an HttpResponseLoggingInterceptor to the request to log HTTP responses.
 *
 * @property initializers The list of HttpRequestInitializer instances to be chained.
 */
class ChainedHttpRequestInitializer(
    private val initializers: List<HttpRequestInitializer> = emptyList(),
) : HttpRequestInitializer {
    companion object {
        /**
         * Provides a default instance of `ChainedHttpRequestInitializer` with specific initializers.
         *
         * This method constructs a `ChainedHttpRequestInitializer` containing:
         * - `DisableInternalLoggingRequestInitializer` to disable internal logging
         * - `AttachInterceptorRequestInitializer` with `HttpRequestLoggingInterceptor` to log HTTP requests
         *
         * @return A default `ChainedHttpRequestInitializer` instance initialized with predefined initializers.
         */
        @JvmStatic
        fun default(): ChainedHttpRequestInitializer =
            ChainedHttpRequestInitializer(
                buildList {
                    add(DisableInternalLoggingRequestInitializer())
                    add(AttachInterceptorRequestInitializer(HttpRequestLoggingInterceptor()))
                }
            )
    }

    /**
     * Initializes the given HttpRequest by applying a series of initializers and sets a logging interceptor for HTTP responses.
     *
     * @param request The HttpRequest object to be initialized.
     */
    override fun initialize(request: HttpRequest) {
        initializers.forEach { it.initialize(request) }
        request.responseInterceptor = HttpResponseLoggingInterceptor()
    }

    /**
     * Extends the current `ChainedHttpRequestInitializer` with additional initializers.
     *
     * @param initializers Vararg of `HttpRequestInitializer` instances to be added.
     * @return A new `ChainedHttpRequestInitializer` that includes the provided initializers and the existing ones.
     */
    fun extend(vararg initializers: HttpRequestInitializer): ChainedHttpRequestInitializer =
        ChainedHttpRequestInitializer(initializers.toList() + this.initializers)

    /**
     * Extends the current `ChainedHttpRequestInitializer` with another `ChainedHttpRequestInitializer`.
     *
     * @param other An instance of `ChainedHttpRequestInitializer` whose initializers will be added to the current one.
     * @return A new `ChainedHttpRequestInitializer` containing the combined initializers.
     */
    fun extend(other: ChainedHttpRequestInitializer): ChainedHttpRequestInitializer =
        ChainedHttpRequestInitializer(this.initializers + other.initializers)
}