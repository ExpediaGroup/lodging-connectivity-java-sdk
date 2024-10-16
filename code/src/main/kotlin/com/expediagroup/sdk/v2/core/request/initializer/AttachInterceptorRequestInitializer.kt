package com.expediagroup.sdk.v2.core.request.initializer

import com.expediagroup.sdk.v2.core.request.extended.ChainedHttpExecuteInterceptor
import com.google.api.client.http.HttpExecuteInterceptor
import com.google.api.client.http.HttpRequest
import com.google.api.client.http.HttpRequestInitializer

class AttachInterceptorRequestInitializer(private val interceptor: HttpExecuteInterceptor) :
    HttpRequestInitializer {
    override fun initialize(request: HttpRequest) {
        request.interceptor = when(request.interceptor) {
            is ChainedHttpExecuteInterceptor -> (request.interceptor as ChainedHttpExecuteInterceptor).extend(interceptor)
            else -> ChainedHttpExecuteInterceptor().extend(interceptor)
        }
    }
}