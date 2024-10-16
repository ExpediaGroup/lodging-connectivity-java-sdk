package com.expediagroup.sdk.v2.core.trait.authentication

import com.expediagroup.sdk.v2.core.trait.Trait
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.google.api.client.http.HttpTransport

interface AuthenticationHandlerTrait : Trait {
    fun createAuthenticationHandler(
        config: ClientConfiguration,
        transport: HttpTransport,
    ): RefreshAccessTokenTrait
}
