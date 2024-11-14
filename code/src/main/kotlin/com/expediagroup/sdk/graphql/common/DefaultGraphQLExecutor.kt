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
 * Default implementation of [GraphQLExecutor], responsible for executing GraphQL queries and mutations
 * using Apollo Kotlin with a custom HTTP client.
 *
 * This executor leverages the Apollo Client to perform requests and processes responses by capturing
 * the entire data structure and any errors in a [RawResponse], which can then be further processed or
 * filtered by higher-level components in the SDK.
 *
 * By default - this implementation is used internally in all higher-level clients that extend [GraphQLClient] abstract class
 *
 * @param config Configuration details required to set up the custom client and Apollo Client.
 */
internal class DefaultGraphQLExecutor(config: ExpediaGroupClientConfiguration) : GraphQLExecutor() {

    // Custom client for handling HTTP requests and responses.
    private val expediaGroupClient =
        object : ExpediaGroupClient(clientConfiguration = config, namespace = "lodging-connectivity-sdk") {
            override suspend fun throwServiceException(response: HttpResponse, operationId: String) {
                throw ExpediaGroupServiceException("Service error occurred for operation $operationId.\nResponse: $response")
            }
        }

    /**
     * The Apollo Client used to execute GraphQL requests, configured with a custom HTTP client.
     */
    override val apolloClient: ApolloClient = ApolloClient
        .Builder()
        .serverUrl(config.endpoint!!)
        .ktorClient(expediaGroupClient.httpClient)
        .build()

    /**
     * Executes a GraphQL query and returns a [RawResponse] containing the complete data and any errors.
     *
     * @param query The GraphQL query to be executed.
     * @return A [RawResponse] with the full data structure and any errors from the server.
     * @throws ExpediaGroupServiceException If an exception occurs during query execution.
     * @throws NoDataException If the query completes without data but includes errors.
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
     * Executes a GraphQL mutation and returns a [RawResponse] containing the complete data and any errors.
     *
     * @param mutation The GraphQL mutation to be executed.
     * @return A [RawResponse] with the full data structure and any errors from the server.
     * @throws ExpediaGroupServiceException If an exception occurs during mutation execution.
     * @throws NoDataException If the mutation completes without data but includes errors.
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
