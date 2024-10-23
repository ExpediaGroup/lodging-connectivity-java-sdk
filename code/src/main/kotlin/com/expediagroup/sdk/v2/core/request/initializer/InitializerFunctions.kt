package com.expediagroup.sdk.v2.core.request.initializer

import com.expediagroup.sdk.v2.core.request.interceptor.HttpRequestLoggingInterceptor
import com.expediagroup.sdk.v2.core.request.interceptor.HttpResponseLoggingInterceptor
import com.google.api.client.http.HttpRequest

object InitializerFunctions {
    val disableInternalLogging = fun (request: HttpRequest) {
        request.isCurlLoggingEnabled = false
        request.isLoggingEnabled = false
    }

    val attachDefaultRequestLoggingInterceptor = fun (request: HttpRequest) {
        request.interceptor = HttpRequestLoggingInterceptor()
    }

    val attachDefaultResponseLoggingInterceptor = fun (request: HttpRequest) {
        request.responseInterceptor = HttpResponseLoggingInterceptor()
    }
}
