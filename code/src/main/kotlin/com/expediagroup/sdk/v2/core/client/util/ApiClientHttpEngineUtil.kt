package com.expediagroup.sdk.v2.core.client.util

import com.expediagroup.sdk.v2.core.client.ApiClientApolloHttpEngine
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration

/**
 * Creates an instance of `ApiClientApolloHttpEngine` using the provided namespace and client configuration.
 *
 * @param namespace The namespace to be used for creating the API client.
 * @param configuration The client configuration implementing `ClientConfiguration` interface.
 * @return An instance of `ApiClientApolloHttpEngine`.
 */
fun createApiClientHttpEngine(
    namespace: String,
    configuration: ClientConfiguration,
) = ApiClientApolloHttpEngine(
    createApiClient(
        namespace = namespace,
        configuration = configuration
    )
)