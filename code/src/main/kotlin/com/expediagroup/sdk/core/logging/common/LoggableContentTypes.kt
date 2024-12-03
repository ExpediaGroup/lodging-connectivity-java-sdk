package com.expediagroup.sdk.core.logging.common

import com.expediagroup.sdk.core.http.MediaType

/**
 * A list of MIME types representing content types that are deemed loggable.
 * This collection is used to determine whether the content of HTTP requests or responses
 * can be logged based on their MIME types.
 */
val LOGGABLE_CONTENT_TYPES = listOf(
    MediaType.APPLICATION_JSON,
    MediaType.TEXT_PLAIN,
    MediaType.TEXT_HTML,
    MediaType.APPLICATION_XML,
    MediaType.parse("text/*"), // Wildcard to include any text-based types
    MediaType.parse("application/*+json"), // Matches custom JSON-based media types like application/.api+json
    MediaType.APPLICATION_FORM_URLENCODED
)

internal fun isLoggable(mediaType: MediaType): Boolean {
    return LOGGABLE_CONTENT_TYPES.any { loggableType ->
        loggableType.includes(mediaType)
    }
}
