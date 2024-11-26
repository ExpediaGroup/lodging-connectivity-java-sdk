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

package com.expediagroup.sdk.core2.okhttp

import okhttp3.ConnectionPool
import okhttp3.Interceptor

data class OkHttpClientConfiguration(
    val interceptors: List<Interceptor>? = null,
    val networkInterceptors: List<Interceptor>? = null,
    val connectionPool: ConnectionPool? = null,
    val retryOnConnectionFailure: Boolean? = null,
    val callTimeout: Int? = null,
    val connectTimeout: Int? = null,
    val readTimeout: Int? = null,
    val writeTimeout: Int? = null,
) {
    open class Builder {
        private var interceptors: List<Interceptor>? = null
        private var networkInterceptors: List<Interceptor>? = null
        private var connectionPool: ConnectionPool? = null
        private var retryOnConnectionFailure: Boolean? = null
        private var callTimeout: Int? = null
        private var connectTimeout: Int? = null
        private var readTimeout: Int? = null
        private var writeTimeout: Int? = null

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

        fun build(): OkHttpClientConfiguration {
            return OkHttpClientConfiguration(
                interceptors,
                networkInterceptors,
                connectionPool,
                retryOnConnectionFailure,
                callTimeout,
                connectTimeout,
                readTimeout,
                writeTimeout
            )
        }
    }

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }
}
