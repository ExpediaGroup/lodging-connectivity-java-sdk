package com.expediagroup.sdk.core.common

import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor

class UserAgentHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .setHeader("User-Agent", MetadataLoader.asUserAgentString())
            .build()

        return chain.proceed(request)
    }
}
