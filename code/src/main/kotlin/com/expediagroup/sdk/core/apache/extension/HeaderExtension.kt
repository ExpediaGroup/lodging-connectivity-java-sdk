package com.expediagroup.sdk.core.apache.extension

import com.expediagroup.sdk.core.constant.Constant
import com.expediagroup.sdk.core.constant.LoggingMessage.OMITTED
import com.expediagroup.sdk.core.logging.LogMessageConstant
import com.expediagroup.sdk.core.logging.mask.isMaskedField
import com.expediagroup.sdk.core.logging.model.LogMessage
import com.expediagroup.sdk.core.logging.model.LogMessageLine
import com.expediagroup.sdk.core.logging.model.LogMessageLines
import com.expediagroup.sdk.core.logging.model.LogMessageTag
import org.apache.http.Header

fun Array<Header>.getHeadersLogMessage(tags: Set<LogMessageTag>): LogMessage {
    return LogMessage(
        title = LogMessageLine(line = LogMessageConstant.REQUEST_HEADERS + Constant.NEWLINE, tags = tags),
        body = map {
            val value = if (isMaskedField(it.name)) OMITTED else it.value
            LogMessageLine(line = "${it.name}: $value", tags = tags)
        }.let { LogMessageLines().addLines(it) },
    )
}
