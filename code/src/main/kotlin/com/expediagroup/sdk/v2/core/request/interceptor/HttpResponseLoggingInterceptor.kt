package com.expediagroup.sdk.v2.core.request.interceptor

import com.expediagroup.sdk.v2.core.constant.LoggingMessage.OMITTED
import com.expediagroup.sdk.v2.core.extension.io.toBuffer
import com.expediagroup.sdk.v2.core.logging.LogMessageConstant
import com.expediagroup.sdk.v2.core.logging.LOGGABLE_CONTENT_TYPES
import com.expediagroup.sdk.v2.core.logging.LogMessageTag
import com.expediagroup.sdk.v2.core.logging.ExpediaGroupLogger
import com.expediagroup.sdk.v2.core.logging.ExpediaGroupLoggerFactory
import com.expediagroup.sdk.v2.core.logging.mask.isMaskedField
import com.google.api.client.http.HttpResponse
import com.google.api.client.http.HttpResponseInterceptor
import okio.IOException


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
            appendLine(LogMessageConstant.RESPONSE_HEADERS)

            response.headers.forEach { (key, value) ->
                appendLine("${key}: ${if (isMaskedField(key)) OMITTED else value}")
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
        StringBuilder().apply {
            appendLine(LogMessageConstant.RESPONSE_BODY)

            if (setOf<Any?>(null, 0).contains(response.headers.contentLength)) {
                logger.info(LogMessageConstant.EMPTY_OR_UNKNOWN_RESPONSE_BODY, LogMessageTag.INCOMING)
                return
            }

            val contentLength = response.headers.contentLength.toInt()

            if (!canLogBody(response)) {
                appendLine(LogMessageConstant.BODY_CONTENT_TYPE_NOT_SUPPORTED)
                logger.debug(this.toString(), LogMessageTag.INCOMING)
                return
            }

            appendLine(
                response.content.toBuffer(
                    contentLength = contentLength,
                    exhaustStream = false
                ).readUtf8()
            )

            if (contentLength == Int.MAX_VALUE) {
                appendLine(LogMessageConstant.RESPONSE_TOO_LARGE_TO_BE_LOGGED)
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
     * Intercepts the HTTP response to log relevant details such as headers and body.
     *
     * @param response The HTTP response object containing the data to be logged.
     */
    override fun interceptResponse(response: HttpResponse) {
        logResponseEventAndHeaders(response)
        logResponseBody(response)
    }
}