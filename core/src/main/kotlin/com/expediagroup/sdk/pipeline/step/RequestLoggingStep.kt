package com.expediagroup.sdk.pipeline.step

import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.http.RequestBody
import com.expediagroup.sdk.logging.LoggerDecorator
import com.expediagroup.sdk.logging.RequestLogger
import com.expediagroup.sdk.pipeline.RequestPipelineStep
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