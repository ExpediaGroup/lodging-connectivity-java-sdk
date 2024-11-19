package com.expediagroup.sdk.core2.interceptor.common

import com.expediagroup.sdk.core2.client.HttpClient
import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpResponse

class InterceptorChainExecutor(
    private val sdkInterceptors: List<SDKInterceptor>,
    private val index: Int = 0,
    private val request: HttpRequest,
    private val httpClient: HttpClient
) : SDKInterceptor.Chain {

    override fun request(): HttpRequest = request

    override fun proceed(request: HttpRequest): HttpResponse {
        return if (index < sdkInterceptors.size) {
            val next = InterceptorChainExecutor(sdkInterceptors, index + 1, request, httpClient)
            val interceptor = sdkInterceptors[index]
            interceptor.intercept(next)
        } else {
            httpClient.execute(request)
        }
    }
}
