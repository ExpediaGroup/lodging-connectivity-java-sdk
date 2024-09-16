package com.expediagroup.sdk.core.apache.extension

import com.expediagroup.sdk.core.constant.Constant
import com.expediagroup.sdk.core.constant.LoggingMessage.OMITTED
import com.expediagroup.sdk.core.logging.mask.isMaskedField
import org.apache.http.Header

fun Array<Header>.getHeadersLogMessage(): String =
    StringBuilder().apply {
        forEach { header: Header ->
            append("${header.name}: ${if (isMaskedField(header.name)) OMITTED else header.value}")
            append(Constant.NEWLINE)
        }
    }.toString()
