package com.expediagroup.sdk.core.authentication.basic

import com.expediagroup.sdk.core.authentication.common.AuthenticationManager
import com.expediagroup.sdk.core.authentication.common.Credentials

class BasicAuthenticationManager(
    private val credentials: Credentials
) : AuthenticationManager {
    private var encodedCredentials: String? = null

    override fun authenticate() {
        if (encodedCredentials == null) {
            credentials.encodeBasic().also { encodedCredentials = it }
        }
    }

    override fun clearAuthentication() {
        encodedCredentials = null
    }

    fun getAuthorizationHeaderValue(): String {
        return authenticate().let { encodedCredentials ?: "" }
    }
}
