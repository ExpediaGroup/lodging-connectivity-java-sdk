package com.expediagroup.sdk.core.model.exception.service

import com.expediagroup.sdk.core.constant.provider.LoggingMessageProvider

abstract class ExpediaGroupApiException(val statusCode: Int, open val errorObject: Any, transactionId: String?) :
    ExpediaGroupServiceException("Unsuccessful response code [$statusCode]${
        LoggingMessageProvider.getTransactionIdMessage(
            transactionId
        )
    }${stringifyErrorObject(errorObject.toString())}", transactionId = transactionId)

private fun stringifyErrorObject(stringValue: String): String = if (stringValue.isBlank()) " with an empty response body" else ": $stringValue"
