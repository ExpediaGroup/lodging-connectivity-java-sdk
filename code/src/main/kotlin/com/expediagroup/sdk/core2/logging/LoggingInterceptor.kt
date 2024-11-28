package com.expediagroup.sdk.core2.logging

import com.expediagroup.sdk.core2.http.RequestBody
import com.expediagroup.sdk.core2.http.Request
import com.expediagroup.sdk.core2.http.Response
import com.expediagroup.sdk.core2.interceptor.Interceptor
import com.expediagroup.sdk.core2.logging.common.LoggerDecorator
import java.io.IOException
import java.nio.charset.Charset
import okio.Buffer
import okio.BufferedSource
import org.slf4j.LoggerFactory

/**
 * An interceptor that logs HTTP requests and responses.
 *
 * @param maxBodyLogSize The maximum size of the request/response body to log. Defaults to 1MB.
 */
class LoggingInterceptor(
    private val maxBodyLogSize: Long = DEFAULT_MAX_BODY_SIZE
) : Interceptor {
    private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java))

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val startTime = System.currentTimeMillis()

        logRequest(request)
        val response = chain.proceed(request)
        logResponse(response, System.currentTimeMillis() - startTime)

        return response
    }

    private fun logRequest(request: Request) {
        try {
            buildLogMessage {
                append(">>> HTTP ${request.method} ${request.url}\n")
                append("\nHeaders:\n${request.headers}") // TODO: Mask sensitive headers

                request.body?.let {
                    appendBody(">>>", it.peekContent(maxBodyLogSize, it.contentType()?.charset), it.contentLength())
                }
            }.also {
                logger.info(it)
            }
        } catch (e: Exception) {
            logger.warn("Failed to log request: ${e.message}", e)
        }
    }

    private fun logResponse(response: Response, durationMs: Long) {
        try {
            buildLogMessage {
                append("<<< HTTP ${response.code} (${durationMs}ms) ${response.request.url}\n")
                append("\nHeaders:\n${response.headers}") // TODO: Mask sensitive headers

                response.body?.let {
                    appendBody(
                        "<<<",
                        it.source().peekContent(maxBodyLogSize, it.contentType()?.charset),
                        it.contentLength()
                    )
                }
            }.also {
                logger.info(it)
            }
        } catch (e: Exception) {
            logger.warn("Failed to log response: ${e.message}", e)
        }
    }

    private inline fun buildLogMessage(block: StringBuilder.() -> Unit): String =
        StringBuilder().apply(block).toString()

    private fun StringBuilder.appendBody(prefix: String, content: String, contentLength: Long) {
        if (content.isNotEmpty()) {
            append("\n$prefix Body: $content")
            if (contentLength > maxBodyLogSize) {
                append("\n$prefix Body truncated, showing $maxBodyLogSize/$contentLength bytes")
            }
        }
    }

    private fun RequestBody.peekContent(maxSize: Long, charset: Charset?): String {
        val buffer = Buffer()
        writeTo(buffer)
        val bytesToRead = minOf(maxSize, buffer.size)
        return buffer.copy().readString(bytesToRead, charset ?: Charsets.UTF_8)
    }

    private fun BufferedSource.peekContent(maxSize: Long, charset: Charset?): String {
        val buffer = Buffer()
        val bytesToRead = minOf(maxSize, buffer.size)
        buffer.write(this.peek(), bytesToRead)
        return buffer.copy().readString(charset ?: Charsets.UTF_8)
    }

    companion object {
        private const val DEFAULT_MAX_BODY_SIZE = 1024L * 1024L // 1MB
    }
}
