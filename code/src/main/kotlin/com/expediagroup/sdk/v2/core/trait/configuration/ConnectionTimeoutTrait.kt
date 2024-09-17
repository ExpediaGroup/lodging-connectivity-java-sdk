package com.expediagroup.sdk.v2.core.trait.configuration

interface ConnectionTimeoutTrait: ClientConfigurationTrait {
    fun getConnectionTimeout(): Long
}