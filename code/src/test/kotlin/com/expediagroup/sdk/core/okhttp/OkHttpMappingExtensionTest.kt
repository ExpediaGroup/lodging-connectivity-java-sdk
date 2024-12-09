package com.expediagroup.sdk.core.okhttp

import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Headers
import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.http.ResponseBody
import io.mockk.mockk
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import okio.BufferedSink
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class OkHttpMappingExtensionTest {
    @Nested
    inner class FromOkHttpToSDKConversion {

        @Nested
        inner class ToSDKRequestExtensionFunction {
            @Test
            fun `should correctly map OkHttp Request to SDK Request without body`() {
                // Given
                val okHttpRequest = okhttp3.Request.Builder()
                    .url("https://example.com")
                    .method("GET", null)
                    .header("Authorization", "Bearer token")
                    .method("GET", null)
                    .build()

                // When
                val sdkRequest = okHttpRequest.toSDKRequest()

                // Expect
                assertEquals("https://example.com/", sdkRequest.url.toString())
                assertEquals("Bearer token", sdkRequest.headers.get("Authorization"))
                assertNull(sdkRequest.body)
            }

            @Test
            fun `should correctly map OkHttp Request to SDK Request with body`() {
                // Given
                val content = "Hello World"
                val mediaTypeString = "text/plain"

                val okHttpRequestBody = object : okhttp3.RequestBody() {
                    override fun contentType(): okhttp3.MediaType? = mediaTypeString.toMediaTypeOrNull()
                    override fun writeTo(sink: BufferedSink) {
                        sink.writeUtf8(content)
                    }
                }

                val okHttpRequest = okhttp3.Request.Builder()
                    .url("https://example.com")
                    .method("POST", okHttpRequestBody)
                    .header("Authorization", "Bearer token")
                    .build()

                // When
                val sdkRequest = okHttpRequest.toSDKRequest()

                val okHttpRequestBodyBuffer = Buffer() // Capture the original body data using a Buffer
                okHttpRequest.body?.writeTo(okHttpRequestBodyBuffer)
                val okHttpRequestBodyString = okHttpRequestBodyBuffer.readUtf8()

                val sdkRequestBodyBuffer = Buffer() // Capture the SDK request body
                sdkRequest.body?.writeTo(sdkRequestBodyBuffer)
                val sdkRequestBodyString = sdkRequestBodyBuffer.readUtf8()

                // Then
                assertEquals("https://example.com/", sdkRequest.url.toString())
                assertEquals("Bearer token", sdkRequest.headers.get("Authorization"))
                assertEquals(okHttpRequestBodyString, sdkRequestBodyString)
                assertNotEquals("", sdkRequestBodyString)
                assertNotEquals("", okHttpRequestBodyString)
            }
        }

        @Nested
        inner class ToSDKHeadersExtensionFunction {
            @Test
            fun `should correctly map OkHttp Headers to SDK Headers`() {
                // Given
                val okHttpHeaders = okhttp3.Headers.Builder()
                    .add("Content-Type", "application/json")
                    .add("Authorization", "Bearer token")
                    .add("Content-Type", "text/plain")
                    .build()

                // When
                val sdkHeaders = okHttpHeaders.toSDKHeaders()

                // Expect
                assertEquals(listOf("application/json", "text/plain"), sdkHeaders.values("Content-Type"))
                assertEquals("Bearer token", sdkHeaders.get("Authorization"))
            }
        }

        @Nested
        inner class ToSDKRequestBodyExtensionFunction {
            @Test
            fun `should correctly map OkHttp RequestBody to SDK RequestBody with media type`() {
                // Given
                val content = "Hello World"
                val mediaTypeString = "text/plain"
                val contentLength = content.length.toLong()

                val okHttpRequestBody = object : okhttp3.RequestBody() {
                    override fun contentLength(): Long = contentLength
                    override fun contentType(): okhttp3.MediaType? = mediaTypeString.toMediaTypeOrNull()
                    override fun writeTo(sink: BufferedSink) { sink.writeUtf8(content) }
                }

                // When
                val sdkRequestBody = okHttpRequestBody.toSDKRequestBody()

                // Expect
                assertEquals(mediaTypeString, sdkRequestBody.mediaType()?.toString())
                assertEquals(contentLength, sdkRequestBody.contentLength())
                assertDoesNotThrow {
                    sdkRequestBody.writeTo(mockk(relaxed = true)) // Ensure write doesn't throw
                }
            }

            @Test
            fun `should correctly map OkHttp RequestBody to SDK RequestBody without media type`() {
                // Given
                val content = "Hello World"
                val contentLength = content.length.toLong()

                val okHttpRequestBody = object : okhttp3.RequestBody() {
                    override fun contentType(): okhttp3.MediaType? = null
                    override fun contentLength(): Long = contentLength
                    override fun writeTo(sink: BufferedSink) { sink.writeUtf8("Hello World") }
                }

                // When
                val sdkRequestBody = okHttpRequestBody.toSDKRequestBody()

                // Expect
                assertNull(sdkRequestBody.mediaType())
                assertEquals(contentLength, sdkRequestBody.contentLength())
                assertDoesNotThrow {
                    sdkRequestBody.writeTo(mockk(relaxed = true)) // Ensure write doesn't throw
                }
            }
        }

        @Nested
        inner class ToSDKResponseExtensionFunction {
            @Test
            fun `should correctly map OkHttp Response to SDK Response with response body`() {
                // Given
                val sdkRequest = Request.builder()
                    .url("https://example.com")
                    .method(Method.POST)
                    .build()

                val okHttpResponse = okhttp3.Response.Builder()
                    .request(okhttp3.Request.Builder().url("https://example.com").build())
                    .protocol(okhttp3.Protocol.HTTP_1_1)
                    .code(200)
                    .message("OK")
                    .header("Content-Type", "application/json")
                    .body("Response body".toResponseBody())
                    .build()

                // When
                val sdkResponse = okHttpResponse.toSDKResponse(sdkRequest)

                // Expect
                assertEquals(Protocol.HTTP_1_1, sdkResponse.protocol)
                assertEquals(200, sdkResponse.status.code)
                assertEquals("OK", sdkResponse.message)
                assertEquals("application/json", sdkResponse.headers.get("Content-Type"))
                assertEquals("Response body", sdkResponse.body?.source().use { source -> source?.readUtf8() })
            }

            @Test
            fun `should correctly map OkHttp Response to SDK Response without response body`() {
                // Given
                val sdkRequest = Request.builder()
                    .url("https://example.com")
                    .method(Method.POST)
                    .build()

                val okHttpResponse = okhttp3.Response.Builder()
                    .request(okhttp3.Request.Builder().url("https://example.com").build())
                    .protocol(okhttp3.Protocol.HTTP_1_1)
                    .code(200)
                    .message("OK")
                    .header("Content-Type", "application/json")
                    .build()

                // When
                val sdkResponse = okHttpResponse.toSDKResponse(sdkRequest)

                // Expect
                assertEquals(Protocol.HTTP_1_1, sdkResponse.protocol)
                assertEquals(200, sdkResponse.status.code)
                assertEquals("OK", sdkResponse.message)
                assertEquals("application/json", sdkResponse.headers.get("Content-Type"))
                assertNull(sdkResponse.body)
            }
        }

        @Nested
        inner class ToSDKResponseBodyExtensionFunction {
            @Test
            fun `should correctly map OkHttp ResponseBody to SDK ResponseBody with media type`() {
                // Given
                val okHttpResponseBody = "Response body".toResponseBody("text/plain".toMediaTypeOrNull())

                // When
                val sdkResponseBody = okHttpResponseBody.toSDKResponseBody()

                // Expect
                assertEquals("text/plain;charset=utf-8", sdkResponseBody.mediaType()?.toString())
                assertEquals("Response body", sdkResponseBody.source().use { source -> source.readUtf8() })
            }

            @Test
            fun `should correctly map OkHttp ResponseBody to SDK ResponseBody without media type`() {
                // Given
                val okHttpResponseBody = "Response body".toResponseBody()

                // When
                val sdkResponseBody = okHttpResponseBody.toSDKResponseBody()

                // Expect
                assertEquals("Response body", sdkResponseBody.source().use { source -> source.readUtf8() })
                assertNull(sdkResponseBody.mediaType())
            }
        }
    }

    @Nested
    inner class FromSDKToOkHttpConversion {

        @Nested
        inner class ToOkHttpRequestExtensionFunction {
            @Test
            fun `should correctly map SDK Request to OkHttp Request with request body and with media type`() {
                // Given
                val originalContent = "Hello World"

                val sdkRequest = Request.builder()
                    .url("https://example.com")
                    .addHeader("Authorization", "Bearer token")
                    .method(Method.POST)
                    .body(RequestBody.create(originalContent.byteInputStream(), CommonMediaTypes.TEXT_PLAIN))
                    .build()

                // When
                val okHttpRequest = sdkRequest.toOkHttpRequest()

                val okHttpBodyBuffer = Buffer() // Capture the OkHttp body
                okHttpRequest.body?.writeTo(okHttpBodyBuffer)
                val actualBody = okHttpBodyBuffer.readUtf8()

                // Expect
                assertEquals("https://example.com/", okHttpRequest.url.toString())
                assertEquals("Bearer token", okHttpRequest.header("Authorization"))
                assertEquals("POST", okHttpRequest.method)
                assertEquals("text/plain", okHttpRequest.body?.contentType().toString())
                assertEquals(originalContent, actualBody)
            }

            @Test
            fun `should correctly map SDK Request to OkHttp Request with request body and without media type`() {
                // Given
                val originalContent = "Hello World"

                val sdkRequest = Request.builder()
                    .url("https://example.com")
                    .addHeader("Authorization", "Bearer token")
                    .method(Method.POST)
                    .body(RequestBody.create(originalContent.byteInputStream()))
                    .build()

                // When
                val okHttpRequest = sdkRequest.toOkHttpRequest()

                // Capture the OkHttp body
                val okHttpBodyBuffer = Buffer()
                okHttpRequest.body?.writeTo(okHttpBodyBuffer)
                val actualBody = okHttpBodyBuffer.readUtf8()

                // Expect
                assertEquals("https://example.com/", okHttpRequest.url.toString())
                assertEquals("Bearer token", okHttpRequest.header("Authorization"))
                assertEquals("POST", okHttpRequest.method)
                assertNull(okHttpRequest.body?.contentType())
                assertEquals(originalContent, actualBody)
            }

            @Test
            fun `should correctly map SDK Request to OkHttp Request without request body`() {
                // Given
                val sdkRequest = Request.builder()
                    .url("https://example.com")
                    .addHeader("Authorization", "Bearer token")
                    .method(Method.GET)
                    .build()

                // When
                val okHttpRequest = sdkRequest.toOkHttpRequest()

                // Expect
                assertEquals("https://example.com/", okHttpRequest.url.toString())
                assertEquals("Bearer token", okHttpRequest.header("Authorization"))
                assertEquals("GET", okHttpRequest.method)
                assertNull(okHttpRequest.body)
            }
        }

        @Nested
        inner class ToOkHttpHeadersExtensionFunction {
            @Test
            fun `should correctly map SDK Headers to OkHttp Headers`() {
                // Given
                val sdkHeaders = Headers.builder()
                    .add("Content-Type", "application/json")
                    .add("Authorization", "Bearer token")
                    .add("Accept", listOf("text/plain", "text/html"))
                    .build()

                // When
                val okHttpHeaders = sdkHeaders.toOkHttpHeaders()

                // Expect
                assertEquals("application/json", okHttpHeaders["Content-Type"])
                assertEquals(listOf("text/plain", "text/html"), okHttpHeaders.values("accept"))
                assertEquals("Bearer token", okHttpHeaders["Authorization"])
            }
        }

        @Nested
        inner class ToOkHttpRequestBodyExtensionFunction {
            @Test
            fun `should correctly map SDK RequestBody to OkHttp RequestBody with media type`() {
                // Given
                val content = "Hello World"
                val sdkRequestBody = RequestBody.create(
                    inputStream = content.byteInputStream(),
                    mediaType = MediaType.parse("text/plain"),
                    contentLength = content.length.toLong()
                )

                // When
                val okHttpRequestBody = sdkRequestBody.toOkHttpRequestBody()

                val okHttpRequestBodyBuffer = Buffer()
                okHttpRequestBody.writeTo(okHttpRequestBodyBuffer)
                val okHttpRequestBodyString = okHttpRequestBodyBuffer.readUtf8()

                // Expect
                assertEquals("text/plain", okHttpRequestBody.contentType()?.toString())
                assertEquals(content.length.toLong(), okHttpRequestBody.contentLength())
                assertEquals(content, okHttpRequestBodyString)
                assertDoesNotThrow {
                    okHttpRequestBody.writeTo(mockk(relaxed = true))
                }
            }

            @Test
            fun `should correctly map SDK RequestBody to OkHttp RequestBody without media type`() {
                // Given
                val content = "Hello World"
                val sdkRequestBody = RequestBody.create(
                    inputStream = content.byteInputStream(),
                    contentLength = content.length.toLong()
                )

                // When
                val okHttpRequestBody = sdkRequestBody.toOkHttpRequestBody()

                val okHttpRequestBodyBuffer = Buffer()
                okHttpRequestBody.writeTo(okHttpRequestBodyBuffer)
                val okHttpRequestBodyString = okHttpRequestBodyBuffer.readUtf8()

                // Expect
                assertEquals(content.length.toLong(), okHttpRequestBody.contentLength())
                assertEquals(content, okHttpRequestBodyString)
                assertNull(okHttpRequestBody.contentType())
                assertDoesNotThrow {
                    okHttpRequestBody.writeTo(mockk(relaxed = true))
                }
            }
        }

        @Nested
        inner class ToOkHttpResponseBodyExtensionFunction {
            @Test
            fun `should correctly map SDK ResponseBody to OkHttp ResponseBody`() {
                // Given
                val content = "Response Body"
                val sdkResponseBody = ResponseBody.create(
                    inputStream = content.byteInputStream(),
                    mediaType = CommonMediaTypes.TEXT_PLAIN,
                    contentLength = content.length.toLong()
                )

                // When
                val okHttpResponseBody = sdkResponseBody.toOkHttpResponseBody()

                // Expect
                assertEquals(CommonMediaTypes.TEXT_PLAIN.toString(), okHttpResponseBody.contentType().toString())
                assertEquals(content.length.toLong(), okHttpResponseBody.contentLength())
                assertEquals(content, sdkResponseBody.source().use { source -> source.readUtf8() })
                assertEquals(sdkResponseBody.source(), okHttpResponseBody.source())
            }
        }
    }
}
