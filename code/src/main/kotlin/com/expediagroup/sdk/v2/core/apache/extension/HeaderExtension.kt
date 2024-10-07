package com.expediagroup.sdk.v2.core.apache.extension

import com.expediagroup.sdk.v2.core.logging.mask.isMaskedField
import com.expediagroup.sdk.v2.core.constant.Constant
import com.expediagroup.sdk.v2.core.constant.LoggingMessage.OMITTED
import org.apache.http.Header

fun Array<Header>.getHeadersLogMessage(): String =
    StringBuilder().apply {
        forEach { header: Header ->
            append("${header.name}: ${if (isMaskedField(header.name)) OMITTED else header.value}")
            append(Constant.NEWLINE)
        }
    }.toString()
