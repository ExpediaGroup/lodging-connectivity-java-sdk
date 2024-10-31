package com.expediagroup.sdk.core.request.initializer

import com.expediagroup.sdk.core.request.interceptor.HttpRequestLoggingInterceptor
import com.expediagroup.sdk.core.request.interceptor.HttpResponseLoggingInterceptor
import com.google.api.client.http.HttpRequest

object InitializerFunctions {
    val disableInternalLogging = fun (request: HttpRequest) {
        request.isCurlLoggingEnabled = false
        request.isLoggingEnabled = false
    }

    val attachDefaultRequestLoggingInterceptor = fun (request: HttpRequest) {
        request.interceptor = com.expediagroup.sdk.core.request.interceptor.HttpRequestLoggingInterceptor()
    }

    val attachDefaultResponseLoggingInterceptor = fun (request: HttpRequest) {
        request.responseInterceptor = HttpResponseLoggingInterceptor()
    }
}
