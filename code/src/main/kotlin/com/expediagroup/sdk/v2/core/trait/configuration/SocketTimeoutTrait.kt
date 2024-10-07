package com.expediagroup.sdk.v2.core.trait.configuration

interface SocketTimeoutTrait: ClientConfiguration {
    fun getSocketTimeout(): Long
}