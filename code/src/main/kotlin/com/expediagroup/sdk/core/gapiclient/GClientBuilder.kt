package com.expediagroup.sdk.core.gapiclient

import com.expediagroup.sdk.core.gapiclient.initializer.DefaultGClientRequestInitializer
import com.google.api.client.googleapis.services.AbstractGoogleClient
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory

class GClientBuilder(
    transport: HttpTransport,
    jsonFactory: JsonFactory,
    rootUrl: GenericUrl,
    requestInitializer: HttpRequestInitializer? = null,
    servicePath: String = "",
    namespace: String,
) : AbstractGoogleClient.Builder(
    transport,
    rootUrl.build(),
    servicePath,
    jsonFactory.createJsonObjectParser(), // TODO: Configure value
    requestInitializer,
) {
    override fun build(): AbstractGoogleClient {
        return GClient(this)
    }

    init {
        applicationName = namespace
        googleClientRequestInitializer = DefaultGClientRequestInitializer.getDefaultInstance()
    }
}