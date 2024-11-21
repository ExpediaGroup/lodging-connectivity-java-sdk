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

import java.time.Instant

/**
 * Stores and manages a bearer token and its expiration details.
 *
 * The `BearerTokenStorage` class is responsible for encapsulating the bearer token along with its
 * expiration time. It provides utilities to check if the token is about to expire and to format
 * the token as an `Authorization` header value.
 *
 * @param accessToken The bearer token.
 * @param expiresIn The time in seconds until the token expires, relative to when it was issued.
 */
data class BearerTokenStorage(
    val accessToken: String,
    val expiresIn: Long
) {
    private val expiryInstant: Instant = calculateExpiryInstant(expiresIn)

    /**
     * Checks if the bearer token is about to expire.
     *
     * A token is considered "about to expire" if the current time is within a predefined margin
     * (60 seconds) of the token's expiration time, or if the token is invalid.
     *
     * @return `true` if the token is invalid or about to expire; `false` otherwise.
     */
    fun isAboutToExpire(): Boolean {
        if (expiresIn <= 0) {
            return true // Token is invalid or expired
        }

        val margin = 60L

        return Instant.now().isAfter(expiryInstant.minusSeconds(margin))
    }

    /**
     * Formats the bearer token as an `Authorization` header value.
     *
     * @return The token in the format `Bearer <accessToken>`.
     */
    fun getAsAuthorizationHeaderValue(): String {
        return "Bearer $accessToken"
    }

    /**
     * Calculates the expiration time of the token as an [Instant].
     *
     * @param expiresIn The time in seconds until the token expires.
     * @return The expiration time as an [Instant].
     */
    private fun calculateExpiryInstant(expiresIn: Long): Instant =
        Instant.now().plusSeconds(expiresIn)

    companion object {
        val emptyBearerTokenStorage = BearerTokenStorage("", -1)
    }
}
