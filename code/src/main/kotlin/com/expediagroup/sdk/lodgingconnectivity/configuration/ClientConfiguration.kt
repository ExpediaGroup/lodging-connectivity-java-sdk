/*
 * Copyright (C) 2024 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.lodgingconnectivity.configuration

import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration

/**
 * A configuration class that holds the necessary credentials and settings for API clients.
 *
 * This class is used to configure SDK clients by providing essential
 * details such as API keys, environment, timeouts, and logging settings.
 *
 * It also provides a fluent `Builder` pattern for easy creation of configuration instances.
 *
 * @property key The API key used for authentication.
 * @property secret The API secret used for authentication.
 * @property environment The environment in which the API client will operate (e.g., production or test).
 * @property requestTimeout The request timeout duration in milliseconds (optional).
 * @property connectionTimeout The connection timeout duration in milliseconds (optional).
 * @property socketTimeout The socket timeout duration in milliseconds (optional).
 * @property maskedLoggingHeaders A set of HTTP headers whose values should be masked in logs (optional).
 * @property maskedLoggingBodyFields A set of fields in the request body whose values should be masked in logs (optional).
 */
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

    /**
     * A builder for creating `ClientConfiguration` instances.
     */
    class Builder {
        private var key: String? = null
        private var secret: String? = null
        private var environment: ClientEnvironment? = null
        private var requestTimeout: Long? = null
        private var connectionTimeout: Long? = null
        private var socketTimeout: Long? = null
        private var maskedLoggingHeaders: Set<String>? = null
        private var maskedLoggingBodyFields: Set<String>? = null

        /**
         * Sets the API key.
         * @param key The API key to use.
         */
        fun key(key: String) = apply {
            this.key = key
        }

        /**
         * Sets the API secret.
         * @param secret The API secret to use.
         */
        fun secret(secret: String) = apply {
            this.secret = secret
        }

        /**
         * Sets the environment (e.g., production, test, or sandbox).
         * @param environment The `ClientEnvironment` to use.
         */
        fun environment(environment: ClientEnvironment) = apply {
            this.environment = environment
        }

        /**
         * Sets the request timeout in milliseconds.
         * @param requestTimeout The request timeout duration.
         */
        fun requestTimeout(requestTimeout: Long) = apply {
            this.requestTimeout = requestTimeout
        }

        /**
         * Sets the connection timeout in milliseconds.
         * @param connectionTimeout The connection timeout duration.
         */
        fun connectionTimeout(connectionTimeout: Long) = apply {
            this.connectionTimeout = connectionTimeout
        }

        /**
         * Sets the socket timeout in milliseconds.
         * @param socketTimeout The socket timeout duration.
         */
        fun socketTimeout(socketTimeout: Long) = apply {
            this.socketTimeout = socketTimeout
        }

        /**
         * Sets the headers whose values should be masked in logs.
         * @param maskedLoggingHeaders A set of HTTP headers to mask in logs.
         */
        fun maskedLoggingHeaders(maskedLoggingHeaders: Set<String>) = apply {
            this.maskedLoggingHeaders = maskedLoggingHeaders
        }

        /**
         * Sets the body fields whose values should be masked in logs.
         * @param maskedLoggingBodyFields A set of fields in the request body to mask in logs.
         */
        fun maskedLoggingBodyFields(maskedLoggingBodyFields: Set<String>) = apply {
            this.maskedLoggingBodyFields = maskedLoggingBodyFields
        }

        /**
         * Builds and returns the `ClientConfiguration` instance.
         * @return The configured `ClientConfiguration`.
         */
        fun build(): ClientConfiguration {
            return ClientConfiguration(
                key,
                secret,
                environment,
                requestTimeout,
                connectionTimeout,
                socketTimeout,
                maskedLoggingHeaders,
                maskedLoggingBodyFields
            )
        }
    }

    companion object {
        @JvmStatic
        fun builder(): Builder = Builder()
    }

    internal fun toExpediaGroupClientConfiguration(apiEndpoint: ApiEndpoint) =
        ExpediaGroupClientConfiguration(
            key = this.key,
            secret = this.secret,
            endpoint = apiEndpoint.endpoint,
            authEndpoint = apiEndpoint.authEndpoint,
            requestTimeout = this.requestTimeout,
            connectionTimeout = this.connectionTimeout,
            socketTimeout = this.socketTimeout,
            maskedLoggingHeaders = this.maskedLoggingHeaders,
            maskedLoggingBodyFields = this.maskedLoggingBodyFields
        )
}

