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

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.constant.LoggingMessage
import com.expediagroup.sdk.core.logging.LogMessageTag
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.core.plugin.logging.ExpediaGroupLoggerFactory
import com.google.api.client.auth.oauth2.ClientCredentialsTokenRequest
import com.google.api.client.http.BasicAuthentication
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.gson.GsonFactory
import com.google.auth.oauth2.AccessToken
import java.time.Instant
import java.util.*

internal class ExpediaGroupAuthenticationStrategy(
    private val provider: ConfigurationProvider,
    private val transport: HttpTransport,
) : AuthenticationStrategy {
    private val logger = ExpediaGroupLoggerFactory.getLogger(javaClass)

    override fun refreshAccessToken(): AccessToken =
        ClientCredentialsTokenRequest(
            transport,
            GsonFactory.getDefaultInstance(),
            GenericUrl(provider.authEndpoint),
        ).setClientAuthentication(
            BasicAuthentication(provider.key, provider.secret)
        ).also {
            logger.info(LoggingMessage.TOKEN_RENEWAL_IN_PROGRESS, tags = setOf(LogMessageTag.PROGRESSING))
        }.let {
            try {
                it.execute().let {
                    return@let AccessToken.newBuilder()
                        .setTokenValue(it.accessToken)
                        .setExpirationTime(Date.from(Instant.now().plusSeconds(it.expiresInSeconds.toLong())))
                        .setScopes(it.scope)
                        .build().also {
                            logger.info(LoggingMessage.TOKEN_RENEWAL_SUCCESSFUL, tags = setOf(LogMessageTag.SUCCESS))
                        }
                }
            } catch (e: Exception) {
                logger.error(LoggingMessage.TOKEN_RENEWAL_FAILURE, tags = setOf(LogMessageTag.ERROR))
                throw ExpediaGroupAuthException(
                    message = "Token renewal failed!",
                )
            }
        }
}
