package com.expediagroup.sdk.v2.core.apache.interceptor

import com.expediagroup.sdk.v2.core.apache.extension.*
import com.expediagroup.sdk.v2.core.constant.Constant
import com.expediagroup.sdk.v2.core.logging.ExpediaGroupLoggerFactory
import com.expediagroup.sdk.v2.core.logging.LogMessageConstant
import com.expediagroup.sdk.v2.core.logging.LogMessageTag
import org.apache.http.HttpResponse
import org.apache.http.HttpResponseInterceptor
import org.apache.http.protocol.HttpContext

class ExpediaGroupResponseInterceptor : HttpResponseInterceptor {
    private val logger = ExpediaGroupLoggerFactory.getLogger(javaClass)

    override fun process(response: HttpResponse?, context: HttpContext?) {
        if (response == null || context == null) {
            return
        }

        StringBuilder().apply {
            response.statusLine.statusCode
            append(
                LogMessageConstant.RESPONSE_FROM.format(
                    context.getProtocol(),
                    context.getRequestMethod(),
                    context.getRequestUrl(),
                    response.statusLine.statusCode,
                    response.statusLine.reasonPhrase,
                )
            )
            append(Constant.NEWLINE)
            append(LogMessageConstant.RESPONSE_HEADERS)
            append(Constant.NEWLINE)
            append(response.getHeadersLogMessage())
            logger.info(toString(), tags = setOf(LogMessageTag.INCOMING))
            clear()

            append(LogMessageConstant.RESPONSE_BODY)
            append(Constant.NEWLINE)
            append(response.getBodyLogMessage())
            logger.info(toString(), tags = setOf(LogMessageTag.INCOMING))
        }
    }
}
