package com.expediagroup.sdk.v2.core.gapiclient.extension

import com.expediagroup.sdk.v2.core.constant.Authentication
import com.google.auth.oauth2.OAuth2CredentialsWithRefresh
import java.time.Duration

fun OAuth2CredentialsWithRefresh.Builder.withDefaultConfigurations(): OAuth2CredentialsWithRefresh.Builder = apply {
    expirationMargin = Duration.ofSeconds(Authentication.BEARER_EXPIRY_MARGIN_IN_SECONDS)
    refreshMargin = Duration.ofSeconds(Authentication.BEARER_EXPIRY_MARGIN_IN_SECONDS)
}
