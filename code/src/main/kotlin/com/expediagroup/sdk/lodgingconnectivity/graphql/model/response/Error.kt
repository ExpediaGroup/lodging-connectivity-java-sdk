package com.expediagroup.sdk.lodgingconnectivity.graphql.model.response

data class Error(
    val message: String,
    val path: List<String>?,
)
