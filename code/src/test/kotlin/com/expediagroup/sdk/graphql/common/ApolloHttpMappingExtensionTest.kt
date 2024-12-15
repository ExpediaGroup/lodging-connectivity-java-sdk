package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.http.HttpBody
import com.apollographql.apollo.api.http.HttpMethod
import com.apollographql.apollo.api.http.HttpRequest
import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Method
import okio.Buffer
import okio.BufferedSink
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ApolloHttpMappingExtensionTest {

    @Nested
    inner class FromApolloToSDKConversion {

        @Nested
        inner class ToSDKRequestExtensionFunction {
            @Test
            fun `should map Apollo request to SDK request correctly`() {
                // Given
                val url = "https://www.example.com"
                val method = HttpMethod.Post
                val contentTypeHeader = Pair("Content-Type", "application/json")
                val userAgentHeader = Pair("User-Agent", "test-sdk")
                val bodyString = "Hello, world!"

                val body = object : HttpBody {
                    override val contentLength = -1L

                    override val contentType = CommonMediaTypes.APPLICATION_JSON_GRAPHQL.toString()

                    override fun writeTo(bufferedSink: BufferedSink) {
                        bufferedSink.writeUtf8(bodyString)
                    }
                }

                val apolloRequest = HttpRequest.Builder(method, url)
                    .body(body)
                    .addHeader(contentTypeHeader.first, contentTypeHeader.second)
                    .addHeader(userAgentHeader.first, userAgentHeader.second)
                    .build()

                // When
                val sdkRequest = apolloRequest.toSDKRequest()

                val buffer = Buffer()
                sdkRequest.body?.writeTo(buffer)
                val bufferStringContent = buffer.readUtf8()

                // Expect
                assertEquals(Method.POST, sdkRequest.method)
                assertEquals(url, sdkRequest.url.toString())
                assertEquals(contentTypeHeader.second, sdkRequest.headers.get(contentTypeHeader.first))
                assertEquals(userAgentHeader.second, sdkRequest.headers.get(userAgentHeader.first))
                assertEquals(bodyString, bufferStringContent)
            }

            @Test
            fun `should map Apollo request without body correctly`() {
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
        }
    }

    @Nested
    inner class FromSDKToApolloConversion {

    }
}