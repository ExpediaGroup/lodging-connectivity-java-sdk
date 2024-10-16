package com.expediagroup.sdk.v2.core.client.util

import com.expediagroup.sdk.v2.core.apache.util.getSingletonApacheHttpTransport
import com.expediagroup.sdk.v2.core.authentication.util.getHttpCredentialsAdapter
import com.expediagroup.sdk.v2.core.client.ApiClient
import com.expediagroup.sdk.v2.core.client.ApiClientBuilder
import com.expediagroup.sdk.v2.core.request.extended.ChainedHttpRequestInitializer
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.core.trait.configuration.EndpointTrait
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpTransport

@JvmOverloads
fun createApiClient(
    namespace: String,
    configuration: ClientConfiguration,
    transport: HttpTransport? = null
): ApiClient {
    val jsonFactory = createGsonFactory()
    require(configuration is EndpointTrait) { "Configuration must implement EndpointTrait" }

    val requestInitializer = ChainedHttpRequestInitializer.default()
        .extend(getHttpCredentialsAdapter(configuration))

    val builder = ApiClientBuilder(
        namespace = namespace,
        transport = transport ?: getSingletonApacheHttpTransport(configuration),
        jsonFactory = jsonFactory,
        rootUrl = GenericUrl((configuration as EndpointTrait).getEndpoint()),
        requestInitializer = requestInitializer,
    )

    return ApiClient(builder, configuration)
}
