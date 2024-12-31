package com.expediagroup.sdk.transport

import com.expediagroup.sdk.exception.client.ExpediaGroupConfigurationException
import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.http.Response
import com.expediagroup.sdk.pipeline.ExecutionPipeline
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import io.mockk.verify
import java.util.ServiceLoader
import java.util.concurrent.CompletableFuture
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AbstractAsyncRequestExecutorTest {

    @Test
    fun `should load the available AsyncTransport implementation in the classpath if not provided`() {
        // Given
        val mockAsyncTransport = mockk<AsyncTransport>()
        val mockLoader = mockk<ServiceLoader<AsyncTransport>>().also { mockkStatic(ServiceLoader::class) }

        every { mockLoader.iterator() } returns mutableListOf(mockAsyncTransport).iterator()
        every { ServiceLoader.load(AsyncTransport::class.java) } returns mockLoader

        // When
        val asyncExecutor = object : AbstractAsyncRequestExecutor() {
            override val executionPipeline = mockk<ExecutionPipeline>()
        }

        val asyncTransportField = AbstractAsyncRequestExecutor::class.java.getDeclaredField("asyncTransport")
        asyncTransportField.isAccessible = true
        val loadedAsyncTransport = asyncTransportField.get(asyncExecutor)

        // Expect
        assertNotNull(loadedAsyncTransport)
        assertEquals(mockAsyncTransport, loadedAsyncTransport)

        unmockkStatic(ServiceLoader::class)
    }

    @Test
    fun `should use provided AsyncTransport if given`() {
        // Given
        val mockAsyncTransport = mockk<AsyncTransport>()

        // When
        val executor = object : AbstractAsyncRequestExecutor(mockAsyncTransport) {
            override val executionPipeline = mockk<ExecutionPipeline>()
        }

        val asyncTransportField = AbstractAsyncRequestExecutor::class.java.getDeclaredField("asyncTransport")
        asyncTransportField.isAccessible = true
        val loadedAsyncTransport = asyncTransportField.get(executor)

        // Expect
        assertNotNull(loadedAsyncTransport)
        assertEquals(mockAsyncTransport, loadedAsyncTransport)
    }

    @Test
    fun `should throw an exception if unable to load AsyncTransport`() {
        // Given
        val mockLoader = mockk<ServiceLoader<AsyncTransport>>().also { mockkStatic(ServiceLoader::class) }

        every { mockLoader.iterator() } returns mutableListOf<AsyncTransport>().iterator()
        every { ServiceLoader.load(AsyncTransport::class.java) } returns mockLoader

        // When & Expect
        assertThrows<ExpediaGroupConfigurationException> {
            object : AbstractAsyncRequestExecutor() {
                override val executionPipeline = mockk<ExecutionPipeline>()
            }
        }

        unmockkStatic(ServiceLoader::class)
    }

    @Test
    fun `should apply the execution pipeline`() {
        val mockAsyncTransport = mockk<AsyncTransport>()
        val mockExecutionPipeline = mockk<ExecutionPipeline>()

        val asyncExecutor = object : AbstractAsyncRequestExecutor(mockAsyncTransport) {
            override val executionPipeline = mockExecutionPipeline
        }

        every { mockAsyncTransport.execute(any()) } returns CompletableFuture.completedFuture(mockk<Response>())
        every { mockExecutionPipeline.startRequestPipeline(any<Request>()) } returns mockk<Request>()
        every { mockExecutionPipeline.startResponsePipeline(any<Response>()) } returns mockk<Response>()

        asyncExecutor.execute(mockk<Request>())

        verify(exactly = 1) { mockExecutionPipeline.startRequestPipeline(any<Request>()) }
        verify(exactly = 1) { mockExecutionPipeline.startResponsePipeline(any<Response>()) }
        verify(exactly = 1) { mockAsyncTransport.execute(any<Request>()) }
    }

    @Test
    fun `should dispose the underlying AsyncTransport`() {
        // Given
        val mockAsyncTransport = mockk<AsyncTransport>()
        val asyncExecutor = object : AbstractAsyncRequestExecutor(mockAsyncTransport) {
            override val executionPipeline = mockk<ExecutionPipeline>()
        }

        every { mockAsyncTransport.dispose() } just Runs

        // When
        asyncExecutor.dispose()

        // Expect
        verify(exactly = 1) { mockAsyncTransport.dispose() }
    }
}
