package com.expediagroup.sdk.core.logging.model

import com.expediagroup.sdk.core.model.TransactionId

data class RequestLogMetadata(
    val transactionId: TransactionId,
    val method: String,
    val url: String,
)
