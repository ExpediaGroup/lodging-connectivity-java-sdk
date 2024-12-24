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

package com.expediagroup.sdk.core.interceptor

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import java.util.concurrent.CompletableFuture

/**
 * Represents an asynchronous interceptor for modifying or augmenting HTTP requests and responses within the SDK.
 *
 * This `AsyncInterceptor` allows pre-processing of requests and post-processing of responses asynchronously
 * as they pass through the HTTP execution pipeline. This is useful for tasks like logging, authentication,
 * retry logic, or adding custom headers in an asynchronous environment.
 */
interface AsyncInterceptor {
    /**
     * Intercepts an HTTP request asynchronously and optionally modifies it or processes its corresponding response.
     *
     * Implementations of this method can inspect and modify the request before it is sent, or inspect
     * and modify the response after it is received. The request is forwarded to the next interceptor in the chain
     * by calling [Chain.proceed].
     *
     * @param chain The [Chain] containing the request to process and the logic to continue the chain.
     * @return A [CompletableFuture] representing the [Response] resulting from the processed request.
     */
    fun intercept(chain: Chain): CompletableFuture<Response>

    /**
     * Represents a chain of asynchronous interceptors and the ability to proceed with an HTTP request asynchronously.
     *
     * Each interceptor in the chain can call [proceed] to pass the request to the next interceptor or
     * handle the request and response directly.
     */
    interface Chain {
        /**
         * Retrieves the current HTTP request.
         *
         * @return The [Request] that is currently being processed.
         */
        fun request(): Request

        /**
         * Proceeds with the HTTP request asynchronously, invoking the next interceptor in the chain or the final request execution.
         *
         * Interceptors use this method to pass the request down the chain. The returned [CompletableFuture]
         * resolves to the response from either the next interceptor or the HTTP client execution.
         *
         * @param request The [Request] to proceed with.
         * @return A [CompletableFuture] representing the [Response] resulting from the request execution.
         */
        fun proceed(request: Request): CompletableFuture<Response>
    }
}
