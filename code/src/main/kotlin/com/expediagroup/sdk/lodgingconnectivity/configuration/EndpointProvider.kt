package com.expediagroup.sdk.lodgingconnectivity.configuration

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

object EndpointProvider {
    fun getSupplyClientEndpoint(environment: ClientEnvironment): String {
        return try {
            SupplyClientEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Unsupported environment [$environment] for SupplyClient")
        }
    }

    fun getPaymentClientEndpoint(environment: ClientEnvironment): String {
        return try {
            PaymentClientEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Unsupported environment [$environment] for PaymentClient")
        }
    }

    fun getSandboxClientEndpoint(environment: ClientEnvironment): String {
        return try {
            SandboxClientEndpoint.valueOf(environment.name).url
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Unsupported environment [$environment] for SandboxClient")
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
            throw IllegalArgumentException("Unsupported environment [$environment] for Authentication")
        }
    }
}
