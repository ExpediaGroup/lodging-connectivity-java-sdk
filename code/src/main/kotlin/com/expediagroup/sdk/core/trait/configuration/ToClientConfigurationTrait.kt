package com.expediagroup.sdk.core.trait.configuration

import com.expediagroup.sdk.core.trait.Trait

/**
 * An interface representing a trait that can be converted to a `ClientConfigurationTrait`.
 * It provides methods to convert with or without default configurations.
 */
interface ToClientConfigurationTrait: Trait {
    fun toClientConfiguration(withDefault: ClientConfigurationTrait): ClientConfigurationTrait

    fun toClientConfiguration(): ClientConfigurationTrait
}