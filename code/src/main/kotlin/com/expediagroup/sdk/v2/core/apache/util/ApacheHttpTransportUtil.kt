package com.expediagroup.sdk.v2.core.apache.util

import com.expediagroup.sdk.v2.core.trait.common.IdTrait
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.google.api.client.http.apache.v2.ApacheHttpTransport
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

fun createApacheHttpTransport(configuration: ClientConfiguration): ApacheHttpTransport =
    ApacheHttpTransport(getSingletonHttpClient(configuration))

fun getSingletonApacheHttpTransport(configuration: ClientConfiguration) =
    CreateSingletonApacheHttpTransportLambda.execute(configuration)

private class CreateSingletonApacheHttpTransportLambda : (ClientConfiguration) -> ApacheHttpTransport {
    companion object {
        @JvmStatic
        private val transports: ConcurrentMap<UUID, ApacheHttpTransport> = ConcurrentHashMap()

        @JvmStatic
        val INSTANCE = CreateSingletonApacheHttpTransportLambda()

        @JvmStatic
        fun execute(configuration: ClientConfiguration) = INSTANCE(configuration)
    }

    override fun invoke(configuration: ClientConfiguration): ApacheHttpTransport {
        require(configuration is IdTrait)

        return transports.getOrPut((configuration as IdTrait).id) {
            createApacheHttpTransport(configuration)
        }
    }
}
