package com.expediagroup.sdk.okhttp

import okhttp3.ConnectionPool
import okhttp3.Interceptor

object OkHttpTransportConfigurator {
    private val configurationBuilder: OkHttpClientConfiguration.Builder = OkHttpClientConfiguration.Builder()

    fun setInterceptors(interceptors: List<Interceptor>) {
        configurationBuilder.interceptors(interceptors)
    }

    fun setNetworkInterceptors(networkInterceptors: List<Interceptor>) {
        configurationBuilder.networkInterceptors(networkInterceptors)
    }

    fun setConnectionPool(connectionPool: ConnectionPool) {
        configurationBuilder.connectionPool(connectionPool)
    }

    fun setRetryOnConnectionFailure(retryOnConnectionFailure: Boolean) {
        configurationBuilder.retryOnConnectionFailure(retryOnConnectionFailure)
    }

    fun setCallTimeout(callTimeout: Int) {
        configurationBuilder.callTimeout(callTimeout)
    }

    fun setConnectTimeout(connectTimeout: Int) {
        configurationBuilder.connectTimeout(connectTimeout)
    }

    fun setReadTimeout(readTimeout: Int) {
        configurationBuilder.readTimeout(readTimeout)
    }

    fun setWriteTimeout(writeTimeout: Int) {
        configurationBuilder.writeTimeout(writeTimeout)
    }

    fun get(): OkHttpClientConfiguration = configurationBuilder.build()
}
