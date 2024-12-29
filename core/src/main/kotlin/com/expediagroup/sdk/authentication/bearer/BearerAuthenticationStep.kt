package com.expediagroup.sdk.authentication.bearer

import com.expediagroup.sdk.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.transport.RequestPipelineStep
import java.io.IOException

class BearerAuthenticationStep(
    private val authenticationManager: AbstractBearerAuthenticationManager,
) : RequestPipelineStep {
    private val lock = Any()

    override fun invoke(request: Request): Request {
        ensureValidAuthentication()
        return addAuthorizationHeader(request)
    }

    private fun ensureValidAuthentication() {
        try {
            if (authenticationManager.isTokenAboutToExpire()) {
                synchronized(lock) {
                    if (authenticationManager.isTokenAboutToExpire()) {
                        authenticationManager.authenticate()
                    }
                }
            }
        } catch (e: IOException) {
            throw ExpediaGroupAuthException("Failed to authenticate", e)
        }
    }

    private fun addAuthorizationHeader(request: Request): Request = request.newBuilder()
        .addHeader("Authorization", authenticationManager.getAuthorizationHeaderValue())
        .build()
}