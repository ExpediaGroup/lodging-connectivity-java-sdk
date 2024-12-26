package com.expediagroup.sdk.core.logging

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor
import com.expediagroup.sdk.core.logging.common.Constant.DEFAULT_MAX_BODY_SIZE
import com.expediagroup.sdk.core.logging.common.LoggerDecorator
import com.expediagroup.sdk.core.logging.common.RequestLogger
import com.expediagroup.sdk.core.logging.common.ResponseLogger
import java.util.concurrent.CompletableFuture
import okio.Buffer
import org.slf4j.LoggerFactory

class LoggingInterceptor(
    private val maxBodyLogSize: Long = DEFAULT_MAX_BODY_SIZE
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): CompletableFuture<Response> {
        val request = chain.request()

        var reusableRequest: Request = request

        request.body?.let {
            reusableRequest = reusableRequest.newBuilder()
                .body(it.snapshot())
                .build()
        }

        RequestLogger.log(logger, reusableRequest, maxBodyLogSize = maxBodyLogSize)

        return chain.proceed(reusableRequest).thenApply {
            ResponseLogger.log(logger, it, maxBodyLogSize = maxBodyLogSize)
            it
        }
    }

    private fun RequestBody.snapshot(): RequestBody {
        val buffer = Buffer().apply { use { writeTo(this) } }

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
