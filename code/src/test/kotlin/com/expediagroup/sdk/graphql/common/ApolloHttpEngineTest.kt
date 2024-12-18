package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.http.HttpBody
import com.apollographql.apollo.api.http.HttpMethod
import com.apollographql.apollo.api.http.HttpRequest
import com.apollographql.apollo.exception.ApolloNetworkException
import com.apollographql.java.client.ApolloDisposable
import com.apollographql.java.client.network.http.HttpCallback
import com.expediagroup.sdk.core.client.RequestExecutor
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.Status
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.util.concurrent.ConcurrentHashMap
import okio.Buffer
import okio.BufferedSink
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ApolloHttpEngineTest {
    private lateinit var requestExecutor: RequestExecutor
    private lateinit var callback: HttpCallback
    private lateinit var disposable: ApolloDisposable
    private lateinit var httpEngine: ApolloHttpEngine

    @BeforeEach
    fun setUp() {
        requestExecutor = mockk()
        callback = mockk(relaxed = true)
        disposable = mockk(relaxed = true)
        httpEngine = ApolloHttpEngine(requestExecutor)
    }

    private fun Request.match(other: Request): Boolean {
        val buffer = Buffer().also { body?.writeTo(it) }
        val otherBuffer = Buffer().also { other.body?.writeTo(it) }

        return this.method == other.method &&
                url.toString() == other.url.toString() &&
                headers.names() == other.headers.names() &&
                method == other.method &&
                body?.contentLength() == other.body?.contentLength() &&
                body?.mediaType().toString() == other.body?.mediaType().toString() &&
                buffer.readUtf8() == otherBuffer.readUtf8()
    }

    @Test
    fun `should execute HTTP request successfully`() {
        // Given
        val bodyString = "Hello World!"

        val apolloRequestBody = object : HttpBody {
            override val contentLength = bodyString.length.toLong()
            override val contentType = "text/plain"
            override fun writeTo(bufferedSink: BufferedSink) {
                bufferedSink.writeUtf8(bodyString)
            }
        }

        val apolloRequest = HttpRequest.Builder(method = HttpMethod.Post, url = "https://example.com")
            .body(apolloRequestBody)
            .build()

        val sdkRequest = apolloRequest.toSDKRequest()

        val sdkResponse = Response.builder()
            .status(Status.OK)
            .request(sdkRequest)
            .protocol(Protocol.HTTP_1_1)
            .build()

        every { requestExecutor.execute(match { it.match(sdkRequest) }) } returns sdkResponse

        // When
        httpEngine.execute(apolloRequest, callback, disposable)

        // Expect
        verify { requestExecutor.execute(match { it.match(sdkRequest) }) }
        verify { callback.onResponse(match { it.statusCode == 200 }) }
        verify(exactly = 0) { callback.onFailure(any()) }
    }

    @Test
    fun `should handle failure when HTTP request throws exception`() {
        // Given
        val apolloRequest = HttpRequest.Builder(method = HttpMethod.Post, url = "https://example.com").build()
        val sdkRequest = apolloRequest.toSDKRequest()

        every { requestExecutor.execute(sdkRequest) } throws RuntimeException("Execution error")

        // When
        httpEngine.execute(apolloRequest, callback, disposable)

        // Then
        verify { callback.onFailure(any(ApolloNetworkException::class)) }
    }

    @Test
    fun `should handle HTTP engine disposed state`() {
        // Given
        val httpRequest = mockk<HttpRequest>()
        httpEngine.dispose()

        // When
        httpEngine.execute(httpRequest, callback, disposable)

        // Then
        verify {
            callback.onFailure(withArg { exception ->
                assertTrue(exception.message!!.contains("HTTP engine has been disposed"))
            })
        }
    }

    @Test
    fun `should dispose active requests on dispose`() {
        // Given
        val disposable1 = mockk<ApolloDisposable>(relaxed = true)
        val disposable2 = mockk<ApolloDisposable>(relaxed = true)
        val activeRequests = ConcurrentHashMap<String, ApolloDisposable>().apply {
            this["request1"] = disposable1
            this["request2"] = disposable2
        }

        val activeRequestsField = ApolloHttpEngine::class.java.getDeclaredField("activeRequests")
        activeRequestsField.isAccessible = true
        activeRequestsField.set(httpEngine, activeRequests)

        // When
        httpEngine.dispose()

        // Then
        verify { disposable1.dispose() }
        verify { disposable2.dispose() }
        assertTrue(activeRequests.isEmpty())
    }

    @Test
    fun `should prevent execution after dispose`() {
        // Given
        val httpRequest = mockk<HttpRequest>()
        httpEngine.dispose()

        // When
        httpEngine.execute(httpRequest, callback, disposable)

        // Then
        verify {
            callback.onFailure(withArg { exception ->
                assertTrue(exception.message!!.contains("HTTP engine has been disposed"))
            })
        }
    }

    @Test
    fun `should not invoke callback onResponse if engine is disposed during execution`() {
        // Given
        val apolloRequest = HttpRequest.Builder(method = HttpMethod.Post, url = "https://example.com").build()
        val sdkRequest = apolloRequest.toSDKRequest()
        val sdkResponse = Response.builder()
            .status(Status.OK)
            .request(sdkRequest)
            .protocol(Protocol.HTTP_1_1)
            .build()

        every { requestExecutor.execute(match { it.match(sdkRequest) }) } answers {
            // Simulate disposing the engine during execution
            httpEngine.dispose()
            sdkResponse
        }

        // When
        httpEngine.execute(apolloRequest, callback, disposable)

        // Then
        verify(exactly = 0) { callback.onResponse(any()) }
        verify(exactly = 0) { callback.onFailure(any()) }
    }

    @Test
    fun `should dispose only once when dispose is called multiple times`() {
        // Given
        val disposable1 = mockk<ApolloDisposable>(relaxed = true)
        val disposable2 = mockk<ApolloDisposable>(relaxed = true)
        val activeRequests = ConcurrentHashMap<String, ApolloDisposable>().apply {
            this["request1"] = disposable1
            this["request2"] = disposable2
        }

        val activeRequestsField = ApolloHttpEngine::class.java.getDeclaredField("activeRequests")
        activeRequestsField.isAccessible = true
        activeRequestsField.set(httpEngine, activeRequests)

        // When
        httpEngine.dispose()
        httpEngine.dispose()

        // Then
        verify(exactly = 1) { disposable1.dispose() }
        verify(exactly = 1) { disposable2.dispose() }
        assertTrue(activeRequests.isEmpty())
    }
}
