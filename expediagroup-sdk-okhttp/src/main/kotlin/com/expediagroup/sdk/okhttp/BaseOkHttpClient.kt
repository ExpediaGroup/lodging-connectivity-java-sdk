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

package com.expediagroup.sdk.okhttp

import java.time.Duration
import okhttp3.OkHttpClient

/**
 * A utility object for managing and configuring a singleton instance of an `OkHttpClient`.
 *
 * The `BaseOkHttpClient` object provides methods to retrieve a singleton instance of
 * `OkHttpClient` and to configure a new instance based on the provided `OkHttpClientConfiguration`.
 * It ensures thread safety and avoids recreating the client unnecessarily.
 *
 * ## Usage
 * - Use `getInstance()` to retrieve the singleton instance of `OkHttpClient`.
 * - Use `getInstance(configuration)` to create a configured `OkHttpClient` instance
 *   with specific settings provided via the `OkHttpClientConfiguration` object.
 */
internal object BaseOkHttpClient {

    val instance by lazy {
        val configuration: OkHttpClientConfiguration = OkHttpTransportConfigurator.get()

        OkHttpClient.Builder().apply {
            configuration.callTimeout?.let {
                callTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.connectTimeout?.let {
                connectTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.readTimeout?.let {
                readTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.writeTimeout?.let {
                writeTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.connectionPool?.let {
                connectionPool(it)
            }
            configuration.retryOnConnectionFailure?.let {
                retryOnConnectionFailure(it)
            }
            configuration.interceptors?.forEach {
                addInterceptor(it)
            }
            configuration.networkInterceptors?.forEach {
                addNetworkInterceptor(it)
            }
        }.build()
    }
}
