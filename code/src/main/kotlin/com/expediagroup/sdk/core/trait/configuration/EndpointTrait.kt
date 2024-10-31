package com.expediagroup.sdk.core.trait.configuration

/**
 * Interface that represents an endpoint trait in a client configuration.
 *
 * This trait is responsible for providing the endpoint URL which
 * is essential for making network requests.
 */
interface EndpointTrait: ClientConfiguration {
    fun getEndpoint(): String
}
