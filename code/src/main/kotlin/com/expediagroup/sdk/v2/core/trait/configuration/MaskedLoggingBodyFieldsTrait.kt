package com.expediagroup.sdk.v2.core.trait.configuration

interface MaskedLoggingBodyFieldsTrait: ClientConfigurationTrait {
    fun getMaskedLoggingBodyFields(): Set<String>
}