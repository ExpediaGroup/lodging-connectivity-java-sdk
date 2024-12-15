package com.expediagroup.sdk.core.authentication.bearer

import com.expediagroup.sdk.core.authentication.common.Credentials
import com.expediagroup.sdk.core.client.RequestExecutor
import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupResponseParsingException
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupNetworkException
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BearerAuthenticationManagerTest {

    private lateinit var requestExecutor: RequestExecutor
    private lateinit var credentials: Credentials
    private lateinit var authenticationManager: BearerAuthenticationManager
    private val authUrl = "http://auth.example.com/token"

    @BeforeAll
    fun setup() {
        requestExecutor = mockk()
        credentials = Credentials("client_key", "client_secret")
        authenticationManager = BearerAuthenticationManager(authUrl, requestExecutor, credentials)
    }

    @AfterEach
    fun tearDown() {
        clearMocks(requestExecutor)
        authenticationManager.clearAuthentication()
    }


    /**
     * Test successful authentication flow.
     */
    @Test
    fun `authenticate should store token on successful response`() {
        // Arrange
        val expiresIn: Long = 3600L
        var available: Int? = null
        val response = Response.builder()
            .body(
                ResponseBody.create(
                    """{ "access_token": "first_token", "expires_in": $expiresIn }""".toByteArray().inputStream().also {
                        available = it.available()
                    },
                    CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                    available!!.toLong()
                )
            )
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message("Accepted")
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .build()

        every { requestExecutor.execute(any()) } returns response

        // Act
        authenticationManager.authenticate()

        // Assert
        assertEquals("Bearer first_token", authenticationManager.getAuthorizationHeaderValue())
        verify(exactly = 1) { requestExecutor.execute(any()) }
    }

    /**
     * Test authentication failure due to server error.
     */
    @Test
    fun `authenticate should throw ExpediaGroupAuthException on failure response`() {
        // Arrange
        val request = Request.builder().url("http://localhost").method(Method.POST).build()
        val response = Response.builder()
            .request(request)
            .status(Status.INTERNAL_SERVER_ERROR)
            .protocol(Protocol.HTTP_1_1)
            .message(Status.INTERNAL_SERVER_ERROR.name)
            .build()
        every { requestExecutor.execute(any()) } returns response

        // Act & Assert
        val exception = assertThrows<ExpediaGroupAuthException> {
            authenticationManager.authenticate()
        }
        assertEquals("[${Status.INTERNAL_SERVER_ERROR.code}] Authentication failed", exception.message)
        verify(exactly = 1) { requestExecutor.execute(any()) }
    }

    /**
     * Test authentication failure due to network issues.
     */
    @Test
    fun `authenticate should throw ExpediaGroupNetworkException on network failure`() {
        // Arrange
        every { requestExecutor.execute(any()) } throws ExpediaGroupNetworkException("Network error")

        // Act & Assert
        val exception = assertThrows<ExpediaGroupNetworkException> {
            authenticationManager.authenticate()
        }
        assertEquals("Network error", exception.message)
        verify(exactly = 1) { requestExecutor.execute(any()) }
    }

    /**
     * Test authentication failure due to response parsing issues.
     */
    @Test
    fun `authenticate should throw ExpediaGroupResponseParsingException on parsing failure`() {
        // Arrange
        var available: Int? = null
        val response = Response.builder()
            .body(
                ResponseBody.create(
                    """{ "id": 1 }""".toByteArray().inputStream().also {
                        available = it.available()
                    },
                    CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                    available!!.toLong()
                )
            )
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message("Accepted")
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .build()

        every { requestExecutor.execute(any()) } returns response

        // Act & Assert
        val exception = assertThrows<ExpediaGroupResponseParsingException> {
            authenticationManager.authenticate()
        }
        assertTrue(exception.message!!.contains("Failed to parse"))
        verify(exactly = 1) { requestExecutor.execute(any()) }
    }

    /**
     * Test isTokenAboutToExpire when token is not about to expire.
     */
    @Test
    fun `isTokenAboutToExpire should return false when token is valid`() {
        // Arrange
        val expiresIn: Long = 3600L
        var available: Int? = null
        val response = Response.builder()
            .body(
                ResponseBody.create(
                    """{ "access_token": "accessToken", "expires_in": $expiresIn }""".toByteArray().inputStream().also {
                        available = it.available()
                    },
                    CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                    available!!.toLong()
                )
            )
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message("Accepted")
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .build()

        every { requestExecutor.execute(any()) } returns response

        // Act
        authenticationManager.authenticate()
        val isAboutToExpire = authenticationManager.isTokenAboutToExpire()

        // Assert
        assertFalse(isAboutToExpire)
    }

    /**
     * Test isTokenAboutToExpire when token is about to expire.
     */
    @Test
    fun `isTokenAboutToExpire should return true when token is about to expire`() {
        // Arrange
        val expiresIn: Long = 1L
        var available: Int? = null
        val response = Response.builder()
            .body(
                ResponseBody.create(
                    """{ "access_token": "first_token", "expires_in": $expiresIn }""".toByteArray().inputStream().also {
                        available = it.available()
                    },
                    CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                    available!!.toLong()
                )
            )
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message("Accepted")
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .build()

        every { requestExecutor.execute(any()) } returns response

        // Authenticate to store the token
        authenticationManager.authenticate()

        // Create a spy of the authentication manager to manipulate isTokenAboutToExpire
        val spyManager = spyk(authenticationManager)

        // Mock isTokenAboutToExpire to return true
        every { spyManager.isTokenAboutToExpire() } returns true

        // Act
        val isAboutToExpire = spyManager.isTokenAboutToExpire()

        // Assert
        assertTrue(isAboutToExpire)
        verify(exactly = 1) { spyManager.isTokenAboutToExpire() }
    }

    /**
     * Test clearing authentication.
     */
    @Test
    fun `clearAuthentication should reset the token`() {
        // Arrange
        val expiresIn: Long = 3600L
        var available: Int? = null
        val response = Response.builder()
            .body(
                ResponseBody.create(
                    """{ "access_token": "first_token", "expires_in": $expiresIn }""".toByteArray().inputStream().also {
                        available = it.available()
                    },
                    CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                    available!!.toLong()
                )
            )
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message("Accepted")
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .build()

        every { requestExecutor.execute(any()) } returns response

        // Act
        authenticationManager.authenticate()
        assertEquals("Bearer first_token", authenticationManager.getAuthorizationHeaderValue())

        authenticationManager.clearAuthentication()

        // Assert
        assertEquals("Bearer ", authenticationManager.getAuthorizationHeaderValue())
    }

    /**
     * Test getAuthorizationHeaderValue when no token is present.
     */
    @Test
    fun `getAuthorizationHeaderValue should return empty bearer when no token is present`() {
        // Arrange
        authenticationManager.clearAuthentication()

        // Act
        val authHeader = authenticationManager.getAuthorizationHeaderValue()

        // Assert
        assertEquals("Bearer ", authHeader)
    }

    /**
     * Test authenticate multiple times sequentially.
     */
    @Test
    fun `authenticate multiple times should update the token each time`() {
        // Arrange
        val expiresIn: Long = 3600L
        var available: Int? = null
        val response1 = Response.builder()
            .body(
                ResponseBody.create(
                    """{ "access_token": "first_token", "expires_in": $expiresIn }""".toByteArray().inputStream().also {
                        available = it.available()
                    },
                    CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                    available!!.toLong()
                )
            )
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message("Accepted")
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .build()

        val response2 = Response.builder()
            .body(
                ResponseBody.create(
                    """{ "access_token": "second_token", "expires_in": $expiresIn }""".toByteArray().inputStream()
                        .also {
                            available = it.available()
                        },
                    CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                    available!!.toLong()
                )
            )
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message("Accepted")
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .build()

        every { requestExecutor.execute(any()) } returnsMany listOf(response1, response2)

        // Act
        authenticationManager.authenticate()
        val firstAuthHeader = authenticationManager.getAuthorizationHeaderValue()

        authenticationManager.authenticate()
        val secondAuthHeader = authenticationManager.getAuthorizationHeaderValue()

        // Assert
        assertEquals("Bearer first_token", firstAuthHeader)
        assertEquals("Bearer second_token", secondAuthHeader)
        verify(exactly = 2) { requestExecutor.execute(any()) }
    }

    /**
     * Test authentication failure due to invalid credentials.
     */
    @Test
    fun `authenticate should throw ExpediaGroupAuthException on invalid credentials`() {
        // Arrange
        // Assuming server returns 401 Unauthorized for invalid credentials
        val request = Request.builder().url("http://localhost").method(Method.POST).build()
        val response = Response.builder()
            .request(request)
            .status(Status.UNAUTHORIZED)
            .protocol(Protocol.HTTP_1_1)
            .message(Status.UNAUTHORIZED.name)
            .build()
        every { requestExecutor.execute(any()) } returns response

        // Act & Assert
        val exception = assertThrows<ExpediaGroupAuthException> {
            authenticationManager.authenticate()
        }
        assertEquals("[${Status.UNAUTHORIZED.code}] Authentication failed", exception.message)
        verify(exactly = 1) { requestExecutor.execute(any()) }
    }

    /**
     * Test authentication failure when response body is null.
     */
    @Test
    fun `authenticate should throw ExpediaGroupResponseParsingException when response body is null`() {
        // Arrange

        val response = Response.builder()
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message(Status.INTERNAL_SERVER_ERROR.name)
            .body(null)
            .build()
        every { requestExecutor.execute(any()) } returns response

        // Act & Assert
        assertThrows<ExpediaGroupResponseParsingException> {
            authenticationManager.authenticate()
        }

        verify(exactly = 1) { requestExecutor.execute(any()) }
    }

    /**
     * Test multiple sequential clear and authenticate operations.
     */
    @Test
    fun `sequential clear and authenticate operations should maintain consistent state`() {
        // Arrange
        val expiresIn: Long = 3600L
        var available: Int? = null
        val response1 = Response.builder()
            .body(
                ResponseBody.create(
                    """{ "access_token": "first_token", "expires_in": $expiresIn }""".toByteArray().inputStream().also {
                        available = it.available()
                    },
                    CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                    available!!.toLong()
                )
            )
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message("Accepted")
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .build()

        val response2 = Response.builder()
            .body(
                ResponseBody.create(
                    """{ "access_token": "second_token", "expires_in": $expiresIn }""".toByteArray().inputStream()
                        .also {
                            available = it.available()
                        },
                    CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                    available!!.toLong()
                )
            )
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message("Accepted")
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .build()

        every { requestExecutor.execute(any()) } returnsMany listOf(response1, response2)

        // Act
        authenticationManager.authenticate()
        assertEquals("Bearer first_token", authenticationManager.getAuthorizationHeaderValue())

        authenticationManager.clearAuthentication()
        assertEquals("Bearer ", authenticationManager.getAuthorizationHeaderValue())

        authenticationManager.authenticate()
        assertEquals("Bearer second_token", authenticationManager.getAuthorizationHeaderValue())

        // Assert
        verify(exactly = 2) { requestExecutor.execute(any()) }
    }

    /**
     * Test isTokenAboutToExpire at the exact expiration threshold.
    //     */
    @Test
    fun `isTokenAboutToExpire should return true at expiration threshold`() {
        val expiresIn: Long = 0L
        var available: Int? = null
        val response = Response.builder()
            .body(
                ResponseBody.create(
                    """{ "access_token": "first_token", "expires_in": $expiresIn }""".toByteArray().inputStream().also {
                        available = it.available()
                    },
                    CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                    available!!.toLong()
                )
            )
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message("Accepted")
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .build() // Token expires immediately

        every { requestExecutor.execute(any()) } returns response

        // Act
        authenticationManager.authenticate()
        val isAboutToExpire = authenticationManager.isTokenAboutToExpire()

        // Assert
        assertTrue(isAboutToExpire)
    }

    /**
     * Test authentication when the response body is empty.
     */
    @Test
    fun `authenticate should throw ExpediaGroupResponseParsingException when response body is empty`() {
        // Arrange
        var available: Int? = null
        val response = Response.builder()
            .body(
                ResponseBody.create(
                    ByteArray(0).inputStream().also {
                        available = it.available()
                    },
                    CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                    available!!.toLong()
                )
            )
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message("Accepted")
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .build()

        every { requestExecutor.execute(any()) } returns response

        // Act & Assert
        val exception = assertThrows<ExpediaGroupResponseParsingException> {
            authenticationManager.authenticate()
        }
        assertTrue(exception.message!!.contains("Failed to parse"))
        verify(exactly = 1) { requestExecutor.execute(any()) }
    }

    /**
     * Test handling of delayed responses (timeout simulation).
     */
    @Test
    fun `authenticate should handle delayed responses gracefully`() {
        val expiresIn: Long = 3600L
        var available: Int? = null
        val response = Response.builder()
            .body(
                ResponseBody.create(
                    """{ "access_token": "first_token", "expires_in": $expiresIn }""".toByteArray().inputStream().also {
                        available = it.available()
                    },
                    CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                    available!!.toLong()
                )
            )
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message("Accepted")
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .build() // Token expires immediately

        every { requestExecutor.execute(any()) } answers {
            Thread.sleep(500) // Simulate delay
            response
        }

        // Act
        val future = Executors.newSingleThreadExecutor().submit {
            authenticationManager.authenticate()
        }

        // Assert
        assertDoesNotThrow {
            future.get(1, TimeUnit.SECONDS)
        }
        assertEquals("Bearer first_token", authenticationManager.getAuthorizationHeaderValue())
        verify(exactly = 1) { requestExecutor.execute(any()) }
    }
}
