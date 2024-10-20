package com.expediagroup.sdk.v2.core.request.initializer

import com.expediagroup.sdk.v2.core.request.extended.ChainedHttpExecuteInterceptor
import com.google.api.client.http.HttpExecuteInterceptor
import com.google.api.client.http.HttpRequest
import com.google.api.client.http.HttpRequestInitializer

/**
 * AttachInterceptorRequestInitializer is an implementation of HttpRequestInitializer
 * that attaches a given HttpExecuteInterceptor to an HTTP request's existing interceptor.
 *
 * @param interceptor The HttpExecuteInterceptor to be attached to the request.
 *
 * If the request already has a ChainedHttpExecuteInterceptor, the provided interceptor
 * is added to the existing chain. Otherwise, a new ChainedHttpExecuteInterceptor is created
 * and the provided interceptor is added to it.
 */
class AttachInterceptorRequestInitializer(private val interceptor: HttpExecuteInterceptor) :
    HttpRequestInitializer {
    override fun initialize(request: HttpRequest) {
        request.interceptor = when(request.interceptor) {
            is ChainedHttpExecuteInterceptor -> (request.interceptor as ChainedHttpExecuteInterceptor).extend(interceptor)
            else -> ChainedHttpExecuteInterceptor().extend(interceptor)
        }
    }
}