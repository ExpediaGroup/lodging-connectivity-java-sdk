/*
 * Copyright (C) 2024 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.core.authentication.bearer

import com.expediagroup.sdk.core.authentication.common.Credentials
import com.expediagroup.sdk.core.client.Transport
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException
import java.io.IOException

/**
 * An interceptor that handles bearer token-based authentication for HTTP requests.
 *
 * This interceptor ensures that an up-to-date bearer token is added to the `Authorization` header of each HTTP request.
 * It manages token expiration and re-authentication automatically. If the token is about to expire, the interceptor
 * synchronously refreshes it before proceeding with the request.
 *
 * Requests to the `authUrl` (authentication endpoint) are excluded from this behavior to prevent recursive authentication loops.
 *
 * @param transport The [Transport] used for making authentication requests.
 * @param authUrl The URL of the authentication endpoint used to retrieve bearer tokens.
 * @param credentials The [Credentials] required for authentication.
 */
class BearerAuthenticationInterceptor(
    transport: Transport,
    private val authUrl: String,
    credentials: Credentials
) : Interceptor {
    private val bearerAuthenticationManager = BearerAuthenticationManager(transport, authUrl, credentials)
    private val lock = Any()

    /**
     * Intercepts the HTTP request, adding a bearer token to the `Authorization` header.
     *
     * This method checks if the token needs to be refreshed and does so if necessary. It excludes
     * requests targeting the `authUrl` from this behavior to avoid recursive authentication requests.
     *
     * @param chain The [Interceptor.Chain] responsible for managing the request and its progression.
     * @return The [Response] resulting from the executed request.
     * @throws ExpediaGroupAuthException If authentication fails due to invalid credentials or server errors
     */
    @Throws(ExpediaGroupAuthException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        if (isAuthenticationRequest(request)) {
            return chain.proceed(request)
        }

        ensureValidAuthentication()

        val authorizedRequest = request.newBuilder()
            .addHeader("Authorization", bearerAuthenticationManager.getAuthorizationHeaderValue())
            .build()

        return chain.proceed(authorizedRequest)
    }

    /**
     * Checks if the given request is for authentication.
     */
    private fun isAuthenticationRequest(request: Request): Boolean = request.url.toString() == authUrl

    /**
     * Ensures there is a valid authentication token available.
     * If needed, authenticates under a synchronization lock to prevent multiple simultaneous authentications.
     *
     * @throws ExpediaGroupAuthException If authentication fails
     */
    private fun ensureValidAuthentication() {
        try {
            if (bearerAuthenticationManager.needsAuthentication()) {
                synchronized(lock) {
                    if (bearerAuthenticationManager.needsAuthentication()) {
                        bearerAuthenticationManager.authenticate()
                    }
                }
            }
        } catch (e: IOException) {
            throw ExpediaGroupAuthException("Failed to authenticate", e)
        }
    }
}
