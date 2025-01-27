package com.expediagroup.sdk.rest.trait.operation

import com.expediagroup.sdk.rest.trait.serialization.DeserializeResponseBodyTrait
import com.expediagroup.sdk.rest.trait.serialization.SerializeRequestBodyTrait
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.io.InputStream

class SerializationTraitTest {
    @Test
    fun `can implement serialize and deserialize traits without conflicts`() {
        assertDoesNotThrow {
            object : SerializeRequestBodyTrait, DeserializeResponseBodyTrait {
                override fun <T> deserialize(inputStream: InputStream, instance: ResponseBodyTrait<T>): T {
                    if (instance is JacksonModelResponseBodyTrait<T>) {
                        return jacksonObjectMapper().readValue(inputStream, instance.getTypeIdentifier())
                    }

                    throw IllegalArgumentException("Unsupported response body type")
                }

                override fun <T> serialize(value: T): InputStream {
                    return "{}".byteInputStream()
                }
            }
        }
    }
}
