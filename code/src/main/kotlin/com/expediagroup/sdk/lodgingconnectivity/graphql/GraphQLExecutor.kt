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

package com.expediagroup.sdk.lodgingconnectivity.graphql

import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Query
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse

/**
 * An interface for executing GraphQL operations, including queries, mutations, and subscriptions.
 *
 * Implementers of this interface are responsible for executing GraphQL operations and returning the results,
 * while handling any errors that may occur during the execution.
 */
interface GraphQLExecutor {

    /**
     * Executes a GraphQL query and returns the result.
     *
     * @param query The GraphQL query to execute.
     * @return The result of the query execution.
     * @param <T> The type of data returned by the query, extending `Query.Data`.
     * @throws ExpediaGroupServiceException If the query execution returns errors.
     */
    fun <T : Query.Data> execute(query: Query<T>): RawResponse<T>

    /**
     * Executes a GraphQL mutation and returns the result.
     *
     * @param mutation The GraphQL mutation to execute.
     * @return The result of the mutation execution.
     * @param <T> The type of data returned by the mutation, extending `Mutation.Data`.
     * @throws ExpediaGroupServiceException If the mutation execution returns errors.
     */
    fun <T : Mutation.Data> execute(mutation: Mutation<T>): RawResponse<T>
}

