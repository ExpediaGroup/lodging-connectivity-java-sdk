package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.Operation
import com.expediagroup.sdk.core.client.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.core.client.Disposable
import com.expediagroup.sdk.graphql.model.response.RawResponse
import java.util.concurrent.CompletableFuture

abstract class GraphQLAsyncExecutor(
    protected val asyncRequestExecutor: AbstractAsyncRequestExecutor
) : Disposable {

    abstract fun <T : Operation.Data> execute(operation: Operation<T>): CompletableFuture<RawResponse<T>>

    override fun dispose() {
        asyncRequestExecutor.dispose()
    }
}