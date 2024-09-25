package com.expediagroup.sdk.core.apache.util

import com.expediagroup.sdk.core.apache.interceptor.ExpediaGroupRequestInterceptor
import com.expediagroup.sdk.core.apache.interceptor.ExpediaGroupResponseInterceptor
import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.google.api.client.http.apache.v2.ApacheHttpTransport
import org.apache.http.client.HttpClient
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap


fun createHttpClient(configurationProvider: ConfigurationProvider): HttpClient =
    ApacheHttpTransport.newDefaultHttpClientBuilder()
        .setDefaultRequestConfig(createRequestConfig(configurationProvider))
        .setMaxConnTotal(configurationProvider.maxConnTotal!!)
        .setMaxConnPerRoute(configurationProvider.maxConnPerRoute!!)
        .addInterceptorLast(ExpediaGroupRequestInterceptor())
        .addInterceptorLast(ExpediaGroupResponseInterceptor())
        .build()

fun getSingletonHttpClient(configurationProvider: ConfigurationProvider) =
    CreateSingletonHttpClientLambda.execute(configurationProvider)


private class CreateSingletonHttpClientLambda : (ConfigurationProvider) -> HttpClient {
    companion object {
        @JvmStatic
        private val clients: ConcurrentMap<UUID, HttpClient> = ConcurrentHashMap()

        @JvmStatic
        val INSTANCE = CreateSingletonHttpClientLambda()

        @JvmStatic
        fun execute(configurationProvider: ConfigurationProvider): HttpClient {
            return INSTANCE(configurationProvider)
        }
    }

    override fun invoke(configurationProvider: ConfigurationProvider): HttpClient =
        clients.getOrPut(configurationProvider.id) {
            createHttpClient(configurationProvider)
        }
}