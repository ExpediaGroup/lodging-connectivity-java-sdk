package com.expediagroup.sdk.v2.core.trait.configuration

interface RequestTimeoutTrait: ClientConfigurationTrait {
    fun getRequestTimeout(): Long
}