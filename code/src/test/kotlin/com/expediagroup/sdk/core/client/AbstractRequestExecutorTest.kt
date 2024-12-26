package com.expediagroup.sdk.core.client

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor
import com.expediagroup.sdk.core.interceptor.InterceptorsChainExecutor
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkConstructor
import io.mockk.verify
import org.junit.jupiter.api.Test

class AbstractRequestExecutorTest {
    private val mockTransport = mockk<SyncTransport>(relaxed = true)
    private val mockInterceptor1 = mockk<Interceptor>(relaxed = true)
    private val mockInterceptor2 = mockk<Interceptor>(relaxed = true)

    private val testRequestExecutor = object : AbstractRequestExecutor(mockTransport) {
        override val interceptors: List<Interceptor> = listOf(mockInterceptor1, mockInterceptor2)
    }

    @Test
    fun `should call the applied interceptors in the default execute implementation`() {
        // Given
        val mockRequest = mockk<Request>(relaxed = true)
        val mockResponse = mockk<Response>(relaxed = true)
        val mockChain = mockk<Interceptor.Chain>(relaxed = true)

        mockkConstructor(InterceptorsChainExecutor::class)

        every {
            mockChain.proceed(any())
        } returns mockResponse

        every {
            anyConstructed<InterceptorsChainExecutor>().proceed(mockRequest)
        } answers {
            mockInterceptor1.intercept(mockChain)
            mockInterceptor2.intercept(mockChain)
            mockResponse
        }

        // When
        testRequestExecutor.execute(mockRequest)

        // Then
        verify(exactly = 1) { mockInterceptor1.intercept(mockChain) }
        verify(exactly = 1) { mockInterceptor2.intercept(mockChain) }
    }

    @Test
    fun `should delegate the dispose call to the inject transport dispose`() {
        testRequestExecutor.dispose()
        verify(exactly = 1) { mockTransport.dispose() }
    }
}
