package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.core2.authentication.bearer.BearerAuthenticationInterceptor
import com.expediagroup.sdk.core2.authentication.common.Credentials
import com.expediagroup.sdk.core2.client.RequestExecutor
import com.expediagroup.sdk.core2.client.Transport
import com.expediagroup.sdk.core2.http.Request
import com.expediagroup.sdk.core2.http.Response
import com.expediagroup.sdk.core2.interceptor.Interceptor
import com.expediagroup.sdk.core2.interceptor.InterceptorsChainExecutor
import com.expediagroup.sdk.core2.logging.LoggingInterceptor
import com.expediagroup.sdk.core2.okhttp.BaseOkHttpClient
import com.expediagroup.sdk.core2.okhttp.OkHttpTransport
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
    apiEndpoint: ApiEndpoint,
    private val transport: Transport = getHttpTransport(configuration)
) : RequestExecutor(transport) {

    override val interceptors: List<Interceptor> = listOf(
        LoggingInterceptor(),
        BearerAuthenticationInterceptor(
            transport = this.transport,
            authUrl = apiEndpoint.authEndpoint,
            credentials = Credentials(configuration.key, configuration.secret)
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

