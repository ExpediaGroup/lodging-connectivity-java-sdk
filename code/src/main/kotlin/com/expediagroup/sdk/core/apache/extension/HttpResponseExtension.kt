package com.expediagroup.sdk.core.apache.extension

import com.expediagroup.sdk.core.constant.Constant
import com.expediagroup.sdk.core.logging.LOGGABLE_CONTENT_TYPES
import com.expediagroup.sdk.core.logging.LogMessageConstant
import com.expediagroup.sdk.core.logging.mask.maskLogs
import com.expediagroup.sdk.core.logging.model.LogMessage
import com.expediagroup.sdk.core.logging.model.LogMessageLine
import com.expediagroup.sdk.core.logging.model.LogMessageLines
import com.expediagroup.sdk.core.logging.model.LogMessageTag
import org.apache.http.HttpResponse
import org.apache.http.entity.ContentType
import org.apache.http.protocol.HttpContext
import java.nio.charset.Charset

fun HttpResponse.getHeadersLogMessage() =
    this.allHeaders.getHeadersLogMessage(setOf(LogMessageTag.INCOMING))

fun HttpResponse.getBodyLogMessage(): LogMessage {
    if (!isBodyLoggable()) {
        return LogMessage.NULL_INSTANCE
    }

    val byteArray = safeReadContentByteArray()
    val encoding = Charset.forName(entity.contentEncoding?.value ?: Charsets.UTF_8.name())

    return LogMessage(
        title = LogMessageLine(
            line = LogMessageConstant.RESPONSE_BODY + Constant.NEWLINE,
            tags = setOf(LogMessageTag.INCOMING)
        ),
        body = LogMessageLines(
            lines = listOf(
                LogMessageLine(
                    line = maskLogs(String(byteArray, encoding)), tags = setOf(LogMessageTag.INCOMING)
                )
            )
        )
    )
}

fun HttpResponse.safeReadContentByteArray(): ByteArray =
    if (!isBodyLoggable()) {
        ByteArray(0)
    } else {
        entity.readByteArray().let { (byteArray, newEntity) ->
            // Replace the entity with a new one since the original entity is consumed
            entity = newEntity

            return@let byteArray
        }
    }


fun HttpResponse.isBodyLoggable(): Boolean {
    if (this.entity == null) {
        return false
    }

    if (this.entity.contentLength <= 0L) {
        return false
    }

    if (ContentType.get(entity).mimeType !in LOGGABLE_CONTENT_TYPES) {
        return false
    }

    return true
}

fun HttpResponse.getMetadataLogMessage(context: HttpContext): LogMessage =
    LogMessage(
        body = LogMessageLines().addLine {
            LogMessageLine(
                line = "${LogMessageConstant.RESPONSE_FROM} ${statusLine.statusCode} ${context.getRequestMetadataLine()}",
                tags = setOf(LogMessageTag.INCOMING)
            )
        },
    )
