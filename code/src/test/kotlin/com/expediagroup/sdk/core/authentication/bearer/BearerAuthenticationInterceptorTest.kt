package com.expediagroup.sdk.core.authentication.bearer

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.interceptor.Interceptor
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException
import io.mockk.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.IOException
import java.net.URL
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

class BearerAuthenticationInterceptorTest {
    @Test
    fun `intercept should proceed without Authorization header for authentication requests`() {
        // Arrange
        val authManager = mockk<BearerAuthenticationManager>(relaxed = true)
        val interceptor = BearerAuthenticationInterceptor(authManager)
        val chain = mockk<Interceptor.Chain>(relaxed = true)

        val authUrl = "https://api.example.com/auth"
        every { authManager.authUrl } returns authUrl

        // Mocking the authentication request
        val authRequestBuilder = mockk<Request.Builder>(relaxed = true)
        val authRequest = mockk<Request>(relaxed = true)
        every { authRequest.url } returns URL(authUrl)
        every { authRequest.newBuilder() } returns authRequestBuilder
        every { chain.request() } returns authRequest
        every { chain.proceed(authRequest) } returns mockk()

        // Act
        val response = interceptor.intercept(chain)

        // Assert
        // Verify that authUrl was called once
        verify(exactly = 1) { authManager.authUrl }

        // Verify that no authentication methods were called
        verify(exactly = 0) { authManager.authenticate() }
        verify(exactly = 0) { authManager.isTokenAboutToExpire() }
        verify(exactly = 0) { authManager.getAuthorizationHeaderValue() }

        // Optionally, confirm that no other interactions occurred
        confirmVerified(authManager)

        // Verify that chain.proceed was called once with authRequest
        verify(exactly = 1) { chain.proceed(authRequest) }

        // Ensure the response is not null
        assertNotNull(response)
    }


    @Test
    fun `intercept should add Authorization header and not authenticate when token is valid`() {
        // Arrange
        val authManager = mockk<BearerAuthenticationManager>(relaxed = true)
        val interceptor = BearerAuthenticationInterceptor(authManager)
        val chain = mockk<Interceptor.Chain>(relaxed = true)

        // Mocking a non-authentication request
        val requestBuilder = mockk<Request.Builder>(relaxed = true)
        val originalRequest = mockk<Request>(relaxed = true)
        val authorizedRequest = mockk<Request>(relaxed = true)
        val requestUrl = "https://api.example.com/data"

        every { originalRequest.url } returns URL(requestUrl)
        every { originalRequest.newBuilder() } returns requestBuilder
        every { requestBuilder.addHeader("Authorization", "Bearer valid_token") } returns requestBuilder
        every { requestBuilder.build() } returns authorizedRequest
        every { chain.request() } returns originalRequest
        every { chain.proceed(authorizedRequest) } returns mockk()

        // Mocking authManager behavior
        every { authManager.isTokenAboutToExpire() } returns false
        every { authManager.getAuthorizationHeaderValue() } returns "Bearer valid_token"

        // Act
        val response = interceptor.intercept(chain)

        // Assert
        verify(exactly = 1) { authManager.isTokenAboutToExpire() }
        verify(exactly = 1) { authManager.getAuthorizationHeaderValue() }
        verify(exactly = 0) { authManager.authenticate() }
        verify(exactly = 1) { requestBuilder.addHeader("Authorization", "Bearer valid_token") }
        verify(exactly = 1) { chain.proceed(authorizedRequest) }
        assertNotNull(response)
    }

    @Test
    fun `intercept should authenticate and add Authorization header when token is about to expire`() {
        // Arrange
        val authManager = mockk<BearerAuthenticationManager>(relaxed = true)
        val interceptor = BearerAuthenticationInterceptor(authManager)
        val chain = mockk<Interceptor.Chain>(relaxed = true)

        // Mocking a non-authentication request
        val requestBuilder = mockk<Request.Builder>(relaxed = true)
        val originalRequest = mockk<Request>(relaxed = true)
        val authorizedRequest = mockk<Request>(relaxed = true)
        val requestUrl = "https://api.example.com/data"

        every { originalRequest.url } returns URL(requestUrl)
        every { originalRequest.newBuilder() } returns requestBuilder
        every { requestBuilder.addHeader("Authorization", "Bearer refreshed_token") } returns requestBuilder
        every { requestBuilder.build() } returns authorizedRequest
        every { chain.request() } returns originalRequest
        every { chain.proceed(authorizedRequest) } returns mockk()

        // Mocking authManager behavior
        // Both calls to isTokenAboutToExpire() return true to trigger authenticate()
        every { authManager.isTokenAboutToExpire() } returnsMany listOf(true, true)
        every { authManager.authenticate() } just Runs
        every { authManager.getAuthorizationHeaderValue() } returns "Bearer refreshed_token"

        // Act
        val response = interceptor.intercept(chain)

        // Assert
        verify(exactly = 2) { authManager.isTokenAboutToExpire() } // Initial check and inside synchronized block
        verify(exactly = 1) { authManager.authenticate() }
        verify(exactly = 1) { authManager.getAuthorizationHeaderValue() }
        verify(exactly = 1) { requestBuilder.addHeader("Authorization", "Bearer refreshed_token") }
        verify(exactly = 1) { chain.proceed(authorizedRequest) }
        assertNotNull(response)
    }

    @Test
    fun `intercept should handle concurrent authentications and authenticate only once`() {
        // Arrange
        val authManager = mockk<BearerAuthenticationManager>(relaxed = true)
        val interceptor = BearerAuthenticationInterceptor(authManager)
        val chain = mockk<Interceptor.Chain>(relaxed = true)

        val numberOfThreads = 10
        val latch = CountDownLatch(numberOfThreads)
        val executor = Executors.newFixedThreadPool(numberOfThreads)

        // Mocking a non-authentication request
        val requestBuilder = mockk<Request.Builder>(relaxed = true)
        val originalRequest = mockk<Request>(relaxed = true)
        val authorizedRequest = mockk<Request>(relaxed = true)
        val requestUrl = "https://api.example.com/data"

        every { originalRequest.url } returns URL(requestUrl)
        every { originalRequest.newBuilder() } returns requestBuilder
        every { requestBuilder.addHeader("Authorization", "Bearer concurrent_token") } returns requestBuilder
        every { requestBuilder.build() } returns authorizedRequest
        every { chain.request() } returns originalRequest
        every { chain.proceed(authorizedRequest) } returns mockk()

        // Mocking authManager behavior
        // First call returns true to trigger authentication, subsequent calls return false
        every { authManager.isTokenAboutToExpire() } returnsMany listOf(
            true,
            true
        ).plus(List(numberOfThreads - 1) { false })
        every { authManager.authenticate() } just Runs
        every { authManager.getAuthorizationHeaderValue() } returns "Bearer concurrent_token"

        // Act
        repeat(numberOfThreads) {
            executor.submit {
                try {
                    interceptor.intercept(chain)
                } finally {
                    latch.countDown()
                }
            }
        }

        // Wait for all threads to complete
        val completed = latch.await(5, TimeUnit.SECONDS)
        executor.shutdown()

        // Assert
        assertTrue(completed, "All threads should complete within timeout")
        verify(exactly = 1) { authManager.authenticate() } // Should authenticate only once
        verify(exactly = numberOfThreads + 1) { authManager.isTokenAboutToExpire() } // Initial check and per thread
        verify(exactly = numberOfThreads) { authManager.getAuthorizationHeaderValue() }
        verify(exactly = numberOfThreads) { requestBuilder.addHeader("Authorization", "Bearer concurrent_token") }
        verify(exactly = numberOfThreads) { chain.proceed(authorizedRequest) }
    }

    @Test
    fun `intercept should throw ExpediaGroupAuthException when authentication fails`() {
        // Arrange
        val authManager = mockk<BearerAuthenticationManager>(relaxed = true)
        val interceptor = BearerAuthenticationInterceptor(authManager)
        val chain = mockk<Interceptor.Chain>(relaxed = true)

        // Mocking a non-authentication request
        val requestBuilder = mockk<Request.Builder>(relaxed = true)
        val originalRequest = mockk<Request>(relaxed = true)
        val requestUrl = "https://api.example.com/data"

        every { originalRequest.url } returns URL(requestUrl)
        every { originalRequest.newBuilder() } returns requestBuilder
        every { chain.request() } returns originalRequest

        // Mocking authManager behavior
        // Both calls to isTokenAboutToExpire() return true to trigger authenticate(), which throws IOException
        every { authManager.isTokenAboutToExpire() } returnsMany listOf(true, true)
        every { authManager.authenticate() } throws IOException("Network error")

        // Act & Assert
        val exception = assertThrows<ExpediaGroupAuthException> {
            interceptor.intercept(chain)
        }

        assertEquals("Failed to authenticate", exception.message)
        assertTrue(exception.cause is IOException)
        verify(exactly = 2) { authManager.isTokenAboutToExpire() } // Initial check and inside synchronized block
        verify(exactly = 1) { authManager.authenticate() }
        verify(exactly = 0) { authManager.getAuthorizationHeaderValue() }
        verify(exactly = 0) { chain.proceed(any()) }
    }

    @Test
    fun `intercept should add correct Authorization header`() {
        // Arrange
        val authManager = mockk<BearerAuthenticationManager>(relaxed = true)
        val interceptor = BearerAuthenticationInterceptor(authManager)
        val chain = mockk<Interceptor.Chain>(relaxed = true)

        val customToken = "Bearer custom_token_123"

        // Mocking a non-authentication request
        val requestBuilder = mockk<Request.Builder>(relaxed = true)
        val originalRequest = mockk<Request>(relaxed = true)
        val authorizedRequest = mockk<Request>(relaxed = true)
        val requestUrl = "https://api.example.com/data"

        every { originalRequest.url } returns URL(requestUrl)
        every { originalRequest.newBuilder() } returns requestBuilder
        every { requestBuilder.addHeader("Authorization", customToken) } returns requestBuilder
        every { requestBuilder.build() } returns authorizedRequest
        every { chain.request() } returns originalRequest
        every { chain.proceed(authorizedRequest) } returns mockk()

        // Mocking authManager behavior
        every { authManager.isTokenAboutToExpire() } returns false
        every { authManager.getAuthorizationHeaderValue() } returns customToken

        // Act
        val response = interceptor.intercept(chain)

        // Assert
        verify(exactly = 1) { authManager.isTokenAboutToExpire() }
        verify(exactly = 1) { authManager.getAuthorizationHeaderValue() }
        verify(exactly = 0) { authManager.authenticate() }
        verify(exactly = 1) { requestBuilder.addHeader("Authorization", customToken) }
        verify(exactly = 1) { chain.proceed(authorizedRequest) }
        assertNotNull(response)
    }

    @Test
    fun `ensureValidAuthentication should not call authenticate if token is not about to expire`() {
        // Arrange
        val authManager = mockk<BearerAuthenticationManager>(relaxed = true)
        val interceptor = BearerAuthenticationInterceptor(authManager)
        val chain = mockk<Interceptor.Chain>(relaxed = true)

        // Mocking a non-authentication request
        val requestBuilder = mockk<Request.Builder>(relaxed = true)
        val originalRequest = mockk<Request>(relaxed = true)
        val authorizedRequest = mockk<Request>(relaxed = true)
        val requestUrl = "https://api.example.com/data"

        every { originalRequest.url } returns URL(requestUrl)
        every { originalRequest.newBuilder() } returns requestBuilder
        every { requestBuilder.addHeader("Authorization", "Bearer valid_token") } returns requestBuilder
        every { requestBuilder.build() } returns authorizedRequest
        every { chain.request() } returns originalRequest
        every { chain.proceed(authorizedRequest) } returns mockk()

        // Mocking authManager behavior
        every { authManager.isTokenAboutToExpire() } returns false
        every { authManager.getAuthorizationHeaderValue() } returns "Bearer valid_token"

        // Act
        val response = interceptor.intercept(chain)

        // Assert
        verify(exactly = 1) { authManager.isTokenAboutToExpire() }
        verify(exactly = 0) { authManager.authenticate() }
        verify(exactly = 1) { authManager.getAuthorizationHeaderValue() }
        verify(exactly = 1) { requestBuilder.addHeader("Authorization", "Bearer valid_token") }
        verify(exactly = 1) { chain.proceed(authorizedRequest) }
        assertNotNull(response)
    }


    @Test
    fun `ensureValidAuthentication should call authenticate only once when multiple threads detect token expiration`() {
        // Arrange
        val authManager = mockk<BearerAuthenticationManager>(relaxed = true)
        val interceptor = BearerAuthenticationInterceptor(authManager)
        val chain = mockk<Interceptor.Chain>(relaxed = true)

        val numberOfThreads = 5
        val latch = CountDownLatch(numberOfThreads)
        val executor = Executors.newFixedThreadPool(numberOfThreads)

        // Mocking a non-authentication request
        val requestBuilder = mockk<Request.Builder>(relaxed = true)
        val originalRequest = mockk<Request>(relaxed = true)
        val authorizedRequest = mockk<Request>(relaxed = true)
        val requestUrl = "https://api.example.com/data"

        every { originalRequest.url } returns URL(requestUrl)
        every { originalRequest.newBuilder() } returns requestBuilder
        every { requestBuilder.addHeader("Authorization", "Bearer refreshed_token") } returns requestBuilder
        every { requestBuilder.build() } returns authorizedRequest
        every { chain.request() } returns originalRequest
        every { chain.proceed(authorizedRequest) } returns mockk()

        // Mocking authManager behavior
        // Use AtomicBoolean to simulate token expiration
        val tokenExpired = AtomicBoolean(true)
        every { authManager.isTokenAboutToExpire() } answers {
            tokenExpired.get()
        }
        every { authManager.authenticate() } answers {
            // Simulate some delay in authentication
            Thread.sleep(100)
            tokenExpired.set(false)
        }
        every { authManager.getAuthorizationHeaderValue() } returns "Bearer refreshed_token"
        every { authManager.authUrl } returns "https://api.example.com/auth"

        // Act
        repeat(numberOfThreads) {
            executor.submit {
                try {
                    interceptor.intercept(chain)
                } finally {
                    latch.countDown()
                }
            }
        }

        // Wait for all threads to complete
        val completed = latch.await(3, TimeUnit.SECONDS)
        executor.shutdown()

        // Assert
        assertTrue(completed, "All threads should complete within timeout")
        verify(exactly = 1) { authManager.authenticate() } // Should authenticate only once
        verify(atLeast = numberOfThreads) { authManager.isTokenAboutToExpire() }
        verify(exactly = numberOfThreads) { authManager.getAuthorizationHeaderValue() }
        verify(exactly = numberOfThreads) { requestBuilder.addHeader("Authorization", "Bearer refreshed_token") }
        verify(exactly = numberOfThreads) { chain.proceed(authorizedRequest) }
    }

}
