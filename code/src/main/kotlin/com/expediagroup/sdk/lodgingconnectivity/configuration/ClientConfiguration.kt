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

package com.expediagroup.sdk.lodgingconnectivity.configuration

import com.expediagroup.sdk.client.Transport

/**
 * Configuration class used to define configuration options for lodging connectivity clients.
 *
 * This class provides a flexible way to configure different clients such as `ReservationClient` & `PaymentClient`,
 * storing required credentials (`key` and `secret`) for authentication, and some other advanced customization options.
 *
 * Additionally, it enables injecting a custom HTTP client by implementing the `Transport`
 * interface, offering flexibility beyond the default `OkHttpClient` provided by the SDK.
 *
 * - **Required Fields**: `key` and `secret` for secure authentication.
 * - **Custom Transport Integration**: Allows replacing the default `OkHttpClient` with a custom HTTP client by implementing
 *   the `Transport` interface.
 * - **Environment Support**: Enables specifying the target `ClientEnvironment` (e.g., `PROD` or `SANDBOX_PROD`).
 * - **Reusability**: Can be shared across multiple lodging connectivity clients.
 *
 * ### Custom Transport Capability
 * If you wish to use custom HTTP client other than the default `OkHttpClient`, you can implement the [Transport] interface
 * with your HTTP client of choice, then you can pass it via `ClientConfiguration.builder(transport)` method.
 *
 * ### Default Configuration
 * For standard use cases, the SDK provides a default `OkHttpClient`. You can configure it with the standard builder:
 * ```kotlin
 * ClientConfiguration.builder()
 *     .key("your-key")
 *     .secret("your-secret")
 *     .environment(ClientEnvironment.PRODUCTION)
 *     .callTimeout(3000)
 *     .writeTimeout(4000)
 *     .build()
 * ```
 *
 * @see [Transport]
 */
class ClientConfiguration(
    val key: String,
    val secret: String,
    val environment: ClientEnvironment? = null,
    val transport: Transport? = null,
) {

    companion object {

        class Builder {
            private var key: String? = null
            private var secret: String? = null
            private var environment: ClientEnvironment? = null
            private var transport: Transport? = null

            fun key(key: String) = apply { this.key = key }

            fun secret(secret: String) = apply { this.secret = secret }

            fun environment(environment: ClientEnvironment) = apply { this.environment = environment }

            fun transport(transport: Transport) = apply { this.transport = transport }

            fun build(): ClientConfiguration {
                require(key != null) {
                    "key is required"
                }

                require(secret != null) {
                    "secret is required"
                }

                return ClientConfiguration(
                    key = key!!,
                    secret = secret!!,
                    environment = environment,
                    transport = transport
                )
            }
        }

        /**
         * Returns a builder for the default client configurations.
         */
        @JvmStatic
        fun builder(): Builder = Builder()
    }
}
