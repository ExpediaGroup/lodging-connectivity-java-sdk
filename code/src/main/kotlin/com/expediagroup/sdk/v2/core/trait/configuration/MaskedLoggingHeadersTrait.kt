package com.expediagroup.sdk.v2.core.trait.configuration

interface MaskedLoggingHeadersTrait: ClientConfiguration {
    fun getMaskedLoggingHeaders(): Set<String>
}