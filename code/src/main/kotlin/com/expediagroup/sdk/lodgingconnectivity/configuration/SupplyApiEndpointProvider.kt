package com.expediagroup.sdk.lodgingconnectivity.configuration

class SupplyApiEndpointProvider private constructor() {
    companion object {
        @JvmStatic
        fun forEnvironment(environment: ClientEnvironment): ApiEndpoint {
            return ApiEndpoint(
                endpoint = EndpointProvider.getSupplyApiEndpoint(environment),
                authEndpoint = EndpointProvider.getAuthEndpoint(environment)
            )
        }
    }
}
