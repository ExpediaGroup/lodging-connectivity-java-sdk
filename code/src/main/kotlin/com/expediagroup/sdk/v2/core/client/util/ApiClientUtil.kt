package com.expediagroup.sdk.v2.core.client.util

import com.expediagroup.sdk.v2.core.apache.util.getSingletonApacheHttpTransport
import com.expediagroup.sdk.v2.core.authentication.util.getHttpCredentialsAdapter
import com.expediagroup.sdk.v2.core.client.ApiClient
import com.expediagroup.sdk.v2.core.client.ApiClientBuilder
import com.expediagroup.sdk.v2.core.request.initializer.SdkRequestInitializer
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.core.trait.configuration.EndpointTrait
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpTransport

/**
 * Creates an instance of `ApiClient` using the provided client configuration, and optional HTTP transport.
 *
 * @param configuration The client configuration implementing `ClientConfiguration` interface. Must also implement `EndpointTrait`.
 * @param transport An optional `HttpTransport` object. If not provided, a default transport will be used.
 * @return An instance of `ApiClient`.
 */
@JvmOverloads
fun createApiClient(
    configuration: ClientConfiguration,
    transport: HttpTransport? = null
): ApiClient {
    val jsonFactory = createGsonFactory()
    require(configuration is EndpointTrait) { "Configuration must implement EndpointTrait" }

    val requestInitializer = SdkRequestInitializer.default()
        .add(getHttpCredentialsAdapter(configuration))

    val builder = ApiClientBuilder(
        transport = transport ?: getSingletonApacheHttpTransport(configuration),
        jsonFactory = jsonFactory,
        rootUrl = GenericUrl((configuration as EndpointTrait).getEndpoint()),
        requestInitializer = requestInitializer,
    )

    return ApiClient(builder, configuration)
}
