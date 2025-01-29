package com.expediagroup.sdk.rest.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ResponseTest {

    @Test
    fun `response contains correct data`() {
        val data = "response data"
        val headers = mapOf("Content-Type" to listOf("application/json"))
        val response = Response(data, headers)
        assertEquals(data, response.data)
    }

    @Test
    fun `response contains correct headers`() {
        val data = "response data"
        val headers = mapOf("Content-Type" to listOf("application/json"))
        val response = Response(data, headers)
        assertEquals(headers, response.headers)
    }

    @Test
    fun `response handles empty headers`() {
        val data = "response data"
        val headers = emptyMap<String, List<String>>()
        val response = Response(data, headers)
        assertEquals(headers, response.headers)
    }

    @Test
    fun `response handles null data`() {
        val data: String? = null
        val headers = mapOf("Content-Type" to listOf("application/json"))
        val response = Response(data, headers)
        assertEquals(data, response.data)
    }

    @Test
    fun `response handles empty data`() {
        val data = ""
        val headers = mapOf("Content-Type" to listOf("application/json"))
        val response = Response(data, headers)
        assertEquals(data, response.data)
    }
}
