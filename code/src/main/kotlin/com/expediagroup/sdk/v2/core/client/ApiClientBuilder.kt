package com.expediagroup.sdk.v2.core.client

import com.expediagroup.sdk.v2.core.configuration.SdkMetadata
import com.expediagroup.sdk.v2.core.request.initializer.ApiClientRequestInitializer
import com.google.api.client.googleapis.services.AbstractGoogleClient
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory

/**
 * Builder for constructing an instance of `ApiClient`. This class extends
 * `AbstractGoogleClient.Builder` and provides the necessary configurations
 * for the API client.
 *
 * @param transport The HTTP transport to be used for the API client.
 * @param jsonFactory Factory for JSON parsing and serialization.
 * @param rootUrl The root URL for the API service.
 * @param requestInitializer Optional request initializer for HTTP requests.
 * @param servicePath The path to the service endpoint.
 */
class ApiClientBuilder(
    transport: HttpTransport,
    jsonFactory: JsonFactory,
    rootUrl: GenericUrl,
    requestInitializer: HttpRequestInitializer? = null,
    servicePath: String = "",
) : AbstractGoogleClient.Builder(
    transport,
    rootUrl.build(),
    servicePath,
    jsonFactory.createJsonObjectParser(), // TODO: Configure value
    requestInitializer,
) {
    /**
     * Builds an instance of `ApiClient` using the current configuration of `ApiClientBuilder`.
     *
     * @return An instance of `ApiClient` configured with the properties set in this builder.
     */
    override fun build(): AbstractGoogleClient {
        return ApiClient(this)
    }

    init {
        applicationName = SdkMetadata.getArtifactId()
        googleClientRequestInitializer = ApiClientRequestInitializer.default()
    }
}
