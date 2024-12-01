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
import java.util.regex.Pattern

/**
 * Represents an immutable media type as defined in RFC 7231.
 *
 * @property type The primary type (e.g., "text", "application").
 * @property subtype The subtype (e.g., "plain", "json").
 * @property parameters The map of parameters associated with the media type (e.g., charset).
 */
class MediaType private constructor(
    val type: String,
    val subtype: String,
    val parameters: Map<String, String>
) {

    /**
     * Returns the charset specified in the media type, or null if none.
     */
    val charset: Charset?
        get() {
            val charsetName = parameters["charset"] ?: return null
            return try {
                Charset.forName(charsetName)
            } catch (e: UnsupportedCharsetException) {
                null
            }
        }

    /**
     * Returns a new [MediaType] instance with the given [charset] parameter.
     *
     * @param charset The charset to set.
     * @return A new [MediaType] with the specified charset.
     */
    fun withCharset(charset: Charset): MediaType {
        val newParameters = parameters.toMutableMap()
        newParameters["charset"] = charset.name()
        return MediaType(type, subtype, newParameters.toMap())
    }

    override fun toString(): String {
        val params = parameters.entries.joinToString("; ") { (name, value) ->
            "$name=${quoteIfNeeded(value)}"
        }
        return "$type/$subtype${if (params.isNotEmpty()) "; $params" else ""}"
    }

    companion object {
        private const val TOKEN_REGEX = "[!#$%&'*+\\-.^_`|~A-Za-z0-9]+"
        private const val QUOTED_STRING_REGEX = "\"(\\\\[\\s\\S]|[^\\\\\"])*\""

        private val TYPE_SUBTYPE_PATTERN = Pattern.compile(
            "($TOKEN_REGEX)/($TOKEN_REGEX)", Pattern.CASE_INSENSITIVE
        )

        private val PARAMETER_PATTERN = Pattern.compile(
            ";\\s*($TOKEN_REGEX)\\s*=\\s*($TOKEN_REGEX|$QUOTED_STRING_REGEX)", Pattern.CASE_INSENSITIVE
        )

        /**
         * Parses a media type string into a [MediaType] object.
         *
         * @param mediaType The media type string to parse.
         * @return The parsed [MediaType], or null if parsing fails.
         */
        fun parse(mediaType: String): MediaType? {
            require(mediaType.isNotBlank()) { "mediaType must not be blank" }

            val typeSubtypeMatcher = TYPE_SUBTYPE_PATTERN.matcher(mediaType)
            if (!typeSubtypeMatcher.lookingAt()) {
                return null
            }

            val type = typeSubtypeMatcher.group(1).lowercase(Locale.US)
            val subtype = typeSubtypeMatcher.group(2).lowercase(Locale.US)
            val parameters = mutableMapOf<String, String>()

            val parameterMatcher = PARAMETER_PATTERN.matcher(mediaType)
            var s = typeSubtypeMatcher.end()
            while (s < mediaType.length) {
                parameterMatcher.region(s, mediaType.length)
                if (!parameterMatcher.lookingAt()) {
                    return null
                }

                val name = parameterMatcher.group(1).lowercase(Locale.US)
                val valueToken = parameterMatcher.group(2)
                val value = if (valueToken.startsWith("\"")) {
                    unquote(valueToken)
                } else {
                    valueToken
                }
                parameters[name] = value
                s = parameterMatcher.end()
            }

            return MediaType(type, subtype, parameters.toMap())
        }

        private fun unquote(quoted: String): String {
            val sb = StringBuilder()
            var i = 1 // Skip initial quote
            while (i < quoted.length - 1) { // Skip ending quote
                val c = quoted[i]
                if (c == '\\') {
                    i++
                    if (i < quoted.length - 1) {
                        sb.append(quoted[i])
                    }
                } else {
                    sb.append(c)
                }
                i++
            }
            return sb.toString()
        }

        private fun quoteIfNeeded(value: String): String {
            return if (TOKEN_REGEX.toRegex().matches(value)) {
                value
            } else {
                "\"${value.replace("\\", "\\\\").replace("\"", "\\\"")}\""
            }
        }
    }
}

