package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.core.authentication.bearer.BearerAuthenticationManager
import com.expediagroup.sdk.core.authentication.common.Credentials
import com.expediagroup.sdk.core.client.AbstractRequestExecutor
import com.expediagroup.sdk.core.client.ExecutionPipeline
import com.expediagroup.sdk.core.client.Transport
import com.expediagroup.sdk.core.logging.common.LoggerDecorator
import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupConfigurationException
import com.expediagroup.sdk.core.okhttp.BaseOkHttpClient
import com.expediagroup.sdk.core.okhttp.OkHttpTransport
import com.expediagroup.sdk.core.util.pipeline.BearerAuthenticationStep
import com.expediagroup.sdk.core.util.pipeline.RequestHeadersStep
import com.expediagroup.sdk.core.util.pipeline.RequestLoggingStep
import com.expediagroup.sdk.core.util.pipeline.ResponseLoggingStep
import com.expediagroup.sdk.lodgingconnectivity.configuration.ApiEndpoint
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.CustomAsyncClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.CustomClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.DefaultClientConfiguration
import org.slf4j.LoggerFactory

internal fun getTransport(configuration: ClientConfiguration): Transport = when (configuration) {
    is DefaultClientConfiguration -> OkHttpTransport(BaseOkHttpClient.getInstance(configuration.buildOkHttpConfiguration()))
    is CustomClientConfiguration -> configuration.transport
    is CustomAsyncClientConfiguration -> throw ExpediaGroupConfigurationException(
        "async transport implementations can be only used with async clients"
    )
}

class RequestExecutor(
    configuration: ClientConfiguration,
    apiEndpoint: ApiEndpoint
) : AbstractRequestExecutor(getTransport(configuration)) {

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
