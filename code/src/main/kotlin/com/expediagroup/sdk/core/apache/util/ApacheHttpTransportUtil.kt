package com.expediagroup.sdk.core.apache.util

import com.expediagroup.sdk.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.core.trait.configuration.MaxConnectionsPerRouteTrait
import com.expediagroup.sdk.core.trait.configuration.MaxConnectionsTotalTrait
import com.expediagroup.sdk.core.trait.configuration.SocketTimeoutTrait
import com.google.api.client.http.apache.v2.ApacheHttpTransport
import org.apache.http.client.HttpClient
import org.apache.http.client.config.RequestConfig
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap


fun createApacheHttpTransport(configuration: ClientConfiguration): ApacheHttpTransport =
    ApacheHttpTransport(createHttpClient(configuration))

fun getSingletonApacheHttpTransport(configuration: ClientConfiguration): ApacheHttpTransport =
    ApacheHttpTransportSingleton.getTransport(configuration)


/**
 * Singleton object for managing Apache HTTP transports.
 *
 * This singleton object provides a thread-safe way to manage a collection of `ApacheHttpTransport`
 * instances identified by a `ClientConfiguration`'s UUID. The transport instances are stored
 * in a `ConcurrentMap` to prevent duplicate creation and ensure efficient reuse.
 *
 * Functions:
 * - getTransport(configuration: ClientConfiguration): Retrieves an existing `ApacheHttpTransport`
 *   instance if available, or creates a new one based on the given `ClientConfiguration`.
 */
private object ApacheHttpTransportSingleton {
    private val transports: ConcurrentMap<UUID, ApacheHttpTransport> = ConcurrentHashMap()


    /**
     * Retrieves or creates an `ApacheHttpTransport` instance based on the provided `ClientConfiguration`.
     *
     * If an `ApacheHttpTransport` associated with the given configuration ID already exists, it is returned.
     * Otherwise, a new `ApacheHttpTransport` is created using the provided configuration.
     *
     * @param configuration The `ClientConfiguration` instance containing the necessary traits and configurations
     *                      for initializing or retrieving the `ApacheHttpTransport`.
     * @return An `ApacheHttpTransport` instance associated with the given `ClientConfiguration`.
     */
    fun getTransport(configuration: ClientConfiguration): ApacheHttpTransport =
        transports.getOrPut(configuration.id) {
            createApacheHttpTransport(configuration)
        }
}

/**
 * Creates an `HttpClient` instance configured according to the specified `ClientConfiguration`.
 *
 * The method ensures that the provided `configuration` implements the necessary traits
 * (`MaxConnectionsTotalTrait` and `MaxConnectionsPerRouteTrait`) required for setting up
 * the `HttpClient`.
 *
 * @param configuration The `ClientConfiguration` instance containing the necessary traits
 *                      and configurations for initializing the `HttpClient`.
 * @return An `HttpClient` instance configured based on the provided `configuration`.
 */
fun createHttpClient(configuration: ClientConfiguration): HttpClient {
    require(configuration is MaxConnectionsTotalTrait) { "Configuration must implement MaxConnectionsTotalTrait" }
    require(configuration is MaxConnectionsPerRouteTrait) { "Configuration must implement MaxConnectionsPerRouteTrait" }

    return ApacheHttpTransport.newDefaultHttpClientBuilder()
        .setDefaultRequestConfig(createRequestConfig(configuration))
        .setMaxConnTotal((configuration as MaxConnectionsTotalTrait).getMaxConnectionsTotal())
        .setMaxConnPerRoute((configuration as MaxConnectionsPerRouteTrait).getMaxConnectionsPerRoute())
        .build()
}

/**
 * Creates a `RequestConfig` instance based on the specified `ClientConfiguration`.
 *
 * This method ensures that the provided `configuration` implements the necessary
 * `SocketTimeoutTrait` required for configuring the socket timeout settings in
 * the `RequestConfig`.
 *
 * @param configuration The `ClientConfiguration` instance providing the socket timeout settings.
 *                      The configuration must implement `SocketTimeoutTrait`.
 * @return A `RequestConfig` instance configured with the socket timeout properties from the specified configuration.
 */
internal fun createRequestConfig(configuration: ClientConfiguration): RequestConfig {
    require(configuration is SocketTimeoutTrait) { "Configuration must implement SocketTimeoutTrait" }

    return RequestConfig.copy(RequestConfig.DEFAULT)
        .setConnectTimeout(configuration.getSocketTimeout().toInt())
        .setSocketTimeout(configuration.getSocketTimeout().toInt())
        .build()
}
