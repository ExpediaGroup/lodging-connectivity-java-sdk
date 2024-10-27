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

package com.expediagroup.sdk.v2.lodgingconnectivity.graphql.supply

import com.expediagroup.sdk.v2.lodgingconnectivity.configuration.EndpointProvider
import com.expediagroup.sdk.v2.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.lodgingconnectivity.graphql.BaseGraphQLClient
import com.expediagroup.sdk.v2.lodgingconnectivity.graphql.GraphQLExecutor

/**
 * A client for interacting with EG Lodging Connectivity Supply GraphQL API that exposes various lodging capabilities
 * such as reservations, promotions, reviews, notifications, messaging, etc...
 *
 * This client is configured with a `ClientConfiguration` that includes authentication details,
 * and it automatically determines the appropriate API endpoints based on the environment (e.g., production or test).
 *
 * In addition, this client can be configured to target the sandbox environment by passing `ClientEnvironment.SANDBOX_PROD` or
 * `ClientEnvironment.SANDBOX_TEST` to the `environment` configuration option.
 *
 * @constructor Creates a new instance of `SupplyClient` using the provided configuration.
 * @param config The `ClientConfiguration` that includes API credentials and other optional parameters such as environment,
 * timeouts, and logging masking options.
 *
 * Example usage:
 * ```
 * SupplyClient(
 *     ClientConfiguration
 *         .builder()
 *         .key("API_KEY")
 *         .secret("API_SECRET")
 *         .build()
 * )
 * ```
 */
class SupplyClient(config: ClientConfiguration) :
   GraphQLExecutor by BaseGraphQLClient(
       config.toFullClientConfiguration(
           endpointProvider = EndpointProvider::getSupplyClientEndpoint,
           authEndpointProvider = EndpointProvider::getAuthEndpoint
       ),
       namespace = "lodging-connectivity-sdk"
   )
