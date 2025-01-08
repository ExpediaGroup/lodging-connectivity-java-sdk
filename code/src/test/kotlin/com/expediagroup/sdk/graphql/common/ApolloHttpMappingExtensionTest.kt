package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.http.HttpBody
import com.apollographql.apollo.api.http.HttpMethod
import com.apollographql.apollo.api.http.HttpRequest
import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import okio.Buffer
import okio.BufferedSink
import okio.BufferedSource
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ApolloHttpMappingExtensionTest {
    @Test
    fun `toSDKRequest should map Apollo request to SDK request`() {
        // Given
        val url = "https://www.example.com"
        val method = HttpMethod.Post
        val contentTypeHeader = Pair("Content-Type", "application/json")
        val userAgentHeader = Pair("User-Agent", "test-sdk")
        val bodyString = "Hello, world!"

        val body =
            object : HttpBody {
                override val contentLength = -1L

                override val contentType = CommonMediaTypes.APPLICATION_JSON_GRAPHQL.toString()

                override fun writeTo(bufferedSink: BufferedSink) {
                    bufferedSink.writeUtf8(bodyString)
                }
            }

        val apolloRequest =
            HttpRequest
                .Builder(method, url)
                .body(body)
                .addHeader(contentTypeHeader.first, contentTypeHeader.second)
                .addHeader(userAgentHeader.first, userAgentHeader.second)
                .build()

        // When
        val sdkRequest = apolloRequest.toSDKRequest()
        val buffer = Buffer().also { sdkRequest.body?.writeTo(it) }

        // Expect
        assertEquals(Method.POST, sdkRequest.method)
        assertEquals(url, sdkRequest.url.toString())
        assertEquals(contentTypeHeader.second, sdkRequest.headers.get(contentTypeHeader.first))
        assertEquals(userAgentHeader.second, sdkRequest.headers.get(userAgentHeader.first))
        assertEquals(bodyString, buffer.readUtf8())
    }

    @Test
    fun `toSDKRequest should map Apollo request without body`() {
        // Given
        val url = "https://www.example.com"
        val method = HttpMethod.Get

        val apolloRequest = HttpRequest.Builder(method, url).build()

        // When
        val sdkRequest = apolloRequest.toSDKRequest()

        // Expect
        assertEquals(Method.GET, sdkRequest.method)
        assertEquals(url, sdkRequest.url.toString())
    }

    @Test
    fun `toSDKRequestBody should map Apollo request to SDK request body`() {
        // Given
        val bodyString = "Hello, world!"
        val body =
            object : HttpBody {
                override val contentLength = -1L

                override val contentType = CommonMediaTypes.APPLICATION_JSON_GRAPHQL.toString()

                override fun writeTo(bufferedSink: BufferedSink) {
                    bufferedSink.writeUtf8(bodyString)
                }
            }

        // When
        val sdkRequestBody = body.toSDKRequestBody()
        val buffer = Buffer().also { sdkRequestBody.writeTo(it) }

        // Expect
        assertEquals(bodyString, buffer.readUtf8())
        assertEquals(body.contentLength, sdkRequestBody.contentLength())
        assertEquals(body.contentType, sdkRequestBody.mediaType().toString())
    }

    @Test
    fun `toSDKRequestBody should map Apollo request to SDK request body with invalid media type`() {
        // Given
        val bodyString = "Hello, world!"
        val body =
            object : HttpBody {
                override val contentLength = -1L

                override val contentType = "invalid"

                override fun writeTo(bufferedSink: BufferedSink) {
                    bufferedSink.writeUtf8(bodyString)
                }
            }

        // When
        val sdkRequestBody = body.toSDKRequestBody()
        val buffer = Buffer().also { sdkRequestBody.writeTo(it) }

        // Expect
        assertEquals(bodyString, buffer.readUtf8())
        assertEquals(body.contentLength, sdkRequestBody.contentLength())
        assertEquals(null, sdkRequestBody.mediaType())
    }

    @Test
    fun `toApolloResponse should map SDK response to Apollo response`() {
        // Given
        val sdkRequest =
            Request
                .builder()
                .url("https://www.example.com")
                .method(Method.GET)
                .build()

        val responseString = "Hello, world!"

        val responseBody = ResponseBody.create(responseString.byteInputStream())

        val sdkResponse =
            Response
                .builder()
                .request(sdkRequest)
                .status(Status.OK)
                .protocol(Protocol.HTTP_1_1)
                .body(responseBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("User-Agent", "test-sdk")
                .build()

        // When
        val apolloResponse = sdkResponse.toApolloResponse()

        // Expect
        assertEquals(sdkResponse.status.code, apolloResponse.statusCode)
        assertEquals("application/json", apolloResponse.headers.find { it.name == "content-type" }?.value)
        assertEquals("test-sdk", apolloResponse.headers.find { it.name == "user-agent" }?.value)
    }

    @Test
    fun `toApolloResponse should map SDK response to Apollo response without body`() {
        // Given
        val sdkRequest =
            Request
                .builder()
                .url("https://www.example.com")
                .method(Method.GET)
                .build()

        val sdkResponse =
            Response
                .builder()
                .request(sdkRequest)
                .status(Status.OK)
                .protocol(Protocol.HTTP_1_1)
                .addHeader("Content-Type", "application/json")
                .addHeader("User-Agent", "test-sdk")
                .build()

        // When
        val apolloResponse = sdkResponse.toApolloResponse()

        // Expect
        assertEquals(sdkResponse.status.code, apolloResponse.statusCode)
        assertEquals("application/json", apolloResponse.headers.find { it.name == "content-type" }?.value)
        assertEquals("test-sdk", apolloResponse.headers.find { it.name == "user-agent" }?.value)
    }

    @Test
    fun `toApolloResponse should close the original SDK response resource`() {
        // Given
        val mockResponse = mockk<Response>(relaxed = true)
        val mockResponseBody = mockk<ResponseBody>(relaxed = true)
        val mockSource = mockk<BufferedSource>(relaxed = true)

        every { mockResponse.body } returns mockResponseBody
        every { mockResponseBody.source() } returns mockSource

        // When
        mockResponse.toApolloResponse()

        // Expect
        verify { mockResponse.close() }
        verify { mockSource.close() }
    }
}
