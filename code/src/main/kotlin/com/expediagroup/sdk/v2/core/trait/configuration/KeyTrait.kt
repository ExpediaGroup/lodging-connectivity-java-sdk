package com.expediagroup.sdk.v2.core.trait.configuration

interface KeyTrait: ClientConfigurationTrait {
    fun getKey(): String
}