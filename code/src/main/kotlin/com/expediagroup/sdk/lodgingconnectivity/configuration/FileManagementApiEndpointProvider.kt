package com.expediagroup.sdk.lodgingconnectivity.configuration

/**
 * Provides needed endpoints for EG lodging connectivity File Management API, configured based on the specified client environment.
 */
class FileManagementApiEndpointProvider private constructor() {
    companion object {
        /**
         * Returns an [ApiEndpoint] configured for the specified environment.
         *
         * This method selects the appropriate API and authentication endpoints based on the given
         * [ClientEnvironment] to ensure compatibility with different environments (e.g., PROD, TEST).
         *
         * @param environment The [ClientEnvironment] specifying the target environment (e.g., PROD, TEST).
         * @return An [ApiEndpoint] containing the appropriate endpoints for the specified environment.
         */
        @JvmStatic
        fun forEnvironment(environment: ClientEnvironment): ApiEndpoint {
            return ApiEndpoint(
                endpoint = EndpointProvider.getFileManagementClientEndpoint(environment),
                authEndpoint = EndpointProvider.getAuthEndpoint(environment)
            )
        }
    }
}
