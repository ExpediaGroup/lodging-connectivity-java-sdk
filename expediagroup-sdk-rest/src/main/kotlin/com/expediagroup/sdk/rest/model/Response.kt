package com.expediagroup.sdk.rest.model

data class Response<T>(
    val data: T,
    val headers: Map<String, List<String>>
)
