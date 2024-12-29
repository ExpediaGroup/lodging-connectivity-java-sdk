package com.expediagroup.sdk.authentication.bearer

import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.exception.service.ExpediaGroupAuthException
import java.io.IOException

class BearerAuthenticationInterceptorHelper(private val authManager: AbstractBearerAuthenticationManager) {
    private val lock = Any()

    /**
     * Checks if the given request is for authentication.
     */
    fun isAuthenticationRequest(request: Request): Boolean = request.url.toString() == authManager.authUrl

    /**
     * Ensures there is a valid authentication token available.
     * If needed, authenticates under a synchronization lock to prevent multiple simultaneous authentications.
     *
     * @throws ExpediaGroupAuthException If authentication fails
     */
    fun ensureValidAuthentication() {
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

    fun addAuthorizationHeader(request: Request): Request = request.newBuilder()
        .addHeader("Authorization", authManager.getAuthorizationHeaderValue())
        .build()
}
