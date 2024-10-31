package com.expediagroup.sdk.core.jackson

import com.fasterxml.jackson.core.type.TypeReference

/**
 * Serializes the given value into its JSON string representation.
 *
 * @param value The object to be serialized.
 * @return The JSON string representation of the given object.
 */
fun serialize(value: Any): String {
    return OBJECT_MAPPER.writeValueAsString(value)
}

/**
 * Deserializes a JSON string into an object of the specified type.
 *
 * @param T The type into which the JSON string will be deserialized.
 * @param json The JSON string to deserialize.
 * @param typeReference A reference to the type into which the JSON string should be deserialized.
 * @return The deserialized object of the specified type.
 */
inline fun <reified T> deserialize(json: String, typeReference: TypeReference<T>): T {
    return OBJECT_MAPPER.readValue(json, typeReference)
}
