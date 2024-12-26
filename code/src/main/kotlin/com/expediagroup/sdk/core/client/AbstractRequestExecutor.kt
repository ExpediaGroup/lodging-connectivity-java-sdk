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

package com.expediagroup.sdk.core.client

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor
import com.expediagroup.sdk.core.interceptor.InterceptorsChainExecutor
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupNetworkException
import java.util.concurrent.CompletableFuture

/**
 * Abstract base class for processing HTTP requests within the SDK.
 *
 * This class serves as the main entry point for executing HTTP requests through the SDK core. **Each product-SDK is
 * expected to have its own implementation of this abstract class.**
 *
 * It wraps and enhances the injected [SyncTransport] functionality by:
 *
 * 1. Applying request/response interceptors
 * 2. Enforcing SDK-specific policies and rules (e.g. authentication)
 * 3. Providing common error handling and retry logic (if needed)
 * 4. Managing request/response lifecycle and transformation
 *
 * Implementations should:
 * - Define the order and types of interceptors to be applied
 * - Implement any SDK-specific error handling or retry logic
 * - Handle request/response transformation and validation
 *
 * ### Usage Example:
 * ```
 * class RequestExecutor(transport: Transport) : AbstractRequestExecutor(transport) {
 *     override val interceptors = listOf(
 *         AuthenticationInterceptor(),
 *         LoggingInterceptor(),
 *         RetryInterceptor()
 *     )
 *
 *     override fun execute(request: Request) = executeWithInterceptors(request)
 * }
 * ```
 *
 * @param transport The transport implementation to use for executing requests
 */
abstract class AbstractRequestExecutor(protected val transport: Transport) : Transport by transport, Disposable {
    /**
     * List of interceptors to be applied to requests in order.
     *
     * Interceptors can modify requests before they are sent and responses
     * before they are returned to the caller. Common use cases include:
     * - Adding authentication headers
     * - Logging
     * - Retry logic
     * - Request/response validation
     * - Error handling
     */
    protected abstract val interceptors: List<Interceptor>

    /**
     * Executes an HTTP request synchronously, applying all configured interceptors.
     *
     * @param request The request to execute
     * @return The response from the server after passing through interceptors
     * @throws ExpediaGroupNetworkException If any network-related error occurs
     */
    override fun execute(request: Request): CompletableFuture<Response> {
        val chainExecutor = InterceptorsChainExecutor(
            interceptors = interceptors,
            request = request,
            transport = this.transport
        )

        return chainExecutor.proceed(request)
    }
}
