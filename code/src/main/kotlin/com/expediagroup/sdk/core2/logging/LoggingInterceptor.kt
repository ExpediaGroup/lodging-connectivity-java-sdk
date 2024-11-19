package com.expediagroup.sdk.core2.logging

import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpResponse
import com.expediagroup.sdk.core2.interceptor.common.SDKInterceptor
import com.expediagroup.sdk.core2.logging.common.SDKLoggerFactory
import java.io.ByteArrayOutputStream

class LoggingInterceptor : SDKInterceptor {
    private val logger = SDKLoggerFactory.getLogger(this::class.java)

    @Throws(java.io.IOException::class)
    override fun intercept(chain: SDKInterceptor.Chain): HttpResponse {
        val request = chain.request()

        // Log the request information
        logRequest(request)

        // Proceed with the request
        val response = chain.proceed(request)

        // Log the response information
        logResponse(response)

        return response
    }

    private fun logRequest(request: HttpRequest) {
        try {
            val requestLog = StringBuilder()
            requestLog.append("Sending request to URL: ${request.url}")
            requestLog.append("\nMethod: ${request.method}")
            requestLog.append("\nHeaders:\n${request.headers}")

            // Log the request body if it's not empty
            val requestBody = request.body

            if (requestBody != null) {
                val outputStream = ByteArrayOutputStream()
                requestBody.writeTo(outputStream)

                val charset = requestBody.contentType()?.charset ?: Charsets.UTF_8

                val bodyString = outputStream.toByteArray().toString(charset)

                requestLog.append("\nBody:\n$bodyString")
            }

            logger.info(requestLog.toString())
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

            // Read and log the response body (make sure to handle the body correctly)
            val responseBody = response.body

            val charset = responseBody?.contentType()?.charset ?: Charsets.UTF_8

            val bodyString = responseBody?.string(charset)

            responseLog.append("\nBody:\n$bodyString")

            logger.info(responseLog.toString())
        } catch (e: Exception) {
            logger.error("Error logging response: ", e)
        }
    }
}
