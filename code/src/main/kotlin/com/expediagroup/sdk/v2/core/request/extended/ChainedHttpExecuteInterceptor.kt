package com.expediagroup.sdk.v2.core.request.extended

import com.google.api.client.http.HttpExecuteInterceptor
import com.google.api.client.http.HttpRequest

class ChainedHttpExecuteInterceptor(
    private var interceptors: List<HttpExecuteInterceptor> = emptyList()
): HttpExecuteInterceptor {
    override fun intercept(request: HttpRequest?) {
        interceptors.forEach { it.intercept(request) }
        this.extend(ChainedHttpExecuteInterceptor(), ChainedHttpExecuteInterceptor(), ChainedHttpExecuteInterceptor())
    }

    fun extend(vararg interceptors: HttpExecuteInterceptor) = ChainedHttpExecuteInterceptor(
        interceptors.toList().plus(this.interceptors)
    )
}