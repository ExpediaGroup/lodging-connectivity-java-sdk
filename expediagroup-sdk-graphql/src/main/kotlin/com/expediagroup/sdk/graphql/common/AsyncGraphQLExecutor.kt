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
import com.expediagroup.sdk.core.transport.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.model.exception.NoDataException
import com.expediagroup.sdk.graphql.model.response.Error
import com.expediagroup.sdk.graphql.model.response.RawResponse
import java.util.concurrent.CompletableFuture

class AsyncGraphQLExecutor(
    asyncRequestExecutor: AbstractAsyncRequestExecutor,
    private val serverUrl: String
) : AbstractAsyncGraphQLExecutor(asyncRequestExecutor) {

    override fun <T : Operation.Data> execute(operation: Operation<T>): CompletableFuture<RawResponse<T>> {
        val future = CompletableFuture<RawResponse<T>>()

        asyncRequestExecutor.execute(operation.toSDKRequest(serverUrl))
            .thenApply { response ->
                processOperationResponse(response.toApolloResponse(operation), future)
            }.exceptionally { throwable ->
                future.completeExceptionally(throwable)
            }

        return future
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
}
