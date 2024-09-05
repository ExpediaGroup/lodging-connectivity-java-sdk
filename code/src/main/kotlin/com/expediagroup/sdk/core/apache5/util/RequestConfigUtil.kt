package com.expediagroup.sdk.core.apache5.util

import com.expediagroup.sdk.core.apache5.extension.applyClientConfiguration
import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import org.apache.hc.client5.http.config.RequestConfig

internal fun createRequestConfig(configurationProvider: ConfigurationProvider) = RequestConfig.copy(RequestConfig.DEFAULT)
    .applyClientConfiguration(configurationProvider)
    .build()