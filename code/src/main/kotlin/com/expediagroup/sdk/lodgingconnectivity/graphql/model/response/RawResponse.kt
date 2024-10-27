package com.expediagroup.sdk.lodgingconnectivity.graphql.model.response

open class RawResponse<T>(
    val data: T,
    val errors: List<RawResponseError>?
)

data class RawResponseError(
    val message: String,
    val path: List<String>?,
)
