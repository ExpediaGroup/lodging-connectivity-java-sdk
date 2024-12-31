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
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AbstractRequestExecutorTest {

    @Test
    fun `should load the available Transport implementation in the classpath if not provided`() {
        // Given
        val mockTransport = mockk<Transport>()
        val mockLoader = mockk<ServiceLoader<Transport>>().also { mockkStatic(ServiceLoader::class) }

        every { mockLoader.iterator() } returns mutableListOf(mockTransport).iterator()
        every { ServiceLoader.load(Transport::class.java) } returns mockLoader

        // When
        val executor = object : AbstractRequestExecutor() {
            override val executionPipeline = mockk<ExecutionPipeline>()
        }

        val transportField = AbstractRequestExecutor::class.java.getDeclaredField("transport")
        transportField.isAccessible = true
        val loadedTransport = transportField.get(executor)

        // Expect
        assertNotNull(loadedTransport)
        assertEquals(mockTransport, loadedTransport)

        unmockkStatic(ServiceLoader::class)
    }

    @Test
    fun `should use provided Transport if given`() {
        // Given
        val mockTransport = mockk<Transport>()

        // When
        val executor = object : AbstractRequestExecutor(mockTransport) {
            override val executionPipeline = mockk<ExecutionPipeline>()
        }

        val transportField = AbstractRequestExecutor::class.java.getDeclaredField("transport")
        transportField.isAccessible = true
        val loadedTransport = transportField.get(executor)

        // Expect
        assertNotNull(loadedTransport)
        assertEquals(mockTransport, loadedTransport)
    }

    @Test
    fun `should throw an exception if unable to load Transport`() {
        // Given
        val mockLoader = mockk<ServiceLoader<Transport>>().also { mockkStatic(ServiceLoader::class) }

        every { mockLoader.iterator() } returns mutableListOf<Transport>().iterator()
        every { ServiceLoader.load(Transport::class.java) } returns mockLoader

        // When & Expect
        assertThrows<ExpediaGroupConfigurationException> {
            object : AbstractRequestExecutor() {
                override val executionPipeline = mockk<ExecutionPipeline>()
            }
        }

        unmockkStatic(ServiceLoader::class)
    }

    @Test
    fun `should apply the execution pipeline`() {
        val mockTransport = mockk<Transport>()
        val mockExecutionPipeline = mockk<ExecutionPipeline>()

        val executor = object : AbstractRequestExecutor(mockTransport) {
            override val executionPipeline = mockExecutionPipeline
        }

        every { mockTransport.execute(any()) } returns mockk<Response>()
        every { mockExecutionPipeline.startRequestPipeline(any<Request>()) } returns mockk<Request>()
        every { mockExecutionPipeline.startResponsePipeline(any<Response>()) } returns mockk<Response>()

        executor.execute(mockk<Request>())

        verify(exactly = 1) { mockExecutionPipeline.startRequestPipeline(any<Request>()) }
        verify(exactly = 1) { mockExecutionPipeline.startResponsePipeline(any<Response>()) }
        verify(exactly = 1) { mockTransport.execute(any<Request>()) }
    }

    @Test
    fun `should dispose the underlying Transport`() {
        // Given
        val mockTransport = mockk<Transport>()
        val executor = object : AbstractRequestExecutor(mockTransport) {
            override val executionPipeline = mockk<ExecutionPipeline>()
        }

        every { mockTransport.dispose() } just Runs

        // When
        executor.dispose()

        // Expect
        verify(exactly = 1) { mockTransport.dispose() }
    }
}
