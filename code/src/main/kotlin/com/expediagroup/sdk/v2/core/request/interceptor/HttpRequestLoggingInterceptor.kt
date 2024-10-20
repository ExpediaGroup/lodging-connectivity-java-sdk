package com.expediagroup.sdk.v2.core.request.interceptor

import com.expediagroup.sdk.v2.core.constant.LoggingMessage.OMITTED
import com.expediagroup.sdk.v2.core.extension.client.getContentBuffer
import com.expediagroup.sdk.v2.core.logging.*
import com.expediagroup.sdk.v2.core.logging.ExpediaGroupLogger
import com.expediagroup.sdk.v2.core.logging.ExpediaGroupLoggerFactory
import com.expediagroup.sdk.v2.core.logging.mask.isMaskedField
import com.google.api.client.http.HttpExecuteInterceptor
import com.google.api.client.http.HttpRequest

/**
 * HttpRequestLoggingInterceptor is an implementation of HttpExecuteInterceptor that logs HTTP request details,
 * such as headers and body content, for outgoing requests.
 */
class HttpRequestLoggingInterceptor : HttpExecuteInterceptor {
    private val logger: ExpediaGroupLogger =
        ExpediaGroupLoggerFactory.getLogger(HttpRequestLoggingInterceptor::class.java)

    /**
     * Logs the HTTP request method, URL, and headers.
     * Headers that are deemed sensitive by the `isMaskedField` function are masked.
     *
     * @param request The HTTP request object containing the details to be logged.
     */
    private fun logRequestEventAndHeaders(request: HttpRequest) {
        StringBuilder().apply {
            appendLine("${request.requestMethod} ${request.url.clone().build()}")
            appendLine(LogMessageConstant.REQUEST_HEADERS)

            request.headers.forEach { (key, value) ->
                appendLine("${key}: ${if (isMaskedField(key)) OMITTED else value}")
            }

            logger.info(this.toString(), LogMessageTag.OUTGOING)
        }
    }

    /**
     * Logs the HTTP request body.
     *
     * If the request content length is 0 or the content type is not loggable, respective messages
     * are logged at the debug level. Otherwise, the content of the request body is read safely
     * and logged at the info level.
     *
     * @param request The HTTP request object containing the body to be logged.
     */
    private fun logRequestBody(request: HttpRequest) {
        StringBuilder().apply {
            appendLine(LogMessageConstant.REQUEST_BODY)

            if (request.content.length == 0L) {
                return
            }

            if (!canLogBody(request)) {
                appendLine(LogMessageConstant.BODY_CONTENT_TYPE_NOT_SUPPORTED)
                logger.debug(this.toString(), LogMessageTag.OUTGOING)
                return
            }

            appendLine(request.getContentBuffer(resetContent = true).readUtf8())

            logger.info(this.toString(), LogMessageTag.OUTGOING)
        }
    }

    /**
     * Determines if the body of an HTTP request can be logged.
     *
     * @param request The HTTP request to check.
     * @return `true` if the body of the HTTP request can be logged, `false` otherwise.
     */
    private fun canLogBody(request: HttpRequest): Boolean {
        val hasContent = request.content.length != 0L
        val isLoggableContentType = request.headers.contentType in LOGGABLE_CONTENT_TYPES

        return hasContent.and(isLoggableContentType)
    }

    /**
     * Intercepts the HTTP request and logs its details.
     *
     * It logs the HTTP request method, URL, headers, and body.
     *
     * @param request The HTTP request object containing the details to be logged.
     */
    override fun intercept(request: HttpRequest) {
        logRequestEventAndHeaders(request)
        logRequestBody(request)
    }
}
