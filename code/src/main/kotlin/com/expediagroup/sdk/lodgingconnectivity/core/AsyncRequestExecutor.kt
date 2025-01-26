package com.expediagroup.sdk.lodgingconnectivity.core

import com.expediagroup.sdk.core.authentication.bearer.BearerAuthenticationAsyncManager
import com.expediagroup.sdk.core.authentication.common.Credentials
import com.expediagroup.sdk.core.logging.LoggerDecorator
import com.expediagroup.sdk.core.pipeline.ExecutionPipeline
import com.expediagroup.sdk.core.pipeline.step.BearerAuthenticationStep
import com.expediagroup.sdk.core.pipeline.step.RequestHeadersStep
import com.expediagroup.sdk.core.pipeline.step.RequestLoggingStep
import com.expediagroup.sdk.core.pipeline.step.ResponseLoggingStep
import com.expediagroup.sdk.core.transport.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.lodgingconnectivity.configuration.ApiEndpoint
import com.expediagroup.sdk.lodgingconnectivity.configuration.AsyncClientConfiguration
import org.slf4j.LoggerFactory

class AsyncRequestExecutor(
    configuration: AsyncClientConfiguration,
    apiEndpoint: ApiEndpoint,
) : AbstractAsyncRequestExecutor(configuration.asyncTransport) {
    private val authManager =
        BearerAuthenticationAsyncManager(
            authUrl = apiEndpoint.authEndpoint,
            credentials = Credentials(configuration.key, configuration.secret),
            asyncTransport = asyncTransport,
        )

    override val executionPipeline =
        ExecutionPipeline(
            requestPipeline =
                listOf(
                    RequestHeadersStep(),
                    BearerAuthenticationStep(authManager),
                    RequestLoggingStep(logger),
                ),
            responsePipeline =
                listOf(
                    ResponseLoggingStep(logger),
                ),
        )

    companion object {
        private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java.enclosingClass))
    }
}
