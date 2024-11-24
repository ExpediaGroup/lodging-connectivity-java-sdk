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

import java.util.Locale

/**
 * Represents an immutable HTTP request.
 *
 * Use [Builder] to create an instance.
 */
class Request private constructor(
    val method: String,
    val url: Url,
    val headers: HttpHeaders,
    val body: HttpRequestBody?,
    val tags: Map<Class<*>, Any>
) {

    /**
     * Returns the tag associated with the given [type], or null if none.
     *
     * @param type The class type of the tag.
     * @return The tag object, or null if none.
     */
    @Suppress("UNCHECKED_CAST")
    fun <T> tag(type: Class<in T>): T? = tags[type] as? T

    /**
     * Returns the tag associated with [Any] as key, or null if none.
     *
     * @return The tag object, or null if none.
     */
    fun tag(): Any? = tag(Any::class.java)

    /**
     * Returns a new [Builder] initialized with this request's data.
     *
     * @return A new builder.
     */
    fun newBuilder(): Builder = Builder(this)

    /**
     * Builder class for [Request].
     */
    class Builder {
        private var method: String? = null
        private var url: Url? = null
        private var headers: HttpHeaders.Builder = HttpHeaders.Builder()
        private var body: HttpRequestBody? = null
        private var tags: MutableMap<Class<*>, Any> = mutableMapOf()

        /**
         * Creates a new builder.
         */
        constructor()

        /**
         * Creates a builder initialized with the data from [request].
         *
         * @param request The request to copy data from.
         */
        constructor(request: Request) {
            this.method = request.method
            this.url = request.url
            this.headers = request.headers.newBuilder()
            this.body = request.body
            this.tags = request.tags.toMutableMap()
        }

        /**
         * Sets the HTTP method.
         *
         * @param method HTTP method, e.g., GET, POST.
         * @param body Optional request body.
         * @return This builder.
         * @throws IllegalArgumentException If [method] is empty.
         */
        fun method(method: String, body: HttpRequestBody? = null) = apply {
            require(method.isNotEmpty()) { "Method cannot be empty" }
            val upperMethod = method.uppercase(Locale.US)
            this.method = upperMethod
            this.body = body
        }

        /**
         * Sets the URL.
         *
         * @param url The URL as a string.
         * @return This builder.
         * @throws IllegalArgumentException If [url] is invalid.
         */
        fun url(url: String) = apply {
            val parsedUrl = Url.parse(url) ?: throw IllegalArgumentException("Invalid URL: $url")
            this.url = parsedUrl
        }

        /**
         * Sets the URL.
         *
         * @param url The URL as an [Url] object.
         * @return This builder.
         */
        fun url(url: Url) = apply {
            this.url = url
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
         * Adds a header with the specified name and values.
         *
         * @param name The header name.
         * @param values The header values list.
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
         * @throws IllegalArgumentException If [name] is null.
         */
        fun removeHeader(name: String) = apply {
            headers.remove(name)
        }

        /**
         * Sets the request body.
         *
         * @param body The request body.
         * @return This builder.
         */
        fun body(body: HttpRequestBody) = apply {
            this.body = body
        }

        /**
         * Adds a tag to the request.
         *
         * @param type The class type of the tag.
         * @param tag The tag object, or null to remove it.
         * @return This builder.
         * @throws IllegalArgumentException If [type] is null.
         */
        fun <T> tag(type: Class<in T>, tag: T?) = apply {
            if (tag == null) {
                tags.remove(type)
            } else {
                tags[type] = tag
            }
        }

        /**
         * Builds the [Request].
         *
         * @return The built request.
         * @throws IllegalStateException If the request is invalid.
         */
        fun build(): Request {
            val method = this.method ?: throw IllegalStateException("Method is required.")
            val url = this.url ?: throw IllegalStateException("URL is required.")

            return Request(
                method = method,
                url = url,
                headers = headers.build(),
                body = body,
                tags = tags
            )
        }
    }
}
