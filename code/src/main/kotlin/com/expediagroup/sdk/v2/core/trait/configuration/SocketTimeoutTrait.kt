package com.expediagroup.sdk.v2.core.trait.configuration

/**
 * Trait representing the socket timeout configuration for a client.
 *
 * This interface extends `ClientConfiguration`, incorporating the behavior of configuration management
 * and unique client-instance identification. Classes implementing `SocketTimeoutTrait` are expected
 * to provide a method to retrieve the socket timeout duration in milliseconds.
 *
 * Functions:
 * - getSocketTimeout: Retrieves the socket timeout duration in milliseconds.
 */
interface SocketTimeoutTrait: ClientConfiguration {
    fun getSocketTimeout(): Long
}