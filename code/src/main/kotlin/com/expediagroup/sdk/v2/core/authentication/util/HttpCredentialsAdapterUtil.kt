package com.expediagroup.sdk.v2.core.authentication.util

import com.expediagroup.sdk.v2.core.apache.util.createApacheHttpTransport
import com.expediagroup.sdk.v2.core.authentication.extension.withDefaultConfigurations
import com.expediagroup.sdk.v2.core.trait.common.IdTrait
import com.expediagroup.sdk.v2.core.trait.configuration.*
import com.google.auth.http.HttpCredentialsAdapter
import com.google.auth.oauth2.AccessToken
import com.google.auth.oauth2.OAuth2CredentialsWithRefresh
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

fun getHttpCredentialsAdapter(configuration: ClientConfiguration): HttpCredentialsAdapter {
    require(configuration is KeyTrait) { "Configuration must implement KeyTrait!" }
    require(configuration is SecretTrait) { "Configuration must implement SecretTrait!" }
    require(configuration is AuthEndpointTrait) { "Configuration must implement AuthEndpointTrait!" }
    require(configuration is AuthenticationStrategyTrait) { "Configuration must implement ClientConfigurationTrait!" }

    return CreateSingletonHttpCredentialsAdapter.execute(configuration)
}

private class CreateSingletonHttpCredentialsAdapter private constructor() :
        (ClientConfiguration) -> HttpCredentialsAdapter {
    companion object {
        @JvmStatic
        private val INSTANCE = CreateSingletonHttpCredentialsAdapter()

        @JvmStatic
        private val adapters: ConcurrentMap<UUID, HttpCredentialsAdapter> = ConcurrentHashMap()

        @JvmStatic
        fun execute(configuration: ClientConfiguration): HttpCredentialsAdapter =
            INSTANCE(configuration)
    }

    override fun invoke(configuration: ClientConfiguration): HttpCredentialsAdapter {
        require(configuration is KeyTrait) { "Configuration must implement KeyTrait!" }

        val strategy = (configuration as AuthenticationStrategyTrait).getAuthenticationStrategy()
        val handler = strategy.handlerFactory.createAuthenticationHandler(
            config = configuration,
            transport = createApacheHttpTransport(configuration)
        )

        return adapters.getOrPut((configuration as IdTrait).id) {
            HttpCredentialsAdapter(
                OAuth2CredentialsWithRefresh.newBuilder()
                    .withDefaultConfigurations()
                    .setRefreshHandler { handler.refreshAccessToken() as AccessToken }
                    .build()
            )
        }
    }
}
