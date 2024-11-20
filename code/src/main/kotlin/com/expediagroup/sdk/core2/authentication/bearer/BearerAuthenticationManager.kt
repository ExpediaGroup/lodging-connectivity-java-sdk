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
import com.expediagroup.sdk.core2.authentication.common.AuthenticationManager
import com.expediagroup.sdk.core2.authentication.common.Credentials
import com.expediagroup.sdk.core2.client.HttpClient
import com.expediagroup.sdk.core2.http.ContentType
import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpRequestBody
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.IOException
import java.nio.charset.StandardCharsets

/**
 * Manages bearer token authentication for HTTP requests.
 *
 * The `BearerAuthenticationManager` handles the lifecycle of bearer tokens, including retrieval, storage,
 * and validation. It interacts with an authentication server to fetch tokens using client credentials,
 * ensures tokens are refreshed when necessary, and provides them in the required format for authorization headers.
 *
 * @param httpClient The [HttpClient] used to execute authentication requests.
 * @param authUrl The URL of the authentication server's endpoint to obtain bearer tokens.
 * @param credentials The [Credentials] containing the client key and secret used for authentication.
 */
class BearerAuthenticationManager(
    private val httpClient: HttpClient,
    private val authUrl: String,
    private val credentials: Credentials
) : AuthenticationManager {

    @Volatile
    private var bearerTokenStorage = BearerTokenStorage.emptyBearerTokenStorage

    private val objectMapper = ObjectMapper()
        .registerKotlinModule()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    /**
     * Authenticates with the server to obtain a new bearer token.
     *
     * This method sends a `POST` request to the authentication server's endpoint using the provided
     * client credentials. The response is parsed, and the token is stored for future use. If the
     * authentication request fails or the response cannot be parsed, an [IOException] is thrown.
     *
     * @throws IOException If an I/O error occurs during the request or the response indicates failure.
     */
    @Throws(IOException::class)
    override fun authenticate() {
        flushStorage()

        val credential = credentials.encodeBasic()

        val formBody = HttpRequestBody.create(mapOf("grant_type" to "client_credentials"))

        val request = HttpRequest.Builder()
            .url(authUrl)
            .method("POST", formBody)
            .header("Authorization", credential)
            .header("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.mimeType)
            .build()

        val response = httpClient.execute(request)

        if (!response.isSuccessful) {
            throw IOException("Authentication failure: ${response.code}")
        }

        val responseBody = response.body.getOrThrow {
            IOException("Failed to get token")
        }

        responseBody.source().buffer
            .readString(responseBody.contentType()?.charset ?: StandardCharsets.UTF_8)
            .let { stringResponseBody ->
                parseTokenResponse(stringResponseBody)
            }.also { parsedTokenResponse ->
                bearerTokenStorage = BearerTokenStorage(parsedTokenResponse.accessToken, parsedTokenResponse.expiresIn)
            }
    }

    /**
     * Checks if the stored token is about to expire.
     *
     * @return `true` if the token is nearing expiration, `false` otherwise.
     */
    fun isTokenAboutToExpire() = bearerTokenStorage.isAboutToExpire()

    /**
     * Retrieves the stored token formatted as an `Authorization` header value.
     *
     * @return The token in the format `Bearer <token>` for use in HTTP headers.
     */
    fun getTokenAsAuthorizationHeaderValue() = bearerTokenStorage.getAsAuthorizationHeaderValue()

    /**
     * Clears the current token storage.
     */
    private fun flushStorage() {
        bearerTokenStorage = BearerTokenStorage.emptyBearerTokenStorage
    }

    /**
     * Parses the token response returned by the authentication server.
     *
     * This method deserializes the server's response into a [TokenResponse] object. If the response cannot
     * be parsed, an [IOException] is thrown.
     *
     * @param responseBody The raw response body returned by the authentication server.
     * @return A [TokenResponse] containing the token and its expiration details.
     * @throws IOException If the response body cannot be parsed into a [TokenResponse].
     */
    private fun parseTokenResponse(responseBody: String): TokenResponse {
        return try {
            objectMapper.readValue(responseBody, TokenResponse::class.java)
        } catch (e: Exception) {
            throw IOException("Failed to parse token response", e)
        }
    }
}
