package com.expediagroup.sdk.core.v2.client

import com.expediagroup.sdk.core.apache5.util.createHttpClient
import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.gapiclient.GJsonClientBuilder
import com.expediagroup.sdk.core.gapiclient.GJsonHttpClient
import com.google.api.client.http.apache.v5.Apache5HttpTransport
import org.apache.hc.client5.http.classic.HttpClient

class HttpClient(configurationProvider: ConfigurationProvider) {
    private val apache5Client: HttpClient = createHttpClient(configurationProvider)
    private val jsonClient: GJsonHttpClient = GJsonClientBuilder(
        Apache5HttpTransport(apache5Client),

    )
}