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

import com.expediagroup.sdk.core.transport.AsyncTransport
import com.expediagroup.sdk.core.transport.Transport
import com.expediagroup.sdk.lodgingconnectivity.common.GraphQLClient

data class ClientConfiguration(
    val key: String,
    val secret: String,
    val environment: ClientEnvironment? = null,
    val transport: Transport? = null,
)

data class AsyncClientConfiguration(
    val key: String,
    val secret: String,
    val environment: ClientEnvironment? = null,
    val asyncTransport: AsyncTransport? = null,
)

abstract class ClientBuilder<T : GraphQLClient> {
    private var key: String? = null
    private var secret: String? = null
    private var environment: ClientEnvironment? = null
    private var transport: Transport? = null

    fun key(key: String) = apply { this.key = key }

    fun secret(secret: String) = apply { this.secret = secret }

    fun environment(environment: ClientEnvironment) = apply { this.environment = environment }

    fun transport(transport: Transport) = apply { this.transport = transport }

    abstract fun build(): T

    protected fun buildConfig(): ClientConfiguration {
        require(key != null) {
            "key is required"
        }

        require(secret != null) {
            "secret is required"
        }

        return ClientConfiguration(
            key = key!!,
            secret = secret!!,
            environment = environment,
            transport = transport
        )
    }
}

abstract class AsyncClientBuilder<T : GraphQLClient> {
    private var key: String? = null
    private var secret: String? = null
    private var environment: ClientEnvironment? = null
    private var asyncTransport: AsyncTransport? = null

    fun key(key: String) = apply { this.key = key }

    fun secret(secret: String) = apply { this.secret = secret }

    fun environment(environment: ClientEnvironment) = apply { this.environment = environment }

    fun asyncTransport(asyncTransport: AsyncTransport) = apply { this.asyncTransport = asyncTransport }

    abstract fun build(): T

    protected fun buildConfig(): AsyncClientConfiguration {
        require(key != null) {
            "key is required"
        }

        require(secret != null) {
            "secret is required"
        }

        return AsyncClientConfiguration(
            key = key!!,
            secret = secret!!,
            environment = environment,
            asyncTransport = asyncTransport
        )
    }
}
