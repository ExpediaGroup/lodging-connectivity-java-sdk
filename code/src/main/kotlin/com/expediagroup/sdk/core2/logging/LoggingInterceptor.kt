package com.expediagroup.sdk.core2.logging

import com.expediagroup.sdk.core2.extension.orUtf8
import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpResponse
import com.expediagroup.sdk.core2.interceptor.Interceptor
import com.expediagroup.sdk.core2.logging.common.LoggerDecorator
import okio.Buffer
import org.slf4j.LoggerFactory

class LoggingInterceptor : Interceptor {
    private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java))

    @Throws(java.io.IOException::class)
    override fun intercept(chain: Interceptor.Chain): HttpResponse {
        val request = chain.request()
        logRequest(request)

        val response = chain.proceed(request)
        logResponse(response)

        return response
    }

    private fun logRequest(request: HttpRequest) {
        try {
            val requestLog = StringBuilder()
            requestLog.append("Sending request to URL: ${request.url}")
            requestLog.append("\nMethod: ${request.method}")
            requestLog.append("\nHeaders:\n${request.headers}")

            request.body?.let {
                val buffer = Buffer()
                it.writeTo(buffer)
                buffer.readString(it.contentType()?.charset ?: Charsets.UTF_8)
            }.also {
                requestLog.append("\nBody:\n$it")
                logger.info(requestLog.toString())
            }
        } catch (e: Exception) {
            logger.error("Error logging request: ", e)
        }
    }

    private fun logResponse(response: HttpResponse) {
        try {
            val responseLog = StringBuilder()
            responseLog.append("Received response for URL: ${response.request.url}")
            responseLog.append("\nStatus Code: ${response.code}")
            responseLog.append("\nHeaders:\n${response.headers}")

            response.body?.let {
                val source = it.source()

                // TODO: Should we set max loggable content size?
                source.request(Long.MAX_VALUE) // Buffer the entire body.

                val clonedBuffer = source.buffer.clone()
                clonedBuffer.readString(response.body.contentType()?.charset.orUtf8())
            }.also {
                responseLog.append("\nBody:\n$it")
                logger.info(responseLog.toString())
            }
        } catch (e: Exception) {
            logger.error("Error logging response: ", e)
        }
    }
}
