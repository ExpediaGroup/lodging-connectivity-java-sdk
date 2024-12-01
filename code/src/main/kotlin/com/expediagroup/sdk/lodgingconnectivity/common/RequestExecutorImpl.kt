package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.core.authentication.bearer.BearerAuthenticationInterceptor
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

internal fun getHttpClientAdapter(configuration: ClientConfiguration): Transport = when (configuration) {
    is CustomClientConfiguration -> configuration.transport
    is DefaultClientConfiguration -> OkHttpTransport(BaseOkHttpClient.getConfiguredInstance(configuration.buildOkHttpConfiguration()))
}

class RequestExecutorImpl(
    configuration: ClientConfiguration,
    apiEndpoint: ApiEndpoint
) : RequestExecutor(getHttpClientAdapter(configuration)) {

    override val interceptors: List<Interceptor> = listOf(
        LoggingInterceptor(),
        BearerAuthenticationInterceptor(
            transport = this.transport,
            authUrl = apiEndpoint.authEndpoint,
            credentials = Credentials(key = configuration.key, secret = configuration.secret)
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

