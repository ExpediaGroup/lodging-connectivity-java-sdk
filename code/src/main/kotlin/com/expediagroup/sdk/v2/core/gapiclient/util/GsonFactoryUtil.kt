package com.expediagroup.sdk.v2.core.gapiclient.util

import com.google.api.client.json.gson.GsonFactory

// TODO: To be extended to hold Gson Factory configuration
internal fun createGsonFactory(builder: GsonFactory.Builder? = null) =
    if (builder == null) {
        GsonFactory.getDefaultInstance()
    } else {
        builder.build()
    }