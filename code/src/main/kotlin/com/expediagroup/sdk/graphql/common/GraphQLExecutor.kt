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

package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Query
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.model.response.RawResponse

/**
 * Abstract base class for executing GraphQL operations.
 * Defines the core structure for executing queries and mutations using an [ApolloClient].
 *
 * Classes extending `GraphQLExecutor` are expected to provide an implementation of `apolloClient`
 * and define the behavior of the `execute` methods for handling GraphQL queries and mutations.
 */
abstract class GraphQLExecutor {

    /**
     * The Apollo Client instance used to perform GraphQL requests.
     * Subclasses must initialize this property with a configured [ApolloClient] instance.
     */
    protected abstract val apolloClient: ApolloClient

    /**
     * Executes a GraphQL query and returns the raw response.
     *
     * @param query The GraphQL query to be executed.
     * @return A [RawResponse] containing the data or errors from the query response.
     */
    abstract fun <T : Query.Data> execute(query: Query<T>): RawResponse<T>

    /**
     * Executes a GraphQL mutation and returns the raw response.
     *
     * @param mutation The GraphQL mutation to be executed.
     * @return A [RawResponse] containing the data or errors from the mutation response.
     */
    abstract fun <T : Mutation.Data> execute(mutation: Mutation<T>): RawResponse<T>
}


