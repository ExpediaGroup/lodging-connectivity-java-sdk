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
import com.apollographql.apollo.api.Operation
import com.expediagroup.sdk.transport.AbstractRequestExecutor
import com.expediagroup.sdk.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.model.exception.NoDataException
import com.expediagroup.sdk.graphql.model.response.Error
import com.expediagroup.sdk.graphql.model.response.RawResponse

/**
 * A streamlined implementation of [GraphQLExecutor] that handles GraphQL operations with
 * error handling and response processing. This executor processes both queries and mutations
 * while providing detailed error information when operations fail.
 *
 * By default - this implementation is used internally in all higher-level clients
 *
 * @param requestExecutor used for HTTP request execution within the SDK
 * @param serverUrl GraphQL server URL
 */
class GraphQLExecutor(
    requestExecutor: AbstractRequestExecutor,
    private val serverUrl: String
) : AbstractGraphQLExecutor(requestExecutor) {

    /**
     * Executes a GraphQL operation and returns a [RawResponse] containing the complete data and any errors.
     *
     * @param operation The GraphQL operation to be executed.
     * @return A [RawResponse] with the full data structure and any errors from the server.
     * @throws [ExpediaGroupServiceException] If an exception occurs during operation execution.
     * @throws [NoDataException] If the operation completes without data but includes errors.
     */
    override fun <T : Operation.Data> execute(operation: Operation<T>): RawResponse<T> = operation
        .toSDKRequest(serverUrl).let {
            transportPipeline.execute(it)
        }.toApolloResponse(operation).let {
            processApolloResponse(it)
        }

    /**
     * Handles the response from a GraphQL operation
     *
     * @param response The ApolloResponse containing the data and errors from the GraphQL operation.
     */
    private fun <T : Operation.Data> processApolloResponse(response: ApolloResponse<T>): RawResponse<T> {
        return when {
            response.exception != null -> throw ExpediaGroupServiceException(cause = response.exception)

            response.data == null && response.hasErrors() -> throw NoDataException(
                message = "No data received from the server",
                errors = response.errors!!.map { Error.fromApolloError(it) }
            )

            else -> RawResponse(
                data = response.data!!,
                errors = response.errors?.map { Error.fromApolloError(it) }
            )
        }
    }
}
