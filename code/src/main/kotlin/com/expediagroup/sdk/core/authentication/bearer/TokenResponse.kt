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

import com.expediagroup.sdk.core.extension.getOrThrow
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupResponseParsingException
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

/**
 * Represents the response from an authentication server containing a bearer token and its expiration details.
 *
 * The `TokenResponse` class is used to deserialize the response from an authentication server. It includes
 * the bearer token and the duration (in seconds) until the token expires.
 *
 * @param accessToken The bearer token issued by the authentication server.
 * @param expiresIn The time in seconds until the token expires, starting from when it was issued.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class TokenResponse(
    @JsonProperty("access_token") val accessToken: String,
    @JsonProperty("expires_in") val expiresIn: Long
) {
    companion object {
        private val objectMapper = ObjectMapper()
            .registerKotlinModule()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        /**
         * Parses the response from the authentication server to extract token details.
         *
         * @param response The [Response] from the authentication server.
         * @return A [TokenResponse] object containing the token and its metadata.
         * @throws ExpediaGroupResponseParsingException If the response cannot be parsed.
         */
        fun parse(response: Response): TokenResponse {
            val responseBody = response.body.getOrThrow {
                ExpediaGroupResponseParsingException("Authenticate response body is empty or cannot be parsed")
            }

            val responseString = responseBody.source().use {
                it.readString(responseBody.mediaType()?.charset ?: Charsets.UTF_8)
            }

            return try {
                objectMapper.readValue(responseString, TokenResponse::class.java)
            } catch (e: Exception) {
                throw ExpediaGroupResponseParsingException("Failed to parse authentication response", e)
            }
        }
    }
}
