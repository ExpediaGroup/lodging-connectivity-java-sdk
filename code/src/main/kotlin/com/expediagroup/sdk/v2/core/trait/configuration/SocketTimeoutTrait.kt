package com.expediagroup.sdk.v2.core.trait.configuration

interface SocketTimeoutTrait: ClientConfigurationTrait {
    fun getSocketTimeout(): Long
}