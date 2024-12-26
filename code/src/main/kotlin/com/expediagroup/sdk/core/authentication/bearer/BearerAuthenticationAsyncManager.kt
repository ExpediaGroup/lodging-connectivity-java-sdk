package com.expediagroup.sdk.core.authentication.bearer

import com.expediagroup.sdk.core.authentication.common.Credentials
import com.expediagroup.sdk.core.client.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException
import java.util.concurrent.CompletableFuture

class BearerAuthenticationAsyncManager(
    authUrl: String,
    credentials: Credentials,
    private val asyncRequestExecutor: AbstractAsyncRequestExecutor
) : AbstractBearerAuthenticationManager(authUrl, credentials) {

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
        return asyncRequestExecutor.execute(request).thenApply {
            if (!it.isSuccessful) {
                throw ExpediaGroupAuthException(it.status, "Authentication failed")
            }
            it
        }
    }
}
