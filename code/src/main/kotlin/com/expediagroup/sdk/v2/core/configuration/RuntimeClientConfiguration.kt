package com.expediagroup.sdk.v2.core.configuration

import com.expediagroup.sdk.v2.core.trait.configuration.*

data class RuntimeClientConfiguration(
    val key: String? = null,
    val secret: String? = null,
    val endpoint: String? = null,
    val authEndpoint: String? = null,
    val requestTimeout: Long? = null,
    val connectionTimeout: Long? = null,
    val socketTimeout: Long? = null,
    val maskedLoggingHeaders: Set<String>? = null,
    val maskedLoggingBodyFields: Set<String>? = null,
) : ToClientConfigurationTrait {

    override fun toClientConfiguration(): ClientConfigurationTrait =
        object:
            KeyTrait,
            SecretTrait,
            EndpointTrait,
            AuthEndpointTrait,
            RequestTimeoutTrait,
            ConnectionTimeoutTrait,
            SocketTimeoutTrait,
            MaskedLoggingHeadersTrait,
            MaskedLoggingBodyFieldsTrait {

            override fun getKey(): String = key!!
            override fun getSecret(): String = secret!!
            override fun getEndpoint(): String = endpoint!!
            override fun getAuthEndpoint(): String = authEndpoint!!
            override fun getRequestTimeout(): Long = requestTimeout!!
            override fun getConnectionTimeout(): Long = connectionTimeout!!
            override fun getSocketTimeout(): Long = socketTimeout!!
            override fun getMaskedLoggingHeaders(): Set<String> = maskedLoggingHeaders!!
            override fun getMaskedLoggingBodyFields(): Set<String> = maskedLoggingBodyFields!!
        }

    override fun toClientConfiguration(withDefault: ClientConfigurationTrait): ClientConfigurationTrait = 
        object: 
            KeyTrait,
            SecretTrait,
            EndpointTrait,
            AuthEndpointTrait,
            RequestTimeoutTrait,
            ConnectionTimeoutTrait,
            SocketTimeoutTrait,
            MaskedLoggingHeadersTrait,
            MaskedLoggingBodyFieldsTrait {
                
            override fun getKey(): String = 
                key ?: (withDefault as KeyTrait).getKey()
            override fun getSecret(): String = 
                secret ?: (withDefault as SecretTrait).getSecret()
            override fun getEndpoint(): String =
                endpoint ?: (withDefault as EndpointTrait).getEndpoint()
            override fun getAuthEndpoint(): String =
                authEndpoint ?: (withDefault as AuthEndpointTrait).getAuthEndpoint()
            override fun getRequestTimeout(): Long = 
                requestTimeout ?: (withDefault as RequestTimeoutTrait).getRequestTimeout()
            override fun getConnectionTimeout(): Long =
                connectionTimeout ?: (withDefault as ConnectionTimeoutTrait).getConnectionTimeout()
            override fun getSocketTimeout(): Long = 
                socketTimeout ?: (withDefault as SocketTimeoutTrait).getSocketTimeout()
            override fun getMaskedLoggingHeaders(): Set<String> =
                maskedLoggingHeaders ?: (withDefault as MaskedLoggingHeadersTrait).getMaskedLoggingHeaders()
            override fun getMaskedLoggingBodyFields(): Set<String> = 
                maskedLoggingBodyFields ?: (withDefault as MaskedLoggingBodyFieldsTrait).getMaskedLoggingBodyFields()
        }
}
