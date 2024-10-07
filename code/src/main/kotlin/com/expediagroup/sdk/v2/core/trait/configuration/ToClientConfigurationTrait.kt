package com.expediagroup.sdk.v2.core.trait.configuration

import com.expediagroup.sdk.v2.core.trait.Trait

interface ToClientConfigurationTrait: Trait {
    fun toClientConfiguration(withDefault: ClientConfigurationTrait): ClientConfigurationTrait

    fun toClientConfiguration(): ClientConfigurationTrait
}