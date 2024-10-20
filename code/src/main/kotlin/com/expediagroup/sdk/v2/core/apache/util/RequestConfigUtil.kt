package com.expediagroup.sdk.v2.core.apache.util

import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.core.trait.configuration.SocketTimeoutTrait
import org.apache.http.client.config.RequestConfig


/**
 * Creates a copy of the default `RequestConfig` and sets the connection and socket timeouts.
 *
 * This method ensures that the provided `configuration` implements the `SocketTimeoutTrait`,
 * which provides the required `getSocketTimeout` method to retrieve the socket timeout value.
 *
 * @param configuration The `ClientConfiguration` instance that must implement `SocketTimeoutTrait`.
 * @return A configured `RequestConfig` instance with the connection and socket timeouts set, or `null` if the configuration is invalid.
 * @throws IllegalArgumentException If the provided `ClientConfiguration` does not implement `SocketTimeoutTrait`.
 */
internal fun createRequestConfig(configuration: ClientConfiguration): RequestConfig? {
    require(configuration is SocketTimeoutTrait) { "Configuration must implement SocketTimeoutTrait" }

    return RequestConfig.copy(RequestConfig.DEFAULT)
        .setConnectTimeout(configuration.getSocketTimeout().toInt())
        .setSocketTimeout(configuration.getSocketTimeout().toInt())
        .build()
}