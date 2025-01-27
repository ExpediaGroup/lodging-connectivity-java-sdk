package com.expediagroup.sdk.rest.trait.serialization

import com.expediagroup.sdk.rest.trait.Trait
import com.expediagroup.sdk.rest.trait.operation.ResponseBodyTrait
import java.io.InputStream

interface SerializationTrait : Trait

interface SerializeRequestBodyTrait : SerializationTrait {
    fun <T> serialize(value: T): InputStream
}

interface DeserializeResponseBodyTrait : SerializationTrait {
    fun <T> deserialize(inputStream: InputStream, responseBody: ResponseBodyTrait<T>): T
}
