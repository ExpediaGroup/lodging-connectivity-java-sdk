package com.expediagroup.sdk.v2.core.trait.configuration

interface ConnectionTimeoutTrait: ClientConfiguration {
    fun getConnectionTimeout(): Long
}