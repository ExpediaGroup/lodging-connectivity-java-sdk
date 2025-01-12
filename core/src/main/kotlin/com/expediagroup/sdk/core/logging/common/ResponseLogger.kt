package com.expediagroup.sdk.core.logging.common

import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.logging.common.Constant.DEFAULT_MAX_BODY_SIZE
import okio.Buffer
import java.nio.charset.Charset

object ResponseLogger {
    fun log(
        logger: LoggerDecorator,
        response: Response,
        vararg tags: String,
        maxBodyLogSize: Long = DEFAULT_MAX_BODY_SIZE,
    ) {
        try {
            val responseBodyString = response.body?.let { it.peekContent(maxBodyLogSize, it.mediaType()?.charset) }

            buildString {
                append("[URL=${response.request.url}, Code=${response.status.code}, Headers=[${response.headers}], Body=[$responseBodyString]")
            }.also {
                logger.info(it, "Incoming", *tags)
            }
        } catch (e: Exception) {
            logger.warn("Failed to log response: ${e.message}", e)
        }
    }

    private fun ResponseBody.peekContent(
        maxSize: Long,
        charset: Charset?,
    ): String {
        this.mediaType().also {
            if (it === null) {
                return "Response body of unknown media type cannot be logged"
            }

            if (!isLoggable(it)) {
                return "Response body of type ${it.fullType} cannot be logged"
            }
        }

        val buffer = Buffer()
        val bytesToRead = minOf(maxSize, this.contentLength())
        this.source().peek().read(buffer, bytesToRead)
        return buffer.readString(charset ?: Charsets.UTF_8)
    }
}
