package com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging

data class PaginationControl @JvmOverloads constructor(
    val pageSize: Int? = null,
    val cursor: String? = null
)
