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

package com.expediagroup.sdk.core2.authentication.common

import java.io.IOException

/**
 * Defines the contract for managing authentication within the SDK.
 *
 * An `AuthenticationManager` is responsible for handling the process of authenticating with an external
 * service or API. Implementations of this interface manage the lifecycle of authentication
 */
interface AuthenticationManager {
    /**
     * Performs the authentication process, obtaining the necessary credentials or tokens.
     *
     * This method is responsible for executing the authentication logic, such as sending requests to an
     * authentication server, handling the response, and storing the retrieved credentials or tokens for future use.
     * If the authentication process fails, an [IOException] is thrown.
     *
     * @throws IOException If an error occurs during the authentication process, such as network failures
     * or invalid server responses.
     */
    @Throws(IOException::class)
    fun authenticate()
}
