package com.expediagroup.sdk.core.apache.interceptor

import com.expediagroup.sdk.core.apache.extension.getBodyLogMessage
import com.expediagroup.sdk.core.apache.extension.getHeadersLogMessage
import com.expediagroup.sdk.core.apache.extension.getMetadataLogMessage
import com.expediagroup.sdk.core.constant.Constant
import com.expediagroup.sdk.core.logging.LogMessageConstant
import com.expediagroup.sdk.core.logging.LogMessageTag
import com.expediagroup.sdk.core.plugin.logging.ExpediaGroupLoggerFactory
import org.apache.http.HttpRequest
import org.apache.http.HttpRequestInterceptor
import org.apache.http.protocol.HttpContext

class RequestLoggingInterceptor: HttpRequestInterceptor {
    private val logger = ExpediaGroupLoggerFactory.getLogger(javaClass)

    override fun process(request: HttpRequest?, context: HttpContext?) {
        if (request == null || context == null) {
            return
        }

        StringBuilder().apply {
            append(request.getMetadataLogMessage(context))
            append(Constant.NEWLINE)
            append(LogMessageConstant.REQUEST_HEADERS)
            append(Constant.NEWLINE)
            append(request.getHeadersLogMessage())
            logger.info(toString(), tags = setOf(LogMessageTag.OUTGOING))
            clear()

            append(LogMessageConstant.REQUEST_BODY)
            append(Constant.NEWLINE)
            append(request.getBodyLogMessage())
            logger.info(toString(), tags = setOf(LogMessageTag.OUTGOING))
        }
    }
}
