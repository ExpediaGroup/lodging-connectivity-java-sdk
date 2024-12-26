package com.expediagroup.sdk.core.authentication.bearer

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException
import java.io.IOException
import java.util.concurrent.CompletableFuture

class BearerAuthenticationInterceptor(
    private val authManager: BearerAuthenticationManager
) : Interceptor {
    private val lock = Any()


    override fun intercept(chain: Interceptor.Chain): CompletableFuture<Response> {
        val request = chain.request()

        if (isAuthenticationRequest(request)) {
            return chain.proceed(request)
        }

        ensureValidAuthentication()

        val authorizedRequest = request.newBuilder()
            .addHeader("Authorization", authManager.getAuthorizationHeaderValue())
            .build()

        return chain.proceed(authorizedRequest)
    }

    /**
     * Checks if the given request is for authentication.
     */
    private fun isAuthenticationRequest(request: Request): Boolean = request.url.toString() == authManager.authUrl

    /**
     * Ensures there is a valid authentication token available.
     * If needed, authenticates under a synchronization lock to prevent multiple simultaneous authentications.
     *
     * @throws ExpediaGroupAuthException If authentication fails
     */
    private fun ensureValidAuthentication() {
        try {
            if (authManager.isTokenAboutToExpire()) {
                synchronized(lock) {
                    if (authManager.isTokenAboutToExpire()) {
                        authManager.authenticate()
                    }
                }
            }
        } catch (e: IOException) {
            throw ExpediaGroupAuthException("Failed to authenticate", e)
        }
    }
}
