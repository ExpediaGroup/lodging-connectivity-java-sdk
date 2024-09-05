package com.expediagroup.sdk.core.apache5.extension

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import org.apache.hc.client5.http.config.RequestConfig
import org.apache.hc.client5.http.impl.async.HttpAsyncClientBuilder
import org.apache.hc.core5.util.Timeout

fun RequestConfig.Builder.applyClientConfiguration(provider: ConfigurationProvider) =
    // TODO: Consider using PoolingAsyncClientConnectionManager
    this.apply {
        setConnectionRequestTimeout(Timeout.ofMilliseconds(provider.requestTimeout!!))
        HttpAsyncClientBuilder.create()
    }