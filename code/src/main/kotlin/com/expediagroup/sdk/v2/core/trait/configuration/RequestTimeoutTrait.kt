package com.expediagroup.sdk.v2.core.trait.configuration

interface RequestTimeoutTrait: ClientConfiguration {
    fun getRequestTimeout(): Long
}