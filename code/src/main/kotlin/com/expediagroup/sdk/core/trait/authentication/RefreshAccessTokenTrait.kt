package com.expediagroup.sdk.core.trait.authentication

import com.expediagroup.sdk.core.trait.Trait
import com.google.auth.oauth2.AccessToken

/**
 * Interface representing a trait for refreshing access tokens.
 *
 * Implementing classes are responsible for providing a method to refresh
 * access tokens, which can be used for authentication and authorization
 * in client-server communications.
 */
interface RefreshAccessTokenTrait : Trait {
    fun refreshAccessToken(): AccessToken?
}
