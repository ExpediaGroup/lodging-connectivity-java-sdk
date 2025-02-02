package com.expediagroup.sdk.rest.trait.serialization

import com.expediagroup.sdk.rest.trait.Trait
import com.expediagroup.sdk.rest.trait.operation.OperationResponseBodyTrait
import java.io.InputStream

/**
 * Marker interface for serialization traits.
 */
interface SerializationTrait : Trait

/**
 * Trait for serializing request bodies.
 */
interface SerializeRequestBodyTrait : SerializationTrait {
    /**
     * Serializes the given value into an InputStream.
     *
     * @param T the type of the value to serialize
     * @param value the value to serialize
     * @return the serialized value as an InputStream
     */
    fun <T : Any> serialize(value: T): InputStream
}

/**
 * Trait for deserializing response bodies.
 */
interface DeserializeResponseBodyTrait : SerializationTrait {
    /**
     * Deserializes the given InputStream into an object of type T.
     *
     * @param T the type of the object to deserialize
     * @param inputStream the InputStream to deserialize
     * @param operation the operation response body trait
     * @return the deserialized object of type T
     */
    fun <T : Any> deserialize(inputStream: InputStream, operation: OperationResponseBodyTrait<T>): T
}
