package com.expediagroup.sdk.core.apache5.extension

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.configuration.provider.ExpediaGroupConfigurationProvider
import org.apache.hc.client5.http.config.ConnectionConfig
import org.apache.hc.core5.util.Timeout

fun ConnectionConfig.Builder.applyClientConfiguration(provider: ConfigurationProvider) =
    this.apply {
        provider.withDefaultsConfigurationProvider(ExpediaGroupConfigurationProvider).let {
            setSocketTimeout(Timeout.ofMilliseconds(it.socketTimeout!!))
            setConnectTimeout(Timeout.ofMilliseconds(it.connectionTimeout!!))
        }
    }