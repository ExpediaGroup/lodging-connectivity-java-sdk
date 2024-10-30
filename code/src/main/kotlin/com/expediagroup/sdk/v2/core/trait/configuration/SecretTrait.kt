package com.expediagroup.sdk.v2.core.trait.configuration

/**
 * Interface representing a configuration trait that provides access to a secret.
 *
 * This interface extends `ClientConfiguration`, inheriting the properties and behaviors of
 * configuration management and unique client-instance identification. Classes implementing
 * `SecretTrait` are expected to provide a method to retrieve a secret value, often used
 * in authentication or other secure operations.
 *
 * Functions:
 * - getSecret: Retrieves the client's secret as a String.
 */
interface SecretTrait: ClientConfiguration {
    fun getSecret(): String
}
