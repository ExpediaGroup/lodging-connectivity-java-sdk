package com.expediagroup.sdk.v2.core.trait.configuration

interface EndpointTrait: ClientConfiguration {
    fun getEndpoint(): String
}