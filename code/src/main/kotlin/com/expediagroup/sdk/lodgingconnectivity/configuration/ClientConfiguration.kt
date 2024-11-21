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

import com.expediagroup.sdk.core2.client.HttpClientAdapter
import com.expediagroup.sdk.core2.okhttp.OkHttpClientConfiguration
import okhttp3.ConnectionPool
import okhttp3.Interceptor


sealed class ClientConfiguration(
    open val key: String,
    open val secret: String,
    open val environment: ClientEnvironment? = null,
) {

    companion object {
        @JvmStatic
        fun builder(): DefaultClientConfiguration.Builder = DefaultClientConfiguration.Builder()

        @JvmStatic
        fun builder(httpClient: HttpClientAdapter): CustomHttpClientConfiguration.Builder =
            CustomHttpClientConfiguration.Builder(httpClient)
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

        fun key(key: String?): Builder {
            this.key = key
            return this
        }

        fun secret(secret: String?): Builder {
            this.secret = secret
            return this
        }

        fun environment(environment: ClientEnvironment) = apply {
            this.environment = environment
        }

        fun interceptors(interceptors: List<Interceptor>) = apply {
            this.interceptors = interceptors
        }

        fun networkInterceptors(networkInterceptors: List<Interceptor>) = apply {
            this.networkInterceptors = networkInterceptors
        }

        fun connectionPool(connectionPool: ConnectionPool) = apply {
            this.connectionPool = connectionPool
        }

        fun retryOnConnectionFailure(retryOnConnectionFailure: Boolean) = apply {
            this.retryOnConnectionFailure = retryOnConnectionFailure
        }

        fun callTimeout(callTimeout: Int) = apply {
            this.callTimeout = callTimeout
        }

        fun connectTimeout(connectTimeout: Int) = apply {
            this.connectTimeout = connectTimeout
        }

        fun readTimeout(readTimeout: Int) = apply {
            this.readTimeout = readTimeout
        }

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

data class CustomHttpClientConfiguration(
    override val key: String,
    override val secret: String,
    override val environment: ClientEnvironment,
    val httpClientAdapter: HttpClientAdapter,
) : ClientConfiguration(key, secret, environment) {

    class Builder(private var httpClientAdapter: HttpClientAdapter) {
        private var key: String? = null
        private var secret: String? = null
        private var environment: ClientEnvironment? = null

        fun key(key: String) = apply {
            this.key = key
        }

        fun secret(secret: String) = apply {
            this.secret = secret
        }


        fun environment(environment: ClientEnvironment) = apply {
            this.environment = environment
        }

        fun build(): CustomHttpClientConfiguration {
            require(key != null) {
                "key is required"
            }

            require(secret != null) {
                "secret is required"
            }

            return CustomHttpClientConfiguration(
                key = key!!,
                secret = secret!!,
                environment = environment!!,
                httpClientAdapter = httpClientAdapter
            )
        }
    }
}
