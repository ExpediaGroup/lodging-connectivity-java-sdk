package com.expediagroup.sdk.core2.okhttp

import java.time.Duration
import okhttp3.OkHttpClient

internal object BaseOkHttpSdkClient {
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
            configuration.callTimeoutMillis?.let {
                callTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.connectTimeoutMillis?.let {
                connectTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.readTimeoutMillis?.let {
                readTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.writeTimeoutMillis?.let {
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
