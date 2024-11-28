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

package com.expediagroup.sdk.core2.interceptor

import com.expediagroup.sdk.core2.client.Transport
import com.expediagroup.sdk.core2.http.Request
import com.expediagroup.sdk.core2.http.Response
import java.io.IOException

/**
 * Executes a chain of [Interceptor] instances, ensuring sequential processing of HTTP requests and responses.
 *
 * The `InterceptorChainExecutor` is responsible for managing the flow of a request through a list of
 * interceptors, ultimately delegating to the [Transport] for request execution when all interceptors
 * have been processed.
 *
 * This class implements the [Interceptor.Chain] interface, providing methods for accessing the current
 * request and proceeding to the next interceptor or the final request execution.
 *
 * @param interceptors The list of [Interceptor] instances to process.
 * @param index The current position in the interceptor chain. Defaults to `0` for the first interceptor.
 * @param request The [Request] being processed.
 * @param transport The [Transport] responsible for executing the final HTTP request after all interceptors.
 */
class InterceptorsChainExecutor(
    private val transport: Transport,
    private val interceptors: List<Interceptor>,
    private var index: Int = 0,
    private var request: Request
) : Interceptor.Chain {

    /**
     * Retrieves the current [Request] being processed by the chain.
     *
     * @return The current [Request].
     */
    override fun request(): Request = request

    /**
     * Proceeds with the HTTP request by invoking the next [Interceptor] in the chain or
     * executing the final request through the [Transport] if all interceptors have been processed.
     *
     * Each interceptor in the chain can modify the request or response as needed. If this is the last
     * interceptor, the request is passed to the [Transport] for actual execution.
     *
     * @param request The [Request] to proceed with.
     * @return The [Response] resulting from the next interceptor or the final HTTP client execution.
     * @throws IOException If an I/O error occurs during request execution.
     */
    @Throws(IOException::class)
    override fun proceed(request: Request): Response {
        this.request = request

        if (index >= interceptors.size) {
            return transport.execute(request)
        }

        val interceptor = interceptors[index++]
        return interceptor.intercept(this)
    }
}
