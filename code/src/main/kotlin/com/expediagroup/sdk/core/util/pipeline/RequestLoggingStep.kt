package com.expediagroup.sdk.core.util.pipeline

import com.expediagroup.sdk.core.client.RequestPipelineStep
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.logging.common.LoggerDecorator
import com.expediagroup.sdk.core.logging.common.RequestLogger
import okio.Buffer

class RequestLoggingStep(private val logger: LoggerDecorator) : RequestPipelineStep {

    override fun invoke(request: Request): Request {
        var reusableRequest: Request = request

        request.body?.let {
            reusableRequest = reusableRequest.newBuilder()
                .body(it.snapshot())
                .build()
        }

        RequestLogger.log(logger, reusableRequest)

        return reusableRequest
    }

    private fun RequestBody.snapshot(): RequestBody {
        val buffer = Buffer().apply { use { writeTo(this) } }

        return RequestBody.create(
            byteString = buffer.snapshot(),
            mediaType = this.mediaType(),
            contentLength = this.contentLength()
        )
    }
}