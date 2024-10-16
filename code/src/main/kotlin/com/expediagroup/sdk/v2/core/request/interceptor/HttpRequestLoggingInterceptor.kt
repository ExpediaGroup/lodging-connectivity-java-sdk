package com.expediagroup.sdk.v2.core.request.interceptor

import com.expediagroup.sdk.v2.core.constant.LoggingMessage.OMITTED
import com.expediagroup.sdk.v2.core.io.SafeHttpContentReader
import com.expediagroup.sdk.v2.core.logging.*
import com.expediagroup.sdk.v2.core.logging.ExpediaGroupLogger
import com.expediagroup.sdk.v2.core.logging.ExpediaGroupLoggerFactory
import com.expediagroup.sdk.v2.core.logging.mask.isMaskedField
import com.google.api.client.http.HttpExecuteInterceptor
import com.google.api.client.http.HttpRequest

class HttpRequestLoggingInterceptor : HttpExecuteInterceptor {
    private val logger: ExpediaGroupLogger =
        ExpediaGroupLoggerFactory.getLogger(HttpRequestLoggingInterceptor::class.java)

    private fun logRequestEventAndHeaders(request: HttpRequest) {
        StringBuilder().apply {
            appendLine("${request.requestMethod} ${request.url.clone().build()}")
            appendLine(LogMessageConstant.REQUEST_HEADERS)

            request.headers.forEach { (key, value) ->
                appendLine("${key}: ${if (isMaskedField(key)) OMITTED else value}")
            }

            logger.info(this.toString(), setOf(LogMessageTag.OUTGOING))
        }
    }

    private fun logRequestBody(request: HttpRequest) {
        StringBuilder().apply {
            appendLine(LogMessageConstant.REQUEST_BODY)

            if (request.content.length == 0L) {
                return
            }

            if (!canLogBody(request)) {
                appendLine(LogMessageConstant.BODY_CONTENT_TYPE_NOT_SUPPORTED)
                logger.debug(this.toString(), setOf(LogMessageTag.OUTGOING))
                return
            }

            appendLine(SafeHttpContentReader(request).readUtf8())

            logger.info(this.toString(), setOf(LogMessageTag.OUTGOING))
        }
    }

    private fun canLogBody(request: HttpRequest): Boolean {
        val hasContent = request.content.length != 0L
        val isLoggableContentType = request.headers.contentType in LOGGABLE_CONTENT_TYPES

        return hasContent.and(isLoggableContentType)
    }

    override fun intercept(request: HttpRequest) {
        logRequestEventAndHeaders(request)
        logRequestBody(request)
    }
}
