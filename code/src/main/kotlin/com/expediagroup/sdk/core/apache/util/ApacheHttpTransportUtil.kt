package com.expediagroup.sdk.core.apache.util

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.google.api.client.http.apache.v2.ApacheHttpTransport
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

fun createApacheHttpTransport(configurationProvider: ConfigurationProvider): ApacheHttpTransport =
    ApacheHttpTransport(getSingletonHttpClient(configurationProvider))

fun getSingletonApacheHttpTransport(configurationProvider: ConfigurationProvider) =
    CreateSingletonApacheHttpTransportLambda.execute(configurationProvider)

private class CreateSingletonApacheHttpTransportLambda : (ConfigurationProvider) -> ApacheHttpTransport {
    companion object {
        @JvmStatic
        private val transports: ConcurrentMap<UUID, ApacheHttpTransport> = ConcurrentHashMap()

        @JvmStatic
        val INSTANCE = CreateSingletonApacheHttpTransportLambda()

        @JvmStatic
        fun execute(configurationProvider: ConfigurationProvider) = INSTANCE(configurationProvider)
    }

    override fun invoke(configurationProvider: ConfigurationProvider): ApacheHttpTransport =
        transports.getOrPut(configurationProvider.id) {
            createApacheHttpTransport(configurationProvider)
        }
}
