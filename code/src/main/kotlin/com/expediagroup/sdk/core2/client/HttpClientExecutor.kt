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

package com.expediagroup.sdk.core2.client

import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpResponse
import com.expediagroup.sdk.core2.interceptor.Interceptor
import java.io.IOException

/**
 * Abstract class responsible for managing HTTP request execution within the SDK.
 *
 * This class acts as a wrapper around a user-provided [HttpClientAdapter], applying SDK-specific logic and governance
 * during request execution, such as handling interceptors and enforcing additional rules or transformations.
 *
 * Each SDK should implement its own version of this class to define specific behavior, such as request preprocessing,
 * applying interceptors, or handling governance rules.
 *
 * @param httpClientAdapter The user-implemented [HttpClientAdapter] responsible for executing HTTP requests.
 */
abstract class HttpClientExecutor(val httpClientAdapter: HttpClientAdapter) {
    /**
     * The list of SDK-specific interceptors to apply during request execution.
     *
     * Interceptors can be used to modify requests, log information, handle retries, or enforce governance rules.
     */
    protected abstract val interceptors: List<Interceptor>

    /**
     * Executes the given HTTP request, applying SDK-specific logic and governance.
     *
     * This method wraps the [HttpClientAdapter.execute] call, applying interceptors and other custom logic
     * before and after the actual request execution.
     *
     * @param request The [HttpRequest] to be executed.
     * @return The [HttpResponse] resulting from the execution of the request.
     * @throws IOException If an I/O error occurs during request execution.
     */
    @Throws(IOException::class)
    abstract fun execute(request: HttpRequest): HttpResponse
}
