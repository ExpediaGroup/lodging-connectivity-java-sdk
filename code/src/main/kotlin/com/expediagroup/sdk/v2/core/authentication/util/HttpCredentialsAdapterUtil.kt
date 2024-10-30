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

/**
 * Creates and returns an HttpCredentialsAdapter based on the given ClientConfiguration.
 * The configuration must implement KeyTrait, SecretTrait, AuthEndpointTrait, and AuthenticationStrategyTrait.
 *
 * @param configuration The configuration object that must implement the necessary traits for authentication.
 * @return An instance of HttpCredentialsAdapter initialized with the given configuration.
 */
fun getHttpCredentialsAdapter(configuration: ClientConfiguration): HttpCredentialsAdapter {
    require(configuration is KeyTrait) { "Configuration must implement KeyTrait!" }
    require(configuration is SecretTrait) { "Configuration must implement SecretTrait!" }
    require(configuration is AuthEndpointTrait) { "Configuration must implement AuthEndpointTrait!" }
    require(configuration is AuthenticationStrategyTrait) { "Configuration must implement ClientConfigurationTrait!" }

    return CreateSingletonHttpCredentialsAdapter.execute(configuration)
}

/**
 * A singleton class responsible for creating and managing instances of `HttpCredentialsAdapter`
 * based on the provided `ClientConfiguration`. This class ensures that each configuration has a
 * unique adapter instance.
 */
private class CreateSingletonHttpCredentialsAdapter private constructor() :
        (ClientConfiguration) -> HttpCredentialsAdapter {
    companion object {
        @JvmStatic
        private val INSTANCE = CreateSingletonHttpCredentialsAdapter()

        @JvmStatic
        private val adapters: ConcurrentMap<UUID, HttpCredentialsAdapter> = ConcurrentHashMap()

        /**
         * Invokes the creation or retrieval of an `HttpCredentialsAdapter` based on the provided `ClientConfiguration`.
         *
         * @param configuration The `ClientConfiguration` instance which must implement `KeyTrait`, `IdTrait`,
         * and `AuthenticationStrategyTrait`.
         * @return An instance of `HttpCredentialsAdapter` mapped to the unique ID of the provided configuration.
         * @throws IllegalArgumentException If the provided configuration does not implement `KeyTrait`.
         */
        @JvmStatic
        fun execute(configuration: ClientConfiguration): HttpCredentialsAdapter =
            INSTANCE(configuration)
    }

    /**
     * Invokes the creation or retrieval of an `HttpCredentialsAdapter` based on the provided `ClientConfiguration`.
     *
     * @param configuration The `ClientConfiguration` instance which must implement `KeyTrait`, `IdTrait`,
     * and `AuthenticationStrategyTrait`.
     * @return An instance of `HttpCredentialsAdapter` mapped to the unique ID of the provided configuration.
     * @throws IllegalArgumentException If the provided configuration does not implement `KeyTrait`.
     */
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
