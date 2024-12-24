package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.Operation
import com.expediagroup.sdk.core.client.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import java.util.concurrent.CompletableFuture

class DefaultGraphQLAsyncExecutor(
    asyncRequestExecutor: AbstractAsyncRequestExecutor,
    private val serverUrl: String
) : GraphQLAsyncExecutor(asyncRequestExecutor) {

    override fun <T : Operation.Data> execute(operation: Operation<T>): CompletableFuture<RawResponse<T>> {
        return asyncRequestExecutor.execute(operation.toSDKRequest(serverUrl)).thenApply { response ->
            val apolloResponse = response.toApolloResponse(operation)
            RawResponse(
                data = apolloResponse.data!!,
                errors = emptyList()
            )
        }
    }
}