package com.expediagroup.sdk.core.authentication.bearer

import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.AsyncInterceptor
import java.util.concurrent.CompletableFuture

class BearerAuthenticationAsyncInterceptor(
    authManager: BearerAuthenticationAsyncManager
): AsyncInterceptor {

    private val helper = BearerAuthenticationInterceptorHelper(authManager)

    override fun intercept(chain: AsyncInterceptor.Chain): CompletableFuture<Response> {
        val request = chain.request()

        if (helper.isAuthenticationRequest(request)) {
            return chain.proceed(request)
        }

        helper.ensureValidAuthentication()

        val authorizedRequest = helper.addAuthorizationHeader(request)

        return chain.proceed(authorizedRequest)
    }
}
