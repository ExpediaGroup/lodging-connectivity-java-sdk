package com.expediagroup.sdk.v2.core.request.initializer

import com.google.api.client.http.HttpRequest
import com.google.api.client.http.HttpRequestInitializer

class DisableInternalLoggingRequestInitializer: HttpRequestInitializer {
    override fun initialize(request: HttpRequest) {
        request.setLoggingEnabled(false)
        request.setCurlLoggingEnabled(false)
    }
}