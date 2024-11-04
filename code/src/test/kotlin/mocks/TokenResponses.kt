package mocks

import com.google.api.client.auth.oauth2.TokenResponse


// Our expiration threshold is 10 seconds
val successfulTokenResponse = TokenResponse().apply {
    setScope("example")
    setRefreshToken("refresh_token")
    setAccessToken("access_token")
    setExpiresInSeconds(3600)
    setTokenType("token_type")
}

val aboutToExpireSuccessfulTokenResponse = successfulTokenResponse.clone().apply {
    setExpiresInSeconds(9)
}

val oneSecondForAboutToExpireSuccessfulTokenResponse = successfulTokenResponse.clone().apply {
    setExpiresInSeconds(11)
}
