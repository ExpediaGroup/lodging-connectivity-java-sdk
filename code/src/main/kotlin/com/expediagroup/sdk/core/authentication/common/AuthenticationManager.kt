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

package com.expediagroup.sdk.core.authentication.common

import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupResponseParsingException
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupNetworkException

/**
 * Defines the contract for managing authentication within the SDK.
 *
 * An `AuthenticationManager` is responsible for handling the process of authenticating with an external
 * service or API and maintaining the authentication state. Implementations should handle token lifecycle,
 * including acquisition, storage, and renewal.
 */
interface AuthenticationManager {
    /**
     * Performs the authentication process, obtaining the necessary credentials or tokens.
     *
     * This method is responsible for executing the authentication logic, such as sending requests to an
     * authentication server, handling the response, and storing the retrieved credentials or tokens for future use.
     *
     * @throws ExpediaGroupAuthException If authentication fails due to invalid credentials or server errors
     * @throws ExpediaGroupResponseParsingException If the authentication response cannot be parsed
     * @throws ExpediaGroupNetworkException If a network error occurs during authentication
     */
    @Throws(
        ExpediaGroupAuthException::class,
        ExpediaGroupResponseParsingException::class,
        ExpediaGroupNetworkException::class
    )
    fun authenticate()

    /**
     * Clears any stored authentication state.
     */
    fun clearAuthentication()
}
