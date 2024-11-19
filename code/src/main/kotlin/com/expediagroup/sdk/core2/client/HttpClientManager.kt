package com.expediagroup.sdk.core2.client

import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpResponse
import com.expediagroup.sdk.core2.interceptor.common.SDKInterceptor

abstract class HttpClientManager(val httpClient: HttpClient) {
    protected abstract val sdkInterceptors: List<SDKInterceptor>

    abstract fun execute(request: HttpRequest): HttpResponse
}
