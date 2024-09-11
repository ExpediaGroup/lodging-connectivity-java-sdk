package com.expediagroup.sdk.core.apache5.util

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.google.api.client.http.HttpTransport
import com.google.api.client.http.apache.v5.Apache5HttpTransport

fun createApache5HttpTransport(configurationProvider: ConfigurationProvider) =
    Apache5HttpTransport(createHttpClient(configurationProvider))

fun getSingletonApache5HttpTransport(configurationProvider: ConfigurationProvider) =
    Apache5HttpTransport(getSingletonHttpClient(configurationProvider))

private class CreateSingletonApache5HttpTransport: (ConfigurationProvider) -> Apache5HttpTransport {
    companion object {
        @JvmStatic
        private val transport: HttpTransport? = null

        @JvmStatic
        val INSTANCE = CreateSingletonApache5HttpTransport()

        @JvmStatic
        fun execute(configurationProvider: ConfigurationProvider) = INSTANCE(configurationProvider)
    }

    override fun invoke(configurationProvider: ConfigurationProvider): Apache5HttpTransport {
        return Apache5HttpTransport(getSingletonHttpClient(configurationProvider))
    }
}
