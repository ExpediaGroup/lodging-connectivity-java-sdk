package com.expediagroup.sdk.v2.core.trait.configuration

interface SecretTrait: ClientConfigurationTrait {
    fun getSecret(): String
}