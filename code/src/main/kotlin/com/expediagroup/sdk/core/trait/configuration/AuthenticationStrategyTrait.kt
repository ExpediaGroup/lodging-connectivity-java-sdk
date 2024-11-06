package com.expediagroup.sdk.core.trait.configuration

import com.expediagroup.sdk.core.authentication.strategy.AuthenticationStrategy

/**
 * Interface representing a trait for authentication strategies in client configurations.
 *
 * This trait extends the `ClientConfiguration` interface, thereby inheriting
 * its configuration management features and unique identifier characteristics.
 *
 * Classes implementing this trait should provide the specific implementation
 * for retrieving an `AuthenticationStrategy` which dictates how the client
 * will handle authentication.
 */
interface AuthenticationStrategyTrait : ClientConfiguration {
    fun getAuthenticationStrategy(): AuthenticationStrategy
}
