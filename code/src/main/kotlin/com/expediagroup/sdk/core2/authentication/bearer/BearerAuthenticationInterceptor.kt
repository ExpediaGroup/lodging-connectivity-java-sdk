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

package com.expediagroup.sdk.core2.authentication.bearer

import com.expediagroup.sdk.core2.authentication.common.Credentials
import com.expediagroup.sdk.core2.client.HttpClientAdapter
import com.expediagroup.sdk.core2.http.HttpResponse
import com.expediagroup.sdk.core2.interceptor.Interceptor
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
 * @param httpClientAdapter The [HttpClientAdapter] used for making authentication requests.
 * @param authUrl The URL of the authentication endpoint used to retrieve bearer tokens.
 * @param credentials The [Credentials] required for authentication.
 */
class BearerAuthenticationInterceptor(
    httpClientAdapter: HttpClientAdapter,
    private val authUrl: String,
    credentials: Credentials
) : Interceptor {
    private val bearerAuthenticationManager = BearerAuthenticationManager(httpClientAdapter, authUrl, credentials)
    private val lock = Any()

    /**
     * Intercepts the HTTP request, adding a bearer token to the `Authorization` header.
     *
     * This method checks if the token is about to expire and refreshes it if necessary. It excludes
     * requests targeting the `authUrl` from this behavior to avoid recursive authentication requests.
     *
     * @param chain The [Interceptor.Chain] responsible for managing the request and its progression.
     * @return The [HttpResponse] resulting from the executed request.
     * @throws IOException If an error occurs during token retrieval or request execution.
     */
    override fun intercept(chain: Interceptor.Chain): HttpResponse {
        val request = chain.request()

        if (request.url.toString() == authUrl) {
            return chain.proceed(request)
        }

        try {
            if (bearerAuthenticationManager.isTokenAboutToExpire()) {
                synchronized(lock) {
                    if (bearerAuthenticationManager.isTokenAboutToExpire()) {
                        bearerAuthenticationManager.authenticate()
                    }
                }
            }
        } catch (e: IOException) {
            throw IOException("Failed to authenticate", e)
        }

        val authorizedRequest = request.newBuilder()
            .addHeader("Authorization", bearerAuthenticationManager.getTokenAsAuthorizationHeaderValue())
            .build()

        return chain.proceed(authorizedRequest)
    }
}
