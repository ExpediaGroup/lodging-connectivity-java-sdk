package com.expediagroup.sdk.lodgingconnectivity.configuration

import com.expediagroup.sdk.core.client.Transport
import io.mockk.mockk
import okhttp3.ConnectionPool
import okhttp3.Interceptor
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class ClientConfigurationTest {

    @Nested
    inner class DefaultClientConfigurationTest {

        @Test
        fun `should build and store configuration options correctly`() {
            val config = ClientConfiguration.builder()
                .key("test-key")
                .secret("test-secret")
                .environment(ClientEnvironment.TEST)
                .callTimeout(5000)
                .connectTimeout(3000)
                .readTimeout(3000)
                .writeTimeout(3000)
                .retryOnConnectionFailure(true)
                .build()

            assertEquals("test-key", config.key)
            assertEquals("test-secret", config.secret)
            assertEquals(ClientEnvironment.TEST, config.environment)
            assertEquals(5000, config.callTimeout)
            assertEquals(3000, config.connectTimeout)
            assertEquals(true, config.retryOnConnectionFailure)
        }

        @Test
        fun `should throw an exception when key is missing`() {
            val exception = assertThrows<IllegalArgumentException> {
                ClientConfiguration.builder()
                    .secret("test-secret")
                    .build()
            }

            assertEquals("key is required", exception.message)
        }

        @Test
        fun `should throw an exception when secret is missing`() {
            val exception = assertThrows<IllegalArgumentException> {
                ClientConfiguration.builder()
                    .key("test-key")
                    .build()
            }

            assertEquals("secret is required", exception.message)
        }

        @Test
        fun `should build OkHttp configurations from the passed parameters`() {
            val interceptors = listOf<Interceptor>(mockk(relaxed = true))
            val networkInterceptors = listOf<Interceptor>(mockk(relaxed = true))
            val connectionPool = mockk<ConnectionPool>(relaxed = true)

            val config = DefaultClientConfiguration.Builder()
                .key("test-key")
                .secret("test-secret")
                .interceptors(interceptors)
                .networkInterceptors(networkInterceptors)
                .connectionPool(connectionPool)
                .build()

            val okHttpConfig = config.buildOkHttpConfiguration()

            assertSame(interceptors, okHttpConfig.interceptors)
            assertSame(networkInterceptors, okHttpConfig.networkInterceptors)
            assertSame(connectionPool, okHttpConfig.connectionPool)
        }

    }

    @Nested
    inner class CustomClientConfigurationTest {
        @Test
        fun `should build and store configuration options correctly`() {
            val transport = mockk<Transport>(relaxed = true)

            val config = ClientConfiguration.builder(transport)
                .key("test-key")
                .secret("test-secret")
                .environment(ClientEnvironment.TEST)
                .build()

            assertEquals("test-key", config.key)
            assertEquals("test-secret", config.secret)
            assertEquals(ClientEnvironment.TEST, config.environment)
            assertEquals(transport, config.transport)
        }

        @Test
        fun `should throw an exception when key is missing`() {
            val transport = mockk<Transport>(relaxed = true)

            val exception = assertThrows<IllegalArgumentException> {
                ClientConfiguration.builder(transport)
                    .secret("test-secret")
                    .environment(ClientEnvironment.TEST)
                    .build()
            }

            assertEquals("key is required", exception.message)
        }

        @Test
        fun `should throw an exception when secret is missing`() {
            val transport = mockk<Transport>(relaxed = true)

            val exception = assertThrows<IllegalArgumentException> {
                ClientConfiguration.builder(transport)
                    .key("test-key")
                    .environment(ClientEnvironment.TEST)
                    .build()
            }

            assertEquals("secret is required", exception.message)
        }
    }
}