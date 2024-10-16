package com.expediagroup.sdk.v2.core.request.extended

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer

class DefaultApiClientRequestInitializer(
    builder: Builder
) : CommonGoogleClientRequestInitializer(builder) {
    companion object {
        @JvmStatic
        fun getDefaultInstance(): DefaultApiClientRequestInitializer {
            val builder = Builder()
            return DefaultApiClientRequestInitializer(builder)
        }

        class Builder : CommonGoogleClientRequestInitializer.Builder() {
            override fun build(): DefaultApiClientRequestInitializer {
                return DefaultApiClientRequestInitializer(this)
            }
        }
    }

    override fun initialize(request: AbstractGoogleClientRequest<*>) {
        super.initialize(request)
    }
}