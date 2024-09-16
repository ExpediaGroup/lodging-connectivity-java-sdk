package com.expediagroup.sdk.core.logging

object LogMessageConstant {
    const val REQUEST_HEADERS: String = "Request Headers:"

    const val REQUEST_BODY: String = "Request Body:"

    const val RESPONSE_HEADERS: String = "Response Headers:"

    const val RESPONSE_BODY: String = "Response Body:"

    // {PROTOCOL, METHOD, URL, STATUS_CODE, PHRASE}
    const val RESPONSE_FROM: String = "Response from: %s %s %s [%s %s]"

    const val EMPTY_REQUEST_BODY: String = "Empty request body"

    const val EMPTY_RESPONSE_BODY: String = "Empty response body"

    const val BODY_CONTENT_LENGTH_NOT_PROVIDED = "Content length not provided for logging"

    const val BODY_CONTENT_TYPE_NOT_SUPPORTED = "Content type %s not supported for logging"
}
