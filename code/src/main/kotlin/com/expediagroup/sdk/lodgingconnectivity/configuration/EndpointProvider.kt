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

import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupConfigurationException

enum class SupplyApiEndpoint(val url: String) {
    PROD("https://api.expediagroup.com/supply/lodging/graphql"),
    TEST("https://test-api.expediagroup.com/supply/lodging/graphql"),
    SANDBOX_PROD("https://api.sandbox.expediagroup.com/supply/lodging/graphql"),
    SANDBOX_TEST("https://test-api.sandbox.expediagroup.com/supply/lodging/graphql")
}

enum class PaymentApiEndpoint(val url: String) {
    PROD("https://api.expediagroup.com/supply/payments/graphql"),
    TEST("https://test-api.expediagroup.com/supply/payments/graphql"),
    SANDBOX_PROD("https://api.sandbox.expediagroup.com/supply/payments/graphql"),
    SANDBOX_TEST("https://test-api.sandbox.expediagroup.com/supply/payments/graphql")
}

enum class SandboxApiEndpoint(val url: String) {
    SANDBOX_PROD("https://api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql"),
    SANDBOX_TEST("https://test-api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql")
}

enum class FileManagementClientEndpoint(val url: String) {
    PROD("https://api.expediagroup.com/supply-lodging/v1/files"),
    TEST("https://test-api.expediagroup.com/supply-lodging/v1/files")
}

enum class AuthEndpoint(val url: String) {
    PROD("https://api.expediagroup.com/identity/oauth2/v3/token"),
    TEST("https://test-api.expediagroup.com/identity/oauth2/v3/token"),
    SANDBOX_PROD("https://api.expediagroup.com/identity/oauth2/v3/token"),
    SANDBOX_TEST("https://test-api.expediagroup.com/identity/oauth2/v3/token")
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
    fun getSupplyApiEndpoint(environment: ClientEnvironment): String {
        return try {
            SupplyApiEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw ExpediaGroupConfigurationException(
                """
                Unsupported environment [$environment] for Supply API. 
                Supported environments are [${SupplyApiEndpoint.entries.joinToString(", ") }]
                """
            )
        }
    }

    fun getPaymentApiEndpoint(environment: ClientEnvironment): String {
        return try {
            PaymentApiEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw ExpediaGroupConfigurationException(
                """
                Unsupported environment [$environment] for Payment API. 
                Supported environments are [${PaymentApiEndpoint.entries.joinToString(", ") }]
                """
            )
        }
    }

    fun getSandboxApiEndpoint(environment: ClientEnvironment): String {
        return try {
            SandboxApiEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw ExpediaGroupConfigurationException(
                """
                Unsupported environment [$environment] for Sandbox API. 
                Supported environments are [${SandboxApiEndpoint.entries.joinToString(", ") }]
                """
            )
        }
    }

    fun getFileManagementClientEndpoint(environment: ClientEnvironment): String {
        return try {
            FileManagementClientEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Unsupported environment [$environment] for FileManagementClient")
        }
    }

    fun getAuthEndpoint(environment: ClientEnvironment): String {
        return try {
            AuthEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw ExpediaGroupConfigurationException(
                """
                Unsupported environment [$environment] for Authentication API. 
                Supported environments are [${AuthEndpoint.entries.joinToString(", ") }]
                """
            )
        }
    }
}
