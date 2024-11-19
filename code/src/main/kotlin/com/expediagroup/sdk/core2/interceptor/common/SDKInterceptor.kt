package com.expediagroup.sdk.core2.interceptor.common

import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpResponse
import java.io.IOException

interface SDKInterceptor {
    @Throws(IOException::class)
    fun intercept(chain: Chain): HttpResponse

    interface Chain {
        fun request(): HttpRequest

        @Throws(IOException::class)
        fun proceed(request: HttpRequest): HttpResponse
    }
}
