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

import com.expediagroup.sdk.core.configuration.provider.RuntimeConfigurationProvider
import java.util.UUID

interface ClientConfiguration {
    private val id: UUID
        get() = UUID.randomUUID()
    val key: String?
    val secret: String?
    val endpoint: String?
    val authEndpoint: String?
    val requestTimeout: Long?
    val connectionTimeout: Long?
    val socketTimeout: Long?
    val maskedLoggingHeaders: Set<String>?
    val maskedLoggingBodyFields: Set<String>?
    val maxConnTotal: Int?
    val maxConnPerRoute: Int?

    companion object {
        @JvmStatic
        fun builder(): Builder = Builder()
    }

    /** Build a [RuntimeConfigurationProvider] from a [ClientConfiguration]. */
    fun toProvider(): RuntimeConfigurationProvider =
        RuntimeConfigurationProvider(
            id = id,
            key = key,
            secret = secret,
            endpoint = endpoint,
            authEndpoint = authEndpoint,
            requestTimeout = requestTimeout,
            connectionTimeout = connectionTimeout,
            socketTimeout = socketTimeout,
            maskedLoggingHeaders = maskedLoggingHeaders,
            maskedLoggingBodyFields = maskedLoggingBodyFields,
            maxConnTotal = maxConnTotal,
            maxConnPerRoute = maxConnPerRoute
        )

    fun toBuilder(): Builder {
        var builder = Builder()

        key?.let { builder = builder.key(it) }
        secret?.let { builder = builder.secret(it) }
        endpoint?.let { builder = builder.endpoint(it) }
        authEndpoint?.let { builder = builder.authEndpoint(it) }
        requestTimeout?.let { builder = builder.requestTimeout(it) }
        connectionTimeout?.let { builder = builder.connectionTimeout(it) }
        socketTimeout?.let { builder = builder.socketTimeout(it) }
        maskedLoggingHeaders?.let { builder = builder.maskedLoggingHeaders(it) }
        maskedLoggingBodyFields?.let { builder = builder.maskedLoggingBodyFields(it) }
        maxConnTotal?.let { builder = builder.maxConnTotal(it) }
        maxConnPerRoute?.let { builder = builder.maxConnPerRoute(it) }

        return builder
    }


    open class Builder {
        private var key: String? = null
        private var secret: String? = null
        private var endpoint: String? = null
        private var authEndpoint: String? = null
        private var requestTimeout: Long? = null
        private var connectionTimeout: Long? = null
        private var socketTimeout: Long? = null
        private var maskedLoggingHeaders: Set<String>? = null
        private var maskedLoggingBodyFields: Set<String>? = null
        private var maxConnTotal: Int? = null
        private var maxConnPerRoute: Int? = null

        open fun key(key: String) = apply { this.key = key }
        open fun secret(secret: String) = apply { this.secret = secret }
        open fun endpoint(endpoint: String) = apply { this.endpoint = endpoint }
        open fun authEndpoint(authEndpoint: String) = apply { this.authEndpoint = authEndpoint }
        open fun requestTimeout(requestTimeout: Long) = apply { this.requestTimeout = requestTimeout }
        open fun connectionTimeout(connectionTimeout: Long) = apply { this.connectionTimeout = connectionTimeout }
        open fun socketTimeout(socketTimeout: Long) = apply { this.socketTimeout = socketTimeout }
        open fun maskedLoggingHeaders(maskedLoggingHeaders: Set<String>) = apply { this.maskedLoggingHeaders = maskedLoggingHeaders }
        open fun maskedLoggingBodyFields(maskedLoggingBodyFields: Set<String>) = apply { this.maskedLoggingBodyFields = maskedLoggingBodyFields }
        open fun maxConnTotal(maxConnTotal: Int) = apply { this.maxConnTotal = maxConnTotal }
        open fun maxConnPerRoute(maxConnPerRoute: Int) = apply { this.maxConnPerRoute = maxConnPerRoute }

        open fun build(): ClientConfiguration {
            return object : ClientConfiguration {
                override val key: String? = this@Builder.key
                override val secret: String? = this@Builder.secret
                override val endpoint: String? = this@Builder.endpoint
                override val authEndpoint: String? = this@Builder.authEndpoint
                override val requestTimeout: Long? = this@Builder.requestTimeout
                override val connectionTimeout: Long? = this@Builder.connectionTimeout
                override val socketTimeout: Long? = this@Builder.socketTimeout
                override val maskedLoggingHeaders: Set<String>? = this@Builder.maskedLoggingHeaders
                override val maskedLoggingBodyFields: Set<String>? = this@Builder.maskedLoggingBodyFields
                override val maxConnTotal: Int? = this@Builder.maxConnTotal
                override val maxConnPerRoute: Int? = this@Builder.maxConnPerRoute
            }
        }
    }
}
