package com.expediagroup.sdk.v2.core.trait.configuration

interface MaxConnectionsPerRouteTrait: ClientConfiguration {
    fun getMaxConnectionsPerRoute(): Int
}