package com.expediagroup.sdk.v2.core.authentication.strategy

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.v2.core.constant.LoggingMessage
import com.expediagroup.sdk.v2.core.logging.ExpediaGroupLoggerFactory
import com.expediagroup.sdk.v2.core.logging.LogMessageTag
import com.expediagroup.sdk.v2.core.request.extended.ChainedHttpRequestInitializer
import com.expediagroup.sdk.v2.core.trait.authentication.AuthenticationHandlerTrait
import com.expediagroup.sdk.v2.core.trait.authentication.RefreshAccessTokenTrait
import com.expediagroup.sdk.v2.core.trait.configuration.AuthEndpointTrait
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.core.trait.configuration.KeyTrait
import com.expediagroup.sdk.v2.core.trait.configuration.SecretTrait
import com.google.api.client.auth.oauth2.ClientCredentialsTokenRequest
import com.google.api.client.http.BasicAuthentication
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.gson.GsonFactory
import com.google.auth.oauth2.AccessToken
import java.time.Instant
import java.util.*

/**
 * Factory object for creating Bearer Authentication handlers.
 */
object BearerAuthenticationHandlerFactory: AuthenticationHandlerTrait {

    /**
     * Creates an authentication handler to refresh access tokens using client credentials.
     *
     * @param config The client configuration that must implement KeyTrait, SecretTrait, and AuthEndpointTrait.
     * @param transport The HTTP transport to be used for token refresh requests.
     * @return An instance of RefreshAccessTokenTrait which can be used to refresh access tokens.
     */
    override fun createAuthenticationHandler(
        config: ClientConfiguration,
        transport: HttpTransport,
    ): RefreshAccessTokenTrait {

        require(config is KeyTrait) { "Configuration must implement KeyTrait!" }
        require(config is SecretTrait) { "Configuration must implement SecretTrait!" }
        require(config is AuthEndpointTrait) { "Configuration must implement AuthEndpointTrait!" }

        return object : RefreshAccessTokenTrait {
            private val logger = ExpediaGroupLoggerFactory.getLogger(javaClass)

            override fun refreshAccessToken(): AccessToken {
                val key = (config as KeyTrait).getKey()
                val secret = (config as SecretTrait).getSecret()
                val authEndpoint = (config as AuthEndpointTrait).getAuthEndpoint()

                return ClientCredentialsTokenRequest(
                    transport,
                    GsonFactory.getDefaultInstance(),
                    GenericUrl(authEndpoint),
                ).setClientAuthentication(
                    BasicAuthentication(key, secret)
                ).also attachDefaultInitializer@ { request ->
                    request.requestInitializer = when(request.requestInitializer) {
                        is ChainedHttpRequestInitializer ->
                            (request.requestInitializer as ChainedHttpRequestInitializer).extend(
                                ChainedHttpRequestInitializer.default()
                            )

                        is HttpRequestInitializer ->
                            ChainedHttpRequestInitializer.default().extend(request.requestInitializer)

                        else -> ChainedHttpRequestInitializer.default()
                    }
                }.also logTokenRenewalInProgress@ {
                    logger.info(LoggingMessage.TOKEN_RENEWAL_IN_PROGRESS, tags = setOf(LogMessageTag.PROGRESSING))
                }.let executeRequest@ { request ->
                    try {
                        request.execute().let buildAccessToken@ { response ->
                            return@buildAccessToken AccessToken.newBuilder()
                                .setTokenValue(response.accessToken)
                                .setExpirationTime(Date.from(Instant.now().plusSeconds(response.expiresInSeconds.toLong())))
                                .setScopes(response.scope)
                                .build().also {
                                    logger.info(
                                        LoggingMessage.TOKEN_RENEWAL_SUCCESSFUL,
                                        tags = setOf(LogMessageTag.SUCCESS)
                                    )
                                }
                        }
                    } catch (e: Exception) {
                        logger.error(LoggingMessage.TOKEN_RENEWAL_FAILURE, tags = setOf(LogMessageTag.ERROR))
                        throw ExpediaGroupAuthException(
                            message = "Token renewal failed!",
                            cause = e
                        )
                    }
                }
            }
        }
    }
}