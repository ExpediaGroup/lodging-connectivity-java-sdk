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

package com.expediagroup.sdk.interceptor

import com.expediagroup.sdk.client.AsyncTransport
import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.http.Response
import java.util.concurrent.CompletableFuture

class AsyncInterceptorsChainExecutor(
    private val asyncTransport: AsyncTransport,
    private val interceptors: List<AsyncInterceptor>,
    private var index: Int = 0,
    private var request: Request
) : AsyncInterceptor.Chain {

    /**
     * Retrieves the current [Request] being processed by the chain.
     *
     * @return The current [Request].
     */
    override fun request(): Request = request

    /**
     * Proceeds with the HTTP request asynchronously by invoking the next [AsyncInterceptor] in the chain or
     * executing the final request through the [AsyncTransport] if all interceptors have been processed.
     *
     * Each interceptor in the chain can modify the request or response as needed. If this is the last
     * interceptor, the request is passed to the [AsyncTransport] for actual execution.
     *
     * @param request The [Request] to proceed with.
     * @return A [CompletableFuture] representing the [Response] resulting from the next interceptor
     * or the final HTTP client execution.
     */
    override fun proceed(request: Request): CompletableFuture<Response> {
        this.request = request

        // If all interceptors are processed, execute the request using the transport
        if (index >= interceptors.size) {
            return asyncTransport.execute(request)
        }

        // Get the next interceptor in the chain and proceed asynchronously
        val interceptor = interceptors[index++]
        return interceptor.intercept(this)
    }
}
