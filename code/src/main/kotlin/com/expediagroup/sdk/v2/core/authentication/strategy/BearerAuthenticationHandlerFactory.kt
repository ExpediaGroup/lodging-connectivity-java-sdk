package com.expediagroup.sdk.v2.core.authentication.strategy

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.v2.core.constant.LoggingMessage
import com.expediagroup.sdk.v2.core.logging.ExpediaGroupLoggerFactory
import com.expediagroup.sdk.v2.core.logging.LogMessageTag
import com.expediagroup.sdk.v2.core.request.initializer.SdkRequestInitializer
import com.expediagroup.sdk.v2.core.trait.authentication.AuthenticationHandlerTrait
import com.expediagroup.sdk.v2.core.trait.authentication.RefreshAccessTokenTrait
import com.expediagroup.sdk.v2.core.trait.configuration.AuthEndpointTrait
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.core.trait.configuration.KeyTrait
import com.expediagroup.sdk.v2.core.trait.configuration.SecretTrait
import com.google.api.client.auth.oauth2.ClientCredentialsTokenRequest
import com.google.api.client.auth.oauth2.TokenRequest
import com.google.api.client.auth.oauth2.TokenResponse
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
object BearerAuthenticationHandlerFactory : AuthenticationHandlerTrait {

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

            /**
             * Refreshes and returns a new `AccessToken` by making a token request.
             * This method builds the token request, initializes it, logs the token renewal progress,
             * executes the request, and handles any exceptions that occur.
             *
             * @return A newly generated `AccessToken` instance if the token request is successful.
             * @throws ExpediaGroupAuthException if the token renewal process fails.
             */
            override fun refreshAccessToken(): AccessToken =
                buildTokenRequest()
                    .also attachDefaultInitializer@{ request ->
                        request.requestInitializer = attachSdkRequestInitializer(request)
                    }.also logTokenRenewalInProgress@{
                        logger.info(LoggingMessage.TOKEN_RENEWAL_IN_PROGRESS, LogMessageTag.PROGRESSING)
                    }.let executeRequest@{ request ->
                        try {
                            return@executeRequest buildAccessToken(request.execute())
                        } catch (e: Exception) {
                            logger.error(LoggingMessage.TOKEN_RENEWAL_FAILURE, LogMessageTag.ERROR)
                            throw ExpediaGroupAuthException(
                                message = "Token renewal failed!",
                                cause = e
                            )
                        }
                    }


            /**
             * Builds a `ClientCredentialsTokenRequest` using the configuration traits available in the `config` property.
             * Key, secret, and authentication endpoint are retrieved from the configuration.
             *
             * @return An instance of `ClientCredentialsTokenRequest` configured with client authentication and other necessary parameters.
             */
            private fun buildTokenRequest(): ClientCredentialsTokenRequest {
                val key = (config as KeyTrait).getKey()
                val secret = (config as SecretTrait).getSecret()
                val authEndpoint = (config as AuthEndpointTrait).getAuthEndpoint()

                return ClientCredentialsTokenRequest(
                    transport,
                    GsonFactory.getDefaultInstance(),
                    GenericUrl(authEndpoint),
                ).setClientAuthentication(
                    BasicAuthentication(key, secret)
                )
            }

            /**
             * Calculates the token expiration time based on the current time and the duration specified in the token response.
             *
             * @param response The `TokenResponse` object containing the `expiresInSeconds` property, which indicates the time in seconds
             *                 for which the token is valid from the current time.
             * @return A `Date` object representing the calculated expiration time of the token.
             */
            private fun calculateTokenExpirationTime(response: TokenResponse): Date =
                Date.from(Instant.now().plusSeconds(response.expiresInSeconds.toLong()))

            /**
             * Builds an `AccessToken` object from the given `TokenResponse`.
             * Logs a success message upon successful token renewal.
             *
             * @param response The `TokenResponse` from which the access token is created.
             * @return An instance of `AccessToken` containing the token value, expiration time, and scopes.
             */
            private fun buildAccessToken(response: TokenResponse): AccessToken =
                AccessToken.newBuilder()
                    .setTokenValue(response.accessToken)
                    .setExpirationTime(calculateTokenExpirationTime(response))
                    .setScopes(response.scope)
                    .build().also {
                        logger.info(
                            LoggingMessage.TOKEN_RENEWAL_SUCCESSFUL,
                            LogMessageTag.SUCCESS
                        )
                    }

            /**
             * Attaches an appropriate SDK request initializer to the given `TokenRequest` instance based on the type of
             * `requestInitializer` present in the `TokenRequest`.
             *
             * @param request The `TokenRequest` object that requires an initializer. The function checks the type of
             *                `requestInitializer` within this request and attaches an appropriate `SdkRequestInitializer`.
             *                If no suitable initializer is found, a default `SdkRequestInitializer` is used.
             */
            private fun attachSdkRequestInitializer(request: TokenRequest) =
                when (request.requestInitializer) {
                    is SdkRequestInitializer ->
                        (request.requestInitializer as SdkRequestInitializer).add(
                            SdkRequestInitializer.default()
                        )

                    is HttpRequestInitializer ->
                        SdkRequestInitializer.default().add(request.requestInitializer)

                    else -> SdkRequestInitializer.default()
                }
        }

    }
}
