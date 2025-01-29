package com.expediagroup.sdk.rest.extension

import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import com.expediagroup.sdk.rest.serialization.DefaultJacksonBasedOperationDataMapper
import com.expediagroup.sdk.rest.trait.operation.ContentTypeTrait
import com.expediagroup.sdk.rest.trait.operation.HttpMethodTrait
import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationNoResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.serialization.DeserializeResponseBodyTrait
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.InputStream

class SDKCoreResponseExtensionTest {
    private val mapper = jacksonObjectMapper()
    private val deserializer = DefaultJacksonBasedOperationDataMapper(mapper)

    @Nested
    inner class ToRestResponseOperationResponseBodyTraitTest {
        @Test
        fun `parses response body and headers when OperationResponseBodyTrait is implemented`() {
            // given
            val inputStream = """["first", "second"]""".byteInputStream()
            val responseBody = ResponseBody.create(
                inputStream = inputStream,
                mediaType = CommonMediaTypes.APPLICATION_JSON,
                contentLength = inputStream.available().toLong()
            )

            val request = Request.builder()
                .url("http://localhost:8080")
                .method(Method.POST)
                .build()

            val response = Response.builder()
                .addHeader("header", "value")
                .status(Status.ACCEPTED)
                .protocol(Protocol.HTTP_1_1)
                .request(request)
                .body(responseBody)
                .build()

            // when
            val operation = object :
                HttpMethodTrait,
                JacksonModelOperationResponseBodyTrait<ArrayList<String>>,
                ContentTypeTrait {
                override fun getHttpMethod(): String = "POST"
                override fun getContentType(): String = CommonMediaTypes.APPLICATION_JSON.toString()
                override fun getTypeIdentifier(): TypeReference<ArrayList<String>> = jacksonTypeRef()
            }

            val restResponse = response.toRestResponse(operation, deserializer)

            // then
            assertNotNull(restResponse.data)
            assertNotNull(restResponse.headers)
            assertEquals(restResponse.data, listOf("first", "second"))
            assertEquals(1, restResponse.headers.entries().size)
            assertEquals("value", restResponse.headers.get("header"))
        }
    }

    @Nested
    inner class ToRestResponseOperationNoResponseBodyTraitTest {
        @Test
        fun `parses response headers and ignores body values when OperationNoResponseBodyTrait is implemented`() {
            // given
            val response = Response.builder()
                .addHeader("header", "value")
                .status(Status.ACCEPTED)
                .protocol(Protocol.HTTP_1_1)
                .request(
                    Request.builder()
                        .url("http://localhost:8080")
                        .method(Method.POST)
                        .build()
                ).build()

            // when
            val restResponse = response.toRestResponse(object : OperationNoResponseBodyTrait {})

            // then
            assertNull(restResponse.data)
            assertNotNull(restResponse.headers)
            assertEquals(1, restResponse.headers.entries().size)
            assertEquals("value", restResponse.headers.get("header"))
        }
    }

    @Nested
    inner class ParseBodyAsTypeTest {
        @Test
        fun `parses response body as specific type`() {
            // given
            val inputStream = """["first", "second"]""".byteInputStream()
            val responseBody = ResponseBody.create(
                inputStream = inputStream,
                mediaType = CommonMediaTypes.APPLICATION_JSON,
                contentLength = inputStream.available().toLong()
            )

            val request = Request.builder()
                .url("http://localhost:8080")
                .method(Method.POST)
                .build()

            val response = Response.builder()
                .addHeader("header", "value")
                .status(Status.ACCEPTED)
                .protocol(Protocol.HTTP_1_1)
                .request(request)
                .body(responseBody)
                .build()

            // when
            val operation = object :
                HttpMethodTrait,
                JacksonModelOperationResponseBodyTrait<ArrayList<String>>,
                ContentTypeTrait {
                override fun getHttpMethod(): String = "POST"
                override fun getContentType(): String = CommonMediaTypes.APPLICATION_JSON.toString()
                override fun getTypeIdentifier(): TypeReference<ArrayList<String>> = jacksonTypeRef()
            }

            val parsedBody = response.parseBodyAs(operation, deserializer)

            // then
            assertNotNull(parsedBody)
            assertEquals(listOf("first", "second"), parsedBody)
        }
    }
}
