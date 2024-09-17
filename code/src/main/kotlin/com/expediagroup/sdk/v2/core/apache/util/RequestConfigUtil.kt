package com.expediagroup.sdk.v2.core.apache.util

import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.core.trait.configuration.SocketTimeoutTrait
import org.apache.http.client.config.RequestConfig


internal fun createRequestConfig(configuration: ClientConfiguration): RequestConfig? {
    require(configuration is SocketTimeoutTrait) { "Configuration must implement SocketTimeoutTrait" }

    return RequestConfig.copy(RequestConfig.DEFAULT)
        .setConnectTimeout(configuration.getSocketTimeout().toInt())
        .setSocketTimeout(configuration.getSocketTimeout().toInt())
        .build()
}