package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.authentication.bearer.BearerAuthenticationManager
import com.expediagroup.sdk.authentication.bearer.BearerAuthenticationStep
import com.expediagroup.sdk.authentication.common.Credentials
import com.expediagroup.sdk.common.RequestHeadersStep
import com.expediagroup.sdk.lodgingconnectivity.configuration.ApiEndpoint
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.logging.RequestLoggingStep
import com.expediagroup.sdk.logging.ResponseLoggingStep
import com.expediagroup.sdk.logging.common.LoggerDecorator
import com.expediagroup.sdk.transport.AbstractRequestExecutor
import com.expediagroup.sdk.transport.ExecutionPipeline
import org.slf4j.LoggerFactory

class RequestExecutor(
    configuration: ClientConfiguration,
    apiEndpoint: ApiEndpoint
) : AbstractRequestExecutor(configuration.transport) {

    private val authManager = BearerAuthenticationManager(
        authUrl = apiEndpoint.authEndpoint,
        credentials = Credentials(configuration.key, configuration.secret),
        transport = transport
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
