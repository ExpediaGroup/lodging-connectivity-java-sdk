package com.expediagroup.sdk.core.plugin.authentication

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.oauth.util.withDefaultConfigurations
import com.expediagroup.sdk.core.plugin.authentication.strategy.AuthenticationStrategy
import com.google.auth.http.HttpCredentialsAdapter
import com.google.auth.oauth2.OAuth2CredentialsWithRefresh
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

fun getHttpCredentialsAdapter(configurationProvider: ConfigurationProvider): HttpCredentialsAdapter =
    CreateSingletonHttpCredentialsAdapter.execute(configurationProvider)

class CreateSingletonHttpCredentialsAdapter private constructor() : (ConfigurationProvider) -> HttpCredentialsAdapter {
    companion object {
        @JvmStatic
        private val INSTANCE = CreateSingletonHttpCredentialsAdapter()

        @JvmStatic
        private val adapters: ConcurrentMap<String, HttpCredentialsAdapter> = ConcurrentHashMap()

        @JvmStatic
        private fun getAdapterId(configurationProvider: ConfigurationProvider): String =
            configurationProvider.toString().plus(configurationProvider.hashCode())

        @JvmStatic
        fun execute(configurationProvider: ConfigurationProvider): HttpCredentialsAdapter =
            INSTANCE(configurationProvider)
    }

    override fun invoke(provider: ConfigurationProvider): HttpCredentialsAdapter {
        val adapterId = getAdapterId(provider)

        if (adapters.containsKey(adapterId)) {
            return adapters[adapterId]!!
        }

        adapters.put(
            adapterId,
            object : HttpCredentialsAdapter(
                OAuth2CredentialsWithRefresh.newBuilder()
                    .withDefaultConfigurations()
                    .setRefreshHandler(AuthenticationStrategy.from(provider))
                    .build()
            ) {}
        )

        return adapters[adapterId]!!
    }
}
