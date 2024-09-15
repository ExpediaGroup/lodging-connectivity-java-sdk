package com.expediagroup.sdk.core.apache.interceptor

import com.expediagroup.sdk.core.apache.extension.getBodyLogMessage
import com.expediagroup.sdk.core.apache.extension.getHeadersLogMessage
import com.expediagroup.sdk.core.apache.extension.getMetadataLogMessage
import com.expediagroup.sdk.core.logging.model.LogMessageTag
import org.apache.http.HttpRequest
import org.apache.http.HttpRequestInterceptor
import org.apache.http.protocol.HttpContext
import org.slf4j.Logger

class RequestLoggingInterceptor(
    private val logger: Logger
) : HttpRequestInterceptor {
    override fun process(request: HttpRequest?, context: HttpContext?) {
        if (request == null || context == null) {
            return
        }

        logger.info(request.getMetadataLogMessage(context).toString())
        logger.info(request.getHeadersLogMessage(setOf(LogMessageTag.OUTGOING)).toString())
        logger.info(request.getBodyLogMessage().toString())
    }
}