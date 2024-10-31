package com.expediagroup.sdk.core.request.interceptor

import com.expediagroup.sdk.core.constant.LoggingMessage.OMITTED
import com.expediagroup.sdk.core.logging.LogMessageConstant
import com.expediagroup.sdk.core.logging.LOGGABLE_CONTENT_TYPES
import com.expediagroup.sdk.core.logging.LogMessageTag
import com.expediagroup.sdk.core.logging.ExpediaGroupLogger
import com.expediagroup.sdk.core.logging.ExpediaGroupLoggerFactory
import com.expediagroup.sdk.core.logging.mask.isMaskedField
import com.google.api.client.http.HttpResponse
import com.google.api.client.http.HttpResponseInterceptor
import okio.IOException
import okio.buffer
import okio.source


/**
 * The HttpResponseLoggingInterceptor class is responsible for intercepting HTTP responses and logging
 * relevant information such as headers, status, and body content.
 */
class HttpResponseLoggingInterceptor : HttpResponseInterceptor {
    private val logger: ExpediaGroupLogger =
        ExpediaGroupLoggerFactory.getLogger(HttpResponseLoggingInterceptor::class.java)

    /**
     * Logs the HTTP response event and its headers. This function constructs a log message
     * containing the HTTP method, URL, status code, and response headers, and then logs it.
     *
     * @param response The HTTP response object from which the information is extracted.
     */
    private fun logResponseEventAndHeaders(response: HttpResponse) {
        StringBuilder().apply {
            val request = response.request

            val method = request.requestMethod
            val url = request.url.clone().build()
            val status = "[${response.statusCode} ${response.statusMessage}]"

            appendLine("Response from: $method $url $status")
            appendLine(com.expediagroup.sdk.core.logging.LogMessageConstant.RESPONSE_HEADERS)

            response.headers.forEach { (key, value) ->
                val keyCases = listOf(
                    key,
                    key.capitalize(),
                    key.uppercase(),
                    key.lowercase(),
                )

                appendLine("${key}: ${if (keyCases.any(::isMaskedField)) OMITTED else value}")
            }

            logger.info(this.toString(), LogMessageTag.INCOMING)
        }
    }

    /**
     * Logs the body of an HTTP response if it is safe to log based on its content type and length.
     *
     * @param response The HTTP response object containing the body to be logged.
     * @throws IOException If an I/O error occurs during reading the response content.
     */
    @Throws(IOException::class)
    private fun logResponseBody(response: HttpResponse) {
        StringBuilder().apply stringBuilder@ {
            if (setOf<Any?>(null, 0).contains(response.headers.contentLength)) {
                logger.info(com.expediagroup.sdk.core.logging.LogMessageConstant.EMPTY_OR_UNKNOWN_RESPONSE_BODY, LogMessageTag.INCOMING)
                return
            }

            if (!canLogBody(response)) {
                this@stringBuilder.appendLine(com.expediagroup.sdk.core.logging.LogMessageConstant.BODY_CONTENT_TYPE_NOT_SUPPORTED)
                logger.debug(this.toString(), LogMessageTag.INCOMING)
                return
            }

            val contentLength = response.headers.contentLength
            val contentLengthExceedsThreshold = (contentLength > Int.MAX_VALUE.toLong())

            this@stringBuilder.appendLine(com.expediagroup.sdk.core.logging.LogMessageConstant.RESPONSE_BODY)

            if (!response.content.markSupported()) {
                logger.error(com.expediagroup.sdk.core.logging.LogMessageConstant.RESPONSE_CONTENT_INPUT_STREAM_DOES_NOT_SUPPORT_MARK, LogMessageTag.INCOMING)
                return
            }

            response.content.apply stream@ {
                this@stream.mark(contentLength.toInt() + 1)

                this@stringBuilder.appendLine(response.content.source().buffer().readUtf8())
                if (contentLengthExceedsThreshold) {
                    this@stringBuilder.appendLine(com.expediagroup.sdk.core.logging.LogMessageConstant.RESPONSE_TOO_LARGE_TO_BE_LOGGED_WHOLE)
                }

                this@stream.reset()
            }

            logger.info(this.toString(), LogMessageTag.INCOMING)
        }
    }

    /**
     * Determines if the body of the HTTP response can be logged based on content length and content type.
     *
     * @param response The HTTP response to check.
     * @return `true` if the response body can be logged, `false` otherwise.
     */
    private fun canLogBody(response: HttpResponse): Boolean {
        val hasContent = response.headers.contentLength > 0L
        val isLoggableContentType = response.headers.contentType in LOGGABLE_CONTENT_TYPES

        return hasContent.and(isLoggableContentType)
    }

    /**
     * Intercepts the given HTTP response to log its event, headers, and body.
     *
     * @param response The HTTP response to be intercepted and logged.
     * @throws IOException If an I/O error occurs during logging the response content.
     */
    @Throws(IOException::class)
    override fun interceptResponse(response: HttpResponse) {
        logResponseEventAndHeaders(response)
        logResponseBody(response)
    }
}
