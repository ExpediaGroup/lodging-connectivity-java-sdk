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

import com.expediagroup.sdk.core.client.Transport
import com.expediagroup.sdk.core.okhttp.OkHttpClientConfiguration
import okhttp3.ConnectionPool
import okhttp3.Interceptor

/**
 * Configuration class used to define configuration options for lodging connectivity clients.
 *
 * This class provides a flexible way to configure different clients such as `ReservationClient` & `PaymentClient`,
 * storing required credentials (`key` and `secret`) for authentication, and some other advanced customization options.
 *
 * Additionally, it enables injecting a custom HTTP client by implementing the `Transport`
 * interface, offering flexibility beyond the default `OkHttpClient` provided by the SDK.
 *
 * - **Required Fields**: `key` and `secret` for secure authentication.
 * - **Custom Transport Integration**: Allows replacing the default `OkHttpClient` with a custom HTTP client by implementing
 *   the `Transport` interface.
 * - **Environment Support**: Enables specifying the target `ClientEnvironment` (e.g., `PROD` or `TEST`).
 * - **Reusability**: Can be shared across multiple lodging connectivity clients.
 *
 * ### Custom Transport Capability
 * If you wish to use custom HTTP client other than the default `OkHttpClient`, you can implement the [Transport] interface
 * with your HTTP client of choice, then you can pass it via `ClientConfiguration.builder(transport)` method.
 *
 * ### Default Configuration
 * For standard use cases, the SDK provides a default `OkHttpClient`. You can configure it with the standard builder:
 * ```kotlin
 * ClientConfiguration.builder()
 *     .key("your-key")
 *     .secret("your-secret")
 *     .environment(ClientEnvironment.PRODUCTION)
 *     .callTimeout(3000)
 *     .writeTimeout(4000)
 *     .build()
 * ```
 *
 * @see [Transport]
 */
sealed class ClientConfiguration(
    open val key: String,
    open val secret: String,
    open val environment: ClientEnvironment? = null,
) {

    companion object {

        /**
         * Returns a builder for the default client configurations.
         */
        @JvmStatic
        fun builder(): DefaultClientConfiguration.Builder = DefaultClientConfiguration.Builder()

        /**
         * Returns a builder for the configurations that can be used with the custom transport implementation.
         *
         * @param transport The transport implementation to be used in the custom configuration.
         */
        @JvmStatic
        fun builder(transport: Transport): CustomClientConfiguration.Builder =
            CustomClientConfiguration.Builder(transport)
    }
}

data class DefaultClientConfiguration(
    override val key: String,
    override val secret: String,
    override val environment: ClientEnvironment? = null,
    val interceptors: List<Interceptor>? = null,
    val networkInterceptors: List<Interceptor>? = null,
    val connectionPool: ConnectionPool? = null,
    val retryOnConnectionFailure: Boolean? = null,
    val callTimeout: Int? = null,
    val connectTimeout: Int? = null,
    val readTimeout: Int? = null,
    val writeTimeout: Int? = null
) : ClientConfiguration(key, secret, environment) {

    fun buildOkHttpConfiguration() = OkHttpClientConfiguration(
        interceptors = interceptors,
        networkInterceptors = networkInterceptors,
        connectionPool = connectionPool,
        retryOnConnectionFailure = retryOnConnectionFailure,
        callTimeout = callTimeout,
        connectTimeout = connectTimeout,
        readTimeout = readTimeout,
        writeTimeout = writeTimeout
    )

    class Builder {
        private var key: String? = null
        private var secret: String? = null
        private var environment: ClientEnvironment? = null
        private var interceptors: List<Interceptor>? = null
        private var networkInterceptors: List<Interceptor>? = null
        private var connectionPool: ConnectionPool? = null
        private var retryOnConnectionFailure: Boolean? = null
        private var callTimeout: Int? = null
        private var connectTimeout: Int? = null
        private var readTimeout: Int? = null
        private var writeTimeout: Int? = null

        /**
         * Sets the API key used to connect with the API.
         *
         * @param key API key.
         * @return The builder instance.
         */
        fun key(key: String?) = apply {
            this.key = key
        }

        /**
         * Sets the API secret used to authenticate.
         *
         * @param secret API secret.
         * @return The builder instance.
         */
        fun secret(secret: String?) = apply {
            this.secret = secret
        }

        /**
         * Sets the API environment (e.g [ClientEnvironment.PROD], [ClientEnvironment.TEST])
         *
         * @param environment environment to be used.
         * @return The builder instance.
         */
        fun environment(environment: ClientEnvironment) = apply {
            this.environment = environment
        }

        /**
         * Sets interceptors on the default OkHttpClient.
         *
         * @param interceptors A list of interceptors to apply.
         * @return The builder instance.
         */
        fun interceptors(interceptors: List<Interceptor>) = apply {
            this.interceptors = interceptors
        }

        /**
         * Sets the network-level interceptors on the default OkHttpClient.
         *
         * @param networkInterceptors A list of interceptors to apply.
         * @return The builder instance.
         */
        fun networkInterceptors(networkInterceptors: List<Interceptor>) = apply {
            this.networkInterceptors = networkInterceptors
        }

        /**
         * Sets the connection pool configuration.
         *
         * @param connectionPool The connection pool to use.
         * @return The builder instance.
         */
        fun connectionPool(connectionPool: ConnectionPool) = apply {
            this.connectionPool = connectionPool
        }

        /**
         * Whether to retry on connection failure.
         *
         * @param retryOnConnectionFailure `true` to retry on failure, `false` otherwise.
         * @return The builder instance.
         */
        fun retryOnConnectionFailure(retryOnConnectionFailure: Boolean) = apply {
            this.retryOnConnectionFailure = retryOnConnectionFailure
        }

        /**
         * Sets the call timeout.
         *
         * @param callTimeout The timeout duration in milliseconds.
         * @return The builder instance.
         */
        fun callTimeout(callTimeout: Int) = apply {
            this.callTimeout = callTimeout
        }

        /**
         * Sets the connection timeout.
         *
         * @param connectTimeout The timeout duration in milliseconds.
         * @return The builder instance.
         */
        fun connectTimeout(connectTimeout: Int) = apply {
            this.connectTimeout = connectTimeout
        }

        /**
         * Sets the read timeout.
         *
         * @param readTimeout The timeout duration in milliseconds.
         * @return The builder instance.
         */
        fun readTimeout(readTimeout: Int) = apply {
            this.readTimeout = readTimeout
        }

        /**
         * Sets the write timeout.
         * @param writeTimeout The timeout duration in milliseconds.
         * @return The builder instance.
         */
        fun writeTimeout(writeTimeout: Int) = apply {
            this.writeTimeout = writeTimeout
        }

        fun build(): DefaultClientConfiguration {
            require(key != null) {
                "key is required"
            }

            require(secret != null) {
                "secret is required"
            }

            return DefaultClientConfiguration(
                key = key!!,
                secret = secret!!,
                environment = environment,
                interceptors = interceptors,
                networkInterceptors = networkInterceptors,
                connectionPool = connectionPool,
                retryOnConnectionFailure = retryOnConnectionFailure,
                callTimeout = callTimeout,
                connectTimeout = connectTimeout,
                readTimeout = readTimeout,
                writeTimeout = writeTimeout
            )
        }
    }
}

data class CustomClientConfiguration(
    override val key: String,
    override val secret: String,
    override val environment: ClientEnvironment? = null,
    val transport: Transport
) : ClientConfiguration(key, secret, environment) {

    class Builder(private var transport: Transport) {
        private var key: String? = null
        private var secret: String? = null
        private var environment: ClientEnvironment? = null

        /**
         * Sets the API key used to connect with the API.
         *
         * @param key API key.
         * @return The builder instance.
         */
        fun key(key: String) = apply {
            this.key = key
        }

        /**
         * Sets the API secret used to authenticate.
         *
         * @param secret API secret.
         * @return The builder instance.
         */
        fun secret(secret: String) = apply {
            this.secret = secret
        }

        /**
         * Sets the API environment (e.g [ClientEnvironment.PROD], [ClientEnvironment.TEST])
         *
         * @param environment environment to be used.
         * @return The builder instance.
         */
        fun environment(environment: ClientEnvironment) = apply {
            this.environment = environment
        }

        fun build(): CustomClientConfiguration {
            require(key != null) {
                "key is required"
            }

            require(secret != null) {
                "secret is required"
            }

            return CustomClientConfiguration(
                key = key!!,
                secret = secret!!,
                environment = environment,
                transport = transport
            )
        }
    }
}
