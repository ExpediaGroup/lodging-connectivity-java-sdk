package com.expediagroup.sdk.v2.core.trait.configuration

/**
 * Interface for managing the request timeout configuration.
 *
 * This trait extends the ClientConfiguration interface, inheriting properties related
 * to overall client configuration management and unique client-instance identification.
 * Implementing classes should provide a method to retrieve the request timeout duration in milliseconds.
 *
 * Functions:
 * - getRequestTimeout: Retrieves the request timeout duration.
 */
interface RequestTimeoutTrait: ClientConfiguration {
    fun getRequestTimeout(): Long
}
