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
 * Abstract base class for executing GraphQL operations, providing a structure for executing queries and mutations
 * and returning the full response data along with any errors.
 *
 * This class is designed to handle the execution of GraphQL operations and return a [RawResponse] containing
 * the complete, unprocessed data and error details. Subclasses should implement specific behaviors for how
 * requests are sent and processed.
 */
abstract class GraphQLExecutor {

    /**
     * The Apollo Client instance used to perform GraphQL requests.
     * Subclasses must initialize this property with a configured [ApolloClient] instance.
     */
    protected abstract val apolloClient: ApolloClient

    /**
     * Executes a GraphQL query and returns the complete raw response.
     *
     * @param query The GraphQL query to be executed.
     * @return A [RawResponse] containing the full data and any errors from the query response.
     * @throws ExpediaGroupServiceException If an exception occurs during the execution of the query.
     * @throws NoDataException If the query completes without data but includes errors.
     */
    abstract fun <T : Query.Data> execute(query: Query<T>): RawResponse<T>

    /**
     * Executes a GraphQL mutation and returns the complete raw response.
     *
     * @param mutation The GraphQL mutation to be executed.
     * @return A [RawResponse] containing the full data and any errors from the mutation response.
     * @throws ExpediaGroupServiceException If an exception occurs during the execution of the mutation.
     * @throws NoDataException If the mutation completes without data but includes errors.
     */
    abstract fun <T : Mutation.Data> execute(mutation: Mutation<T>): RawResponse<T>
}


