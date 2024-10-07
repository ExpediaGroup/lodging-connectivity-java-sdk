package com.expediagroup.sdk.v2.core.trait.configuration

interface MaskedLoggingBodyFieldsTrait: ClientConfiguration {
    fun getMaskedLoggingBodyFields(): Set<String>
}