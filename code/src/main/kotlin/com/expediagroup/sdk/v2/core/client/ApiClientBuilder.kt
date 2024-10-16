package com.expediagroup.sdk.v2.core.client

import com.expediagroup.sdk.v2.core.request.extended.DefaultApiClientRequestInitializer
import com.google.api.client.googleapis.services.AbstractGoogleClient
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory

class ApiClientBuilder(
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
        return ApiClient(this)
    }

    init {
        applicationName = namespace
        googleClientRequestInitializer = DefaultApiClientRequestInitializer.getDefaultInstance()
    }
}