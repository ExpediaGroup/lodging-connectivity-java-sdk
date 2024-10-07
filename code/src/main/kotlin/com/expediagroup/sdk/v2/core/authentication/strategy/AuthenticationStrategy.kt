package com.expediagroup.sdk.v2.core.authentication.strategy

import com.expediagroup.sdk.v2.core.trait.authentication.CreateAuthenticationHandlerTrait

enum class AuthenticationStrategy(val handlerFactory: CreateAuthenticationHandlerTrait) {
    BEARER(BearerAuthenticationHandlerFactory),
}
