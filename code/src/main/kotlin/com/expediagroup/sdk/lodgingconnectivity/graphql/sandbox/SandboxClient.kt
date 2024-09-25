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

package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox

import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.EndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.graphql.BaseGraphQLClient
import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor

class SandboxClient(config: ClientConfiguration):
    GraphQLExecutor by BaseGraphQLClient(
        config.toExpediaGroupClientConfiguration(
            endpointProvider = EndpointProvider::getSandboxClientEndpoint,
            authEndpointProvider = EndpointProvider::getAuthEndpoint
        ),
        "lodging-supply"
    )
