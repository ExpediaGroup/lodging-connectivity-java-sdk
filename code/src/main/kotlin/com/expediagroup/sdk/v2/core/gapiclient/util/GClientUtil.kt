package com.expediagroup.sdk.v2.core.gapiclient.util

import com.expediagroup.sdk.v2.core.apache.util.getSingletonApacheHttpTransport
import com.expediagroup.sdk.v2.core.authentication.util.getHttpCredentialsAdapter
import com.expediagroup.sdk.v2.core.gapiclient.GClient
import com.expediagroup.sdk.v2.core.gapiclient.GClientBuilder
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.core.trait.configuration.EndpointTrait
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpTransport

@JvmOverloads
fun createGClient(
    namespace: String,
    configuration: ClientConfiguration,
    transport: HttpTransport? = null
): GClient {
    val jsonFactory = createGsonFactory()
    require(configuration is EndpointTrait) { "Configuration must implement EndpointTrait" }

    val builder = GClientBuilder(
        namespace = namespace,
        transport = transport ?: getSingletonApacheHttpTransport(configuration),
        jsonFactory = jsonFactory,
        rootUrl = GenericUrl((configuration as EndpointTrait).getEndpoint()),
        requestInitializer = getHttpCredentialsAdapter(configuration),
    )

    return GClient(builder, configuration)
}
