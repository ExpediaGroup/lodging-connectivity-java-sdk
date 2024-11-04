package com.expediagroup.sdk.core.model.exception.service

import com.expediagroup.sdk.core.constant.provider.LoggingMessageProvider
import com.expediagroup.sdk.core.http.HttpStatus
import com.google.api.client.http.HttpResponse

abstract class ExpediaGroupApiException(val status: HttpStatus, open val errorObject: Any, transactionId: String?) :
    ExpediaGroupServiceException("Unsuccessful response code [${status.code}]${
        LoggingMessageProvider.getTransactionIdMessage(
            transactionId
        )
    }${stringifyErrorObject(errorObject.toString())}", transactionId = transactionId) {
        constructor(response: HttpResponse) : this(
            HttpStatus.fromCode(response.statusCode),
            response.parseAsString(),
            response.request.headers.getFirstHeaderStringValue("transaction-id")
        )
    }

private fun stringifyErrorObject(stringValue: String): String = if (stringValue.isBlank()) " with an empty response body" else ": $stringValue"
