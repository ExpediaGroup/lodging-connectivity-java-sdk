package com.expediagroup.sdk.core.trait.configuration

/**
 * Interface for configuration traits that require specifying the connection timeout duration.
 *
 * Classes implementing this trait should provide a method to retrieve the connection timeout value
 * in milliseconds. The connection timeout determines the maximum time to wait while establishing a connection.
 *
 * This trait extends `ClientConfiguration`, which is responsible for handling general client configuration settings.
 */
interface ConnectionTimeoutTrait: ClientConfiguration {
    fun getConnectionTimeout(): Long
}
