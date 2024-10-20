package com.expediagroup.sdk.v2.core.trait.configuration

/**
 * Interface for configuring the maximum number of connections allowed per route.
 *
 * This interface extends `ClientConfiguration`, inheriting the trait behavior
 * necessary for managing client configurations. Classes implementing this
 * interface must provide an implementation for retrieving the maximum number
 * of connections allowed per route.
 *
 * Functions:
 * - getMaxConnectionsPerRoute: Retrieves the maximum number of connections allowed per route.
 */
interface MaxConnectionsPerRouteTrait: ClientConfiguration {
    fun getMaxConnectionsPerRoute(): Int
}