package com.expediagroup.sdk.v2.lodgingconnectivity.configuration

enum class SupplyClientEndpoint(val url: String) {
    PROD("https://api.expediagroup.com/supply/lodging/graphql"),
    TEST("https://test-api.expediagroup.com/supply/lodging/graphql"),
    SANDBOX_PROD("https://api.sandbox.expediagroup.com/supply/lodging/graphql"),
    SANDBOX_TEST("https://test-api.sandbox.expediagroup.com/supply/lodging/graphql")
}

enum class PaymentClientEndpoint(val url: String) {
    PROD("https://api.expediagroup.com/supply/payments/graphql"),
    TEST("https://test-api.expediagroup.com/supply/payments/graphql")
}

enum class SandboxClientEndpoint(val url: String) {
    PROD("https://api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql"),
    TEST("https://test-api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql")
}

enum class FileManagementClientEndpoint(val url: String) {
    PROD("https://api.expediagroup.com/supply-lodging/v1/files"),
    TEST("https://test-api.expediagroup.com/supply-lodging/v1/files")
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
object EndpointProvider {
    fun getSupplyClientEndpoint(environment: ClientEnvironment): String {
        return try {
            com.expediagroup.sdk.lodgingconnectivity.configuration.SupplyClientEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Unsupported environment [$environment] for SupplyClient")
        }
    }

    fun getPaymentClientEndpoint(environment: ClientEnvironment): String {
        return try {
            com.expediagroup.sdk.lodgingconnectivity.configuration.PaymentClientEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Unsupported environment [$environment] for PaymentClient")
        }
    }

    fun getSandboxClientEndpoint(environment: ClientEnvironment): String {
        return try {
            com.expediagroup.sdk.lodgingconnectivity.configuration.SandboxClientEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Unsupported environment [$environment] for SandboxClient")
        }
    }

    fun getFileManagementClientEndpoint(environment: ClientEnvironment): String {
        return try {
            com.expediagroup.sdk.lodgingconnectivity.configuration.FileManagementClientEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Unsupported environment [$environment] for FileManagementClient")
        }
    }

    fun getAuthEndpoint(environment: ClientEnvironment): String {
        return try {
            com.expediagroup.sdk.lodgingconnectivity.configuration.AuthEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Unsupported environment [$environment] for Authentication")
        }
    }
}
