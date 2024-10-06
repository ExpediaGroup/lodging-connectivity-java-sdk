package com.expediagroup.sdk.v2.core.authentication.strategy

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.v2.core.constant.LoggingMessage
import com.expediagroup.sdk.v2.core.logging.ExpediaGroupLoggerFactory
import com.expediagroup.sdk.v2.core.logging.LogMessageTag
import com.expediagroup.sdk.v2.core.trait.authentication.CreateAuthenticationHandlerTrait
import com.expediagroup.sdk.v2.core.trait.authentication.RefreshAccessTokenTrait
import com.expediagroup.sdk.v2.core.trait.configuration.AuthEndpointTrait
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfigurationTrait
import com.expediagroup.sdk.v2.core.trait.configuration.KeyTrait
import com.expediagroup.sdk.v2.core.trait.configuration.SecretTrait
import com.google.api.client.auth.oauth2.ClientCredentialsTokenRequest
import com.google.api.client.http.BasicAuthentication
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.gson.GsonFactory
import com.google.auth.oauth2.AccessToken
import java.time.Instant
import java.util.*

object BearerAuthenticationHandlerFactory: CreateAuthenticationHandlerTrait {

    override fun createAuthenticationHandler(
        config: ClientConfigurationTrait,
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
                ).also {
                    logger.info(LoggingMessage.TOKEN_RENEWAL_IN_PROGRESS, tags = setOf(LogMessageTag.PROGRESSING))
                }.let {
                    try {
                        it.execute().let {
                            return@let AccessToken.newBuilder()
                                .setTokenValue(it.accessToken)
                                .setExpirationTime(Date.from(Instant.now().plusSeconds(it.expiresInSeconds.toLong())))
                                .setScopes(it.scope)
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
                        )
                    }
                }
            }
        }
    }
}