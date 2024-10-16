package com.expediagroup.sdk.v2.core.trait.authentication

import com.expediagroup.sdk.v2.core.trait.Trait
import com.google.auth.oauth2.AccessToken

interface RefreshAccessTokenTrait : Trait {
    fun refreshAccessToken(): AccessToken?
}
