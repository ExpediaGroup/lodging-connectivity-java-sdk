package com.expediagroup.sdk.core.apache.extension

import com.expediagroup.sdk.core.logging.LOGGABLE_CONTENT_TYPES
import com.expediagroup.sdk.core.logging.LogMessageConstant
import com.expediagroup.sdk.core.logging.mask.maskLogs
import org.apache.http.HttpResponse
import org.apache.http.entity.ContentType
import java.nio.charset.Charset

fun HttpResponse.getHeadersLogMessage(): String =
    this.allHeaders.getHeadersLogMessage()

fun HttpResponse.getBodyLogMessage(): String {
    if (!hasBody()) {
        return LogMessageConstant.EMPTY_RESPONSE_BODY
    }

    if (entity.contentLength < 0L) {
        return LogMessageConstant.BODY_CONTENT_LENGTH_NOT_PROVIDED
    }

    if (ContentType.get(entity).mimeType !in LOGGABLE_CONTENT_TYPES) {
        return LogMessageConstant.BODY_CONTENT_TYPE_NOT_SUPPORTED.format(ContentType.get(entity).mimeType)
    }

    val encoding = Charset.forName(entity.contentEncoding?.value ?: Charsets.UTF_8.name())
    return maskLogs(String(readByteArrayAndCloneEntity(), encoding))
}

fun HttpResponse.readByteArrayAndCloneEntity(): ByteArray =
    if (!hasBody()) {
        ByteArray(0)
    } else {
        entity.readByteArrayAndCloneEntity().let { (byteArray, newEntity) ->
            // Replace the entity with a new one since the original entity is consumed
            entity = newEntity
            return@let byteArray
        }
    }

fun HttpResponse.hasBody(): Boolean {
    if (entity == null) {
        return false
    }
    if (entity.contentLength == 0L) {
        return false
    }

    return true
}
