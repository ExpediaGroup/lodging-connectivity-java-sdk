package com.expediagroup.sdk.authentication.bearer

import com.expediagroup.sdk.authentication.common.Credentials
import com.expediagroup.sdk.pipeline.step.RequestHeadersStep
import com.expediagroup.sdk.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.http.Response
import com.expediagroup.sdk.pipeline.step.RequestLoggingStep
import com.expediagroup.sdk.pipeline.step.ResponseLoggingStep
import com.expediagroup.sdk.logging.common.LoggerDecorator
import com.expediagroup.sdk.transport.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.transport.AsyncTransport
import com.expediagroup.sdk.pipeline.ExecutionPipeline
import java.util.concurrent.CompletableFuture
import org.slf4j.LoggerFactory

class BearerAuthenticationAsyncManager(
    authUrl: String,
    credentials: Credentials,
    private val asyncTransport: AsyncTransport
) : AbstractBearerAuthenticationManager(authUrl, credentials) {

    private val requestExecutor = object : AbstractAsyncRequestExecutor(asyncTransport) {
        override val executionPipeline: ExecutionPipeline = ExecutionPipeline(
            requestPipeline = listOf(
                RequestHeadersStep(),
                RequestLoggingStep(logger)
            ),
            responsePipeline = listOf(
                ResponseLoggingStep(logger)
            )
        )
    }

    override fun authenticate() {
        clearAuthentication()
            .let {
                buildAuthenticationRequest()
            }.let {
                executeAuthenticationRequest(it).join()
            }.let {
                TokenResponse.parse(it)
            }.also {
                storeToken(it)
            }
    }

    /**
     * Executes the authentication request and validates the response.
     *
     * @param request The [Request] object to be executed.
     * @return The [Response] received from the server.
     * @throws ExpediaGroupAuthException If the server responds with an error.
     */
    private fun executeAuthenticationRequest(request: Request): CompletableFuture<Response> = run {
        return requestExecutor.execute(request).thenApply {
            if (!it.isSuccessful) {
                throw ExpediaGroupAuthException(it.status, "Authentication failed")
            }
            it
        }
    }

    companion object {
        private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java.enclosingClass))
    }
}
