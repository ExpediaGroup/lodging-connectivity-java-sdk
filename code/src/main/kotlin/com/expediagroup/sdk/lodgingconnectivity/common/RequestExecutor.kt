package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.authentication.bearer.BearerAuthenticationInterceptor
import com.expediagroup.sdk.authentication.bearer.BearerAuthenticationManager
import com.expediagroup.sdk.authentication.common.Credentials
import com.expediagroup.sdk.client.AbstractRequestExecutor
import com.expediagroup.sdk.common.RequestHeadersInterceptor
import com.expediagroup.sdk.interceptor.Interceptor
import com.expediagroup.sdk.lodgingconnectivity.configuration.ApiEndpoint
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.logging.LoggingInterceptor

class RequestExecutor(
    configuration: ClientConfiguration,
    apiEndpoint: ApiEndpoint
) : AbstractRequestExecutor(configuration.transport) {

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
