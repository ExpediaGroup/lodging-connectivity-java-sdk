package com.expediagroup.sdk.lodgingconnectivity.configuration

class SupplyApiEndpointProvider private constructor() {
    companion object {
        @JvmStatic
        fun forEnvironment(environment: ClientEnvironment): ClientEndpoint {
            return ClientEndpoint(
                endpoint = EndpointProvider.getSupplyApiEndpoint(environment),
                authEndpoint = EndpointProvider.getAuthEndpoint(environment)
            )
        }
    }
}
