package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.core.authentication.bearer.BearerAuthenticationInterceptor
import com.expediagroup.sdk.core.authentication.bearer.BearerAuthenticationManager
import com.expediagroup.sdk.core.authentication.common.Credentials
import com.expediagroup.sdk.core.client.RequestExecutor
import com.expediagroup.sdk.core.client.Transport
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor
import com.expediagroup.sdk.core.interceptor.InterceptorsChainExecutor
import com.expediagroup.sdk.core.logging.LoggingInterceptor
import com.expediagroup.sdk.core.okhttp.BaseOkHttpClient
import com.expediagroup.sdk.core.okhttp.OkHttpTransport
import com.expediagroup.sdk.lodgingconnectivity.configuration.ApiEndpoint
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.CustomClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.DefaultClientConfiguration

internal fun getHttpTransport(configuration: ClientConfiguration): Transport = when (configuration) {
    is CustomClientConfiguration -> configuration.transport
    is DefaultClientConfiguration -> OkHttpTransport(BaseOkHttpClient.getConfiguredInstance(configuration.buildOkHttpConfiguration()))
}

class DefaultRequestExecutor(
    configuration: ClientConfiguration,
    apiEndpoint: ApiEndpoint
) : RequestExecutor(getHttpTransport(configuration)) {

    override val interceptors: List<Interceptor> = listOf(
        LoggingInterceptor(),
        BearerAuthenticationInterceptor(
            BearerAuthenticationManager(
                requestExecutor = this,
                authUrl = apiEndpoint.authEndpoint,
                credentials = Credentials(configuration.key, configuration.secret),
            )
        )
    )

    override fun execute(request: Request): Response {
        val chainExecutor = InterceptorsChainExecutor(
            interceptors = interceptors,
            request = request,
            transport = this.transport
        )

        return chainExecutor.proceed(request)
    }
}

