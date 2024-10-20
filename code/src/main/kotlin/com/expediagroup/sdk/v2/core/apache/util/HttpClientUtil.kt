package com.expediagroup.sdk.v2.core.apache.util

import com.expediagroup.sdk.v2.core.trait.common.IdTrait
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.core.trait.configuration.MaxConnectionsPerRouteTrait
import com.expediagroup.sdk.v2.core.trait.configuration.MaxConnectionsTotalTrait
import com.google.api.client.http.apache.v2.ApacheHttpTransport
import org.apache.http.client.HttpClient


fun createHttpClient(configuration: ClientConfiguration): HttpClient {
    require(configuration is MaxConnectionsTotalTrait) { "Configuration must implement MaxConnectionsTotalTrait" }
    require(configuration is MaxConnectionsPerRouteTrait) { "Configuration must implement MaxConnectionsPerRouteTrait" }

    return ApacheHttpTransport.newDefaultHttpClientBuilder()
        .setDefaultRequestConfig(createRequestConfig(configuration))
        .setMaxConnTotal((configuration as MaxConnectionsTotalTrait).getMaxConnectionsTotal())
        .setMaxConnPerRoute((configuration as MaxConnectionsPerRouteTrait).getMaxConnectionsPerRoute())
        .build()
}

fun getSingletonHttpClient(configuration: ClientConfiguration) =
    CreateSingletonHttpClientLambda.execute(configuration)


private class CreateSingletonHttpClientLambda : (ClientConfiguration) -> HttpClient {
    companion object {
        @JvmStatic
        private var client: HttpClient? = null

        @JvmStatic
        val INSTANCE = CreateSingletonHttpClientLambda()

        @JvmStatic
        fun execute(configuration: ClientConfiguration): HttpClient {
            return INSTANCE(configuration)
        }
    }

    override fun invoke(configuration: ClientConfiguration): HttpClient {
        if (client == null) {
            client = createHttpClient(configuration)
        }

        return client!!
    }
}