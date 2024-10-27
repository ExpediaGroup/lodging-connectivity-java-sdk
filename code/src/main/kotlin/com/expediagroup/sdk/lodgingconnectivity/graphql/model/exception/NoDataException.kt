package com.expediagroup.sdk.lodgingconnectivity.graphql.model.exception

import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponseError

class NoDataException(
    message: String? = null,
    cause: Throwable? = null,
    val errors: List<RawResponseError>,
) : RuntimeException(message, cause)
