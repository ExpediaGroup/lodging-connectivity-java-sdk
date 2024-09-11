package com.expediagroup.sdk.core.gapiclient.util

import com.expediagroup.sdk.core.apache5.util.getSingletonApache5HttpTransport
import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.gapiclient.GClientBuilder
import com.expediagroup.sdk.core.gapiclient.GClient
import com.expediagroup.sdk.core.gson.util.createGsonFactory
import com.expediagroup.sdk.core.plugin.authentication.getHttpCredentialsAdapter
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpTransport

@JvmOverloads
fun createGClient(
    namespace: String,
    configurationProvider: ConfigurationProvider,
    transport: HttpTransport? = null
): GClient {
    val jsonFactory = createGsonFactory()

    val builder = GClientBuilder(
        namespace = namespace,
        transport = transport ?: getSingletonApache5HttpTransport(configurationProvider),
        jsonFactory = jsonFactory,
        rootUrl = GenericUrl(configurationProvider.endpoint!!),
        requestInitializer = getHttpCredentialsAdapter(configurationProvider),
    )

    return GClient(builder)
}