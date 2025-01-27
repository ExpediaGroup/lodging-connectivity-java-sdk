package com.expediagroup.sdk.rest.trait.operation

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class OperationTraitsTest {
    @Test
    fun `an operation can implement all traits without conflicts`() {
        assertDoesNotThrow {
            val operation = object : ResponseBodyJacksonTypeIdentifierTrait<String>,
                HttpMethodTrait,
                UrlPathTrait,
                HeadersTrait,
                OperationRequestBodyTrait<String>,
                UrlQueryParamsTrait,
                ContentTypeTrait,
                JacksonModelResponseBodyTrait<String> {

                override fun getHttpMethod(): String = "POST"

                override fun getUrlPath(): String = "/path"

                override fun getHeaders(): Map<String, List<String>> = emptyMap()

                override fun getRequestBody(): String = "request body"

                override fun getContentType(): String = "application/json"

                override fun getTypeIdentifier(): TypeReference<String> = jacksonTypeRef<String>()

                override fun getUrlQueryParams(): Map<String, List<String>> = emptyMap()
            }
        }
    }

    @Test
    fun `an operation can use all methods inherited by traits when implemented`() {
        val httpOperation = "POST"
        val urlPath = "/path"
        val headers = mapOf(
            "header1" to listOf("value1"),
            "header2" to listOf("value2")
        )
        val requestBody = "request body"
        val contentType = "application/json"
        val typeIdentifier = jacksonTypeRef<String>()
        val urlQueryParams = mapOf(
            "param1" to listOf("value1"),
            "param2" to listOf("value2")
        )

        val operation = object : ResponseBodyJacksonTypeIdentifierTrait<String>,
            HttpMethodTrait,
            UrlPathTrait,
            HeadersTrait,
            OperationRequestBodyTrait<String>,
            UrlQueryParamsTrait,
            ContentTypeTrait,
            JacksonModelResponseBodyTrait<String> {

            override fun getHttpMethod(): String = httpOperation

            override fun getUrlPath(): String = urlPath

            override fun getHeaders(): Map<String, List<String>> = headers

            override fun getRequestBody(): String = requestBody

            override fun getContentType(): String = contentType

            override fun getTypeIdentifier(): TypeReference<String> = typeIdentifier

            override fun getUrlQueryParams(): Map<String, List<String>> = urlQueryParams
        }

        assertEquals(httpOperation, operation.getHttpMethod())
        assertEquals(urlPath, operation.getUrlPath())
        assertEquals(headers, operation.getHeaders())
        assertEquals(requestBody, operation.getRequestBody())
        assertEquals(contentType, operation.getContentType())
        assertEquals(typeIdentifier, operation.getTypeIdentifier())
        assertEquals(urlQueryParams, operation.getUrlQueryParams())
    }
}
