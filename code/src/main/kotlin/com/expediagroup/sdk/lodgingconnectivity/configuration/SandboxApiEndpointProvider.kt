package com.expediagroup.sdk.lodgingconnectivity.configuration

class SandboxApiEndpointProvider private constructor() {
    companion object {
        @JvmStatic
        fun forEnvironment(environment: ClientEnvironment): ClientEndpoint {
            return ClientEndpoint(
                endpoint = EndpointProvider.getSandboxApiEndpoint(environment),
                authEndpoint = EndpointProvider.getAuthEndpoint(environment)
            )
        }
    }
}
