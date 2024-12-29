package com.expediagroup.sdk.logging

import com.expediagroup.sdk.http.Response
import com.expediagroup.sdk.logging.common.LoggerDecorator
import com.expediagroup.sdk.logging.common.ResponseLogger
import com.expediagroup.sdk.transport.ResponsePipelineStep

class ResponseLoggingStep(private val logger: LoggerDecorator) : ResponsePipelineStep {

    override fun invoke(response: Response): Response {
        return response.also { ResponseLogger.log(logger, it) }
    }
}
