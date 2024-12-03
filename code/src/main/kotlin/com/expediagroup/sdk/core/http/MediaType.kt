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

package com.expediagroup.sdk.core.http

import java.nio.charset.Charset
import java.nio.charset.UnsupportedCharsetException
import java.util.Locale

/**
 * Represents a media type, as defined in the HTTP specification.
 *
 * @property type The primary type (e.g., "application", "text").
 * @property subtype The subtype (e.g., "json", "plain").
 * @property parameters The map of parameters associated with the media type (e.g., charset).
 */
class MediaType(
    val type: String,
    val subtype: String,
    val parameters: Map<String, String> = emptyMap()
) {

    /**
     * The full type of the media type, consisting of [type]/[subtype].
     */
    val fullType: String
        get() = "$type/$subtype"

    /**
     * Retrieves the character set from the parameters, if present.
     */
    val charset: Charset?
        get() = parameters["charset"]?.let {
            try {
                Charset.forName(it)
            } catch (_: UnsupportedCharsetException) {
                null
            }
        }

    /**
     * Checks if this media type includes the given media type.
     *
     * @param other The media type to compare against.
     * @return `true` if this media type includes the given media type, `false` otherwise.
     */
    fun includes(other: MediaType): Boolean {
        if (this.type == "*") {
            return true
        } else if (this.type.equals(other.type, ignoreCase = true)) {
            if (this.subtype == "*" || this.subtype.equals(other.subtype, ignoreCase = true)) {
                return true
            }
        }
        return false
    }

    /**
     * Returns a copy of this `MediaType` with the given charset parameter.
     *
     * @param charset The charset to set.
     * @return A new `MediaType` instance with the specified charset.
     */
    fun withCharset(charset: Charset): MediaType {
        val newParameters = parameters.toMutableMap()
        newParameters["charset"] = charset.name()
        return MediaType(type, subtype, newParameters)
    }

    override fun toString(): String {
        val params = parameters.entries.joinToString(separator = ";") { (key, value) ->
            "$key=$value"
        }
        return if (params.isNotEmpty()) "$type/$subtype;$params" else "$type/$subtype"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MediaType) return false

        return type.equals(other.type, ignoreCase = true) &&
                subtype.equals(other.subtype, ignoreCase = true) &&
                parameters.entries.all { (key, value) ->
                    other.parameters[key]?.equals(value, ignoreCase = true) == true
                }
    }

    override fun hashCode(): Int {
        var result = type.lowercase(Locale.getDefault()).hashCode()
        result = 31 * result + subtype.lowercase(Locale.getDefault()).hashCode()
        result = 31 * result + parameters.mapKeys { it.key.lowercase(Locale.getDefault()) }.hashCode()
        return result
    }

    companion object {
        /**
         * Parses a media type string into a [MediaType] object.
         *
         * @param mediaType The media type string to parse.
         * @return The parsed [MediaType].
         * @throws IllegalArgumentException If the media type cannot be parsed.
         */
        fun parse(mediaType: String): MediaType {
            require(mediaType.isNotBlank()) { "Media type must not be blank" }

            val parts = mediaType.split(";").map { it.trim() }
            val typeSubtype = parts[0].split("/")

            if (typeSubtype.size != 2) {
                throw IllegalArgumentException("Invalid media type format: $mediaType")
            }

            val type = typeSubtype[0].lowercase(Locale.getDefault())
            val subtype = typeSubtype[1].lowercase(Locale.getDefault())

            val parameters = mutableMapOf<String, String>()
            for (i in 1 until parts.size) {
                val parameter = parts[i]
                val idx = parameter.indexOf('=')
                if (idx == -1) {
                    throw IllegalArgumentException("Invalid parameter in media type: $parameter")
                }
                val name = parameter.substring(0, idx).trim().lowercase(Locale.getDefault())
                val value = parameter.substring(idx + 1).trim().trim('"')
                parameters[name] = value
            }

            return MediaType(type, subtype, parameters)
        }

        /** Common media type constants **/
        val ALL = MediaType("*", "*")
        val APPLICATION_JSON = MediaType("application", "json")
        val APPLICATION_XML = MediaType("application", "xml")
        val TEXT_PLAIN = MediaType("text", "plain")
        val TEXT_HTML = MediaType("text", "html")
        val APPLICATION_OCTET_STREAM = MediaType("application", "octet-stream")
        val MULTIPART_FORM_DATA = MediaType("multipart", "form-data")
        val APPLICATION_FORM_URLENCODED = MediaType("application", "x-www-form-urlencoded")

        /**
         * Parses multiple media types from a comma-separated string.
         *
         * @param mediaTypes The string containing comma-separated media types.
         * @return A list of parsed [MediaType] objects.
         */
        fun parseMediaTypes(mediaTypes: String): List<MediaType> {
            return mediaTypes.split(",").map { parse(it.trim()) }
        }
    }
}
