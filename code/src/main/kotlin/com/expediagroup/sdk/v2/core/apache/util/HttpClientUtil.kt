package com.expediagroup.sdk.v2.core.apache.util

import com.expediagroup.sdk.v2.core.apache.interceptor.ExpediaGroupRequestInterceptor
import com.expediagroup.sdk.v2.core.apache.interceptor.ExpediaGroupResponseInterceptor
import com.expediagroup.sdk.v2.core.trait.common.IdTrait
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.core.trait.configuration.MaxConnectionsPerRouteTrait
import com.expediagroup.sdk.v2.core.trait.configuration.MaxConnectionsTotalTrait
import com.google.api.client.http.apache.v2.ApacheHttpTransport
import org.apache.http.client.HttpClient
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap


fun createHttpClient(configuration: ClientConfiguration): HttpClient {
    require(configuration is MaxConnectionsTotalTrait) { "Configuration must implement MaxConnectionsTotalTrait" }
    require(configuration is MaxConnectionsPerRouteTrait) { "Configuration must implement MaxConnectionsPerRouteTrait" }

    return ApacheHttpTransport.newDefaultHttpClientBuilder()
        .setDefaultRequestConfig(createRequestConfig(configuration))
        .setMaxConnTotal((configuration as MaxConnectionsTotalTrait).getMaxConnectionsTotal())
        .setMaxConnPerRoute((configuration as MaxConnectionsPerRouteTrait).getMaxConnectionsPerRoute())
        .addInterceptorLast(ExpediaGroupRequestInterceptor())
        .addInterceptorLast(ExpediaGroupResponseInterceptor())
        .build()
}

fun getSingletonHttpClient(configuration: ClientConfiguration) =
    CreateSingletonHttpClientLambda.execute(configuration)


private class CreateSingletonHttpClientLambda : (ClientConfiguration) -> HttpClient {
    companion object {
        @JvmStatic
        private val clients: ConcurrentMap<UUID, HttpClient> = ConcurrentHashMap()

        @JvmStatic
        val INSTANCE = CreateSingletonHttpClientLambda()

        @JvmStatic
        fun execute(configuration: ClientConfiguration): HttpClient {
            return INSTANCE(configuration)
        }
    }

    override fun invoke(configuration: ClientConfiguration): HttpClient {
        return clients.getOrPut((configuration as IdTrait).id) {
            createHttpClient(configuration)
        }
    }
}