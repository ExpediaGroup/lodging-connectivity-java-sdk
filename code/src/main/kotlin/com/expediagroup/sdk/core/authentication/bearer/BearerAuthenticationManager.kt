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

import com.expediagroup.sdk.core.authentication.common.AuthenticationManager
import com.expediagroup.sdk.core.authentication.common.Credentials
import com.expediagroup.sdk.core.client.RequestExecutor
import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupResponseParsingException
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException

/**
 * Manages bearer token authentication for HTTP requests.
 *
 * The `BearerAuthenticationManager` handles the lifecycle of bearer tokens, including retrieval, storage,
 * and validation. It interacts with an authentication server to fetch tokens using client credentials,
 * ensures tokens are refreshed when necessary, and provides them in the required format for authorization headers.
 *
 * @param requestExecutor The [RequestExecutor] used to execute authentication requests.
 * @param authUrl The URL of the authentication server's endpoint to obtain bearer tokens.
 * @param credentials The [Credentials] containing the client key and secret used for authentication.
 */
class BearerAuthenticationManager(
    val authUrl: String,
    private val requestExecutor: RequestExecutor,
    private val credentials: Credentials,
) : AuthenticationManager {

    @Volatile
    private var bearerTokenStorage = BearerTokenStorage.empty

    /**
     * Initiates authentication to obtain a new bearer token.
     *
     * This method sends a request to the authentication server, parses the response, and
     * stores the token for future use.
     *
     * @throws ExpediaGroupAuthException If the authentication request fails.
     * @throws ExpediaGroupResponseParsingException If the response cannot be parsed.
     */
    override fun authenticate() {
        clearAuthentication()
            .let {
                buildAuthenticationRequest()
            }.let {
                executeAuthenticationRequest(it)
            }.let {
                TokenResponse.parse(it)
            }.also {
                storeToken(it)
            }
    }

    /**
     * Checks if the current bearer token is about to expire and needs renewal.
     *
     * @return `true` if the token is near expiration, `false` otherwise.
     */
    fun isTokenAboutToExpire(): Boolean = run {
        bearerTokenStorage.isAboutToExpire()
    }

    /**
     * Clears the stored authentication token.
     *
     * This method resets the internal token storage, effectively invalidating the current session.
     */
    override fun clearAuthentication() = run {
        bearerTokenStorage = BearerTokenStorage.empty
    }

    /**
     * Retrieves the stored token formatted as an `Authorization` header value.
     *
     * @return The token in the format `Bearer <token>` for use in HTTP headers.
     */
    fun getAuthorizationHeaderValue(): String = run {
        bearerTokenStorage.getAuthorizationHeaderValue()
    }

    /**
     * Creates an HTTP request to fetch a new bearer token from the authentication server.
     *
     * @return A [Request] object configured with the necessary headers and parameters.
     */
    private fun buildAuthenticationRequest(): Request = run {
        Request.Builder()
            .url(authUrl)
            .method(Method.POST)
            .body( RequestBody.create(mapOf("grant_type" to "client_credentials")))
            .setHeader("Authorization", credentials.encodeBasic())
            .setHeader("Content-Type", CommonMediaTypes.APPLICATION_FORM_URLENCODED.toString())
            .build()
    }

    /**
     * Executes the authentication request and validates the response.
     *
     * @param request The [Request] object to be executed.
     * @return The [Response] received from the server.
     * @throws ExpediaGroupAuthException If the server responds with an error.
     */
    private fun executeAuthenticationRequest(request: Request): Response = run {
        requestExecutor.execute(request).apply {
            if (!this.isSuccessful) {
                throw ExpediaGroupAuthException(this.status, "Authentication failed")
            }
        }
    }

    /**
     * Stores the retrieved token in internal storage for subsequent use.
     *
     * @param tokenResponse The [TokenResponse] containing the token and its expiration time.
     */
    private fun storeToken(tokenResponse: TokenResponse) = run {
        bearerTokenStorage = BearerTokenStorage.create(
            accessToken = tokenResponse.accessToken,
            expiresIn = tokenResponse.expiresIn
        )
    }
}
