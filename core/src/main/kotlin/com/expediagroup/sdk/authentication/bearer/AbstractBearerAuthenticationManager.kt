package com.expediagroup.sdk.authentication.bearer

import com.expediagroup.sdk.authentication.common.AuthenticationManager
import com.expediagroup.sdk.authentication.common.Credentials
import com.expediagroup.sdk.http.CommonMediaTypes
import com.expediagroup.sdk.http.Method
import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.http.RequestBody

abstract class AbstractBearerAuthenticationManager(
    private val authUrl: String,
    protected val credentials: Credentials
) : AuthenticationManager {

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
    fun buildAuthenticationRequest(): Request = run {
        Request.Builder()
            .url(authUrl)
            .method(Method.POST)
            .body(RequestBody.create(mapOf("grant_type" to "client_credentials")))
            .setHeader("Authorization", credentials.encodeBasic())
            .setHeader("Content-Type", CommonMediaTypes.APPLICATION_FORM_URLENCODED.toString())
            .build()
    }

    /**
     * Stores the retrieved token in internal storage for subsequent use.
     *
     * @param tokenResponse The [TokenResponse] containing the token and its expiration time.
     */
    fun storeToken(tokenResponse: TokenResponse) = run {
        bearerTokenStorage = BearerTokenStorage.create(
            accessToken = tokenResponse.accessToken,
            expiresIn = tokenResponse.expiresIn
        )
    }
}
