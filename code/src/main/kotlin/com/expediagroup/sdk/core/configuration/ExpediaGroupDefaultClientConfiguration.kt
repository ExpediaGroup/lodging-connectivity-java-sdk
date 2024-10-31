package com.expediagroup.sdk.core.configuration

import com.expediagroup.sdk.core.constant.Constant
import com.expediagroup.sdk.core.authentication.strategy.AuthenticationStrategy

/**
 * Implementation of `FullClientConfiguration` that provides default configuration values for the Expedia Group API client.
 *
 * This object acts as the default configuration and returns preset values for various configuration traits needed
 * to interact with the Expedia Group API.
 */
object ExpediaGroupDefaultClientConfiguration :
    FullClientConfiguration {

    override fun getKey(): String {
        throw NotImplementedError("Not implemented")
    }

    override fun getSecret(): String {
        throw NotImplementedError("Not implemented")
    }

    override fun getEndpoint(): String = "https://api.expediagroup.com/"
    override fun getAuthEndpoint(): String = "${getEndpoint()}identity/oauth2/v3/token/"
    override fun getAuthenticationStrategy(): AuthenticationStrategy = AuthenticationStrategy.BEARER
    override fun getRequestTimeout(): Long = Constant.INFINITE_TIMEOUT
    override fun getConnectionTimeout(): Long = Constant.TEN_SECONDS_IN_MILLIS
    override fun getSocketTimeout(): Long = Constant.FIFTEEN_SECONDS_IN_MILLIS
    override fun getMaxConnectionsTotal(): Int = Constant.MAX_CONNECTIONS_TOTAL
    override fun getMaxConnectionsPerRoute(): Int = Constant.MAX_CONNECTIONS_PER_ROUTE
    override fun getMaskedLoggingHeaders(): Set<String> = setOf("Authorization")
    override fun getMaskedLoggingBodyFields(): Set<String> = setOf(
        "cvv",
        "pin",
        "card_cvv",
        "card_cvv2",
        "card_number",
        "access_token",
        "security_code",
        "account_number",
        "card_avs_response",
        "card_cvv_response",
        "card_cvv2_response",
    )
}
