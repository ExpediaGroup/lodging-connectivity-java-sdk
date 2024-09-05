package com.expediagroup.sdk.core.v2.client

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.gapiclient.GJsonHttpClient
import com.expediagroup.sdk.core.gapiclient.util.createGJsonHttpClient
import com.google.api.client.http.GenericUrl

class BaseExpediaGroupClient(
    namespace: String = "",
    configurationProvider: ConfigurationProvider,
) {
    private val gJsonHttpClient: GJsonHttpClient = createGJsonHttpClient(
        namespace = namespace,
        configurationProvider = configurationProvider
    )

    init {
    }
}