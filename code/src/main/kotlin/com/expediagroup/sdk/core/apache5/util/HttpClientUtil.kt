package com.expediagroup.sdk.core.apache5.util

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.google.api.client.http.apache.v5.Apache5HttpTransport
import org.apache.hc.client5.http.classic.HttpClient
import org.apache.hc.core5.http.EntityDetails
import org.apache.hc.core5.http.HttpRequest
import org.apache.hc.core5.http.HttpRequestInterceptor
import org.apache.hc.core5.http.protocol.HttpContext


class DebugInterceptor: HttpRequestInterceptor {
    // TODO: Implement logging
    override fun process(request: HttpRequest?, entitiy: EntityDetails?, content: HttpContext?) {
        println("---")
        request?.headers?.forEach {
            println("${it.name}: ${it.value}")
        }
    }
}

fun createHttpClient(configurationProvider: ConfigurationProvider) = Apache5HttpTransport.newDefaultHttpClientBuilder()
    .apply {
        setConnectionManager(createPoolingHttpClientConnectionManager(configurationProvider))
        setDefaultRequestConfig(createRequestConfig(configurationProvider))
        addRequestInterceptorLast(DebugInterceptor())

    }.build()

fun getSingletonHttpClient(configurationProvider: ConfigurationProvider) =
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