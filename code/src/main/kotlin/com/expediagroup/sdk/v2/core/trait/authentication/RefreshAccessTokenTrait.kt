package com.expediagroup.sdk.v2.core.trait.authentication

import com.expediagroup.sdk.v2.core.trait.Trait

interface RefreshAccessTokenTrait : Trait {
    fun refreshAccessToken(): Any?
}
