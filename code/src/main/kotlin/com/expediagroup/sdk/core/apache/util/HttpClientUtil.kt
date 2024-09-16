package com.expediagroup.sdk.core.apache.util

import com.expediagroup.sdk.core.apache.interceptor.RequestLoggingInterceptor
import com.expediagroup.sdk.core.apache.interceptor.ResponseLoggingInterceptor
import com.expediagroup.sdk.core.client.ExpediaGroupClient
import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.gapiclient.GClient
import com.google.api.client.http.apache.v2.ApacheHttpTransport
import org.apache.http.client.HttpClient
import org.slf4j.LoggerFactory
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap


fun createHttpClient(configurationProvider: ConfigurationProvider): HttpClient =
    ApacheHttpTransport.newDefaultHttpClientBuilder()
        .setDefaultRequestConfig(createRequestConfig(configurationProvider))
        .setMaxConnTotal(configurationProvider.maxConnTotal!!)
        .setMaxConnPerRoute(configurationProvider.maxConnPerRoute!!)
        .addInterceptorLast(RequestLoggingInterceptor(LoggerFactory.getLogger(GClient::class.java)))
        .addInterceptorLast(ResponseLoggingInterceptor(LoggerFactory.getLogger(GClient::class.java)))
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