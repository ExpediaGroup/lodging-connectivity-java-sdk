package com.expediagroup.sdk.v2.core.configuration

import com.expediagroup.sdk.core.constant.Constant
import com.expediagroup.sdk.v2.core.trait.configuration.*

object ExpediaGroupDefaultClientConfiguration :
    EndpointTrait,
    AuthEndpointTrait,
    RequestTimeoutTrait,
    ClientConfigurationTrait,
    SocketTimeoutTrait,
    ConnectionTimeoutTrait {

    override fun getEndpoint(): String = "https://api.expediagroup.com/"
    override fun getAuthEndpoint(): String = "${getEndpoint()}identity/oauth2/v3/token/"
    override fun getRequestTimeout(): Long = Constant.INFINITE_TIMEOUT
    override fun getConnectionTimeout(): Long = Constant.TEN_SECONDS_IN_MILLIS
    override fun getSocketTimeout(): Long = Constant.FIFTEEN_SECONDS_IN_MILLIS
}