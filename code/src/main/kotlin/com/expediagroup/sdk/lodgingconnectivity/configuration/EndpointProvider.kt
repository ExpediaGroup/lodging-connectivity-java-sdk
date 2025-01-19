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

import com.expediagroup.sdk.core.exception.client.ExpediaGroupConfigurationException

enum class SupplyApiEndpoint(
    val url: String,
) {
    PROD("https://api.expediagroup.com/supply/lodging/graphql"),
    TEST("https://test-api.expediagroup.com/supply/lodging/graphql"),
    SANDBOX_PROD("https://api.sandbox.expediagroup.com/supply/lodging/graphql"),
    SANDBOX_TEST("https://test-api.sandbox.expediagroup.com/supply/lodging/graphql"),
}

enum class PaymentApiEndpoint(
    val url: String,
) {
    PROD("https://api.expediagroup.com/supply/payments/graphql"),
    TEST("https://test-api.expediagroup.com/supply/payments/graphql"),
    SANDBOX_PROD("https://api.sandbox.expediagroup.com/supply/payments/graphql"),
    SANDBOX_TEST("https://test-api.sandbox.expediagroup.com/supply/payments/graphql"),
}

enum class SandboxApiEndpoint(
    val url: String,
) {
    SANDBOX_PROD("https://api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql"),
    SANDBOX_TEST("https://test-api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql"),
}

enum class AuthEndpoint(
    val url: String,
) {
    PROD("https://api.expediagroup.com/identity/oauth2/v3/token"),
    TEST("https://test-api.expediagroup.com/identity/oauth2/v3/token"),
    SANDBOX_PROD("https://api.expediagroup.com/identity/oauth2/v3/token"),
    SANDBOX_TEST("https://test-api.expediagroup.com/identity/oauth2/v3/token"),
}

/**
 * An internal utility object for providing API endpoints based on the environment.
 *
 * This class contains methods to retrieve the correct endpoint for different clients
 * (e.g., Supply, Payment, Sandbox, and Authentication) based on the
 * provided `ClientEnvironment`.
 *
 * If an unsupported environment is passed, an `IllegalArgumentException` is thrown.
 */
internal object EndpointProvider {
    fun getSupplyApiEndpoint(environment: ClientEnvironment? = null): ApiEndpoint {
        val env = environment ?: ClientEnvironment.PROD

        return try {
            ApiEndpoint(
                endpoint = SupplyApiEndpoint.valueOf(env.name).url,
                authEndpoint = getAuthEndpoint(env),
            )
        } catch (e: IllegalArgumentException) {
            throw ExpediaGroupConfigurationException(
                """
                Unsupported environment [$environment] for Supply API. 
                Supported environments are [${SupplyApiEndpoint.entries.joinToString(", ")}]
                """,
            )
        }
    }

    fun getPaymentApiEndpoint(environment: ClientEnvironment? = null): ApiEndpoint {
        val env = environment ?: ClientEnvironment.PROD

        return try {
            ApiEndpoint(
                endpoint = PaymentApiEndpoint.valueOf(env.name).url,
                authEndpoint = getAuthEndpoint(env),
            )
        } catch (e: IllegalArgumentException) {
            throw ExpediaGroupConfigurationException(
                """
                Unsupported environment [$environment] for Payment API. 
                Supported environments are [${PaymentApiEndpoint.entries.joinToString(", ")}]
                """,
            )
        }
    }

    fun getSandboxApiEndpoint(environment: ClientEnvironment? = null): ApiEndpoint {
        val env = environment ?: ClientEnvironment.SANDBOX_PROD

        return try {
            ApiEndpoint(
                endpoint = SandboxApiEndpoint.valueOf(env.name).url,
                authEndpoint = getAuthEndpoint(env),
            )
        } catch (e: IllegalArgumentException) {
            throw ExpediaGroupConfigurationException(
                """
                Unsupported environment [$environment] for Sandbox API. 
                Supported environments are [${SandboxApiEndpoint.entries.joinToString(", ")}]
                """,
            )
        }
    }

    private fun getAuthEndpoint(environment: ClientEnvironment? = null): String {
        val env = environment ?: ClientEnvironment.PROD

        return try {
            AuthEndpoint.valueOf(env.name).url
        } catch (e: IllegalArgumentException) {
            throw ExpediaGroupConfigurationException(
                """
                Unsupported environment [$environment] for Authentication API. 
                Supported environments are [${AuthEndpoint.entries.joinToString(", ")}]
                """,
            )
        }
    }
}
