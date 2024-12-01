package com.expediagroup.sdk.core.logging

import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor
import com.expediagroup.sdk.core.logging.common.Constant.DEFAULT_MAX_BODY_SIZE
import com.expediagroup.sdk.core.logging.common.Constant.EXPEDIA_GROUP_SDK
import com.expediagroup.sdk.core.logging.common.RequestLogger
import com.expediagroup.sdk.core.logging.common.ResponseLogger
import java.io.IOException
import org.slf4j.LoggerFactory

/**
 * An interceptor that logs HTTP requests and responses.
 *
 * @param maxBodyLogSize The maximum size of the request/response body to log. Defaults to 1MB.
 */
class LoggingInterceptor(
    private val maxBodyLogSize: Long = DEFAULT_MAX_BODY_SIZE
) : Interceptor {
    private val logger = LoggerFactory.getLogger(EXPEDIA_GROUP_SDK)

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        RequestLogger.log(logger, request, maxBodyLogSize = maxBodyLogSize)

        val response = chain.proceed(request)

        ResponseLogger.log(logger, response, maxBodyLogSize = maxBodyLogSize)

        return response
    }
}
