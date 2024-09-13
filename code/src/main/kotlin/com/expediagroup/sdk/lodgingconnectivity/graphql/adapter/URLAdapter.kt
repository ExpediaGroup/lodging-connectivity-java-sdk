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

package com.expediagroup.sdk.lodgingconnectivity.graphql.adapter

import com.apollographql.apollo.api.Adapter
import com.apollographql.apollo.api.CustomScalarAdapters
import com.apollographql.apollo.api.json.JsonReader
import com.apollographql.apollo.api.json.JsonWriter
import java.net.MalformedURLException
import java.net.URI
import java.net.URISyntaxException
import java.net.URL

/**
 * A custom `Adapter` implementation for handling the `Url` custom scalar in GraphQL.
 * This adapter is designed to work with Apollo GraphQL to convert the `Url` custom scalar
 * to and from its corresponding `URL` object.
 */
object URLAdapter : Adapter<URL?> {

    /**
     * Deserializes the `Url` custom scalar from its JSON string representation into a `URL` object.
     *
     * @param reader The `JsonReader` used to read the JSON input.
     * @param customScalarAdapters A `CustomScalarAdapters` instance, provided by Apollo, used to assist in the conversion of custom scalars.
     * @return The `URL` object parsed from the `Url` JSON string, or `null` if the input string is `null`.
     * @throws IllegalStateException If the string cannot be converted into a valid `URL`.
     */
    override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters): URL? {
        val urlString = reader.nextString() ?: return null
        return try {
            URI(urlString).toURL()
        } catch (e: URISyntaxException) {
            throw IllegalStateException("Invalid URI format: $urlString", e)
        } catch (e: MalformedURLException) {
            throw IllegalStateException("Invalid URL format: $urlString", e)
        }
    }

    /**
     * Serializes a `URL` object to its JSON string representation for the `Url` custom scalar.
     *
     * @param writer The `JsonWriter` used to write the JSON output.
     * @param customScalarAdapters A `CustomScalarAdapters` instance, provided by Apollo, used to assist in the conversion of custom scalars.
     * @param value The `URL` object to serialize, or `null` to write a `null` value.
     */
    override fun toJson(writer: JsonWriter, customScalarAdapters: CustomScalarAdapters, value: URL?) {
        if (value != null) {
            writer.value(value.toString())
        } else {
            writer.nullValue()
        }
    }
}
