package com.expediagroup.sdk.core.request.initializer

import com.google.api.client.http.HttpRequest
import com.google.api.client.http.HttpRequestInitializer

class SdkRequestInitializer(
    vararg functions: (HttpRequest) -> Unit
) : HttpRequestInitializer {
    private val functions: Array<(HttpRequest) -> Unit> = arrayOf(*functions)

    companion object {
        fun default(): SdkRequestInitializer = SdkRequestInitializer(
            InitializerFunctions.attachDefaultRequestLoggingInterceptor,
            InitializerFunctions.attachDefaultResponseLoggingInterceptor,
            InitializerFunctions.disableInternalLogging,
        )
    }

    override fun initialize(request: HttpRequest) {
        functions.forEach { function -> function(request) }
    }

    fun add(vararg initializers: HttpRequestInitializer): SdkRequestInitializer =
        SdkRequestInitializer(*functions, *initializers.map { it::initialize }.toTypedArray())

    fun add(vararg initializers: SdkRequestInitializer): SdkRequestInitializer =
        SdkRequestInitializer(*functions, *initializers.map { it::initialize }.toTypedArray())
}
