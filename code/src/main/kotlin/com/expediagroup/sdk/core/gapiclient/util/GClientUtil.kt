package com.expediagroup.sdk.core.gapiclient.util

import com.expediagroup.sdk.core.apache.util.getSingletonApacheHttpTransport
import com.expediagroup.sdk.core.authentication.util.getHttpCredentialsAdapter
import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.gapiclient.GClient
import com.expediagroup.sdk.core.gapiclient.GClientBuilder
import com.expediagroup.sdk.core.gson.util.createGsonFactory
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
        transport = transport ?: getSingletonApacheHttpTransport(configurationProvider),
        jsonFactory = jsonFactory,
        rootUrl = GenericUrl(configurationProvider.endpoint!!),
        requestInitializer = getHttpCredentialsAdapter(configurationProvider),
    )

    return GClient(builder, configurationProvider)
}
