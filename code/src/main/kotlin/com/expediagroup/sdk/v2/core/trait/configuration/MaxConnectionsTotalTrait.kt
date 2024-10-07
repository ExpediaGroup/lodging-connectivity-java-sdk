package com.expediagroup.sdk.v2.core.trait.configuration

interface MaxConnectionsTotalTrait: ClientConfiguration {
    fun getMaxConnectionsTotal(): Int
}