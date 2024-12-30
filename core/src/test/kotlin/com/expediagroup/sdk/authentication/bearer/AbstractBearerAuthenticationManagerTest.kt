package com.expediagroup.sdk.authentication.bearer

import com.expediagroup.sdk.authentication.common.Credentials
import com.expediagroup.sdk.http.Method
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestBearerAuthenticationManager(
    authUrl: String,
    credentials: Credentials
) : AbstractBearerAuthenticationManager(authUrl, credentials) {
    override fun authenticate() {}
}

class AbstractBearerAuthenticationManagerTest {
    private val authUrl = "https://example.com/auth"
    private val credentials = mockk<Credentials>(relaxed = true)
    private lateinit var authManager: AbstractBearerAuthenticationManager

    @BeforeEach
    fun setUp() {
        authManager = TestBearerAuthenticationManager(authUrl, credentials)
    }

    @Test
    fun `should store and retrieve token correctly`() {
        // Given
        val tokenResponse = TokenResponse("dummyToken", 3600)
        authManager.storeToken(tokenResponse)

        // When
        val header = authManager.getAuthorizationHeaderValue()

        // Expect
        assertEquals("Bearer dummyToken", header)
    }

    @Test
    fun `should detect token about to expire`() {
        // Given
        authManager = TestBearerAuthenticationManager(authUrl, credentials)
        val tokenResponse = TokenResponse("dummyToken", 10)
        authManager.storeToken(tokenResponse)

        // When
        val isAboutToExpire = authManager.isTokenAboutToExpire()

        // Expect
        assertTrue(isAboutToExpire)
    }

    @Test
    fun `should clear authentication`() {
        val tokenResponse = TokenResponse("dummyToken", 3600)
        authManager.storeToken(tokenResponse)

        // When
        authManager.clearAuthentication()

        // Expect
        assertEquals("Bearer ", authManager.getAuthorizationHeaderValue())
    }

    @Test
    fun `should build authentication request with correct headers`() {
        // Given
        every { credentials.encodeBasic() } returns "Basic encodedCredentials"

        // When
        val request = authManager.buildAuthenticationRequest()

        // Expect
        assertEquals(authUrl, request.url.toString())
        assertEquals(Method.POST, request.method)
        assertEquals("Basic encodedCredentials", request.headers.get("Authorization"))
        assertEquals("application/x-www-form-urlencoded", request.headers.get("Content-Type"))
    }
}
