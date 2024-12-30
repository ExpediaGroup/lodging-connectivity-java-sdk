package com.expediagroup.sdk.pipeline.step

import com.expediagroup.sdk.http.Response
import com.expediagroup.sdk.logging.LoggerDecorator
import com.expediagroup.sdk.logging.ResponseLogger
import com.expediagroup.sdk.pipeline.ResponsePipelineStep

class ResponseLoggingStep(private val logger: LoggerDecorator) : ResponsePipelineStep {

    override fun invoke(response: Response): Response {
        return response.also { ResponseLogger.log(logger, it) }
    }
}
