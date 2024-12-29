package com.expediagroup.sdk.logging

import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.http.RequestBody
import com.expediagroup.sdk.logging.common.LoggerDecorator
import com.expediagroup.sdk.logging.common.RequestLogger
import com.expediagroup.sdk.transport.RequestPipelineStep
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