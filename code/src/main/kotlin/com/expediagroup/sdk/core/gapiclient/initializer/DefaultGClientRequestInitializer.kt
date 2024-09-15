package com.expediagroup.sdk.core.gapiclient.initializer

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer

class DefaultGClientRequestInitializer(
    builder: Builder
): CommonGoogleClientRequestInitializer(builder) {
    companion object {
        @JvmStatic
        fun getDefaultInstance(): DefaultGClientRequestInitializer {
            val builder = Builder()
            return DefaultGClientRequestInitializer(builder)
        }

        class Builder: CommonGoogleClientRequestInitializer.Builder() {
            override fun build(): DefaultGClientRequestInitializer {
                return DefaultGClientRequestInitializer(this)
            }
        }
    }

    override fun initialize(request: AbstractGoogleClientRequest<*>) {
        super.initialize(request)
    }
}