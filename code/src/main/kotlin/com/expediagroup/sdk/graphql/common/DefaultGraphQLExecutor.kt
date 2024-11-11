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
import com.apollographql.ktor.ktorClient
import com.expediagroup.sdk.core.client.ExpediaGroupClient
import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.extension.toSDKError
import com.expediagroup.sdk.graphql.model.exception.NoDataException
import com.expediagroup.sdk.graphql.model.response.RawResponse
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking


/**
 * Default implementation of a GraphQLExecutor that handles executing GraphQL queries and mutations.
 * It uses ApolloClient for communication with the GraphQL server.
 *
 * @param config The configuration for the ExpediaGroupClient.
 */
internal class DefaultGraphQLExecutor(config: ExpediaGroupClientConfiguration) : GraphQLExecutor() {

    // Custom client for handling HTTP requests and responses.
    private val expediaGroupClient =
        object : ExpediaGroupClient(clientConfiguration = config, namespace = "lodging-connectivity-sdk") {
            override suspend fun throwServiceException(response: HttpResponse, operationId: String) {
                throw ExpediaGroupServiceException("Service error occurred for operation $operationId.\nResponse: $response")
            }
        }

    override val apolloClient: ApolloClient = ApolloClient
        .Builder()
        .serverUrl(config.endpoint!!)
        .ktorClient(expediaGroupClient.httpClient)
        .build()

    /**
     * Executes a GraphQL query and returns the result.
     *
     * @param query The GraphQL query to execute.
     * @return The raw response containing the fetched data and potential errors.
     * @param T The type of data returned by the query, extending `Query.Data`.
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
     * Executes a GraphQL mutation and returns the raw response containing the fetched data and potential errors.
     *
     * @param mutation The mutation to execute.
     * @return RawResponse containing the data and errors, if any.
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

