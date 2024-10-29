package com.expediagroup.sdk.lodgingconnectivity.graphql.model.response

import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo

interface PaginatedResponse<T, R> : Response<T, R> {
    val pageInfo: PageInfo
}
