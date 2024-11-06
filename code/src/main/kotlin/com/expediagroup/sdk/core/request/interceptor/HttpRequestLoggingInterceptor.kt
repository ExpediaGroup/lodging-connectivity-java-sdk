package com.expediagroup.sdk.core.request.interceptor

import com.expediagroup.sdk.core.constant.LoggingMessage.OMITTED
import com.expediagroup.sdk.core.logging.ExpediaGroupLogger
import com.expediagroup.sdk.core.logging.ExpediaGroupLoggerFactory
import com.expediagroup.sdk.core.logging.LogMessageConstant
import com.expediagroup.sdk.core.logging.LogMessageTag
import com.expediagroup.sdk.core.logging.LOGGABLE_CONTENT_TYPES
import com.expediagroup.sdk.core.logging.mask.isMaskedField
import com.google.api.client.http.HttpExecuteInterceptor
import com.google.api.client.http.HttpRequest
import com.google.api.client.http.InputStreamContent
import okio.Buffer
import okio.IOException

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
                val keyCases = listOf(
                    key,
                    key.capitalize(),
                    key.uppercase(),
                    key.lowercase(),
                )

                appendLine("${key}: ${if (keyCases.any(::isMaskedField)) OMITTED else value}")
            }

            logger.info(this.toString(), LogMessageTag.OUTGOING)
        }
    }

    /**
     * Logs the body of an HTTP request if it meets certain criteria.
     *
     * If the request body is empty, it skips logging the body.
     * If the body content type is not supported for logging, it logs a message indicating this.
     * Otherwise, it logs the content of the request.
     *
     * @param request The HTTP request object containing the body to be logged.
     * @throws IOException if an I/O error occurs while reading the request body.
     */
    @Throws(IOException::class)
    private fun logRequestBody(request: HttpRequest) {
        StringBuilder().apply {
            appendLine(LogMessageConstant.REQUEST_BODY)

            if (request.content.length == 0L) {
                return
            }

            if (!canLogBody(request)) {
                appendLine(LogMessageConstant.BODY_CONTENT_TYPE_NOT_SUPPORTED.format(request.content.type))
                logger.debug(this.toString(), LogMessageTag.OUTGOING)
                return
            }

            appendLine(readAndResetContent(request))

            logger.debug(this.toString(), LogMessageTag.OUTGOING)
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

        val contentType = request.content.type.split(";").firstOrNull()
        val isLoggableContentType = contentType in LOGGABLE_CONTENT_TYPES

        return hasContent.and(isLoggableContentType)
    }

    /**
     * Reads the content of the provided HTTP request's body and returns it as a string.
     * Resets the content of the request to allow it to be read again.
     *
     * @param request The HTTP request whose content will be read and reset.
     * @return The content of the HTTP request as a string.
     * @throws IOException If an I/O error occurs while reading the request body.
     */
    @Throws(IOException::class)
    private fun readAndResetContent(request: HttpRequest): String = Buffer().apply {
        request.content.writeTo(outputStream())
        request.content = InputStreamContent(request.content.type, clone().inputStream())
    }.readUtf8()

    /**
     * Intercepts an HTTP request to log its details.
     *
     * This method logs both the headers and the body of the HTTP request.
     * It first logs the request method, URL, and headers by calling `logRequestEventAndHeaders`.
     * Next, it logs the body of the request by calling `logRequestBody`.
     *
     * @param request The HTTP request object containing the details to be intercepted and logged.
     * @throws IOException if an I/O error occurs while reading the request body.
     */
    @Throws(IOException::class)
    override fun intercept(request: HttpRequest) {
        logRequestEventAndHeaders(request)
        logRequestBody(request)
    }
}
