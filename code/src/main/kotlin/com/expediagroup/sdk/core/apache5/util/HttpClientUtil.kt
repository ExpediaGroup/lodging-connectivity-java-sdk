package com.expediagroup.sdk.core.apache5.util

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.google.api.client.http.apache.v5.Apache5HttpTransport
import org.apache.hc.client5.http.classic.HttpClient


fun createHttpClient(configurationProvider: ConfigurationProvider) = Apache5HttpTransport.newDefaultHttpClientBuilder()
    .apply {
        setConnectionManager(createPoolingHttpClientConnectionManager(configurationProvider))
        setDefaultRequestConfig(createRequestConfig(configurationProvider))
    }.build()


fun createSingletonHttpClient(configurationProvider: ConfigurationProvider) =
    CreateSingletonHttpClientLambda.execute(configurationProvider)


private class CreateSingletonHttpClientLambda: (ConfigurationProvider) -> HttpClient {
    companion object {
        @JvmStatic
        private var client: HttpClient? = null

        @JvmStatic
        val INSTANCE = CreateSingletonHttpClientLambda()

        @JvmStatic
        fun execute(configurationProvider: ConfigurationProvider): HttpClient {
            return INSTANCE(configurationProvider)
        }
    }

    override fun invoke(configurationProvider: ConfigurationProvider): HttpClient {
        if (client == null) {
            client = createHttpClient(configurationProvider)
        }

        return client!!
    }
}