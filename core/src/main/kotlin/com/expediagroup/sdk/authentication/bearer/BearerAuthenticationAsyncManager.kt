/*
 * Copyright (C) 2024 Expedia, Inc.
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

package com.expediagroup.sdk.authentication.bearer

import com.expediagroup.sdk.authentication.common.Credentials
import com.expediagroup.sdk.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.http.Response
import com.expediagroup.sdk.logging.common.LoggerDecorator
import com.expediagroup.sdk.pipeline.ExecutionPipeline
import com.expediagroup.sdk.pipeline.step.RequestHeadersStep
import com.expediagroup.sdk.pipeline.step.RequestLoggingStep
import com.expediagroup.sdk.pipeline.step.ResponseLoggingStep
import com.expediagroup.sdk.transport.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.transport.AsyncTransport
import java.util.concurrent.CompletableFuture
import org.slf4j.LoggerFactory

/**
 * Manages bearer tokens fetching, parsing, storing, and renewal.
 * This async implementation uses the injected [AsyncTransport] to make the authentication requests.
 * Typically, this async implementation should be used with async SDK calls where the [AsyncTransport] is already
 * configured and used to handle requests.
 */
class BearerAuthenticationAsyncManager(
    authUrl: String,
    credentials: Credentials,
    private val asyncTransport: AsyncTransport
) : AbstractBearerAuthenticationManager(authUrl, credentials) {

    private val requestExecutor = object : AbstractAsyncRequestExecutor(asyncTransport) {
        override val executionPipeline = ExecutionPipeline(
            requestPipeline = listOf(
                RequestHeadersStep(),
                RequestLoggingStep(logger)
            ),
            responsePipeline = listOf(
                ResponseLoggingStep(logger)
            )
        )
    }

    /**
     * Initiates authentication to obtain a new bearer token.
     *
     * This method sends a request to the authentication server, parses the response, and
     * stores the token for future use.
     */
    override fun authenticate() {
        try {
            clearAuthentication()
            executeAuthenticationRequest(buildAuthenticationRequest())
                .thenApply { TokenResponse.parse(it) }
                .thenAccept { storeToken(it) }
                .join()
        } catch (e: Exception) {
            throw ExpediaGroupAuthException(message = "Authentication Failed", cause = e)
        }
    }

    /**
     * Executes the authentication request and validates the response.
     */
    private fun executeAuthenticationRequest(request: Request): CompletableFuture<Response> {
        return requestExecutor.execute(request)
            .thenApply {
                if (it.isSuccessful) it
                else throw ExpediaGroupAuthException("Received unsuccessful authentication response: [${it.status}]")
            }
            .exceptionally {
                throw it
            }
    }

    companion object {
        private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java.enclosingClass))
    }
}
