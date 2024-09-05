package com.expediagroup.sdk.core.gapiclient

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory

class GJsonClientBuilder(
    transport: HttpTransport,
    jsonFactory: JsonFactory,
    rootUrl: GenericUrl,
    requestInitializer: HttpRequestInitializer? = null,
    servicePath: String = "",
    namespace: String,
): AbstractGoogleJsonClient.Builder(
    transport,
    jsonFactory,
    rootUrl.build(),
    servicePath,
    requestInitializer,
    false
) {
    override fun build(): AbstractGoogleJsonClient {
        return GJsonHttpClient(this)
    }

    init {
        applicationName = namespace
        googleClientRequestInitializer = DefaultGoogleClientRequestInitializer.getDefaultInstance()
    }
}