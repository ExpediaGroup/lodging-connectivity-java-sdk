package com.expediagroup.sdk.lodgingconnectivity.graphql.model.response

import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginationControl

interface PaginatedResponse<T, R> : Response<T, R> {
    val pageInfo: PageInfo
    val nextPagePaginationControl: PaginationControl?
}
