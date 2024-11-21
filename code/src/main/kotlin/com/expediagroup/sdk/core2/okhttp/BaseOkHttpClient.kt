package com.expediagroup.sdk.core2.okhttp

import java.time.Duration
import okhttp3.OkHttpClient

internal object BaseOkHttpClient {
    @Volatile
    private var instance: OkHttpClient? = null

    fun getInstance(): OkHttpClient {
        return instance ?: synchronized(this) {
            instance ?: OkHttpClient().also { instance = it }
        }
    }

    fun getConfiguredInstance(configuration: OkHttpClientConfiguration): OkHttpClient = getInstance()
        .newBuilder()
        .apply {
            configuration.callTimeout?.let {
                callTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.connectTimeout?.let {
                connectTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.readTimeout?.let {
                readTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.writeTimeout?.let {
                writeTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.connectionPool?.let {
                connectionPool(it)
            }
            configuration.retryOnConnectionFailure?.let {
                retryOnConnectionFailure(it)
            }
            configuration.interceptors?.forEach {
                addInterceptor(it)
            }
            configuration.networkInterceptors?.forEach {
                addNetworkInterceptor(it)
            }
        }.build()
}
