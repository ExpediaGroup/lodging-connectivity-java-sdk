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
 * Represents a collection of HTTP headers.
 * This class is immutable and thread-safe.
 */
class HttpHeaders private constructor(private val headersMap: Map<String, List<String>>) {

    /**
     * Returns the first header value for the given name, or null if none.
     *
     * @param name the header name (case-insensitive)
     * @return the first header value, or null if not found
     * @throws IllegalArgumentException if [name] is null
     */
    fun get(name: String): String? = headersMap[name.lowercase(Locale.US)]?.firstOrNull()

    /**
     * Returns all header values for the given name.
     *
     * @param name the header name (case-insensitive)
     * @return an unmodifiable list of header values, or an empty list if none
     * @throws IllegalArgumentException if [name] is null
     */
    fun values(name: String): List<String> = headersMap[name.lowercase(Locale.US)] ?: emptyList()

    /**
     * Returns an unmodifiable set of all header names.
     *
     * @return an unmodifiable set of header names
     */
    fun names(): Set<String> = headersMap.keys

    /**
     * Returns an unmodifiable list of all header entries.
     *
     * @return an unmodifiable list of header entries as [Map.Entry]
     */
    fun entries(): Set<Map.Entry<String, List<String>>> = headersMap.entries

    /**
     * Returns a new [Builder] initialized with the existing headers.
     *
     * @return a new [Builder]
     */
    fun newBuilder(): Builder = Builder(this)

    override fun toString(): String = buildString {
        headersMap.forEach {
            append(it.key)
            append(": ")
            append(it.value.toString())
            append("\n")
        }
    }

    /**
     * Builder for constructing [HttpHeaders] instances.
     */
    class Builder {

        private val headersMap: MutableMap<String, MutableList<String>> = LinkedHashMap()

        /**
         * Creates a new builder
         */
        constructor()

        /**
         * Creates a new builder initialized with the headers from [headers].
         *
         * @param headers the headers to initialize from
         */
        constructor(headers: HttpHeaders) : this() {
            headers.headersMap.forEach { (key, values) ->
                headersMap[key] = values.toMutableList()
            }
        }

        /**
         * Adds a header with the specified name and value.
         * Multiple headers with the same name are allowed.
         *
         * @param name the header name
         * @param value the header value
         * @return this builder
         * @throws IllegalArgumentException if [name] or [value] is invalid
         */
        @Throws(IllegalArgumentException::class)
        fun add(name: String, value: String): Builder {
            return add(name, listOf(value))
        }

        /**
         * Adds all header values for the specified name.
         *
         * @param name the header name
         * @param values the list of header values
         * @return this builder
         * @throws IllegalArgumentException if [name] or any [values] are invalid
         */
        @Throws(IllegalArgumentException::class)
        fun add(name: String, values: List<String>): Builder {
            val (processedName, processedValues) = processNameAndValues(name, values)
            headersMap.computeIfAbsent(processedName) { mutableListOf() }.addAll(processedValues)
            return this
        }

        /**
         * Sets the header with the specified name to the single value provided.
         * If headers with this name already exist, they are removed.
         *
         * @param name the header name
         * @param value the header value
         * @return this builder
         * @throws IllegalArgumentException if [name] or [value] is invalid
         */
        @Throws(IllegalArgumentException::class)
        fun set(name: String, value: String): Builder {
            val (processedName, processedValues) = processNameAndValues(name, listOf(value))
            remove(processedName)
            add(name, value)
            return this
        }

        /**
         * Sets the header with the specified name to the values list provided.
         * If headers with this name already exist, they are removed.
         *
         * @param name the header name
         * @param values the header value
         * @return this builder
         * @throws IllegalArgumentException if [name] or [values] are invalid
         */
        @Throws(IllegalArgumentException::class)
        fun set(name: String, values: List<String>): Builder {
            val (processedName, processedValues) = processNameAndValues(name, values)
            remove(processedName)
            add(name, processedValues)
            return this
        }

        /**
         * Removes any header with the specified name.
         *
         * @param name the header name
         * @return this builder
         */
        fun remove(name: String): Builder {
            headersMap.remove(name.lowercase(Locale.US))
            return this
        }

        /**
         * Builds an immutable [HttpHeaders] instance.
         *
         * @return the built [HttpHeaders]
         */
        fun build(): HttpHeaders {
            return HttpHeaders(headersMap)
        }

        private fun processNameAndValues(name: String, values: List<String>): Pair<String, List<String>> {
            val processedName = name.lowercase(Locale.US).trim()
            val processedValues = values.map { it.trim() }

            processedValues.forEach {
                checkNameAndValue(processedName, it)
            }

            return Pair(processedName, processedValues)
        }

        /**
         * Validates the header name and value.
         *
         * @param name the header name
         * @param value the header value
         * @throws IllegalArgumentException if [name] or [value] is invalid
         */
        @Throws(IllegalArgumentException::class)
        private fun checkNameAndValue(name: String, value: String) {
            require(name.isNotBlank()) { "Header name must not be blank" }
            for (char in name) {
                require(char in '!'..'\u007E') {
                    String.format("Invalid character %#04x in header name: %s", char.code, name)
                }
            }
            for (char in value) {
                require(char == '\t' || (char in '\u0020'..'\u007E')) {
                    String.format("Invalid character %#04x in header value: %s", char.code, value)
                }
            }
        }
    }
}
