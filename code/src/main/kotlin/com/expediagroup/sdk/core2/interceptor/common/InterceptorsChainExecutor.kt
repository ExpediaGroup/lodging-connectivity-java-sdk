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

package com.expediagroup.sdk.core2.interceptor.common

import com.expediagroup.sdk.core2.client.HttpClient
import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpResponse
import java.io.IOException

/**
 * Executes a chain of [SDKInterceptor] instances, ensuring sequential processing of HTTP requests and responses.
 *
 * The `InterceptorChainExecutor` is responsible for managing the flow of a request through a list of
 * interceptors, ultimately delegating to the [HttpClient] for request execution when all interceptors
 * have been processed.
 *
 * This class implements the [SDKInterceptor.Chain] interface, providing methods for accessing the current
 * request and proceeding to the next interceptor or the final request execution.
 *
 * @param sdkInterceptors The list of [SDKInterceptor] instances to process.
 * @param index The current position in the interceptor chain. Defaults to `0` for the first interceptor.
 * @param request The [HttpRequest] being processed.
 * @param httpClient The [HttpClient] responsible for executing the final HTTP request after all interceptors.
 */
class InterceptorsChainExecutor(
    private val httpClient: HttpClient,
    private val sdkInterceptors: List<SDKInterceptor>,
    private var index: Int = 0,
    private var request: HttpRequest
) : SDKInterceptor.Chain {

    /**
     * Retrieves the current [HttpRequest] being processed by the chain.
     *
     * @return The current [HttpRequest].
     */
    override fun request(): HttpRequest = request

    /**
     * Proceeds with the HTTP request by invoking the next [SDKInterceptor] in the chain or
     * executing the final request through the [HttpClient] if all interceptors have been processed.
     *
     * Each interceptor in the chain can modify the request or response as needed. If this is the last
     * interceptor, the request is passed to the [HttpClient] for actual execution.
     *
     * @param request The [HttpRequest] to proceed with.
     * @return The [HttpResponse] resulting from the next interceptor or the final HTTP client execution.
     * @throws IOException If an I/O error occurs during request execution.
     */
    @Throws(IOException::class)
    override fun proceed(request: HttpRequest): HttpResponse {
        this.request = request

        if (index >= sdkInterceptors.size) {
            return httpClient.execute(request)
        }

        val interceptor = sdkInterceptors[index++]
        return interceptor.intercept(this)
    }
}
