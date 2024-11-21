package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.core.authentication.bearer.BearerAuthenticationInterceptor
import com.expediagroup.sdk.core.authentication.common.Credentials
import com.expediagroup.sdk.core.client.HttpClientAdapter
import com.expediagroup.sdk.core.client.HttpClientExecutor
import com.expediagroup.sdk.core.http.HttpRequest
import com.expediagroup.sdk.core.http.HttpResponse
import com.expediagroup.sdk.core.interceptor.Interceptor
import com.expediagroup.sdk.core.interceptor.InterceptorsChainExecutor
import com.expediagroup.sdk.core.logging.LoggingInterceptor
import com.expediagroup.sdk.core.okhttp.BaseOkHttpClient
import com.expediagroup.sdk.core.okhttp.OkHttpClientAdapter
import com.expediagroup.sdk.lodgingconnectivity.configuration.ApiEndpoint
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.CustomHttpClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.DefaultClientConfiguration

internal fun getHttpClientAdapter(configuration: ClientConfiguration): HttpClientAdapter = when (configuration) {
    is CustomHttpClientConfiguration -> configuration.httpClientAdapter
    is DefaultClientConfiguration -> OkHttpClientAdapter(BaseOkHttpClient.getConfiguredInstance(configuration.buildOkHttpConfiguration()))
}

class HttpClientExecutorImpl(
    configuration: ClientConfiguration,
    apiEndpoint: ApiEndpoint
) : HttpClientExecutor(getHttpClientAdapter(configuration)) {

    override val interceptors: List<Interceptor> = listOf(
        LoggingInterceptor(),
        BearerAuthenticationInterceptor(
            httpClientAdapter = this.httpClientAdapter,
            authUrl = apiEndpoint.authEndpoint,
            credentials = Credentials(key = configuration.key, secret = configuration.secret)
        )
    )

    override fun execute(request: HttpRequest): HttpResponse {
        val chainExecutor = InterceptorsChainExecutor(
            interceptors = interceptors,
            request = request,
            httpClientAdapter = this.httpClientAdapter
        )

        return chainExecutor.proceed(request)
    }
}

