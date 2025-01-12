package com.expediagroup.sdk.core.okhttp

import io.mockk.mockk
import okhttp3.ConnectionPool
import okhttp3.Interceptor
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class BaseOkHttpClientTest {
    @Test
    fun `should return singleton instance`() {
        val instance1 = BaseOkHttpClient.getInstance()
        val instance2 = BaseOkHttpClient.getInstance()
        assertSame(instance1, instance2)
    }

    @Test
    fun `should return configured instance with timeouts correctly`() {
        // Given
        val configuration =
            OkHttpClientConfiguration(
                callTimeout = 1000,
                connectTimeout = 2000,
                readTimeout = 3000,
                writeTimeout = 4000,
            )

        // When
        val client = BaseOkHttpClient.getInstance(configuration)

        // Expect
        assertEquals(1000, client.callTimeoutMillis)
        assertEquals(2000, client.connectTimeoutMillis)
        assertEquals(3000, client.readTimeoutMillis)
        assertEquals(4000, client.writeTimeoutMillis)
    }

    @Test
    fun `should return configured instance with connection pool correctly`() {
        // Given
        val connectionPool = ConnectionPool(5, 10, TimeUnit.MINUTES)
        val configuration = OkHttpClientConfiguration(connectionPool = connectionPool)

        // When
        val client = BaseOkHttpClient.getInstance(configuration)

        // Expect
        assertSame(connectionPool, client.connectionPool)
    }

    @Test
    fun `should return configured instance with interceptors correctly`() {
        // Given
        val mockInterceptor = mockk<Interceptor>()
        val configuration = OkHttpClientConfiguration(interceptors = listOf(mockInterceptor))

        // When
        val client = BaseOkHttpClient.getInstance(configuration)

        // Expect
        assertTrue(client.interceptors.contains(mockInterceptor))
    }

    @Test
    fun `should return configured instance with network interceptors correctly`() {
        // Given
        val mockNetworkInterceptor = mockk<Interceptor>()
        val configuration = OkHttpClientConfiguration(networkInterceptors = listOf(mockNetworkInterceptor))

        // When
        val client = BaseOkHttpClient.getInstance(configuration)

        // Expect
        assertTrue(client.networkInterceptors.contains(mockNetworkInterceptor))
    }

    @Test
    fun `should return configured instance with retryOnConnectionFailure correctly`() {
        // Given
        val configuration = OkHttpClientConfiguration(retryOnConnectionFailure = true)

        // When
        val client = BaseOkHttpClient.getInstance(configuration)

        // Expect
        assertTrue(client.retryOnConnectionFailure)
    }

    @Test
    fun `should assign a new connection pool to the new instance if passed through the configurations`() {
        // Given
        val baseInstance = BaseOkHttpClient.getInstance()
        val instanceWithCustomCallTimeout =
            BaseOkHttpClient.getInstance(
                configuration = OkHttpClientConfiguration(callTimeout = 1000),
            )
        val newConnectionPoolConfiguration =
            OkHttpClientConfiguration(
                connectionPool = ConnectionPool(5, 10, TimeUnit.MINUTES),
            )

        // When
        val instanceWithCustomConnectionPool = BaseOkHttpClient.getInstance(newConnectionPoolConfiguration)

        // Expect
        assertSame(baseInstance.connectionPool, instanceWithCustomCallTimeout.connectionPool)
        assertNotSame(baseInstance.connectionPool, instanceWithCustomConnectionPool.connectionPool)
    }

    @Test
    fun `should return a new instance that share the same connection pool created by the base instance`() {
        // Given
        val baseInstance = BaseOkHttpClient.getInstance()
        val configuredInstance = BaseOkHttpClient.getInstance(OkHttpClientConfiguration(callTimeout = 1000))

        // When
        val baseInstanceConnectionPool = baseInstance.connectionPool
        val configuredInstanceConnectionPool = configuredInstance.connectionPool
        val baseInstanceDispatcher = baseInstance.dispatcher
        val configuredInstanceDispatcher = configuredInstance.dispatcher

        // Expect
        assertSame(baseInstanceConnectionPool, configuredInstanceConnectionPool)
        assertSame(baseInstanceDispatcher, configuredInstanceDispatcher)
    }

    @Test
    fun `should return same OKHttpInstance across multiple threads`() {
        // Given
        val threadsCount = 5
        val executor = Executors.newFixedThreadPool(threadsCount)
        val tasks = List(threadsCount) { Callable { BaseOkHttpClient.getInstance() } }

        // When
        val results = executor.invokeAll(tasks).map { it.get() }
        executor.shutdown()
        executor.awaitTermination(5, TimeUnit.SECONDS)
        val firstInstance = results.first()

        // Expect
        results.forEach { instance ->
            assertNotNull(instance)
            assertSame(firstInstance, instance)
        }
    }
}
