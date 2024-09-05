package com.expediagroup.sdk.core.gapiclient.util

import com.expediagroup.sdk.core.apache5.util.createSingletonApache5HttpTransport
import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.gapiclient.GJsonClientBuilder
import com.expediagroup.sdk.core.gapiclient.GJsonHttpClient
import com.expediagroup.sdk.core.gson.util.createGsonFactory
import com.google.api.client.http.GenericUrl

fun createGJsonHttpClient(
    namespace: String,
    configurationProvider: ConfigurationProvider
): GJsonHttpClient {
    val jsonFactory = createGsonFactory()

    val jsonClient = GJsonClientBuilder(
        namespace = namespace,
        transport = createSingletonApache5HttpTransport(configurationProvider),
        jsonFactory = jsonFactory,
        rootUrl = GenericUrl(configurationProvider.endpoint!!),
    )

    val gJsonClient = GJsonHttpClient(jsonClient)
    return gJsonClient
}