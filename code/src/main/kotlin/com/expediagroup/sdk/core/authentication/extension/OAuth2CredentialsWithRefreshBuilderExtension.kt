package com.expediagroup.sdk.core.authentication.extension

import com.expediagroup.sdk.core.constant.Authentication
import com.google.auth.oauth2.OAuth2CredentialsWithRefresh
import java.time.Duration

/**
 * Configures the `OAuth2CredentialsWithRefresh.Builder` with default configuration settings.
 *
 * This method sets the `expirationMargin` and `refreshMargin` to default values defined by `Authentication.BEARER_EXPIRY_MARGIN_IN_SECONDS`.
 *
 * @return The `OAuth2CredentialsWithRefresh.Builder` instance with default configurations applied.
 */
fun OAuth2CredentialsWithRefresh.Builder.withDefaultConfigurations(): OAuth2CredentialsWithRefresh.Builder = apply {
    expirationMargin = Duration.ofSeconds(Authentication.BEARER_EXPIRY_MARGIN_IN_SECONDS)
    refreshMargin = Duration.ofSeconds(Authentication.BEARER_EXPIRY_MARGIN_IN_SECONDS)
}
