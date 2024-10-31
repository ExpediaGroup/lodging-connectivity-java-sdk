package com.expediagroup.sdk.core.configuration

import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupConfigurationException
import com.expediagroup.sdk.core.authentication.strategy.AuthenticationStrategy
import com.expediagroup.sdk.core.trait.common.BuilderTrait
import com.expediagroup.sdk.core.trait.configuration.*
import java.util.UUID

/**
 * Interface representing the full configuration required for a client setup.
 * Combines various traits that offer specific configuration aspects such as key, secret, endpoints,
 * timeout settings, logging preferences, and connection limitations.
 */
interface FullClientConfiguration :
    KeyTrait,
    SecretTrait,
    EndpointTrait,
    AuthEndpointTrait,
    MaskedLoggingHeadersTrait,
    MaskedLoggingBodyFieldsTrait,
    RequestTimeoutTrait,
    SocketTimeoutTrait,
    ConnectionTimeoutTrait,
    AuthenticationStrategyTrait,
    MaxConnectionsTotalTrait,
    MaxConnectionsPerRouteTrait {
    open class Builder : BuilderTrait<FullClientConfiguration> {
        private var key: String? = null
        private var secret: String? = null
        private var endpoint: String? = null
        private var authEndpoint: String? = null
        private var requestTimeout: Long? = null
        private var connectionTimeout: Long? = null
        private var socketTimeout: Long? = null
        private var maskedLoggingHeaders: Set<String>? = null
        private var maskedLoggingBodyFields: Set<String>? = null
        private var maxConnectionsTotal: Int? = null
        private var maxConnectionsPerRoute: Int? = null
        private var authenticationStrategy: String? = null

        fun key(key: String) = apply {
            this.key = key
        }

        fun secret(secret: String) = apply {
            this.secret = secret
        }

        fun endpoint(endpoint: String) = apply {
            this.endpoint = endpoint
        }

        fun authEndpoint(authEndpoint: String) = apply {
            this.authEndpoint = authEndpoint
        }

        fun requestTimeout(requestTimeout: Long) = apply {
            this.requestTimeout = requestTimeout
        }

        fun connectionTimeout(connectionTimeout: Long) = apply {
            this.connectionTimeout = connectionTimeout
        }

        fun socketTimeout(socketTimeout: Long) = apply {
            this.socketTimeout = socketTimeout
        }

        fun maskedLoggingHeaders(maskedLoggingHeaders: Set<String>) = apply {
            this.maskedLoggingHeaders = maskedLoggingHeaders
        }

        fun maskedLoggingBodyFields(maskedLoggingBodyFields: Set<String>) = apply {
            this.maskedLoggingBodyFields = maskedLoggingBodyFields
        }

        fun maxConnectionsTotal(maxConnectionsTotal: Int) = apply {
            this.maxConnectionsTotal = maxConnectionsTotal
        }

        fun maxConnectionsPerRoute(maxConnectionsPerRoute: Int) = apply {
            this.maxConnectionsPerRoute = maxConnectionsPerRoute
        }

        fun authenticationStrategy(authenticationStrategy: String) = apply {
            this.authenticationStrategy = authenticationStrategy
        }

        /**
         * Builds and returns a fully configured instance of `FullClientConfiguration`.
         *
         * @return A `FullClientConfiguration` object with all required settings and defaults applied.
         * @throws ExpediaGroupConfigurationException if required settings like key or secret are missing.
         */
        override fun build(): FullClientConfiguration =
            object : FullClientConfiguration {
                override val id: UUID = UUID.randomUUID()

                override fun getKey(): String =
                    key ?: throw ExpediaGroupConfigurationException("API key is required for authentication.")


                override fun getSecret(): String =
                    secret ?: throw ExpediaGroupConfigurationException("API secret is required for authentication.")

                override fun getEndpoint(): String =
                    endpoint ?: ExpediaGroupDefaultClientConfiguration.getEndpoint()

                override fun getAuthEndpoint(): String =
                    authEndpoint ?: ExpediaGroupDefaultClientConfiguration.getAuthEndpoint()

                override fun getMaskedLoggingHeaders(): Set<String> =
                    maskedLoggingHeaders ?: ExpediaGroupDefaultClientConfiguration.getMaskedLoggingHeaders()

                override fun getMaskedLoggingBodyFields(): Set<String> =
                    maskedLoggingBodyFields ?: ExpediaGroupDefaultClientConfiguration.getMaskedLoggingBodyFields()

                override fun getRequestTimeout(): Long =
                    requestTimeout ?: ExpediaGroupDefaultClientConfiguration.getRequestTimeout()

                override fun getSocketTimeout(): Long =
                    socketTimeout ?: ExpediaGroupDefaultClientConfiguration.getSocketTimeout()

                override fun getConnectionTimeout(): Long =
                    connectionTimeout ?: ExpediaGroupDefaultClientConfiguration.getConnectionTimeout()

                override fun getAuthenticationStrategy(): AuthenticationStrategy =
                    ExpediaGroupDefaultClientConfiguration.getAuthenticationStrategy()

                override fun getMaxConnectionsTotal(): Int =
                    maxConnectionsTotal ?: ExpediaGroupDefaultClientConfiguration.getMaxConnectionsTotal()

                override fun getMaxConnectionsPerRoute(): Int =
                    maxConnectionsPerRoute ?: ExpediaGroupDefaultClientConfiguration.getMaxConnectionsPerRoute()
            }
    }
}
