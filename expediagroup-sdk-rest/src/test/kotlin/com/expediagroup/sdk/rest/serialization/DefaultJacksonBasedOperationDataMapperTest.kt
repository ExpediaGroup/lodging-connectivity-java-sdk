package com.expediagroup.sdk.rest.serialization

import java.io.ByteArrayInputStream
import java.io.InputStream

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationResponseBodyTrait

class DefaultJacksonBasedOperationDataMapperTest {

    private val mapper: ObjectMapper = jacksonObjectMapper()
    private val dataMapper = DefaultJacksonBasedOperationDataMapper(mapper)

    @Test
    fun `serialize returns input stream for input stream value`() {
        val inputStream: InputStream = ByteArrayInputStream("test".toByteArray())

        val actual = dataMapper.serialize(inputStream)

        assertEquals(inputStream, actual)
    }

    @Test
    fun `serialize serializes value to input stream`() {
        val json = """{"key":"value"}"""

        val actual = dataMapper.serialize(json)
        val expected = mapper.writeValueAsBytes(json).inputStream()

        assertEquals(expected.readBytes().toList(), actual.readBytes().toList())
    }

    @Test
    fun `deserialize deserializes input stream to specified type`() {
        val inputStream: InputStream = """["first","second"]""".byteInputStream()
        val operation = object : JacksonModelOperationResponseBodyTrait<List<String>> {
            override fun getTypeIdentifier(): TypeReference<List<String>> = jacksonTypeRef()
        }

        val actual = dataMapper.deserialize(inputStream, operation)
        val expected = listOf("first", "second")
        assertEquals(expected, actual)
    }

    @Test
    fun `deserialize throws IllegalArgumentException for operation that does not implement JacksonModelOperationResponseBodyTrait`() {
        val inputStream: InputStream = ByteArrayInputStream("test".toByteArray())
        val operation = object : OperationResponseBodyTrait<String> {}
        assertThrows(IllegalArgumentException::class.java) {
            dataMapper.deserialize(inputStream, operation)
        }
    }
}
