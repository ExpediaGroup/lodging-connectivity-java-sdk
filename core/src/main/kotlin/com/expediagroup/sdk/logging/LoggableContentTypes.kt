package com.expediagroup.sdk.logging

import com.expediagroup.sdk.http.MediaType

/**
 * A list of MIME types representing content types that are deemed loggable.
 * This collection is used to determine whether the content of HTTP requests or responses
 * can be logged based on their MIME types.
 */
val LOGGABLE_CONTENT_TYPES = listOf(
    MediaType.of("text", "plain"),
    MediaType.of("text", "html"),
    MediaType.of("text", "css"),
    MediaType.of("text", "javascript"),
    MediaType.of("text", "csv"),
    MediaType.of("text", "*"),
    MediaType.of("application", "json"),
    MediaType.of("application", "xml"),
    MediaType.of("application", "x-www-form-urlencoded"),
    MediaType.of("application", "json+graphql"),
    MediaType.of("application", "hal+json")
)

internal fun isLoggable(mediaType: MediaType): Boolean {
    return LOGGABLE_CONTENT_TYPES.any { loggableType ->
        loggableType.includes(mediaType)
    }
}
