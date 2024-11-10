package com.expediagroup.sdk.graphql.model.response

open class RawResponse<T>(
    val data: T,
    val errors: List<Error>?
)
