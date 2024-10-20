package com.expediagroup.sdk.v2.core.trait.configuration

/**
 * Interface defining a trait for configuring the maximum number of total connections.
 *
 * This interface extends `ClientConfiguration`, thereby incorporating configuration management
 * and unique client-instance identification features. Implementing classes should provide logic
 * to retrieve the maximum number of total connections allowed.
 *
 * Functions:
 * - getMaxConnectionsTotal: Retrieves the maximum number of total connections allowed.
 */
interface MaxConnectionsTotalTrait: ClientConfiguration {
    fun getMaxConnectionsTotal(): Int
}