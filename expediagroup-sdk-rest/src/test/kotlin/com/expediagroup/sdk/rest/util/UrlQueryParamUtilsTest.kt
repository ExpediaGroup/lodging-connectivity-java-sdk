package com.expediagroup.sdk.rest.util

import com.expediagroup.sdk.rest.model.UrlQueryParam
import io.mockk.mockk
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals // Import JUnit Jupiter Assertions

class UrlQueryParamUtilsTest {
    companion object {
        val stringifyQueryParam = mockk<StringifyQueryParam>()
    }

    @Nested
    inner class StringifyFormTest {
        @Test
        fun `should return form-encoded string for single value`() {
            val param = UrlQueryParam("key1", listOf("value1"), stringifyQueryParam)
            val expected = "key1=value1"
            assertEquals(expected, stringifyForm(param))
        }

        @Test
        fun `should return form-encoded string for multiple values`() {
            val param = UrlQueryParam("key1", listOf("value1", "value2", "value3"), stringifyQueryParam)
            val expected = "key1=value1,value2,value3"
            assertEquals(expected, stringifyForm(param))
        }

        @Test
        fun `should return form-encoded string for empty value list`() {
            val param = UrlQueryParam("key1", emptyList(), stringifyQueryParam)
            val expected = "key1="
            assertEquals(expected, stringifyForm(param))
        }

        @Test
        fun `should return form-encoded string for key with special characters`() {
            val param = UrlQueryParam("key with spaces", listOf("value1"), stringifyQueryParam)
            val expected = "key with spaces=value1"
            assertEquals(expected, stringifyForm(param))
        }

        @Test
        fun `should return form-encoded string for values with special characters`() {
            val param = UrlQueryParam("key1", listOf("value with,comma", "value with&ampersand", "value with=equals"), stringifyQueryParam)
            val expected = "key1=value with,comma,value with&ampersand,value with=equals"
            assertEquals(expected, stringifyForm(param))
        }

        @Test
        fun `should return form-encoded string for empty key`() {
            val param = UrlQueryParam("", listOf("value1", "value2"), stringifyQueryParam)
            val expected = "=value1,value2"
            assertEquals(expected, stringifyForm(param))
        }

        @Test
        fun `should return form-encoded string for values with plus sign`() {
            val param = UrlQueryParam("key1", listOf("value+with+plus"), stringifyQueryParam)
            val expected = "key1=value+with+plus"
            assertEquals(expected, stringifyForm(param))
        }

        @Test
        fun `should return form-encoded string for values with forward slash`() {
            val param = UrlQueryParam("key1", listOf("value/with/slash"), stringifyQueryParam)
            val expected = "key1=value/with/slash"
            assertEquals(expected, stringifyForm(param))
        }

        @Test
        fun `should handle very long key`() {
            val longKey = "a".repeat(1024)
            val param = UrlQueryParam(longKey, listOf("value1"), stringifyQueryParam)
            val expected = "${longKey}=value1"
            assertEquals(expected, stringifyForm(param))
        }

        @Test
        fun `should handle very long value`() {
            val longValue = "b".repeat(1024)
            val param = UrlQueryParam("key1", listOf(longValue), stringifyQueryParam)
            val expected = "key1=${longValue}"
            assertEquals(expected, stringifyForm(param))
        }

        @Test
        fun `should handle very large number of values`() {
            val values = List(1000) { "value$it" }
            val param = UrlQueryParam("key1", values, stringifyQueryParam)
            val expected = "key1=" + values.joinToString(",")
            assertEquals(expected, stringifyForm(param))
        }
    }

    @Nested
    inner class StringifyExplodeTest {
        @Test
        fun `should return exploded form-encoded string for single value`() {
            val param = UrlQueryParam("key1", listOf("value1"), stringifyQueryParam)
            val expected = "key1=value1"
            assertEquals(expected, stringifyExplode(param))
        }

        @Test
        fun `should return exploded form-encoded string for multiple values`() {
            val param = UrlQueryParam("key1", listOf("value1", "value2", "value3"), stringifyQueryParam)
            val expected = "key1=value1&key1=value2&key1=value3"
            assertEquals(expected, stringifyExplode(param))
        }

        @Test
        fun `should return exploded form-encoded string for empty value list`() {
            val param = UrlQueryParam("key1", emptyList(), stringifyQueryParam)
            val expected = "key1="
            assertEquals(expected, stringifyExplode(param))
        }

        @Test
        fun `should return exploded form-encoded string for key with special characters`() {
            val param = UrlQueryParam("key with spaces", listOf("value1"), stringifyQueryParam)
            val expected = "key with spaces=value1"
            assertEquals(expected, stringifyExplode(param))
        }

        @Test
        fun `should return exploded form-encoded string for values with special characters`() {
            val param = UrlQueryParam("key1", listOf("value with,comma", "value with&ampersand", "value with=equals"), stringifyQueryParam)
            val expected = "key1=value with,comma&key1=value with&ampersand&key1=value with=equals"
            assertEquals(expected, stringifyExplode(param))
        }

        @Test
        fun `should return exploded form-encoded string for empty key`() {
            val param = UrlQueryParam("", listOf("value1", "value2"), stringifyQueryParam)
            val expected = "=value1&=value2"
            assertEquals(expected, stringifyExplode(param))
        }

        @Test
        fun `should return exploded form-encoded string for values with plus sign`() {
            val param = UrlQueryParam("key1", listOf("value+with+plus"), stringifyQueryParam)
            val expected = "key1=value+with+plus"
            assertEquals(expected, stringifyExplode(param))
        }

        @Test
        fun `should return exploded form-encoded string for values with forward slash`() {
            val param = UrlQueryParam("key1", listOf("value/with/slash"), stringifyQueryParam)
            val expected = "key1=value/with/slash"
            assertEquals(expected, stringifyExplode(param))
        }

        @Test
        fun `should handle very long key in exploded form`() {
            val longKey = "a".repeat(1024)
            val param = UrlQueryParam(longKey, listOf("value1"), stringifyQueryParam)
            val expected = "${longKey}=value1"
            assertEquals(expected, stringifyExplode(param))
        }

        @Test
        fun `should handle very long value in exploded form`() {
            val longValue = "b".repeat(1024)
            val param = UrlQueryParam("key1", listOf(longValue), stringifyQueryParam)
            val expected = "key1=${longValue}"
            assertEquals(expected, stringifyExplode(param))
        }

        @Test
        fun `should handle very large number of values in exploded form`() {
            val values = List(1000) { "value$it" }
            val param = UrlQueryParam("key1", values, stringifyQueryParam)
            val expected = values.joinToString("&key1=", prefix = "key1=")
            assertEquals(expected, stringifyExplode(param))
        }
    }

    @Nested
    inner class StringifySpaceDelimitedTest {
        @Test
        fun `should return space-delimited string for single value`() {
            val param = UrlQueryParam("key1", listOf("value1"), stringifyQueryParam)
            val expected = "key1=value1"
            assertEquals(expected, stringifySpaceDelimited(param))
        }

        @Test
        fun `should return space-delimited string for multiple values`() {
            val param = UrlQueryParam("key1", listOf("value1", "value2", "value3"), stringifyQueryParam)
            val expected = "key1=value1%20value2%20value3"
            assertEquals(expected, stringifySpaceDelimited(param))
        }

        @Test
        fun `should return space-delimited string for empty value list`() {
            val param = UrlQueryParam("key1", emptyList(), stringifyQueryParam)
            val expected = "key1="
            assertEquals(expected, stringifySpaceDelimited(param))
        }

        @Test
        fun `should return space-delimited string for key with special characters`() {
            val param = UrlQueryParam("key with spaces", listOf("value1"), stringifyQueryParam)
            val expected = "key with spaces=value1"
            assertEquals(expected, stringifySpaceDelimited(param))
        }

        @Test
        fun `should return space-delimited string for values with special characters`() {
            val param = UrlQueryParam("key1", listOf("value with space", "value2"), stringifyQueryParam)
            val expected = "key1=value with space%20value2"
            assertEquals(expected, stringifySpaceDelimited(param))
        }

        @Test
        fun `should return space-delimited string for empty key`() {
            val param = UrlQueryParam("", listOf("value1", "value2"), stringifyQueryParam)
            val expected = "=value1%20value2"
            assertEquals(expected, stringifySpaceDelimited(param))
        }

        @Test
        fun `should return space-delimited string for values with plus sign`() {
            val param = UrlQueryParam("key1", listOf("value+with+plus"), stringifyQueryParam)
            val expected = "key1=value+with+plus"
            assertEquals(expected, stringifySpaceDelimited(param))
        }

        @Test
        fun `should return space-delimited string for values with forward slash`() {
            val param = UrlQueryParam("key1", listOf("value/with/slash"), stringifyQueryParam)
            val expected = "key1=value/with/slash"
            assertEquals(expected, stringifySpaceDelimited(param))
        }

        @Test
        fun `should handle very long key in space delimited form`() {
            val longKey = "a".repeat(1024)
            val param = UrlQueryParam(longKey, listOf("value1"), stringifyQueryParam)
            val expected = "${longKey}=value1"
            assertEquals(expected, stringifySpaceDelimited(param))
        }

        @Test
        fun `should handle very long value in space delimited form`() {
            val longValue = "b".repeat(1024)
            val param = UrlQueryParam("key1", listOf(longValue), stringifyQueryParam)
            val expected = "key1=${longValue}"
            assertEquals(expected, stringifySpaceDelimited(param))
        }

        @Test
        fun `should handle very large number of values in space delimited form`() {
            val values = List(1000) { "value$it" }
            val param = UrlQueryParam("key1", values, stringifyQueryParam)
            val expected = "key1=" + values.joinToString("%20")
            assertEquals(expected, stringifySpaceDelimited(param))
        }
    }

    @Nested
    inner class StringifyPipeDelimitedTest {
        @Test
        fun `should return pipe-delimited string for single value`() {
            val param = UrlQueryParam("key1", listOf("value1"), stringifyQueryParam)
            val expected = "key1=value1"
            assertEquals(expected, stringifyPipeDelimited(param))
        }

        @Test
        fun `should return pipe-delimited string for multiple values`() {
            val param = UrlQueryParam("key1", listOf("value1", "value2", "value3"), stringifyQueryParam)
            val expected = "key1=value1|value2|value3"
            assertEquals(expected, stringifyPipeDelimited(param))
        }

        @Test
        fun `should return pipe-delimited string for empty value list`() {
            val param = UrlQueryParam("key1", emptyList(), stringifyQueryParam)
            val expected = "key1="
            assertEquals(expected, stringifyPipeDelimited(param))
        }

        @Test
        fun `should return pipe-delimited string for key with special characters`() {
            val param = UrlQueryParam("key with spaces", listOf("value1"), stringifyQueryParam)
            val expected = "key with spaces=value1"
            assertEquals(expected, stringifyPipeDelimited(param))
        }

        @Test
        fun `should return pipe-delimited string for values with special characters`() {
            val param = UrlQueryParam("key1", listOf("value with|pipe", "value2"), stringifyQueryParam)
            val expected = "key1=value with|pipe|value2"
            assertEquals(expected, stringifyPipeDelimited(param))
        }

        @Test
        fun `should return pipe-delimited string for empty key`() {
            val param = UrlQueryParam("", listOf("value1", "value2"), stringifyQueryParam)
            val expected = "=value1|value2"
            assertEquals(expected, stringifyPipeDelimited(param))
        }

        @Test
        fun `should return pipe-delimited string for values with plus sign`() {
            val param = UrlQueryParam("key1", listOf("value+with+plus"), stringifyQueryParam)
            val expected = "key1=value+with+plus"
            assertEquals(expected, stringifyPipeDelimited(param))
        }

        @Test
        fun `should return pipe-delimited string for values with forward slash`() {
            val param = UrlQueryParam("key1", listOf("value/with/slash"), stringifyQueryParam)
            val expected = "key1=value/with/slash"
            assertEquals(expected, stringifyPipeDelimited(param))
        }

        @Test
        fun `should handle very long key in pipe delimited form`() {
            val longKey = "a".repeat(1024)
            val param = UrlQueryParam(longKey, listOf("value1"), stringifyQueryParam)
            val expected = "${longKey}=value1"
            assertEquals(expected, stringifyPipeDelimited(param))
        }

        @Test
        fun `should handle very long value in pipe delimited form`() {
            val longValue = "b".repeat(1024)
            val param = UrlQueryParam("key1", listOf(longValue), stringifyQueryParam)
            val expected = "key1=${longValue}"
            assertEquals(expected, stringifyPipeDelimited(param))
        }

        @Test
        fun `should handle very large number of values in pipe delimited form`() {
            val values = List(1000) { "value$it" }
            val param = UrlQueryParam("key1", values, stringifyQueryParam)
            val expected = "key1=" + values.joinToString("|")
            assertEquals(expected, stringifyPipeDelimited(param))
        }
    }

    @Nested
    inner class StringifyQueryParamTest {
        @Test
        fun `invoke should correctly convert UrlQueryParam to String using provided logic`() {
            val customStringify = StringifyQueryParam { param ->
                "${param.key}:${param.value.joinToString("-")}"
            }
            val param = UrlQueryParam("myKey", listOf("v1", "v2"), stringifyQueryParam)
            val expectedString = "myKey:v1-v2"

            val actualString = customStringify(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `invoke should handle empty values list`() {
            val customStringify = StringifyQueryParam { param ->
                "${param.key}:${param.value.joinToString("-")}"
            }
            val param = UrlQueryParam("myKey", emptyList(), stringifyQueryParam)
            val expectedString = "myKey:"

            val actualString = customStringify(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `invoke should handle empty key`() {
            val customStringify = StringifyQueryParam { param ->
                "${param.key}:${param.value.joinToString("-")}"
            }
            val param = UrlQueryParam("", listOf("v1", "v2"), stringifyQueryParam)
            val expectedString = ":v1-v2"

            val actualString = customStringify(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `invoke should handle custom encoding`() {
            val customStringify = StringifyQueryParam { param ->
                val encodedValues = param.value.map { it.replace(" ", "+") } // Encode space as +
                "${param.key}=${encodedValues.joinToString(",")}"
            }
            val param = UrlQueryParam("key", listOf("value with space", "another value"), stringifyQueryParam)
            val expected = "key=value+with+space,another+value"
            assertEquals(expected, customStringify(param))
        }

        @Test
        fun `invoke should add a prefix`() {
            val customStringify = StringifyQueryParam { param ->
                "prefix_${param.key}=${param.value.joinToString(",")}"
            }
            val param = UrlQueryParam("key", listOf("v1", "v2"), stringifyQueryParam)
            val expected = "prefix_key=v1,v2"
            assertEquals(expected, customStringify(param))
        }
    }
}
