package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.authentication.bearer.BearerAuthenticationAsyncManager
import com.expediagroup.sdk.authentication.common.Credentials
import com.expediagroup.sdk.lodgingconnectivity.configuration.ApiEndpoint
import com.expediagroup.sdk.lodgingconnectivity.configuration.AsyncClientConfiguration
import com.expediagroup.sdk.logging.common.LoggerDecorator
import com.expediagroup.sdk.pipeline.ExecutionPipeline
import com.expediagroup.sdk.pipeline.step.BearerAuthenticationStep
import com.expediagroup.sdk.pipeline.step.RequestHeadersStep
import com.expediagroup.sdk.pipeline.step.RequestLoggingStep
import com.expediagroup.sdk.pipeline.step.ResponseLoggingStep
import com.expediagroup.sdk.transport.AbstractAsyncRequestExecutor
import org.slf4j.LoggerFactory

class AsyncRequestExecutor(
    configuration: AsyncClientConfiguration,
    apiEndpoint: ApiEndpoint
) : AbstractAsyncRequestExecutor(configuration.asyncTransport) {

    private val authManager = BearerAuthenticationAsyncManager(
        authUrl = apiEndpoint.authEndpoint,
        credentials = Credentials(configuration.key, configuration.secret),
        asyncTransport = asyncTransport
    )

    override val executionPipeline = ExecutionPipeline(
        requestPipeline = listOf(
            RequestHeadersStep(),
            BearerAuthenticationStep(authManager),
            RequestLoggingStep(logger)
        ),
        responsePipeline = listOf(
            ResponseLoggingStep(logger)
        )
    )

    companion object {
        private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java.enclosingClass))
    }
}
