package com.expediagroup.sdk.v2.core.trait.configuration

/**
 * Interface representing a trait that provides the authentication endpoint.
 *
 * This trait extends `ClientConfiguration` and includes a method to retrieve
 * the authentication endpoint URL. Classes implementing this trait should
 * provide the necessary logic to fetch or compute the authentication endpoint.
 */
interface AuthEndpointTrait: ClientConfiguration {
    fun getAuthEndpoint(): String
}