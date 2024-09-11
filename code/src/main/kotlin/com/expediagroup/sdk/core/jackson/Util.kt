package com.expediagroup.sdk.core.jackson

import com.fasterxml.jackson.core.type.TypeReference

fun serialize(value: Any): String {
    return OBJECT_MAPPER.writeValueAsString(value)
}

inline fun <reified T> deserialize(json: String, typeReference: TypeReference<T>): T {
    return OBJECT_MAPPER.readValue(json, typeReference)
}
