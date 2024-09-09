package com.expediagroup.sdk.lodgingconnectivity.configuration

import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration

data class ClientConfiguration(
    val key: String?,
    val secret: String?,
    val environment: ClientEnvironment?,
    val requestTimeout: Long? = null,
    val connectionTimeout: Long? = null,
    val socketTimeout: Long? = null,
    val maskedLoggingHeaders: Set<String>? = null,
    val maskedLoggingBodyFields: Set<String>? = null
) {
    class Builder {
        private var key: String? = null
        private var secret: String? = null
        private var environment: ClientEnvironment? = null
        private var requestTimeout: Long? = null
        private var connectionTimeout: Long? = null
        private var socketTimeout: Long? = null
        private var maskedLoggingHeaders: Set<String>? = null
        private var maskedLoggingBodyFields: Set<String>? = null

        fun key(key: String) = apply {
            this.key = key
        }

        fun secret(secret: String) = apply {
            this.secret = secret
        }

        fun environment(environment: ClientEnvironment) = apply {
            this.environment = environment
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

        fun build(): ClientConfiguration {
            return ClientConfiguration(
                key,
                secret,
                environment,
                requestTimeout,
                connectionTimeout,
                socketTimeout,
                maskedLoggingHeaders,
                maskedLoggingBodyFields,
            )
        }
    }

    companion object {
        /** Create a new [ClientConfiguration] builder. */
        @JvmStatic
        fun builder(): Builder = Builder()
    }

    fun toExpediaGroupClientConfiguration(endpoint: String, authEndpoint: String): ExpediaGroupClientConfiguration =
        ExpediaGroupClientConfiguration(
            key,
            secret,
            endpoint,
            requestTimeout,
            connectionTimeout,
            socketTimeout,
            maskedLoggingHeaders,
            maskedLoggingBodyFields,
            authEndpoint
        )
}
