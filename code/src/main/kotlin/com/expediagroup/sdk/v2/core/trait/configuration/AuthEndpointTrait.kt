package com.expediagroup.sdk.v2.core.trait.configuration

interface AuthEndpointTrait: ClientConfiguration {
    fun getAuthEndpoint(): String
}