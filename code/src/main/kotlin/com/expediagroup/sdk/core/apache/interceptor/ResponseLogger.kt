package com.expediagroup.sdk.core.apache.interceptor

import com.expediagroup.sdk.core.apache.extension.getBodyLogMessage
import com.expediagroup.sdk.core.apache.extension.getHeadersLogMessage
import com.expediagroup.sdk.core.apache.extension.getMetadataLogMessage
import org.apache.http.HttpResponse
import org.apache.http.HttpResponseInterceptor
import org.apache.http.protocol.HttpContext
import org.slf4j.Logger

class ResponseLogger(
    private val logger: Logger
) : HttpResponseInterceptor {
    override fun process(response: HttpResponse?, context: HttpContext?) {
        if (response == null || context == null) {
            return
        }

        logger.info(response.getMetadataLogMessage(context).toString())
        logger.info(response.getHeadersLogMessage().toString())
        logger.debug(response.getBodyLogMessage().toString())
    }
}
