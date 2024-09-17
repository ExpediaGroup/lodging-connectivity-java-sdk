package com.expediagroup.sdk.v2.core.trait.configuration

interface MaskedLoggingHeadersTrait: ClientConfigurationTrait {
    fun getMaskedLoggingHeaders(): Set<String>
}