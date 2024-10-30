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
    TEST("https://test-api.expediagroup.com/supply/payments/graphql")
}

enum class SandboxApiEndpoint(val url: String) {
    SANDBOX_PROD("https://api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql"),
    SANDBOX_TEST("https://test-api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql")
}

enum class AuthEndpoint(val url: String) {
    PROD("https://api.expediagroup.com/identity/oauth2/v3/token/"),
    TEST("https://test-api.expediagroup.com/identity/oauth2/v3/token/"),
    SANDBOX_PROD("https://api.expediagroup.com/identity/oauth2/v3/token/"),
    SANDBOX_TEST("https://test-api.expediagroup.com/identity/oauth2/v3/token/")
}

/**
 * An internal utility object for providing API endpoints based on the environment.
 *
 * This class contains methods to retrieve the correct endpoint for different clients
 * (e.g., Supply, Payment, Sandbox, File Management, and Authentication) based on the
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
                Unsupported environment [$environment] for ReservationClient. 
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
                Unsupported environment [$environment] for PaymentClient. 
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
                Unsupported environment [$environment] for SandboxDataManagementClient. 
                Supported environments are [${SandboxApiEndpoint.entries.joinToString(", ") }]
                """
            )
        }
    }

    fun getAuthEndpoint(environment: ClientEnvironment): String {
        return try {
            AuthEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw ExpediaGroupConfigurationException(
                """
                Unsupported environment [$environment] for Authentication. 
                Supported environments are [${AuthEndpoint.entries.joinToString(", ") }]
                """
            )
        }
    }
}
