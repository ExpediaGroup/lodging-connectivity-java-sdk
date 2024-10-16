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
        @JvmStatic
        fun default(): ChainedHttpRequestInitializer =
            ChainedHttpRequestInitializer(
                buildList {
                    add(DisableInternalLoggingRequestInitializer())
                    add(AttachInterceptorRequestInitializer(HttpRequestLoggingInterceptor()))
                }
            )
    }

    override fun initialize(request: HttpRequest) {
        initializers.forEach { it.initialize(request) }
        request.responseInterceptor = HttpResponseLoggingInterceptor()
    }

    fun extend(vararg initializers: HttpRequestInitializer): ChainedHttpRequestInitializer =
        ChainedHttpRequestInitializer(initializers.toList() + this.initializers)

    fun extend(other: ChainedHttpRequestInitializer): ChainedHttpRequestInitializer =
        ChainedHttpRequestInitializer(this.initializers + other.initializers)
}