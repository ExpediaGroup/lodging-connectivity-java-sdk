package com.expediagroup.sdk.core.logging.common

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.logging.common.Constant.DEFAULT_MAX_BODY_SIZE
import java.io.IOException
import java.nio.charset.Charset
import okio.Buffer

object RequestLogger {
    fun log(
        logger: LoggerDecorator,
        request: Request,
        vararg tags: String,
        maxBodyLogSize: Long = DEFAULT_MAX_BODY_SIZE
    ) {
        try {
            val requestBodyString = request.body?.let { it.readLoggableBody(maxBodyLogSize, it.mediaType()?.charset) }

            buildString {
                append("[URL=${request.url}, Method=${request.method}, Headers=[${request.headers}], Body=[${requestBodyString}]")
            }.also {
                logger.info(it, "Outgoing", *tags)
            }

        } catch (e: Exception) {
            logger.warn("Failed to log request")
        }
    }

    @Throws(IOException::class)
    private fun RequestBody.readLoggableBody(maxBodyLogSize: Long, charset: Charset?): String {
        this.mediaType().also {
            if (it === null) {
                return "Request body of unknown media type cannot be logged"
            }

            if (!isLoggable(it)) {
                return "Request body of type ${it.fullType} cannot be logged"
            }
        }

        val buffer = Buffer().apply { writeTo(this) }
        val bytesToRead = minOf(maxBodyLogSize, buffer.size)

        return buffer.readString(bytesToRead, charset ?: Charsets.UTF_8)
    }
}
