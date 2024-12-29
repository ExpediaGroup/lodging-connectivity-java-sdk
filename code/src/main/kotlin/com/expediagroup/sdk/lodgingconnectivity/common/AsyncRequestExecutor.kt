package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.core.authentication.bearer.BearerAuthenticationAsyncManager
import com.expediagroup.sdk.core.authentication.common.Credentials
import com.expediagroup.sdk.core.client.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.core.client.AsyncTransport
import com.expediagroup.sdk.core.client.ExecutionPipeline
import com.expediagroup.sdk.core.logging.common.LoggerDecorator
import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupConfigurationException
import com.expediagroup.sdk.core.okhttp.BaseOkHttpClient
import com.expediagroup.sdk.core.okhttp.OkHttpAsyncTransport
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

internal fun getAsyncTransport(configuration: ClientConfiguration): AsyncTransport = when (configuration) {
    is DefaultClientConfiguration -> OkHttpAsyncTransport(BaseOkHttpClient.getInstance(configuration.buildOkHttpConfiguration()))
    is CustomAsyncClientConfiguration -> configuration.asyncTransport
    is CustomClientConfiguration -> throw ExpediaGroupConfigurationException(
        "sync transport implementations can be only used with sync clients"
    )
}

class AsyncRequestExecutor(
    configuration: ClientConfiguration,
    apiEndpoint: ApiEndpoint
) : AbstractAsyncRequestExecutor(getAsyncTransport(configuration)) {

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
