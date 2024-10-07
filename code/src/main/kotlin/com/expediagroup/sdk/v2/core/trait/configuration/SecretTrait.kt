package com.expediagroup.sdk.v2.core.trait.configuration

interface SecretTrait: ClientConfiguration {
    fun getSecret(): String
}