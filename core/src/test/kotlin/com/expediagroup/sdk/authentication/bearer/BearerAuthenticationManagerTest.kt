package com.expediagroup.sdk.authentication.bearer

import com.expediagroup.sdk.authentication.common.Credentials
import com.expediagroup.sdk.exception.client.ExpediaGroupResponseParsingException
import com.expediagroup.sdk.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.exception.service.ExpediaGroupNetworkException
import com.expediagroup.sdk.http.CommonMediaTypes
import com.expediagroup.sdk.http.Method
import com.expediagroup.sdk.http.Protocol
import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.http.Response
import com.expediagroup.sdk.http.ResponseBody
import com.expediagroup.sdk.http.Status
import com.expediagroup.sdk.transport.Transport
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BearerAuthenticationManagerTest {

    private lateinit var transport: Transport
    private lateinit var credentials: Credentials
    private lateinit var authenticationManager: BearerAuthenticationManager
    private val authUrl = "https://auth.example.com/token"

    @BeforeAll
    fun setup() {
        transport = mockk()
        credentials = Credentials("client_key", "client_secret")
        authenticationManager = BearerAuthenticationManager(authUrl, credentials, transport)
    }

    @AfterEach
    fun tearDown() {
        clearMocks(transport)
        authenticationManager.clearAuthentication()
    }


    @Test
    fun `should authenticate and store access token on successful response`() {
        val expiresIn = 3600L
        var available: Int?
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

        every { transport.execute(any()) } returns response

        authenticationManager.authenticate()

        assertEquals("Bearer first_token", authenticationManager.getAuthorizationHeaderValue())
        verify(exactly = 1) { transport.execute(any()) }
    }

    @Test
    fun `should throw ExpediaGroupAuthException on failure response`() {
        // Arrange
        val request = Request.builder().url("http://localhost").method(Method.POST).build()
        val response = Response.builder()
            .request(request)
            .status(Status.INTERNAL_SERVER_ERROR)
            .protocol(Protocol.HTTP_1_1)
            .message(Status.INTERNAL_SERVER_ERROR.name)
            .build()
        every { transport.execute(any()) } returns response

        val exception = assertThrows<ExpediaGroupAuthException> {
            authenticationManager.authenticate()
        }
        assertEquals("[${Status.INTERNAL_SERVER_ERROR.code}] Authentication failed", exception.message)
        verify(exactly = 1) { transport.execute(any()) }
    }

    @Test
    fun `authenticate should throw ExpediaGroupNetworkException on network failure`() {
        // Arrange
        every { transport.execute(any()) } throws ExpediaGroupNetworkException("Network error")

        val exception = assertThrows<ExpediaGroupNetworkException> {
            authenticationManager.authenticate()
        }
        assertEquals("Network error", exception.message)
        verify(exactly = 1) { transport.execute(any()) }
    }

    @Test
    fun `authenticate should throw ExpediaGroupResponseParsingException on parsing failure`() {
        var available: Int?
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

        every { transport.execute(any()) } returns response

        val exception = assertThrows<ExpediaGroupResponseParsingException> {
            authenticationManager.authenticate()
        }
        assertTrue(exception.message!!.contains("Failed to parse"))
        verify(exactly = 1) { transport.execute(any()) }
    }

    @Test
    fun `should treat the stored token as a valid token when not expired`() {
        // Arrange
        val expiresIn = 3600L
        var available: Int?
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

        every { transport.execute(any()) } returns response

        authenticationManager.authenticate()
        val isAboutToExpire = authenticationManager.isTokenAboutToExpire()

        assertFalse(isAboutToExpire)
    }

    @Test
    fun `should treat the stored token as a invalid token if expired`() {
        val expiresIn = 1L
        var available: Int?
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

        every { transport.execute(any()) } returns response

        // Authenticate to store the token
        authenticationManager.authenticate()

        // Create a spy of the authentication manager to manipulate isTokenAboutToExpire
        val spyManager = spyk(authenticationManager)

        every { spyManager.isTokenAboutToExpire() } returns true

        val isAboutToExpire = spyManager.isTokenAboutToExpire()

        assertTrue(isAboutToExpire)
        verify(exactly = 1) { spyManager.isTokenAboutToExpire() }
    }

    @Test
    fun `should handle token clearance`() {
        val expiresIn = 3600L
        var available: Int?
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

        every { transport.execute(any()) } returns response

        authenticationManager.authenticate()
        assertEquals("Bearer first_token", authenticationManager.getAuthorizationHeaderValue())

        authenticationManager.clearAuthentication()

        assertEquals("Bearer ", authenticationManager.getAuthorizationHeaderValue())
    }

    @Test
    fun `getAuthorizationHeaderValue should return empty bearer when no token is present`() {
        // Arrange
        authenticationManager.clearAuthentication()

        val authHeader = authenticationManager.getAuthorizationHeaderValue()

        assertEquals("Bearer ", authHeader)
    }

    @Test
    fun `authenticate multiple times should update the token each time`() {
        val expiresIn = 3600L
        var available: Int?
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

        every { transport.execute(any()) } returnsMany listOf(response1, response2)

        authenticationManager.authenticate()
        val firstAuthHeader = authenticationManager.getAuthorizationHeaderValue()

        authenticationManager.authenticate()
        val secondAuthHeader = authenticationManager.getAuthorizationHeaderValue()

        assertEquals("Bearer first_token", firstAuthHeader)
        assertEquals("Bearer second_token", secondAuthHeader)
        verify(exactly = 2) { transport.execute(any()) }
    }

    @Test
    fun `authenticate should throw ExpediaGroupAuthException on invalid credentials`() {
        // Assuming server returns 401 Unauthorized for invalid credentials
        val request = Request.builder().url("http://localhost").method(Method.POST).build()
        val response = Response.builder()
            .request(request)
            .status(Status.UNAUTHORIZED)
            .protocol(Protocol.HTTP_1_1)
            .message(Status.UNAUTHORIZED.name)
            .build()
        every { transport.execute(any()) } returns response

        val exception = assertThrows<ExpediaGroupAuthException> {
            authenticationManager.authenticate()
        }
        assertEquals("[${Status.UNAUTHORIZED.code}] Authentication failed", exception.message)
        verify(exactly = 1) { transport.execute(any()) }
    }

    @Test
    fun `authenticate should throw ExpediaGroupResponseParsingException when response body is null`() {

        val response = Response.builder()
            .request(Request.builder().url("http://localhost").method(Method.POST).build())
            .status(Status.ACCEPTED)
            .protocol(Protocol.HTTP_1_1)
            .message(Status.INTERNAL_SERVER_ERROR.name)
            .body(null)
            .build()
        every { transport.execute(any()) } returns response

        assertThrows<ExpediaGroupResponseParsingException> {
            authenticationManager.authenticate()
        }

        verify(exactly = 1) { transport.execute(any()) }
    }

    @Test
    fun `sequential clear and authenticate operations should maintain consistent state`() {
        val expiresIn = 3600L
        var available: Int?
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

        every { transport.execute(any()) } returnsMany listOf(response1, response2)

        authenticationManager.authenticate()
        assertEquals("Bearer first_token", authenticationManager.getAuthorizationHeaderValue())

        authenticationManager.clearAuthentication()
        assertEquals("Bearer ", authenticationManager.getAuthorizationHeaderValue())

        authenticationManager.authenticate()
        assertEquals("Bearer second_token", authenticationManager.getAuthorizationHeaderValue())

        verify(exactly = 2) { transport.execute(any()) }
    }

    @Test
    fun `isTokenAboutToExpire should return true at expiration threshold`() {
        val expiresIn = 0L
        var available: Int?
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

        every { transport.execute(any()) } returns response

        authenticationManager.authenticate()
        val isAboutToExpire = authenticationManager.isTokenAboutToExpire()

        assertTrue(isAboutToExpire)
    }

    @Test
    fun `authenticate should throw ExpediaGroupResponseParsingException when response body is empty`() {
        var available: Int?
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

        every { transport.execute(any()) } returns response

        val exception = assertThrows<ExpediaGroupResponseParsingException> {
            authenticationManager.authenticate()
        }
        assertTrue(exception.message!!.contains("Failed to parse"))
        verify(exactly = 1) { transport.execute(any()) }
    }

    @Test
    fun `authenticate should handle delayed responses gracefully`() {
        val expiresIn = 3600L
        var available: Int?
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

        every { transport.execute(any()) } answers {
            Thread.sleep(500) // Simulate delay
            response
        }

        val future = Executors.newSingleThreadExecutor().submit {
            authenticationManager.authenticate()
        }

        assertDoesNotThrow {
            future.get(1, TimeUnit.SECONDS)
        }
        assertEquals("Bearer first_token", authenticationManager.getAuthorizationHeaderValue())
        verify(exactly = 1) { transport.execute(any()) }
    }
}
