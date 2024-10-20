package com.expediagroup.sdk.v2.core.apache.util

import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.google.api.client.http.apache.v2.ApacheHttpTransport

/**
 * Creates an `ApacheHttpTransport` instance based on the provided `ClientConfiguration`.
 *
 * @param configuration The `ClientConfiguration` used to configure the `ApacheHttpTransport` instance.
 * @return A new instance of `ApacheHttpTransport` configured according to the provided `ClientConfiguration`.
 */
fun createApacheHttpTransport(configuration: ClientConfiguration): ApacheHttpTransport =
    ApacheHttpTransport(createHttpClient(configuration))

/**
 * Retrieves a singleton instance of `ApacheHttpTransport` based on the provided `ClientConfiguration`.
 *
 * @param configuration The `ClientConfiguration` used to configure the `ApacheHttpTransport` instance.
 * @return An instance of `ApacheHttpTransport`.
 */
fun getSingletonApacheHttpTransport(configuration: ClientConfiguration) =
    CreateSingletonApacheHttpTransportLambda.execute(configuration)

/**
 * A lambda class responsible for creating a singleton instance of `ApacheHttpTransport`.
 * This class implements the function type `(ClientConfiguration) -> ApacheHttpTransport`,
 * and provides thread-safe creation of a singleton `ApacheHttpTransport` instance based on
 * the provided `ClientConfiguration`.
 *
 * The `execute` method can be used to obtain the singleton instance of `ApacheHttpTransport`.
 */
private class CreateSingletonApacheHttpTransportLambda : (ClientConfiguration) -> ApacheHttpTransport {
    companion object {
        @JvmStatic
        private var transport: ApacheHttpTransport? = null

        @JvmStatic
        val INSTANCE = CreateSingletonApacheHttpTransportLambda()

        /**
         * Executes the lambda to create or return a singleton instance of `ApacheHttpTransport`
         * based on the provided `ClientConfiguration`. If the singleton instance does not exist,
         * it will be created using `createApacheHttpTransport`.
         *
         * @param configuration The `ClientConfiguration` used to configure the `ApacheHttpTransport` instance.
         */
        @JvmStatic
        fun execute(configuration: ClientConfiguration) = INSTANCE(configuration)
    }

    /**
     * Invokes the lambda to create or return a singleton instance of `ApacheHttpTransport`
     * based on the provided `ClientConfiguration`. If the transport instance is null, it
     * will be created using the `createApacheHttpTransport` method.
     *
     * @param configuration The `ClientConfiguration` used to configure the `ApacheHttpTransport` instance.
     * @return A singleton instance of `ApacheHttpTransport`.
     */
    override fun invoke(configuration: ClientConfiguration): ApacheHttpTransport {
        if (transport == null) {
            transport = createApacheHttpTransport(configuration)
        }

        return transport!!
    }
}