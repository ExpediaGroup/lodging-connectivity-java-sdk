package com.expediagroup.sdk.core.http

import java.net.MalformedURLException
import java.net.URL
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RequestTest {

    @Test
    fun `should build request instance with all properties`() {
        // Given
        val method = Method.POST
        val url = URL("https://example.com")
        val headers = Headers.Builder().add("Authorization", "Bearer token").build()
        val body = RequestBody.create("Sample body".byteInputStream())

        // When
        val request = Request
            .builder()
            .method(method)
            .url(url)
            .headers(headers)
            .body(body)
            .build()

        // Expect
        assertEquals(method, request.method)
        assertEquals(url, request.url)
        assertEquals("Bearer token", request.headers.get("Authorization"))
        assertEquals(body, request.body)
    }

    @Test
    fun `should build a new request based on previous instance`() {
        // Given
        val originalRequest = Request
            .builder()
            .method(Method.GET)
            .url("https://example.com")
            .addHeader("Content-Type", "application/json")
            .build()

        // When
        val newRequest = originalRequest
            .newBuilder()
            .addHeader("Accept", "text/plain")
            .build()

        // Expect
        assertEquals(Method.GET, newRequest.method)
        assertEquals(originalRequest.url, newRequest.url)

        assertEquals("application/json", originalRequest.headers.get("Content-Type"))
        assertNull(originalRequest.headers.get("Accept"))

        assertEquals("application/json", newRequest.headers.get("Content-Type"))
        assertEquals("text/plain", newRequest.headers.get("Accept"))
    }

    @Test
    fun `should build a request with valid method and url string`() {
        // Given
        val urlString = "https://example.com"

        // When
        val request = Request
            .builder()
            .method(Method.GET)
            .url(urlString)
            .build()

        // Expect
        assertEquals(URL(urlString), request.url)
    }

    @Test
    fun `should throw an exception if the URL string is invalid`() {
        val invalidUrl = "invalid_url"

        val exception = assertThrows<MalformedURLException> {
            Request.builder().method(Method.GET).url(invalidUrl).build()
        }

        assertEquals("no protocol: invalid_url", exception.message)
    }

    @Test
    fun `should throw an exception if the method is missing`() {
        val exception = assertThrows<IllegalStateException> {
            Request.builder().url("https://example.com").build()
        }

        assertEquals("Method is required.", exception.message)
    }

    @Test
    fun `should throw an exception if the URL is missing`() {
        val exception = assertThrows<IllegalStateException> {
            Request.builder().method(Method.GET).build()
        }

        assertEquals("URL is required.", exception.message)
    }

    @Test
    fun `should handle adding and setting headers as expected`() {
        val request = Request
            .builder()
            .method(Method.GET)
            .url("https://example.com")
            .addHeader("Header1", "Value1")
            .setHeader("Header2", "Value2")
            .setHeader("Header1", "NewValue1")
            .build()

        assertEquals("NewValue1", request.headers.get("Header1"))
        assertEquals("Value2", request.headers.get("Header2"))
    }

    @Test
    fun `should remove headers as expected`() {
        val request = Request
            .builder()
            .method(Method.GET)
            .url("https://example.com")
            .addHeader("Header1", "Value1")
            .addHeader("Header2", "Value2")
            .removeHeader("Header1")
            .build()

        assertNull(request.headers.get("Header1"))
        assertEquals("Value2", request.headers.get("Header2"))
    }

    @Test
    fun `should build a request without a body`() {
        val request = Request
            .builder()
            .method(Method.GET)
            .url("https://example.com")
            .build()

        assertNull(request.body)
    }
}
