package com.expediagroup.sdk.core.configuration


/**
 * A builder class for constructing instances of FullClientConfiguration with customizable parameters.
 * This builder pattern allows you to configure various settings for the client, such as authentication details,
 * endpoints, and timeout settings.
 *
 * @param T The type of the client that will be built.
 */
abstract class DefaultClientBuilder<out T> {
    private var configurationBuilder = FullClientConfiguration.Builder()

    fun key(key: String) = apply {
        configurationBuilder = configurationBuilder.key(key)
    }

    fun secret(secret: String) = apply {
        configurationBuilder = configurationBuilder.secret(secret)
    }

    fun endpoint(endpoint: String) = apply {
        configurationBuilder = configurationBuilder.endpoint(endpoint)
    }

    fun authEndpoint(authEndpoint: String) = apply {
        configurationBuilder = configurationBuilder.authEndpoint(authEndpoint)
    }

    fun requestTimeout(requestTimeout: Long) = apply {
        configurationBuilder = configurationBuilder.requestTimeout(requestTimeout)
    }

    fun connectionTimeout(connectionTimeout: Long) = apply {
        configurationBuilder = configurationBuilder.connectionTimeout(connectionTimeout)
    }

    fun socketTimeout(socketTimeout: Long) = apply {
        configurationBuilder = configurationBuilder.socketTimeout(socketTimeout)
    }

    fun maskedLoggingHeaders(maskedLoggingHeaders: Set<String>) = apply {
        configurationBuilder = configurationBuilder.maskedLoggingHeaders(maskedLoggingHeaders)
    }

    fun maskedLoggingBodyFields(maskedLoggingBodyFields: Set<String>) = apply {
        configurationBuilder = configurationBuilder.maskedLoggingBodyFields(maskedLoggingBodyFields)
    }

    fun maxConnectionTotal(maxConnectionTotal: Int) = apply {
        configurationBuilder = configurationBuilder.maxConnectionsTotal(maxConnectionTotal)
    }

    fun maxConnectionPerRoute(maxConnectionPerRoute: Int) = apply {
        configurationBuilder = configurationBuilder.maxConnectionsPerRoute(maxConnectionPerRoute)
    }

    /**
     * Builds and returns a fully configured client instance.
     *
     * @return a fully configured instance of the client.
     */
    fun buildConfiguration(): FullClientConfiguration {
        return configurationBuilder.build()
    }

    /**
     * Builds and returns a fully configured client instance.
     *
     * @return a fully configured instance of the client.
     */
    open fun build(): T {
        throw NotImplementedError("Not yet implemented")
    }
}
