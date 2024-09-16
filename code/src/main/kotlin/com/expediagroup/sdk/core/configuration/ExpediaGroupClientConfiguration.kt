/*
 * Copyright (C) 2022 Expedia, Inc.
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
package com.expediagroup.sdk.core.configuration

//import com.expediagroup.sdk.core.client.ExpediaGroupClient
import com.expediagroup.sdk.core.configuration.provider.RuntimeConfigurationProvider

/**
 * Configuration for the [ExpediaGroupClient].
 *
 * @property key The API key to use for authentication.
 * @property secret The API secret to use for authentication.
 * @property endpoint The API endpoint to use for requests.
 * @property requestTimeout The request timeout to be used in milliseconds.
 * @property connectionTimeout The connection timeout to be used in milliseconds.
 * @property socketTimeout The socket timeout to be used in milliseconds.
 * @property maskedLoggingHeaders The headers to be masked in logging.
 * @property maskedLoggingBodyFields The body fields to be masked in logging.
 * @property authEndpoint The API endpoint to use for authentication.
 */
data class ExpediaGroupClientConfiguration(
    override val key: String? = null,
    override val secret: String? = null,
    override val endpoint: String? = null,
    override val authEndpoint: String? = null,
    override val requestTimeout: Long? = null,
    override val connectionTimeout: Long? = null,
    override val socketTimeout: Long? = null,
    override val maskedLoggingHeaders: Set<String>? = null,
    override val maskedLoggingBodyFields: Set<String>? = null,
    override val maxConnTotal: Int? = null,
    override val maxConnPerRoute: Int? = null,
) : ClientConfiguration {
    /** Build a [RuntimeConfigurationProvider] from an [ExpediaGroupClientConfiguration]. */
    override fun toProvider(): RuntimeConfigurationProvider = super.toProvider().copy(authEndpoint = authEndpoint)

    companion object {
        @JvmStatic
        fun builder(): Builder = Builder()

        @JvmStatic
        fun from(configuration: ClientConfiguration): ExpediaGroupClientConfiguration {
            return ExpediaGroupClientConfiguration(
                key = configuration.key,
                secret = configuration.secret,
                endpoint = configuration.endpoint,
                authEndpoint = configuration.authEndpoint,
                requestTimeout = configuration.requestTimeout,
                connectionTimeout = configuration.connectionTimeout,
                socketTimeout = configuration.socketTimeout,
                maskedLoggingHeaders = configuration.maskedLoggingHeaders,
                maskedLoggingBodyFields = configuration.maskedLoggingBodyFields,
                maxConnTotal = configuration.maxConnTotal,
                maxConnPerRoute = configuration.maxConnPerRoute
            )
        }
    }

    class Builder : ClientConfiguration.Builder() {
        override fun key(key: String): Builder = apply { super.key(key) }
        override fun secret(secret: String): Builder = apply { super.secret(secret) }
        override fun endpoint(endpoint: String): Builder = apply { super.endpoint(endpoint) }
        override fun authEndpoint(authEndpoint: String): Builder = apply { super.authEndpoint(authEndpoint) }
        override fun requestTimeout(requestTimeout: Long): Builder = apply { super.requestTimeout(requestTimeout) }
        override fun connectionTimeout(connectionTimeout: Long): Builder =
            apply { super.connectionTimeout(connectionTimeout) }

        override fun socketTimeout(socketTimeout: Long): Builder = apply { super.socketTimeout(socketTimeout) }
        override fun maskedLoggingHeaders(maskedLoggingHeaders: Set<String>): Builder =
            apply { super.maskedLoggingHeaders(maskedLoggingHeaders) }

        override fun maskedLoggingBodyFields(maskedLoggingBodyFields: Set<String>): Builder =
            apply { super.maskedLoggingBodyFields(maskedLoggingBodyFields) }

        override fun maxConnTotal(maxConnTotal: Int): Builder = apply { super.maxConnTotal(maxConnTotal) }
        override fun maxConnPerRoute(maxConnPerRoute: Int): Builder = apply { super.maxConnPerRoute(maxConnPerRoute) }


        override fun build(): ExpediaGroupClientConfiguration =
            from(super.build())
    }
}