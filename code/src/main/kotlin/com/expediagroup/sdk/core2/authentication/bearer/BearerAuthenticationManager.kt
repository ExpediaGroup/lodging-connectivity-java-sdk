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

import com.expediagroup.sdk.core.extension.getOrThrow
import com.expediagroup.sdk.core.http.HttpStatus
import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupResponseParsingException
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.core2.authentication.common.AuthenticationManager
import com.expediagroup.sdk.core2.authentication.common.Credentials
import com.expediagroup.sdk.core2.client.Transport
import com.expediagroup.sdk.core2.http.ContentType
import com.expediagroup.sdk.core2.http.RequestBody
import com.expediagroup.sdk.core2.http.Request
import com.expediagroup.sdk.core2.http.Response
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

/**
 * Manages bearer token authentication for HTTP requests.
 *
 * The `BearerAuthenticationManager` handles the lifecycle of bearer tokens, including retrieval, storage,
 * and validation. It interacts with an authentication server to fetch tokens using client credentials,
 * ensures tokens are refreshed when necessary, and provides them in the required format for authorization headers.
 *
 * @param transport The [Transport] used to execute authentication requests.
 * @param authUrl The URL of the authentication server's endpoint to obtain bearer tokens.
 * @param credentials The [Credentials] containing the client key and secret used for authentication.
 */
class BearerAuthenticationManager(
    private val transport: Transport,
    private val authUrl: String,
    private val credentials: Credentials
) : AuthenticationManager {

    @Volatile
    private var bearerTokenStorage = BearerTokenStorage.empty

    private val objectMapper = ObjectMapper()
        .registerKotlinModule()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    override fun authenticate() {
        clearAuthentication()

        val request = createAuthenticationRequest()
        val response = executeAuthenticationRequest(request)
        val tokenResponse = parseAuthenticationResponse(response)
        storeToken(tokenResponse)
    }

    override fun needsAuthentication(): Boolean = bearerTokenStorage.isAboutToExpire()

    override fun clearAuthentication() {
        bearerTokenStorage = BearerTokenStorage.empty
    }

    /**
     * Retrieves the stored token formatted as an `Authorization` header value.
     *
     * @return The token in the format `Bearer <token>` for use in HTTP headers.
     */
    fun getAuthorizationHeaderValue(): String = bearerTokenStorage.getAsAuthorizationHeaderValue()

    private fun createAuthenticationRequest(): Request =
        Request.Builder()
            .url(authUrl)
            .method("POST", RequestBody.create(mapOf("grant_type" to "client_credentials")))
            .header("Authorization", credentials.encodeBasic())
            .header("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.mimeType)
            .build()

    private fun executeAuthenticationRequest(request: Request): Response {
        val response = transport.execute(request)
        if (!response.isSuccessful) {
            throw ExpediaGroupAuthException(response.code, "Authentication failed")
        }
        return response
    }

    private fun parseAuthenticationResponse(response: Response): TokenResponse {
        val responseBody = response.body.getOrThrow {
            ExpediaGroupAuthException(HttpStatus.INTERNAL_SERVER_ERROR, "Authentication response body is empty")
        }

        val responseString = responseBody.source().use {
            it.readString(responseBody.contentType()?.charset ?: Charsets.UTF_8)
        }

        return try {
            objectMapper.readValue(responseString, TokenResponse::class.java)
        } catch (e: Exception) {
            throw ExpediaGroupResponseParsingException("Failed to parse authentication response", e)
        }
    }

    private fun storeToken(tokenResponse: TokenResponse) {
        bearerTokenStorage = BearerTokenStorage.create(
            accessToken = tokenResponse.accessToken,
            expiresIn = tokenResponse.expiresIn
        )
    }
}
