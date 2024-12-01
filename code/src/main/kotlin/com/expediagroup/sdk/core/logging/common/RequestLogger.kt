package com.expediagroup.sdk.core.logging.common

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.logging.common.Constant.DEFAULT_MAX_BODY_SIZE
import java.io.IOException
import java.nio.charset.Charset
import okio.Buffer
import org.slf4j.Logger

object RequestLogger {
    fun log(
        logger: Logger,
        request: Request,
        tags: List<String>? = null,
        maxBodyLogSize: Long = DEFAULT_MAX_BODY_SIZE
    ) {
        try {
            val requestBodyString = request.body?.let { it.peekContent(maxBodyLogSize, it.mediaType()?.charset) }

            buildString {
                tags?.let {
                    append("[")
                    append(it.joinToString(", "))
                    append("] - ")
                }
                append("[Outgoing] - ")
                append("[Method=${request.method}, URL=${request.url}, Headers=[${request.headers}], Body=[${requestBodyString}]")
            }.also {
                logger.info(it)
            }

        } catch (e: Exception) {
            logger.warn("Failed to log request: ${e.message}", e)
        }
    }

    @Throws(IOException::class)
    private fun RequestBody.peekContent(maxSize: Long, charset: Charset?): String {
        this.mediaType().also {
            if (it === null) {
                return "Request body of unknown media type cannot be logged"
            }

            if (!isLoggable(it)) {
                return "Request body of type ${it.fullType} cannot be logged"
            }
        }

        val buffer = Buffer()
        writeTo(buffer)
        val bytesToRead = minOf(maxSize, buffer.size)
        return buffer.copy().readString(bytesToRead, charset ?: Charsets.UTF_8)
    }
}
