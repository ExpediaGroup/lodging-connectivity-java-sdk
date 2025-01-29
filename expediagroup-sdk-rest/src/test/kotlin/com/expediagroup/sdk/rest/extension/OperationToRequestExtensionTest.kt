package com.expediagroup.sdk.rest.extension

import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.rest.trait.operation.ContentTypeTrait
import com.expediagroup.sdk.rest.trait.operation.HttpMethodTrait
import com.expediagroup.sdk.rest.trait.operation.UrlPathTrait
import com.expediagroup.sdk.rest.trait.operation.UrlQueryParamsTrait
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.net.URL

class OperationToRequestExtensionTest {
    @Nested
    inner class ParseUrlTest {
        @ParameterizedTest
        @ValueSource(
            strings = [
                "http://example.com:1234/v2/htmx",
                "http://127.0.0.1:8080/v1/api",
                "https://example.com:443/anime",
                "ftp://ftp.example.com:21",
                "file://servername:32234"
            ]
        )
        fun `parses url with different ports`(base: String) {
            val baseUrl = URL(base)
            val operation = object : UrlPathTrait {
                override fun getUrlPath(): String = "/test"
            }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("$base/test")

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "http://example.com/v1/api",
                "http://127.0.0.1:8080/v1/api",
                "https://example.com/v1/api",
                "ftp://ftp.example.com/v1/api",
                "file:///home/v1/api",
                "file://servername/v1/api",
            ]
        )
        fun `respects base url path`(base: String) {
            val baseUrl = URL(base)
            val operation = object : UrlPathTrait {
                override fun getUrlPath(): String = "/test"
            }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("$base/test")

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "http://example.com/v1/api",
                "http://127.0.0.1:8080/v1/api",
                "https://example.com/v1/api",
                "ftp://ftp.example.com/v1/api",
                "file:///home/v1/api",
                "file://servername/v1/api",
            ]
        )
        fun `adds query parameters`(base: String) {
            val baseUrl = URL(base)
            val operation = object : UrlPathTrait, UrlQueryParamsTrait {
                override fun getUrlPath(): String = "/test"
                override fun getUrlQueryParams(): Map<String, List<String>> = mapOf(
                    "key1" to listOf("value1"),
                    "key2" to listOf("value2", "value3")
                )
            }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("$base/test?key1=value1&key2=value2&key2=value3")

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "http://example.com/v1/api",
                "http://127.0.0.1:8080/v1/api",
                "https://example.com/v1/api",
                "ftp://ftp.example.com/v1/api",
                "file:///home/v1/api",
                "file://servername/v1/api",
            ]
        )
        fun `adds query parameters and ignores empty values`(base: String) {
            val baseUrl = URL(base)
            val operation = object : UrlPathTrait, UrlQueryParamsTrait {
                override fun getUrlPath(): String = "/test"
                override fun getUrlQueryParams(): Map<String, List<String>> = mapOf(
                    "key1" to emptyList(),
                    "key2" to listOf("value2", "value3")
                )
            }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("$base/test?key2=value2&key2=value3")

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "http://example.com/v1/api",
                "http://127.0.0.1:8080/v1/api",
                "https://example.com/v1/api",
                "ftp://ftp.example.com/v1/api",
                "file:///home/v1/api",
                "file://servername/v1/api",
            ]
        )
        fun `adds query parameters and ignores empty keys`(base: String) {
            val baseUrl = URL(base)
            val operation = object : UrlPathTrait, UrlQueryParamsTrait {
                override fun getUrlPath(): String = "/test"
                override fun getUrlQueryParams(): Map<String, List<String>> = mapOf(
                    "key1" to emptyList(),
                    "" to listOf("value2", "value3")
                )
            }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("$base/test")

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "http://example.com/v1/api",
                "http://127.0.0.1:8080/v1/api",
                "https://example.com/v1/api",
                "ftp://ftp.example.com/v1/api",
                "file:///home/v1/api",
                "file://servername/v1/api",
            ]
        )
        fun `adds query parameters and ignores empty keys and values`(base: String) {
            val baseUrl = URL(base)
            val operation = object : UrlPathTrait, UrlQueryParamsTrait {
                override fun getUrlPath(): String = "/test"
                override fun getUrlQueryParams(): Map<String, List<String>> = mapOf(
                    "key1" to emptyList(),
                    "" to emptyList()
                )
            }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("$base/test")

            assertEquals(expected, actual)
        }

        @Test
        fun `ignores empty operation path`() {
            val baseUrl = URL("http://example.com/v1/api")
            val operation = object : UrlPathTrait {
                override fun getUrlPath(): String = ""
            }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("http://example.com/v1/api")

            assertEquals(expected, actual)
        }

        @Test
        fun `adds query parameters with empty path`() {
            val baseUrl = URL("http://example.com")
            val operation = object : UrlPathTrait, UrlQueryParamsTrait {
                override fun getUrlPath(): String = ""
                override fun getUrlQueryParams(): Map<String, List<String>> = mapOf(
                    "key1" to listOf("value1"),
                    "key2" to listOf("value2", "value3")
                )
            }

            val actual = operation.parseURL(baseUrl)
            val expected = URL("http://example.com?key1=value1&key2=value2&key2=value3")

            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class ParseMethodTest {
        @ParameterizedTest
        @ValueSource(
            strings = [
                "get",
                "pOst",
                "POST",
                "pUT",
                "DeLEtE",
                "PAtCh",
                "HEAd",
                "OPTIONS",
                "TrAcE",
                "Connect"
            ]
        )
        fun `parses valid http methods case insensitive`(method: String) {
            val operation = object : HttpMethodTrait {
                override fun getHttpMethod(): String = method
            }

            val actual = operation.parseMethod()
            val expected = Method.valueOf(method.uppercase())

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "Omar",
                "Jordan",
                "Nasser",
                "Dwairi",
                "Noor",
                "Dana",
            ]
        )
        fun `throws exception for invalid http methods`(method: String) {
            val operation = object : HttpMethodTrait {
                override fun getHttpMethod(): String = method
            }

            assertThrows<IllegalArgumentException> {
                operation.parseMethod()
            }
        }
    }

    @Nested
    inner class ParseMediaTypeTest {
        @ParameterizedTest
        @ValueSource(
            strings = [
                "application/json",
                "Application/Json",
                "application/xml",
                "APPLICATION/XML",
                "application/Yaml",
                "applicatioN/x-WWW-form-urlencoded",
                "application/OCTET-stream",
                "application/pDF",
                "application/ZiP",
                "application/GZIP",
                "application/X-tar",
                "application/x-RAR-compressed",
            ]
        )
        fun `parses valid media types cases insensitive`(mediaType: String) {
            val operation = object : ContentTypeTrait {
                override fun getContentType(): String = mediaType
            }

            val actual = operation.parseMediaType()
            val expected = MediaType.parse(mediaType)

            assertEquals(expected, actual)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "Omar",
                "Jordan",
                "Nasser",
                "Dwairi",
                "Noor",
                "Dana",
            ]
        )
        fun `throws exception for invalid media types`(mediaType: String) {
            val operation = object : ContentTypeTrait {
                override fun getContentType(): String = mediaType
            }

            assertThrows<IllegalArgumentException> {
                operation.parseMediaType()
            }
        }
    }
}
