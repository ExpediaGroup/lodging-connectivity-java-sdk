/*
 * Copyright (C) 2022 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.sdk.core.authentication.strategy

import com.expediagroup.sdk.core.apache.util.getSingletonApacheHttpTransport
import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.google.api.client.http.HttpTransport
import com.google.auth.oauth2.AccessToken
import com.google.auth.oauth2.OAuth2CredentialsWithRefresh.OAuth2RefreshHandler

internal interface AuthenticationStrategy : OAuth2RefreshHandler {
    override fun refreshAccessToken(): AccessToken

    companion object {
        fun from(
            provider: ConfigurationProvider,
            transport: HttpTransport = getSingletonApacheHttpTransport(provider)
        ): AuthenticationStrategy =
            ExpediaGroupAuthenticationStrategy(
                provider = provider,
                transport = transport
            )
    }

    enum class AuthenticationType {
        BEARER,
    }
}
