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

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents the response from an authentication server containing a bearer token and its expiration details.
 *
 * The `TokenResponse` class is used to deserialize the response from an authentication server. It includes
 * the bearer token and the duration (in seconds) until the token expires.
 *
 * @param accessToken The bearer token issued by the authentication server.
 * @param expiresIn The time in seconds until the token expires, starting from when it was issued.
 */
data class TokenResponse(
    @JsonProperty("access_token") val accessToken: String,
    @JsonProperty("expires_in") val expiresIn: Long
)
