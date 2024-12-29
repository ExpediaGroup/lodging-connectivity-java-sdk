package com.expediagroup.sdk.authentication.bearer

import com.expediagroup.sdk.http.Response
import com.expediagroup.sdk.interceptor.AsyncInterceptor
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
