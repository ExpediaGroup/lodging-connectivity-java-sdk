package com.expediagroup.sdk.v2.core.apache.util

import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.google.api.client.http.apache.v2.ApacheHttpTransport

fun createApacheHttpTransport(configuration: ClientConfiguration): ApacheHttpTransport =
    ApacheHttpTransport(createHttpClient(configuration))

fun getSingletonApacheHttpTransport(configuration: ClientConfiguration) =
    CreateSingletonApacheHttpTransportLambda.execute(configuration)

private class CreateSingletonApacheHttpTransportLambda : (ClientConfiguration) -> ApacheHttpTransport {
    companion object {
        @JvmStatic
        private var transport: ApacheHttpTransport? = null

        @JvmStatic
        val INSTANCE = CreateSingletonApacheHttpTransportLambda()

        @JvmStatic
        fun execute(configuration: ClientConfiguration) = INSTANCE(configuration)
    }

    override fun invoke(configuration: ClientConfiguration): ApacheHttpTransport {
        if (transport == null) {
            transport = createApacheHttpTransport(configuration)
        }

        return transport!!
    }
}