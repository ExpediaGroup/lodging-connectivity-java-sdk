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

package com.expediagroup.sdk.core2.http

import java.io.Closeable
import java.io.IOException

/**
 * Represents an immutable HTTP response.
 *
 * Use [Builder] to create an instance.
 */
class Response private constructor(
    val request: Request,
    val protocol: Protocol,
    val code: Int,
    val message: String,
    val headers: Headers,
    val body: ResponseBody?
) : Closeable {

    /**
     * Returns the header value for [name], or null if not present.
     *
     * @param name The name of the header.
     * @return The value of the header, or null if not present.
     */
    fun header(name: String): String? = headers.get(name)

    /**
     * Returns all header values for [name].
     *
     * @param name The name of the header.
     * @return A list of header values.
     */
    fun headers(name: String): List<String> = headers.values(name)

    /**
     * Returns true if the response code is in the 200-299 range.
     */
    val isSuccessful: Boolean
        get() = code in 200..299

    /**
     * Returns a new [Builder] initialized with this response's data.
     *
     * @return A new builder.
     */
    fun newBuilder(): Builder = Builder(this)

    /**
     * Closes the response body and releases any resources.
     *
     * After calling this method, the response body cannot be read.
     *
     * @throws IOException If an I/O error occurs.
     */
    @Throws(IOException::class)
    override fun close() {
        body?.close()
    }

    /**
     * Builder class for [Response].
     */
    class Builder {
        private var request: Request? = null
        private var protocol: Protocol? = null
        private var code: Int = -1
        private var message: String? = null
        private var headers: Headers.Builder = Headers.Builder()
        private var body: ResponseBody? = null

        /**
         * Creates an empty builder.
         */
        constructor()

        /**
         * Creates a builder initialized with the data from [response].
         *
         * @param response The response to copy data from.
         */
        constructor(response: Response) {
            this.request = response.request
            this.protocol = response.protocol
            this.code = response.code
            this.message = response.message
            this.headers = response.headers.newBuilder()
            this.body = response.body
        }

        /**
         * Sets the request that initiated this response.
         *
         * @param request The originating request.
         * @return This builder.
         */
        fun request(request: Request) = apply {
            this.request = request
        }

        /**
         * Sets the protocol used for the response.
         *
         * @param protocol The protocol (e.g., HTTP/1.1).
         * @return This builder.
         */
        fun protocol(protocol: Protocol) = apply {
            this.protocol = protocol
        }

        /**
         * Sets the HTTP status code.
         *
         * @param code The HTTP status code.
         * @return This builder.
         * @throws IllegalArgumentException If [code] is negative.
         */
        fun code(code: Int) = apply {
            require(code >= 0) { "code must be >= 0" }
            this.code = code
        }

        /**
         * Sets the HTTP reason phrase.
         *
         * @param message The reason phrase.
         * @return This builder.
         */
        fun message(message: String) = apply {
            this.message = message
        }

        /**
         * Adds a header with the specified name and value.
         *
         * @param name The header name.
         * @param value The header value.
         * @return This builder.
         * @throws IllegalArgumentException If [name] or [value] is invalid.
         */
        fun addHeader(name: String, value: String) = apply {
            headers.add(name, value)
        }

        /**
         * Adds a header with the specified name and values list.
         *
         * @param name The header name.
         * @param values The header value.
         * @return This builder.
         * @throws IllegalArgumentException If [name] or [values] are invalid.
         */
        fun addHeader(name: String, values: List<String>) = apply {
            headers.add(name, values)
        }

        /**
         * Sets a header with the specified name and value, replacing any existing values.
         *
         * @param name The header name.
         * @param value The header value.
         * @return This builder.
         * @throws IllegalArgumentException If [name] or [value] is invalid.
         */
        fun header(name: String, value: String) = apply {
            headers.set(name, value)
        }

        /**
         * Sets a header with the specified name and values list, replacing any existing values.
         *
         * @param name The header name.
         * @param values The header values list.
         * @return This builder.
         * @throws IllegalArgumentException If [name] or [values] are invalid.
         */
        fun header(name: String, values: List<String>) = apply {
            headers.set(name, values)
        }

        /**
         * Removes all headers with the specified name.
         *
         * @param name The header name.
         * @return This builder.
         */
        fun removeHeader(name: String) = apply {
            headers.remove(name)
        }

        /**
         * Sets the response headers.
         *
         * @param headers The response headers.
         * @return This builder.
         */
        fun headers(headers: Headers) = apply {
            this.headers = headers.newBuilder()
        }

        /**
         * Sets the response body.
         *
         * @param body The response body, or null if none.
         * @return This builder.
         */
        fun body(body: ResponseBody?) = apply {
            this.body = body
        }

        /**
         * Builds the [Response].
         *
         * @return The built response.
         * @throws IllegalStateException If required fields are missing.
         */
        fun build(): Response {
            val request = this.request ?: throw IllegalStateException("request is required")
            val protocol = this.protocol ?: throw IllegalStateException("protocol is required")
            val code = this.code.takeIf { it >= 0 } ?: throw IllegalStateException("code is required")
            val message = this.message ?: throw IllegalStateException("message is required")

            return Response(
                request = request,
                protocol = protocol,
                code = code,
                message = message,
                headers = headers.build(),
                body = body
            )
        }
    }
}
