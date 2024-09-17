package com.expediagroup.sdk.v2.core.trait.authentication

import com.expediagroup.sdk.v2.core.trait.Trait
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfigurationTrait
import com.google.api.client.http.HttpTransport

interface CreateAuthenticationHandlerTrait : Trait {
    fun createAuthenticationHandler(
        config: ClientConfigurationTrait,
        transport: HttpTransport,
    ): RefreshAccessTokenTrait
}
