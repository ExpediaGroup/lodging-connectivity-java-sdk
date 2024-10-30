package com.expediagroup.sdk.v2.core.trait.configuration

/**
 * KeyTrait interface for client configurations that provides access to the client's key.
 *
 * This interface extends ClientConfiguration, thereby inheriting configuration management and
 * unique client-instance identification behavior. Classes implementing this interface are expected
 * to provide a method to retrieve the client's key for various operations such as authentication.
 *
 * Functions:
 * - getKey: Retrieves the client's key as a String.
 */
interface KeyTrait: ClientConfiguration {
    fun getKey(): String
}
