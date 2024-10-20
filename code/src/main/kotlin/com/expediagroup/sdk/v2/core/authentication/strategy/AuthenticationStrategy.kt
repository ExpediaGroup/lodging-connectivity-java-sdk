package com.expediagroup.sdk.v2.core.authentication.strategy

import com.expediagroup.sdk.v2.core.trait.authentication.AuthenticationHandlerTrait

/**
 * Enumeration that represents different authentication strategies for a client configuration.
 *
 * @property handlerFactory A factory that creates an instance of the authentication handler
 *                          trait for the specific strategy.
 */
enum class AuthenticationStrategy(val handlerFactory: AuthenticationHandlerTrait) {
    BEARER(BearerAuthenticationHandlerFactory),
}
