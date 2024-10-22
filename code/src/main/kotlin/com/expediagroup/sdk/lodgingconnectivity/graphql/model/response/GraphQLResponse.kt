package com.expediagroup.sdk.lodgingconnectivity.graphql.model.response

import com.apollographql.apollo.api.Error

open class GraphQLResponse<T>(
    val data: T,
    val errors: List<Error>?
)
