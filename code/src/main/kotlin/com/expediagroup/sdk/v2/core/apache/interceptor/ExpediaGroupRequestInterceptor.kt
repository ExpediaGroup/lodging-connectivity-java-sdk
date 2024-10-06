package com.expediagroup.sdk.v2.core.apache.interceptor

import com.expediagroup.sdk.v2.core.apache.extension.getBodyLogMessage
import com.expediagroup.sdk.v2.core.apache.extension.getHeadersLogMessage
import com.expediagroup.sdk.v2.core.apache.extension.getMetadataLogMessage
import com.expediagroup.sdk.v2.core.constant.Constant
import com.expediagroup.sdk.v2.core.logging.ExpediaGroupLoggerFactory
import com.expediagroup.sdk.v2.core.logging.LogMessageConstant
import com.expediagroup.sdk.v2.core.logging.LogMessageTag
import org.apache.http.HttpRequest
import org.apache.http.HttpRequestInterceptor
import org.apache.http.protocol.HttpContext

class ExpediaGroupRequestInterceptor : HttpRequestInterceptor {
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
