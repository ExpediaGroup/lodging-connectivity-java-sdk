package com.expediagroup.sdk.graphql.model.response

data class Error(
    val message: String,
    val path: List<String>?,
)
