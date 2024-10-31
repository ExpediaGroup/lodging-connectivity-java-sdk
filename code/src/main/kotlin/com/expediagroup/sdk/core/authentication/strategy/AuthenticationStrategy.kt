package com.expediagroup.sdk.core.authentication.strategy

import com.expediagroup.sdk.core.trait.authentication.AuthenticationHandlerTrait

/**
 * Enumeration that represents different authentication strategies for a client configuration.
 *
 * @property handlerFactory A factory that creates an instance of the authentication handler
 *                          trait for the specific strategy.
 */
enum class AuthenticationStrategy(val handlerFactory: com.expediagroup.sdk.core.trait.authentication.AuthenticationHandlerTrait) {
    BEARER(BearerAuthenticationHandlerFactory),
}
