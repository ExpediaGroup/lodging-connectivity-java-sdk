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

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Query
import com.apollographql.ktor.ktorClient
import com.expediagroup.sdk.core.client.ExpediaGroupClient
import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.toSDKError
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.exception.NoDataException
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

/**
 * An internal base implementation of a GraphQL client for executing GraphQL queries, mutations, and subscriptions.
 *
 * This class integrates the Apollo GraphQL client with a custom `ExpediaGroupClient` for handling HTTP communication
 * and error management. It provides a foundation for more specific client implementations by executing operations
 * with error handling.
 *
 * @param config The configuration for the `ExpediaGroupClient`
 */
internal class BaseGraphQLClient(config: ExpediaGroupClientConfiguration) : GraphQLExecutor {

    // Custom client for handling HTTP requests and responses.
    private val expediaGroupClient =
        object : ExpediaGroupClient(clientConfiguration = config, namespace = "lodging-connectivity-sdk") {
            override suspend fun throwServiceException(response: HttpResponse, operationId: String) {
                throw ExpediaGroupServiceException("Service error occurred for operation $operationId.\nResponse: $response")
            }
        }

    private val apolloClient: ApolloClient = ApolloClient.Builder()
        .serverUrl(config.endpoint!!)
        .ktorClient(expediaGroupClient.httpClient)

        .build()

    /**
     * Executes a GraphQL query and returns the result.
     *
     * @param query The GraphQL query to execute.
     * @return The result of the query execution, with errors handled.
     * @throws ExpediaGroupServiceException If the query execution returns errors.
     */
    override fun <T : Query.Data> execute(query: Query<T>): RawResponse<T> {
        return runBlocking {
            apolloClient.query(query).execute().apply {
                if (exception != null) {
                    throw ExpediaGroupServiceException(message = exception?.message, cause = exception)
                }
                if (data == null && hasErrors()) {
                    throw NoDataException(
                        message = "No data received from the server",
                        errors = errors!!.map { it.toSDKError() })
                }
            }.let {
                RawResponse(
                    data = it.data!!,
                    errors = it.errors?.map { apolloError -> apolloError.toSDKError() }
                )
            }
        }
    }

    /**
     * Executes a GraphQL mutation and returns the result.
     *
     * @param mutation The GraphQL mutation to execute.
     * @return The result of the mutation execution, with errors handled.
     * @throws ExpediaGroupServiceException If the mutation execution returns errors.
     */
    override fun <T : Mutation.Data> execute(mutation: Mutation<T>): RawResponse<T> {
        return runBlocking {
            apolloClient.mutation(mutation).execute().apply {
                if (exception != null) {
                    throw ExpediaGroupServiceException(message = exception?.message, cause = exception)
                }
                if (data == null && hasErrors()) {
                    throw NoDataException(
                        message = "No data received from the server",
                        errors = errors!!.map { it.toSDKError() })
                }
            }.let {
                RawResponse(
                    data = it.data!!,
                    errors = it.errors?.map { apolloError -> apolloError.toSDKError() }
                )
            }
        }
    }
}

