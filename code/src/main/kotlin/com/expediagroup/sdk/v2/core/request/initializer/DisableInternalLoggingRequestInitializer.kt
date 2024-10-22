package com.expediagroup.sdk.v2.core.request.initializer

import com.google.api.client.http.HttpRequest
import com.google.api.client.http.HttpRequestInitializer

/**
 * DisableInternalLoggingRequestInitializer is an implementation of HttpRequestInitializer
 * that disables internal and curl logging for HTTP requests.
 *
 * By using this initializer, any HTTP request it initializes will
 * have both internal logging and curl command logging disabled.
 */
class DisableInternalLoggingRequestInitializer: HttpRequestInitializer {
    override fun initialize(request: HttpRequest) {
        request.setLoggingEnabled(false)
        request.setCurlLoggingEnabled(false)
    }
}
