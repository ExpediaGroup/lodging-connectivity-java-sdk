package com.expediagroup.sdk.core.apache.extension

import com.expediagroup.sdk.core.constant.Constant
import com.expediagroup.sdk.core.logging.LOGGABLE_CONTENT_TYPES
import com.expediagroup.sdk.core.logging.LogMessageConstant
import com.expediagroup.sdk.core.logging.mask.maskLogs
import org.apache.http.HttpEntityEnclosingRequest
import org.apache.http.HttpRequest
import org.apache.http.entity.ContentType
import org.apache.http.protocol.HttpContext
import java.nio.charset.Charset


fun HttpRequest.getBodyLogMessage(): String {
    if (this !is HttpEntityEnclosingRequest) {
        return Constant.EMPTY_STRING
    }

    if (entity == null) {
        return LogMessageConstant.EMPTY_REQUEST_BODY
    }

    if (ContentType.get(entity).mimeType !in LOGGABLE_CONTENT_TYPES) {
        return LogMessageConstant.BODY_CONTENT_TYPE_NOT_SUPPORTED.format(ContentType.get(entity).mimeType)
    }

    val encoding = Charset.forName(entity.contentEncoding?.value ?: Charsets.UTF_8.name())
    return maskLogs(String(readByteArrayAndCloneEntity(), encoding))
}

fun HttpRequest.getHeadersLogMessage(): String =
    this.allHeaders.getHeadersLogMessage()

fun HttpRequest.getMetadataLogMessage(context: HttpContext): String =
    "$protocolVersion ${requestLine.method} ${context.getRequestUrl()}"
