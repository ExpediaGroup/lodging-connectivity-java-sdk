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

package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.core.client.Disposable
import com.expediagroup.sdk.graphql.common.AbstractGraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.configuration.ApiEndpoint

/**
 * Abstract base class for GraphQL clients that defines the core structure for executing GraphQL operations.
 * Classes extending `GraphQLClient` are expected to provide an implementation of the [AbstractGraphQLExecutor].
 *
 * This design allows subclasses to define custom logic for executing GraphQL queries and mutations
 * while relying on the `graphQLExecutor` to perform the actual request handling.
 */
abstract class GraphQLClient : Disposable {

    /**
     * The API endpoint that the client is configured to communicate with. Includes the primary API endpoint
     * and the authentication endpoint.
     */
    protected abstract val apiEndpoint: ApiEndpoint

    /**
     * The executor responsible for handling GraphQL operations.
     * Subclasses must provide a concrete implementation of this executor to define
     * how queries and mutations are processed.
     */
    protected abstract val graphQLExecutor: AbstractGraphQLExecutor

    /**
     * Closes the underlying [AbstractGraphQLExecutor] by calling [AbstractGraphQLExecutor.dispose]
     */
    override fun dispose() {
        graphQLExecutor.dispose()
    }
}
