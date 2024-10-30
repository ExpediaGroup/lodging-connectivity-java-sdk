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

package com.expediagroup.sdk.v2.lodgingconnectivity.graphql.adapter

import com.apollographql.apollo.api.Adapter
import com.apollographql.apollo.api.CustomScalarAdapters
import com.apollographql.apollo.api.json.JsonReader
import com.apollographql.apollo.api.json.JsonWriter
import java.net.MalformedURLException
import java.net.URI
import java.net.URISyntaxException
import java.net.URL

/**
 * Converts the custom scalar `Url` to and from `java.net.URL`.
 */
object URLAdapter : Adapter<URL?> {

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

    override fun toJson(writer: JsonWriter, customScalarAdapters: CustomScalarAdapters, value: URL?) {
        if (value != null) {
            writer.value(value.toString())
        } else {
            writer.nullValue()
        }
    }
}
