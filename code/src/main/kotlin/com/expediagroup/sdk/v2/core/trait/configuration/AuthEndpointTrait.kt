package com.expediagroup.sdk.v2.core.trait.configuration

interface AuthEndpointTrait: ClientConfigurationTrait {
    fun getAuthEndpoint(): String
}