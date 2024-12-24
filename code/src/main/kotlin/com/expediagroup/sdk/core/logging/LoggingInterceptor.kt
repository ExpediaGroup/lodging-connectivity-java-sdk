package com.expediagroup.sdk.core.logging

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor
import com.expediagroup.sdk.core.logging.common.Constant.DEFAULT_MAX_BODY_SIZE
import com.expediagroup.sdk.core.logging.common.LoggerDecorator
import com.expediagroup.sdk.core.logging.common.RequestLogger
import com.expediagroup.sdk.core.logging.common.ResponseLogger
import java.io.IOException
import okio.Buffer
import org.slf4j.LoggerFactory

/**
 * An interceptor that logs HTTP requests and responses.
 *
 * @param maxBodyLogSize The maximum size of the request/response body to log. Defaults to 1MB.
 */
class LoggingInterceptor(
    private val maxBodyLogSize: Long = DEFAULT_MAX_BODY_SIZE
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        var reusableRequest: Request = request

        request.body?.let {
            reusableRequest = reusableRequest.newBuilder()
                .body(it.snapshot())
                .build()
        }

        RequestLogger.log(logger, reusableRequest, maxBodyLogSize = maxBodyLogSize)

        val response = chain.proceed(reusableRequest)

        ResponseLogger.log(logger, response, maxBodyLogSize = maxBodyLogSize)

        return response
    }

    private fun RequestBody.snapshot():  RequestBody {
        val buffer = Buffer().apply { writeTo(this) }

        return RequestBody.create(
            byteString = buffer.snapshot(),
            mediaType = this.mediaType(),
            contentLength = this.contentLength()
        )
    }

    companion object {
        private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java.enclosingClass))
    }
}
