package com.expediagroup.sdk.core.logging

/**
 * Object holding constants for logging messages related to HTTP requests and responses.
 */
object LogMessageConstant {
    const val REQUEST_HEADERS: String = "Request Headers:"

    const val REQUEST_BODY: String = "Request Body:"

    const val RESPONSE_HEADERS: String = "Response Headers:"

    const val RESPONSE_BODY: String = "Response Body:"

    const val EMPTY_OR_UNKNOWN_RESPONSE_BODY: String = "Empty response body or unknown content length"

    const val BODY_CONTENT_TYPE_NOT_SUPPORTED = "Content type %s not supported for logging"

    const val RESPONSE_TOO_LARGE_TO_BE_LOGGED_WHOLE = "Response too large to be logged whole..."

    const val RESPONSE_CONTENT_INPUT_STREAM_DOES_NOT_SUPPORT_MARK =
        "Response content input stream does not support mark"
}
