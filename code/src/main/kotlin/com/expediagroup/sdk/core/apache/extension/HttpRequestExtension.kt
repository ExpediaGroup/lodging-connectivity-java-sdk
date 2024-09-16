package com.expediagroup.sdk.core.apache.extension

import com.expediagroup.sdk.core.constant.Constant
import com.expediagroup.sdk.core.logging.LOGGABLE_CONTENT_TYPES
import com.expediagroup.sdk.core.logging.LogMessageConstant
import com.expediagroup.sdk.core.logging.mask.maskLogs
import com.expediagroup.sdk.core.logging.model.LogMessage
import com.expediagroup.sdk.core.logging.model.LogMessageLine
import com.expediagroup.sdk.core.logging.model.LogMessageLines
import com.expediagroup.sdk.core.logging.model.LogMessageTag
import org.apache.http.HttpEntityEnclosingRequest
import org.apache.http.HttpRequest
import org.apache.http.entity.ContentType
import org.apache.http.protocol.HttpContext
import java.nio.charset.Charset


fun HttpRequest.getBodyLogMessage(): LogMessage {
    if (this !is HttpEntityEnclosingRequest) {
        return LogMessage.NULL_INSTANCE
    }

    if (entity == null) {
        return LogMessage.NULL_INSTANCE
    }

    if (ContentType.get(entity).mimeType !in LOGGABLE_CONTENT_TYPES) {
        return LogMessage.NULL_INSTANCE
    }

    val encoding = Charset.forName(entity.contentEncoding?.value ?: Charsets.UTF_8.name())
    val byteArray = safeReadByteArray()

    return LogMessage(
        title = LogMessageLine(
            line = LogMessageConstant.REQUEST_BODY + Constant.NEWLINE,
            tags = emptySet()
        ), body = LogMessageLines(
            lines = listOf(
                LogMessageLine(
                    line = maskLogs(String(byteArray, encoding)), tags = setOf(LogMessageTag.OUTGOING)
                )
            ),
        )
    )
}

fun HttpRequest.getHeadersLogMessage(
    tags: Set<LogMessageTag> = setOf(LogMessageTag.OUTGOING)
): LogMessage =
    this.allHeaders.getHeadersLogMessage(tags)

fun HttpRequest.getMetadataLogMessage(context: HttpContext) = LogMessage(
    body = LogMessageLines().addLine {
        LogMessageLine(
            tags = setOf(LogMessageTag.OUTGOING),
            line = "$protocolVersion ${requestLine.method} ${context.getRequestUrl()}"
        )
    }
)
