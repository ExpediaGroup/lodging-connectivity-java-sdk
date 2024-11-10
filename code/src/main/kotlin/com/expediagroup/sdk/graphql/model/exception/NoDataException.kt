package com.expediagroup.sdk.graphql.model.exception

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.model.response.Error

class NoDataException(
    message: String? = null,
    cause: Throwable? = null,
    val errors: List<Error>,
) : ExpediaGroupServiceException(message, cause)
