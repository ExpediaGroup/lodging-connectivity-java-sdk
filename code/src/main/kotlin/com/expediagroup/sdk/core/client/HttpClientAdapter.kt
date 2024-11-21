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

import com.expediagroup.sdk.core.http.HttpRequest
import com.expediagroup.sdk.core.http.HttpResponse
import java.io.IOException

/**
 * Interface representing an HTTP client adapter that can be implemented to integrate custom HTTP client libraries
 * with the SDK.
 *
 * This interface allows users to plug in their own HTTP client implementation by providing a method to execute HTTP
 * requests and return responses in a format compatible with the SDK.
 */
interface HttpClientAdapter {
    /**
     * Executes the given HTTP request and returns the corresponding HTTP response.
     *
     * Users implementing this method are responsible for converting their HTTP client's request/response model
     * into the SDK [HttpRequest] and [HttpResponse] abstractions. This ensures compatibility with the SDK
     * networking layer.
     *
     * @param request The [HttpRequest] to be executed, representing the HTTP request to be sent.
     * @return The [HttpResponse] resulting from the execution of the request, representing the HTTP response received.
     * @throws IOException If an I/O error occurs during request execution.
     */
    @Throws(IOException::class)
    fun execute(request: HttpRequest): HttpResponse
}
