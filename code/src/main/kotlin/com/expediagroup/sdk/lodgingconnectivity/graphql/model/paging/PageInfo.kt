package com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging

data class PageInfo(
    val pageSize: Int,
    val hasNext: Boolean,
    val cursor: String? = null,
    val nextPageCursor: String? = null,
    val totalCount: Int? = null
)
