package com.expediagroup.sdk.lodgingconnectivity.graphql.model.exception

import com.apollographql.apollo.api.Error

class NoDataException(
    message: String? = null,
    cause: Throwable? = null,
    val errors: List<Error>,
) : RuntimeException(message, cause)
