package com.expediagroup.sdk.lodgingconnectivity.configuration

class PaymentApiEndpointProvider private constructor() {
    companion object {
        @JvmStatic
        fun forEnvironment(environment: ClientEnvironment): ApiEndpoint {
            return ApiEndpoint(
                endpoint = EndpointProvider.getPaymentApiEndpoint(environment),
                authEndpoint = EndpointProvider.getAuthEndpoint(environment)
            )
        }
    }
}
