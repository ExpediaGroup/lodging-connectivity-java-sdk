package com.expediagroup.sdk.core.apache.interceptor

import com.expediagroup.sdk.core.apache.extension.getBodyLogMessage
import com.expediagroup.sdk.core.apache.extension.getHeadersLogMessage
import com.expediagroup.sdk.core.apache.extension.getMetadataLogMessage
import com.expediagroup.sdk.core.logging.model.LogMessage
import com.expediagroup.sdk.core.logging.model.LogMessageTag
import org.apache.http.HttpRequest
import org.apache.http.HttpRequestInterceptor
import org.apache.http.protocol.HttpContext
import org.slf4j.Logger

class RequestLogger(
    private val logger: Logger
) : HttpRequestInterceptor {
    override fun process(request: HttpRequest?, context: HttpContext?) {
        logger.info(request?.getMetadataLogMessage(context!!).toString())

        logger.debug(
            request?.getHeadersLogMessage(
                setOf(LogMessageTag.OUTGOING)
            ).toString()
        )

        logger.debug(
            request?.getBodyLogMessage()?.toString() ?: LogMessage.NULL_INSTANCE.toString()
        )
    }
}