package com.expediagroup.sdk.v2.core.authentication.strategy

import com.expediagroup.sdk.v2.core.trait.authentication.AuthenticationHandlerTrait

enum class AuthenticationStrategy(val handlerFactory: AuthenticationHandlerTrait) {
    BEARER(BearerAuthenticationHandlerFactory),
}
