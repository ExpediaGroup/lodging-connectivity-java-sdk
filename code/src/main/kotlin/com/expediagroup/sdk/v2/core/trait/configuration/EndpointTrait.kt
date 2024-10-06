package com.expediagroup.sdk.v2.core.trait.configuration

interface EndpointTrait: ClientConfigurationTrait {
    fun getEndpoint(): String
}