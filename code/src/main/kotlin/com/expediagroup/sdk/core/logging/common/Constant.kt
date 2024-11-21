package com.expediagroup.sdk.core.logging.common

object Constant {
    const val NEWLINE = "\n"
    const val COMMA_SPACE = ", "
    const val DOUBLE_RIGHT_ANGLE_BRACKETS: String = ">>"
    const val REQUEST_HEADERS: String = "Request Headers:"
    const val REQUEST_BODY: String = "Request Body:"
    const val RESPONSE_HEADERS: String = "Response Headers:"
    const val RESPONSE_BODY: String = "Response Body:"
    const val EMPTY_OR_UNKNOWN_RESPONSE_BODY: String = "Empty response body or unknown content length"
    const val BODY_CONTENT_TYPE_NOT_SUPPORTED = "Content type %s not supported for logging"
    const val RESPONSE_TOO_LARGE_TO_BE_LOGGED_WHOLE = "Response too large to be logged whole..."
    const val LOGGING_PREFIX = "[ExpediaGroupSDK]"
    const val TOKEN_RENEWAL_IN_PROGRESS = "Renewing token"
    const val TOKEN_RENEWAL_SUCCESSFUL = "Token renewal successful"
    const val TOKEN_RENEWAL_FAILURE = "Token renewal failure"
    const val OMITTED = "<-- omitted -->"
}
