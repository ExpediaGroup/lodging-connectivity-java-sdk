package com.expediagroup.sdk.core.util.pipeline

import com.expediagroup.sdk.core.client.ResponsePipelineStep
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.logging.common.LoggerDecorator
import com.expediagroup.sdk.core.logging.common.ResponseLogger

class ResponseLoggingStep(private val logger: LoggerDecorator) : ResponsePipelineStep {

    override fun invoke(response: Response): Response {
        return response.also { ResponseLogger.log(logger, it) }
    }
}