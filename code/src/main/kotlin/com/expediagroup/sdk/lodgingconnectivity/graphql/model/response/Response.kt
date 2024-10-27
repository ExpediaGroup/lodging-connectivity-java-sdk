package com.expediagroup.sdk.lodgingconnectivity.graphql.model.response

interface Response<T, R> {
    val data: T
    val rawResponse: RawResponse<R>
}
