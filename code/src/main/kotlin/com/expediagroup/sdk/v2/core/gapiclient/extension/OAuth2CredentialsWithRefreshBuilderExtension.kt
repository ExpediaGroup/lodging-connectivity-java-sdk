//package com.expediagroup.sdk.v2.core.gapiclient.extension
//
//import com.expediagroup.sdk.v2.core.constant.Authentication.BEARER_EXPIRY_MARGIN_IN_SECONDS
//import com.google.auth.oauth2.OAuth2CredentialsWithRefresh
//import java.time.Duration
//
//fun OAuth2CredentialsWithRefresh.Builder.withDefaultConfigurations(): OAuth2CredentialsWithRefresh.Builder = apply {
//    expirationMargin = Duration.ofSeconds(BEARER_EXPIRY_MARGIN_IN_SECONDS)
//    refreshMargin = Duration.ofSeconds(BEARER_EXPIRY_MARGIN_IN_SECONDS)
//}
