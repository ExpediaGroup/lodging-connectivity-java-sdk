package com.expediagroup.sdk.core.apache5.extension

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import org.apache.hc.client5.http.config.ConnectionConfig
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder

fun PoolingHttpClientConnectionManagerBuilder.applyClientConfiguration(provider: ConfigurationProvider) =
    this.apply {
        val connectionManager = ConnectionConfig.copy(ConnectionConfig.DEFAULT)
            .applyClientConfiguration(provider)
            .build()

        setDefaultConnectionConfig(connectionManager)
        setMaxConnTotal(provider.maxConnTotal!!)
        setMaxConnPerRoute(provider.maxConnPerRoute!!)
    }