package com.expediagroup.sdk.v2.core.client.util

import com.expediagroup.sdk.v2.core.client.ApiClientApolloHttpEngine
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration

fun createApiClientHttpEngine(
    namespace: String,
    configuration: ClientConfiguration,
) = ApiClientApolloHttpEngine(
    createApiClient(
        namespace = namespace,
        configuration = configuration
    )
)