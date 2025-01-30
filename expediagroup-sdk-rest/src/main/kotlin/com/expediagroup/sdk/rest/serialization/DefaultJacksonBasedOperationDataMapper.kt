package com.expediagroup.sdk.rest.serialization

import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.serialization.DeserializeResponseBodyTrait
import com.expediagroup.sdk.rest.trait.serialization.SerializeRequestBodyTrait
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.IOException
import java.io.InputStream

/**
 * Default implementation of data mapper using Jackson for serialization and deserialization.
 *
 * Note: This implementation should move to a separate lib in the future (expediagroup-sdk-serialization-jackson).
 *
 * @property mapper the ObjectMapper instance used for JSON processing
 */
class DefaultJacksonBasedOperationDataMapper(
    private val mapper: ObjectMapper = jacksonObjectMapper()
): SerializeRequestBodyTrait, DeserializeResponseBodyTrait {

    /**
     * Serializes the given value to an InputStream.
     *
     * @param value the value to serialize
     * @return the serialized value as an InputStream
     * @throws IOException if an I/O error occurs during serialization
     */
    @Throws(IOException::class)
    override fun <T> serialize(value: T): InputStream {
        if (value is InputStream) {
            return value
        }

        return mapper.writeValueAsBytes(value).inputStream()
    }

    /**
     * Deserializes the given InputStream to the specified type.
     *
     * @param inputStream the InputStream to deserialize
     * @param operation the operation containing the type information
     * @return the deserialized value
     * @throws IllegalArgumentException if the operation does not implement JacksonModelOperationResponseBodyTrait
     * @throws IOException if an I/O error occurs during deserialization
     */
    @Throws(
        IllegalArgumentException::class,
        IOException::class
    )
    override fun <T> deserialize(
        inputStream: InputStream,
        operation: OperationResponseBodyTrait<T>
    ): T {
        require(operation is JacksonModelOperationResponseBodyTrait<T>) {
            "Operation must implement OperationResponseBodyTrait"
        }

        return mapper.readValue(inputStream, operation.getTypeIdentifier())
    }
}
