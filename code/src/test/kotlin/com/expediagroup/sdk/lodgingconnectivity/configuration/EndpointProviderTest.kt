package com.expediagroup.sdk.lodgingconnectivity.configuration

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class EndpointProviderTest {

    @Test
    fun `should return the expected supply endpoints for different environments`() {
        // Given
        val expectedProdEndpoint = ApiEndpoint(
            endpoint = "https://api.expediagroup.com/supply/lodging/graphql",
            authEndpoint = "https://api.expediagroup.com/identity/oauth2/v3/token"
        )

        val expectedTestEndpoint = ApiEndpoint(
            endpoint = "https://test-api.expediagroup.com/supply/lodging/graphql",
            authEndpoint = "https://test-api.expediagroup.com/identity/oauth2/v3/token"
        )

        val expectedSandboxProdEndpoint = ApiEndpoint(
            endpoint = "https://api.sandbox.expediagroup.com/supply/lodging/graphql",
            authEndpoint = "https://api.expediagroup.com/identity/oauth2/v3/token"
        )

        val expectedSandboxTestEndpoint = ApiEndpoint(
            endpoint = "https://test-api.sandbox.expediagroup.com/supply/lodging/graphql",
            authEndpoint = "https://test-api.expediagroup.com/identity/oauth2/v3/token"
        )

        // When
        val prodEndpoint  = EndpointProvider.getSupplyApiEndpoint(ClientEnvironment.PROD)
        val testEndpoint = EndpointProvider.getSupplyApiEndpoint(ClientEnvironment.TEST)
        val sandboxProdEndpoint = EndpointProvider.getSupplyApiEndpoint(ClientEnvironment.SANDBOX_PROD)
        val sandboxTestEndpoint = EndpointProvider.getSupplyApiEndpoint(ClientEnvironment.SANDBOX_TEST)

        // Expect
        assertEquals(expectedProdEndpoint, prodEndpoint)
        assertEquals(expectedTestEndpoint, testEndpoint)
        assertEquals(expectedSandboxProdEndpoint, sandboxProdEndpoint)
        assertEquals(expectedSandboxTestEndpoint, sandboxTestEndpoint)
    }

    @Test
    fun `should return the expected payment endpoints for different environments`() {
        // Given
        val expectedProdEndpoint = ApiEndpoint(
            endpoint = "https://api.expediagroup.com/supply/payments/graphql",
            authEndpoint = "https://api.expediagroup.com/identity/oauth2/v3/token"
        )

        val expectedTestEndpoint = ApiEndpoint(
            endpoint = "https://test-api.expediagroup.com/supply/payments/graphql",
            authEndpoint = "https://test-api.expediagroup.com/identity/oauth2/v3/token"
        )

        val expectedSandboxProdEndpoint = ApiEndpoint(
            endpoint = "https://api.sandbox.expediagroup.com/supply/payments/graphql",
            authEndpoint = "https://api.expediagroup.com/identity/oauth2/v3/token"
        )

        val expectedSandboxTestEndpoint = ApiEndpoint(
            endpoint = "https://test-api.sandbox.expediagroup.com/supply/payments/graphql",
            authEndpoint = "https://test-api.expediagroup.com/identity/oauth2/v3/token"
        )

        // When
        val prodEndpoint  = EndpointProvider.getPaymentApiEndpoint(ClientEnvironment.PROD)
        val testEndpoint = EndpointProvider.getPaymentApiEndpoint(ClientEnvironment.TEST)
        val sandboxProdEndpoint = EndpointProvider.getPaymentApiEndpoint(ClientEnvironment.SANDBOX_PROD)
        val sandboxTestEndpoint = EndpointProvider.getPaymentApiEndpoint(ClientEnvironment.SANDBOX_TEST)

        // Expect
        assertEquals(expectedProdEndpoint, prodEndpoint)
        assertEquals(expectedTestEndpoint, testEndpoint)
        assertEquals(expectedSandboxProdEndpoint, sandboxProdEndpoint)
        assertEquals(expectedSandboxTestEndpoint, sandboxTestEndpoint)
    }

    @Test
    fun `should return the expected sandbox endpoints for different environments`() {
        // Given
        val expectedSandboxProdEndpoint = ApiEndpoint(
            endpoint = "https://api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql",
            authEndpoint = "https://api.expediagroup.com/identity/oauth2/v3/token"
        )

        val expectedSandboxTestEndpoint = ApiEndpoint(
            endpoint = "https://test-api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql",
            authEndpoint = "https://test-api.expediagroup.com/identity/oauth2/v3/token"
        )

        // When
        val sandboxProdEndpoint = EndpointProvider.getSandboxApiEndpoint(ClientEnvironment.SANDBOX_PROD)
        val sandboxTestEndpoint = EndpointProvider.getSandboxApiEndpoint(ClientEnvironment.SANDBOX_TEST)

        // Expect
        assertEquals(expectedSandboxProdEndpoint, sandboxProdEndpoint)
        assertEquals(expectedSandboxTestEndpoint, sandboxTestEndpoint)
    }

    @Test
    fun `should use PROD as default environment for supply api`() {
        // Given
        val expectedEndpoint = ApiEndpoint(
            endpoint = "https://api.expediagroup.com/supply/lodging/graphql",
            authEndpoint = "https://api.expediagroup.com/identity/oauth2/v3/token"
        )

        // When
        val endpoint  = EndpointProvider.getSupplyApiEndpoint()

        // Expect
        assertEquals(expectedEndpoint, endpoint)
    }

    @Test
    fun `should use PROD as default environment for payment api`() {
        // Given
        val expectedEndpoint = ApiEndpoint(
            endpoint = "https://api.expediagroup.com/supply/payments/graphql",
            authEndpoint = "https://api.expediagroup.com/identity/oauth2/v3/token"
        )

        // When
        val endpoint  = EndpointProvider.getPaymentApiEndpoint()

        // Expect
        assertEquals(expectedEndpoint, endpoint)
    }

    @Test
    fun `should use SANDBOX_PROD as default environment for sandbox api`() {
        // Given
        val expectedEndpoint = ApiEndpoint(
            endpoint = "https://api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql",
            authEndpoint = "https://api.expediagroup.com/identity/oauth2/v3/token"
        )

        // When
        val endpoint  = EndpointProvider.getSandboxApiEndpoint()

        // Expect
        assertEquals(expectedEndpoint, endpoint)
    }
}
