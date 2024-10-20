package com.expediagroup.sdk.v2.core.apache.util

import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.core.trait.configuration.MaxConnectionsPerRouteTrait
import com.expediagroup.sdk.v2.core.trait.configuration.MaxConnectionsTotalTrait
import com.google.api.client.http.apache.v2.ApacheHttpTransport
import org.apache.http.client.HttpClient


/**
 * Creates an instance of `HttpClient` based on the provided `ClientConfiguration`.
 *
 * This method requires that the `ClientConfiguration` implements both `MaxConnectionsTotalTrait`
 * and `MaxConnectionsPerRouteTrait`.
 *
 * @param configuration The `ClientConfiguration` used to configure the `HttpClient` instance.
 * @return A new instance of `HttpClient` configured according to the provided `ClientConfiguration`.
 * @throws IllegalArgumentException If the provided `ClientConfiguration` does not implement the required traits.
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
 * Retrieves a singleton instance of HttpClient configured with the provided ClientConfiguration.
 *
 * @param configuration The configuration object implementing ClientConfiguration, containing the necessary settings for HttpClient.
 * @return A singleton instance of HttpClient configured according to the provided ClientConfiguration.
 */
fun getSingletonHttpClient(configuration: ClientConfiguration) =
    CreateSingletonHttpClientLambda.execute(configuration)


/**
 * Singleton pattern implementation to create and manage a single instance of HttpClient.
 *
 * This class inherits from a function type `(ClientConfiguration) -> HttpClient`
 * and allows the creation of a singleton HttpClient instance based on the provided configuration.
 *
 * The companion object maintains the singleton instance and provides methods for accessing it.
 */
private class CreateSingletonHttpClientLambda : (ClientConfiguration) -> HttpClient {
    companion object {
        @JvmStatic
        private var client: HttpClient? = null

        @JvmStatic
        val INSTANCE = CreateSingletonHttpClientLambda()

        /**
         * Executes the creation of the singleton HttpClient instance based on the provided configuration.
         *
         * @param configuration The configuration object implementing ClientConfiguration, containing the necessary settings for HttpClient.
         * @return A singleton instance of HttpClient configured according to the provided ClientConfiguration.
         */
        @JvmStatic
        fun execute(configuration: ClientConfiguration): HttpClient {
            return INSTANCE(configuration)
        }
    }

    /**
     * Creates a singleton instance of HttpClient based on the provided configuration.
     *
     * @param configuration The configuration object implementing ClientConfiguration, containing necessary settings for HttpClient.
     * @return A singleton instance of HttpClient configured according to the provided ClientConfiguration.
     */
    override fun invoke(configuration: ClientConfiguration): HttpClient {
        if (client == null) {
            client = createHttpClient(configuration)
        }

        return client!!
    }
}