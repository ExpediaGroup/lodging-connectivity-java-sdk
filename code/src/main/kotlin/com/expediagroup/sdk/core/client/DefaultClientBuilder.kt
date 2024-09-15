package com.expediagroup.sdk.core.client

import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration

interface ClientBuilder<T> {
    fun build(): T
}

abstract class DefaultClientBuilder<T>(
    private var configurationBuilder: ExpediaGroupClientConfiguration.Builder = ExpediaGroupClientConfiguration.Builder()
) : ClientBuilder<T> {
    fun key(key: String) = apply { configurationBuilder = configurationBuilder.key(key) }
    fun secret(secret: String) = apply { configurationBuilder = configurationBuilder.secret(secret) }
    fun endpoint(endpoint: String) = apply { configurationBuilder = configurationBuilder.endpoint(endpoint) }
    fun authEndpoint(authEndpoint: String) = apply { configurationBuilder = configurationBuilder.authEndpoint(authEndpoint) }
    fun requestTimeout(requestTimeout: Long) = apply { configurationBuilder = configurationBuilder.requestTimeout(requestTimeout) }
    fun connectionTimeout(connectionTimeout: Long) = apply { configurationBuilder = configurationBuilder.connectionTimeout(connectionTimeout) }
    fun socketTimeout(socketTimeout: Long) = apply { configurationBuilder = configurationBuilder.socketTimeout(socketTimeout) }
    fun maskedLoggingHeaders(maskedLoggingHeaders: Set<String>) = apply { configurationBuilder = configurationBuilder.maskedLoggingHeaders(maskedLoggingHeaders) }
    fun maskedLoggingBodyFields(maskedLoggingBodyFields: Set<String>) = apply { configurationBuilder = configurationBuilder.maskedLoggingBodyFields(maskedLoggingBodyFields) }
    fun maxConnTotal(maxConnTotal: Int) = apply { configurationBuilder = configurationBuilder.maxConnTotal(maxConnTotal) }
    fun maxConnPerRoute(maxConnPerRoute: Int) = apply { configurationBuilder = configurationBuilder.maxConnPerRoute(maxConnPerRoute) }
}