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

package com.expediagroup.sdk.v2.lodgingconnectivity.graphql

import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Query
import com.apollographql.java.client.ApolloClient
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.v2.core.configuration.DefaultClientBuilder
import com.expediagroup.sdk.v2.core.configuration.FullClientConfiguration
import com.expediagroup.sdk.v2.core.client.ApiClientApolloHttpEngine
import com.expediagroup.sdk.v2.core.client.util.createApiClient
import com.expediagroup.sdk.v2.lodgingconnectivity.configuration.ClientConfiguration
import java.util.concurrent.CompletableFuture

class BaseGraphQLClient(configuration: FullClientConfiguration) : GraphQLExecutor {
    private val engine: ApiClientApolloHttpEngine = ApiClientApolloHttpEngine(
        createApiClient(
            configuration = configuration
        )
    )

    companion object {
        @JvmStatic
        fun builder() = ClientConfiguration.builder()
    }

    private val apolloClient: ApolloClient = ApolloClient.Builder()
        .serverUrl(configuration.getEndpoint())
        .httpEngine(engine)
        .build()

    class Builder(private val namespace: String) : DefaultClientBuilder<BaseGraphQLClient>() {
        override fun build(): BaseGraphQLClient {
            return BaseGraphQLClient(this.buildConfiguration())
        }
    }

    /**
     * Executes a GraphQL query and returns the result.
     *
     * @param query The GraphQL query to execute.
     * @return The result of the query execution, with errors handled.
     * @throws ExpediaGroupServiceException If the query execution returns errors.
     */
    override fun <T : Query.Data> execute(query: Query<T>): CompletableFuture<T> {
        val promise: CompletableFuture<T> = CompletableFuture()

        apolloClient.query(query).enqueue { response ->
            try {
                if (response.hasErrors()) {
                    // Complete exceptionally if there are GraphQL errors
                    promise.completeExceptionally(ExpediaGroupServiceException(message = response.errors.toString()))
                } else if (response.exception != null) {
                    // Complete exceptionally if there is a network or other exception
                    promise.completeExceptionally(ExpediaGroupServiceException(cause = response.exception))
                } else {
                    // Complete normally with the response data if no errors or exceptions
                    promise.complete(response.dataAssertNoErrors)
                }
            } catch (e: Exception) {
                // Handle unexpected exceptions during callback execution
                promise.completeExceptionally(ExpediaGroupServiceException(cause = e))
            }
        }

        return promise
    }


    /**
     * Executes a GraphQL mutation and returns the result.
     *
     * @param mutation The GraphQL mutation to execute.
     * @return The result of the mutation execution, with errors handled.
     * @throws ExpediaGroupServiceException If the mutation execution returns errors.
     */
    override fun <T : Mutation.Data> execute(mutation: Mutation<T>): CompletableFuture<T> {
        val promise: CompletableFuture<T> = CompletableFuture()

        apolloClient.mutation(mutation).enqueue { response ->
            try {
                if (response.hasErrors()) {
                    // Complete exceptionally if there are GraphQL errors
                    promise.completeExceptionally(ExpediaGroupServiceException(response.errors.toString()))
                } else if (response.exception != null) {
                    // Complete exceptionally if there is a network or other exception
                    promise.completeExceptionally(ExpediaGroupServiceException(cause = response.exception))
                } else {
                    // Complete normally with the response data if no errors or exceptions
                    promise.complete(response.dataAssertNoErrors)
                }
            } catch (e: Exception) {
                // Handle unexpected exceptions during callback execution
                promise.completeExceptionally(ExpediaGroupServiceException(cause = e))
            }
        }

        return promise
    }
}
