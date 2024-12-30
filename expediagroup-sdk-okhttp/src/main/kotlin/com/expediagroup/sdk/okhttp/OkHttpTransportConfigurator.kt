package com.expediagroup.sdk.okhttp

import okhttp3.ConnectionPool
import okhttp3.Interceptor


object OkHttpTransportConfigurator {
    private val configurationBuilder: OkHttpClientConfiguration.Builder = OkHttpClientConfiguration.Builder()

    @JvmStatic
    fun setInterceptors(interceptors: List<Interceptor>) {
        configurationBuilder.interceptors(interceptors)
    }

    @JvmStatic
    fun setNetworkInterceptors(networkInterceptors: List<Interceptor>) {
        configurationBuilder.networkInterceptors(networkInterceptors)
    }

    @JvmStatic
    fun setConnectionPool(connectionPool: ConnectionPool) {
        configurationBuilder.connectionPool(connectionPool)
    }

    @JvmStatic
    fun setRetryOnConnectionFailure(retryOnConnectionFailure: Boolean) {
        configurationBuilder.retryOnConnectionFailure(retryOnConnectionFailure)
    }

    @JvmStatic
    fun setCallTimeout(callTimeout: Int) {
        configurationBuilder.callTimeout(callTimeout)
    }

    @JvmStatic
    fun setConnectTimeout(connectTimeout: Int) {
        configurationBuilder.connectTimeout(connectTimeout)
    }

    @JvmStatic
    fun setReadTimeout(readTimeout: Int) {
        configurationBuilder.readTimeout(readTimeout)
    }

    @JvmStatic
    fun setWriteTimeout(writeTimeout: Int) {
        configurationBuilder.writeTimeout(writeTimeout)
    }

    fun get(): OkHttpClientConfiguration = configurationBuilder.build()
}
