/*
 * Copyright (C) 2024 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.lodgingconnectivity.configuration

/**
 * Provides needed endpoints for EG lodging connectivity Payment GraphQL API, configured based on the specified client environment.
 */
class PaymentApiEndpointProvider private constructor() {
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
                endpoint = EndpointProvider.getPaymentApiEndpoint(environment),
                authEndpoint = EndpointProvider.getAuthEndpoint(environment)
            )
        }
    }
}
