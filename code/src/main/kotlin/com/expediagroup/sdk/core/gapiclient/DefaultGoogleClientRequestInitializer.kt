package com.expediagroup.sdk.core.gapiclient

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer

class DefaultGoogleClientRequestInitializer(
    builder: Builder
): CommonGoogleClientRequestInitializer(builder) {
    companion object {
        fun getDefaultInstance(): DefaultGoogleClientRequestInitializer {
            val builder = Builder()
            return DefaultGoogleClientRequestInitializer(builder)
        }

        class Builder: CommonGoogleClientRequestInitializer.Builder() {
            override fun build(): DefaultGoogleClientRequestInitializer {
                return DefaultGoogleClientRequestInitializer(this)
            }
        }
    }

    override fun initialize(request: AbstractGoogleClientRequest<*>) {
        super.initialize(request)
    }
}