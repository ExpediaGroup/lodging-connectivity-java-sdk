package com.expediagroup.sdk.core.client.util

import com.google.api.client.json.gson.GsonFactory

/**
 * Creates a GsonFactory instance using the provided builder or returns the default instance if the builder is null.
 *
 * TODO: To be extended to hold Gson Factory configuration
 *
 * @param builder An optional builder for customizing the GsonFactory instance. If null, the default GsonFactory instance is returned.
 * @return An instance of GsonFactory based on the builder configuration or the default configuration.
 */
internal fun createGsonFactory(builder: GsonFactory.Builder? = null) =
    if (builder == null) {
        GsonFactory.getDefaultInstance()
    } else {
        builder.build()
    }
