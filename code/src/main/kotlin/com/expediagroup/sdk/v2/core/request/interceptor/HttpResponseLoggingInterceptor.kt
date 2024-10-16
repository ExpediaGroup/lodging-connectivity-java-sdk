package com.expediagroup.sdk.v2.core.request.interceptor

import com.expediagroup.sdk.v2.core.constant.LoggingMessage.OMITTED
import com.expediagroup.sdk.v2.core.io.SafeInputStreamReader
import com.expediagroup.sdk.v2.core.logging.LogMessageConstant
import com.expediagroup.sdk.v2.core.logging.LOGGABLE_CONTENT_TYPES
import com.expediagroup.sdk.v2.core.logging.LogMessageTag
import com.expediagroup.sdk.v2.core.logging.ExpediaGroupLogger
import com.expediagroup.sdk.v2.core.logging.ExpediaGroupLoggerFactory
import com.expediagroup.sdk.v2.core.logging.mask.isMaskedField
import com.google.api.client.http.HttpResponse
import com.google.api.client.http.HttpResponseInterceptor
import okio.IOException


class HttpResponseLoggingInterceptor : HttpResponseInterceptor {
    private val logger: ExpediaGroupLogger =
        ExpediaGroupLoggerFactory.getLogger(HttpResponseLoggingInterceptor::class.java)

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

            logger.info(this.toString(), setOf(LogMessageTag.INCOMING))
        }
    }

    private fun logResponseBody(response: HttpResponse) {
        StringBuilder().apply {
            appendLine(LogMessageConstant.RESPONSE_BODY)

            if (setOf<Any?>(null, 0).contains(response.headers.contentLength)) {
                logger.info(LogMessageConstant.EMPTY_OR_UNKNOWN_RESPONSE_BODY, setOf(LogMessageTag.INCOMING))
                return
            }

            try {
                val contentLength = response.headers.contentLength.toInt()
                if (contentLength == 0) {
                    return
                }

                if (!canLogBody(response)) {
                    appendLine(LogMessageConstant.BODY_CONTENT_TYPE_NOT_SUPPORTED)
                    logger.debug(this.toString(), setOf(LogMessageTag.INCOMING))
                    return
                }

                val safeInputStreamReader = SafeInputStreamReader(response.content, contentLength)

                appendLine(safeInputStreamReader.readUtf8())

                if (contentLength == Int.MAX_VALUE) {
                    appendLine(LogMessageConstant.RESPONSE_TOO_LARGE_TO_BE_LOGGED)
                }

                logger.info(this.toString(), setOf(LogMessageTag.INCOMING))

            } catch (e: IOException) {
                e.printStackTrace()
                throw e
            }
        }
    }

    private fun canLogBody(response: HttpResponse): Boolean {
        val hasContent = response.headers.contentLength > 0L
        val isLoggableContentType = response.headers.contentType in LOGGABLE_CONTENT_TYPES

        return hasContent.and(isLoggableContentType)
    }

    override fun interceptResponse(response: HttpResponse) {
        logResponseEventAndHeaders(response)
        logResponseBody(response)
    }
}