package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.core2.authentication.bearer.BearerAuthenticationInterceptor
import com.expediagroup.sdk.core2.authentication.common.Credentials
import com.expediagroup.sdk.core2.client.HttpClientAdapter
import com.expediagroup.sdk.core2.client.HttpClientExecutor
import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpResponse
import com.expediagroup.sdk.core2.interceptor.Interceptor
import com.expediagroup.sdk.core2.interceptor.InterceptorsChainExecutor
import com.expediagroup.sdk.core2.logging.LoggingInterceptor
import com.expediagroup.sdk.core2.okhttp.BaseOkHttpClient
import com.expediagroup.sdk.core2.okhttp.OkHttpClientAdapter
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

