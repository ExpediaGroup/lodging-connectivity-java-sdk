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

import java.time.Clock
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
 * @param expirationBufferSeconds The number of seconds before the token's expiration time that it is considered "about to expire".
 * @param clock The clock to use for time-based operations. Defaults to system clock.
 */
class BearerTokenStorage private constructor(
    val accessToken: String,
    val expiresIn: Long,
    private val expirationBufferSeconds: Long,
    private val clock: Clock,
    private val expiryInstant: Instant
) {

    /**
     * Checks if the bearer token is about to expire.
     *
     * A token is considered "about to expire" if the current time is within the configured buffer
     * of the token's expiration time.
     *
     * @return `true` if the token is about to expire; `false` otherwise.
     */
    fun isAboutToExpire(): Boolean =
        Instant.now(clock).isAfter(expiryInstant.minusSeconds(expirationBufferSeconds))

    /**
     * Formats the bearer token as an `Authorization` header value.
     *
     * @return The token in the format `Bearer <accessToken>`.
     */
    fun getAsAuthorizationHeaderValue(): String = "Bearer $accessToken"

    companion object {
        private const val DEFAULT_EXPIRATION_BUFFER_SECONDS = 60L

        /**
         * Creates an empty bearer token storage instance.
         * This instance will always report as expired.
         */
        val empty: BearerTokenStorage = create("", -1)

        /**
         * Creates a new bearer token storage instance with default settings.
         *
         * @param accessToken The bearer token
         * @param expiresIn The time in seconds until the token expires
         * @param expirationBufferSeconds Optional buffer time before expiration. Defaults to 60 seconds.
         * @param clock Optional clock for time operations. Defaults to system clock.
         * @return A new BearerTokenStorage instance
         */
        fun create(
            accessToken: String,
            expiresIn: Long,
            expirationBufferSeconds: Long = DEFAULT_EXPIRATION_BUFFER_SECONDS,
            clock: Clock = Clock.systemUTC()
        ): BearerTokenStorage {
            val expiryInstant = if (expiresIn >= 0) {
                Instant.now(clock).plusSeconds(expiresIn)
            } else {
                Instant.EPOCH
            }

            return BearerTokenStorage(
                accessToken = accessToken,
                expiresIn = expiresIn,
                expirationBufferSeconds = expirationBufferSeconds,
                clock = clock,
                expiryInstant = expiryInstant
            )
        }
    }

    override fun toString(): String {
        return "BearerTokenStorage(expiresIn=$expiresIn, expirationBufferSeconds=$expirationBufferSeconds, expiryInstant=$expiryInstant)"
    }
}
