package com.expediagroup.sdk.graphql.model.response

import com.expediagroup.sdk.graphql.model.paging.PageInfo

interface PaginatedResponse<T, R> : Response<T, R> {
    val pageInfo: PageInfo
}
