package com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging

import com.apollographql.apollo.api.Error
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.GraphQLResponse

class PaginatedGraphQLResponse<T>(
    data: T,
    errors: List<Error>?,
    val pageInfo: PageInfo,
) : GraphQLResponse<T>(data, errors)
