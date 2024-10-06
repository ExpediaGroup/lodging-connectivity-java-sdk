package com.expediagroup.sdk.v2.core.trait.configuration

import com.expediagroup.sdk.v2.core.authentication.strategy.AuthenticationStrategy

interface AuthenticationStrategyTrait : ClientConfigurationTrait {
    fun getAuthenticationStrategy(): AuthenticationStrategy
}
