package com.expediagroup.sdk.core.apache5.util

import com.expediagroup.sdk.core.apache5.extension.applyClientConfiguration
import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder

internal fun createPoolingHttpClientConnectionManager(configurationProvider: ConfigurationProvider) =
    PoolingHttpClientConnectionManagerBuilder.create()
        .applyClientConfiguration(configurationProvider)
        .build()
