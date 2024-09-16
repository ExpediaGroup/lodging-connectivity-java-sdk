package com.expediagroup.sdk.core.authentication.util

import com.expediagroup.sdk.core.authentication.strategy.AuthenticationStrategy
import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.gapiclient.extension.withDefaultConfigurations
import com.google.auth.http.HttpCredentialsAdapter
import com.google.auth.oauth2.OAuth2CredentialsWithRefresh
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

fun getHttpCredentialsAdapter(configurationProvider: ConfigurationProvider): HttpCredentialsAdapter =
    CreateSingletonHttpCredentialsAdapter.execute(configurationProvider)

private class CreateSingletonHttpCredentialsAdapter private constructor() :
        (ConfigurationProvider) -> HttpCredentialsAdapter {
    companion object {
        @JvmStatic
        private val INSTANCE = CreateSingletonHttpCredentialsAdapter()

        @JvmStatic
        private val adapters: ConcurrentMap<UUID, HttpCredentialsAdapter> = ConcurrentHashMap()

        @JvmStatic
        fun execute(configurationProvider: ConfigurationProvider): HttpCredentialsAdapter =
            INSTANCE(configurationProvider)
    }

    override fun invoke(provider: ConfigurationProvider): HttpCredentialsAdapter =
        adapters.getOrPut(provider.id) {
            HttpCredentialsAdapter(
                OAuth2CredentialsWithRefresh.newBuilder()
                    .withDefaultConfigurations()
                    .setRefreshHandler(AuthenticationStrategy.from(provider))
                    .build()
            )
        }
}
