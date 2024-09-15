package com.expediagroup.sdk.core.apache.util

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import org.apache.http.client.config.RequestConfig


internal fun createRequestConfig(configurationProvider: ConfigurationProvider) = RequestConfig.copy(RequestConfig.DEFAULT)
    .setConnectTimeout(configurationProvider.socketTimeout!!.toInt())
    .setSocketTimeout(configurationProvider.socketTimeout!!.toInt())
    .build()
