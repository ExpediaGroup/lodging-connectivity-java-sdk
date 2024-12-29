package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.authentication.bearer.BearerAuthenticationInterceptor
import com.expediagroup.sdk.authentication.bearer.BearerAuthenticationManager
import com.expediagroup.sdk.authentication.common.Credentials
import com.expediagroup.sdk.client.AbstractRequestExecutor
import com.expediagroup.sdk.client.Transport
import com.expediagroup.sdk.common.RequestHeadersInterceptor
import com.expediagroup.sdk.interceptor.Interceptor
import com.expediagroup.sdk.logging.LoggingInterceptor
import com.expediagroup.sdk.okhttp.BaseOkHttpClient
import com.expediagroup.sdk.okhttp.OkHttpTransport
import com.expediagroup.sdk.lodgingconnectivity.configuration.ApiEndpoint
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.CustomClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.DefaultClientConfiguration

internal fun getHttpTransport(configuration: ClientConfiguration): Transport = when (configuration) {
    is CustomClientConfiguration -> configuration.transport
    is DefaultClientConfiguration -> OkHttpTransport(BaseOkHttpClient.getInstance(configuration.buildOkHttpConfiguration()))
}

class RequestExecutor(
    configuration: ClientConfiguration,
    apiEndpoint: ApiEndpoint
) : AbstractRequestExecutor(getHttpTransport(configuration)) {

    override val interceptors: List<Interceptor> = listOf(
        RequestHeadersInterceptor(),
        BearerAuthenticationInterceptor(
            BearerAuthenticationManager(
                requestExecutor = this,
                authUrl = apiEndpoint.authEndpoint,
                credentials = Credentials(configuration.key, configuration.secret),
            )
        ),
        LoggingInterceptor()
    )
}

