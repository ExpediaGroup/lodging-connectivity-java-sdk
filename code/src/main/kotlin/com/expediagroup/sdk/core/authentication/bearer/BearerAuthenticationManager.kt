package com.expediagroup.sdk.core.authentication.bearer

import com.expediagroup.sdk.core.authentication.common.AuthenticationManager
import com.expediagroup.sdk.core.authentication.common.Credentials
import com.expediagroup.sdk.core.client.AbstractRequestExecutor
import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupAuthException
import java.util.concurrent.CompletableFuture

class BearerAuthenticationManager(
    val authUrl: String,
    private val credentials: Credentials,
    private val requestExecutor: AbstractRequestExecutor
) : AuthenticationManager {

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

    @Volatile
    private var bearerTokenStorage = BearerTokenStorage.empty

    /**
     * Checks if the current bearer token is about to expire and needs renewal.
     *
     * @return `true` if the token is near expiration, `false` otherwise.
     */
    fun isTokenAboutToExpire(): Boolean = run {
        bearerTokenStorage.isAboutToExpire()
    }

    /**
     * Clears the stored authentication token.
     *
     * This method resets the internal token storage, effectively invalidating the current session.
     */
    override fun clearAuthentication() = run {
        bearerTokenStorage = BearerTokenStorage.empty
    }

    /**
     * Retrieves the stored token formatted as an `Authorization` header value.
     *
     * @return The token in the format `Bearer <token>` for use in HTTP headers.
     */
    fun getAuthorizationHeaderValue(): String = run {
        bearerTokenStorage.getAuthorizationHeaderValue()
    }

    /**
     * Creates an HTTP request to fetch a new bearer token from the authentication server.
     *
     * @return A [Request] object configured with the necessary headers and parameters.
     */
    private fun buildAuthenticationRequest(): Request = run {
        Request.Builder()
            .url(authUrl)
            .method(Method.POST)
            .body(RequestBody.create(mapOf("grant_type" to "client_credentials")))
            .setHeader("Authorization", credentials.encodeBasic())
            .setHeader("Content-Type", CommonMediaTypes.APPLICATION_FORM_URLENCODED.toString())
            .build()
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

    /**
     * Stores the retrieved token in internal storage for subsequent use.
     *
     * @param tokenResponse The [TokenResponse] containing the token and its expiration time.
     */
    private fun storeToken(tokenResponse: TokenResponse) = run {
        bearerTokenStorage = BearerTokenStorage.create(
            accessToken = tokenResponse.accessToken,
            expiresIn = tokenResponse.expiresIn
        )
    }
}
