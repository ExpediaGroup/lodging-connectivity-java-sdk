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

import com.apollographql.apollo.api.ApolloResponse
import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.Query
import com.apollographql.java.client.ApolloClient
import com.expediagroup.sdk.core.client.RequestExecutor
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.model.exception.NoDataException
import com.expediagroup.sdk.graphql.model.response.Error
import com.expediagroup.sdk.graphql.model.response.RawResponse
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException

/**
 * A streamlined implementation of [GraphQLExecutor] that handles GraphQL operations with
 * error handling and response processing. This executor processes both queries and mutations
 * while providing detailed error information when operations fail.
 *
 * This executor leverages the Apollo Client to perform requests and processes responses by capturing
 * the entire data structure and any errors in a [RawResponse], which can then be further processed or
 * filtered by higher-level components in the SDK.
 *
 * By default - this implementation is used internally in all higher-level clients that extend [GraphQLClient] abstract class
 *
 * @param requestExecutor used for HTTP request execution within the SDK
 * @param serverUrl GraphQL server URL
 */
internal class DefaultGraphQLExecutor(
    requestExecutor: RequestExecutor,
    serverUrl: String
) : GraphQLExecutor(requestExecutor) {

    /**
     * The Apollo Client used to execute GraphQL requests, configured with a custom HTTP client.
     */
    override val apolloClient: ApolloClient = ApolloClient.Builder()
        .serverUrl(serverUrl)
        .httpEngine(ApolloHttpEngine(requestExecutor))
        .build()

    /**
     * Asynchronously executes a GraphQL query and returns a [CompletableFuture] containing the complete
     * data and any errors wrapped in [RawResponse].
     *
     * @param query The GraphQL query to be executed.
     * @return A [CompletableFuture] with the full data structure and any errors from the server.
     * @throws [ExpediaGroupServiceException] If an exception occurs during query execution.
     * @throws [NoDataException] If the query completes without data but includes errors.
     */
    override fun <T : Query.Data> executeAsync(query: Query<T>): CompletableFuture<RawResponse<T>> {
        return CompletableFuture<RawResponse<T>>().also {
            apolloClient.query(query).enqueue { response -> processOperationResponse(response, it) }
        }
    }

    /**
     * Executes a GraphQL query and returns a [RawResponse] containing the complete data and any errors.
     *
     * @param query The GraphQL query to be executed.
     * @return A [RawResponse] with the full data structure and any errors from the server.
     * @throws [ExpediaGroupServiceException] If an exception occurs during query execution.
     * @throws [NoDataException] If the query completes without data but includes errors.
     */
    override fun <T : Query.Data> execute(query: Query<T>): RawResponse<T> {
        return executeAsync(query).getOrThrowDomainException()
    }

    /**
     * Asynchronously executes a GraphQL mutation and returns a [CompletableFuture] containing the complete
     * data and any errors wrapped in [RawResponse].
     *
     * @param mutation The GraphQL mutation to be executed.
     * @return A [CompletableFuture] with the full data structure and any errors from the server.
     * @throws [ExpediaGroupServiceException] If an exception occurs during mutation execution.
     * @throws [NoDataException] If the mutation completes without data but includes errors.
     */
    override fun <T : Mutation.Data> executeAsync(mutation: Mutation<T>): CompletableFuture<RawResponse<T>> {
        return CompletableFuture<RawResponse<T>>().also {
            apolloClient.mutation(mutation).enqueue { response -> processOperationResponse(response, it) }
        }
    }

    /**
     * Executes a GraphQL mutation and returns a [RawResponse] containing the complete data and any errors.
     *
     * @param mutation The GraphQL mutation to be executed.
     * @return A [RawResponse] with the full data structure and any errors from the server.
     * @throws [ExpediaGroupServiceException] If an exception occurs during mutation execution.
     * @throws [NoDataException] If the mutation completes without data but includes errors.
     */
    override fun <T : Mutation.Data> execute(mutation: Mutation<T>): RawResponse<T> {
        return executeAsync(mutation).getOrThrowDomainException()
    }

    /**
     * Handles the response from a GraphQL operation, determining whether to complete the provided CompletableFuture
     * with either success or an exception based on the response data and errors.
     *
     * @param response The ApolloResponse containing the data and errors from the GraphQL operation.
     * @param future A CompletableFuture that will be completed based on the response handling logic.
     */
    private fun <T : Operation.Data> processOperationResponse(
        response: ApolloResponse<T>,
        future: CompletableFuture<RawResponse<T>>
    ) {
        try {
            when {
                response.exception != null -> future.completeExceptionally(
                    ExpediaGroupServiceException(
                        cause = response.exception
                    )
                )

                response.data == null && response.hasErrors() -> future.completeExceptionally(
                    NoDataException(
                        message = "No data received from the server",
                        errors = response.errors!!.map { Error.fromApolloError(it) }
                    )
                )

                else -> future.complete(
                    RawResponse(
                        data = response.data!!,
                        errors = response.errors?.map { Error.fromApolloError(it) }
                    )
                )
            }
        } catch (e: Exception) {
            future.completeExceptionally(
                ExpediaGroupServiceException(
                    message = e.message,
                    cause = e
                )
            )
        }
    }

    private fun <T> CompletableFuture<T>.getOrThrowDomainException(): T {
        return try {
            this.get()
        } catch (e: ExecutionException) {
            when (e.cause) {
                is NoDataException -> throw e.cause as NoDataException
                is ExpediaGroupServiceException -> throw e.cause as ExpediaGroupServiceException
                else -> throw e
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
            throw ExpediaGroupServiceException("Interrupted while waiting for response", e)
        }
    }
}
