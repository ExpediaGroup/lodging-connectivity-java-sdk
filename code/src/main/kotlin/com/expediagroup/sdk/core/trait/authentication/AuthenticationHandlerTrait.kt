package com.expediagroup.sdk.core.trait.authentication

import com.expediagroup.sdk.core.trait.Trait
import com.expediagroup.sdk.core.trait.configuration.ClientConfiguration
import com.google.api.client.http.HttpTransport

/**
 * Interface representing a trait for handling authentication.
 *
 * Implementing classes are responsible for creating an instance
 * of the `RefreshAccessTokenTrait` using given client configuration
 * and HTTP transport.
 */
interface AuthenticationHandlerTrait : Trait {
    fun createAuthenticationHandler(
        config: ClientConfiguration,
        transport: HttpTransport,
    ): com.expediagroup.sdk.core.trait.authentication.RefreshAccessTokenTrait
}
