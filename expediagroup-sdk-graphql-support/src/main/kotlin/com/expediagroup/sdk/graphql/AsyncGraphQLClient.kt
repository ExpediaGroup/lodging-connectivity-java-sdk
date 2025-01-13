package com.expediagroup.sdk.graphql

import com.expediagroup.sdk.core.transport.Disposable

abstract class AsyncGraphQLClient : Disposable {
    /**
     * The executor responsible for handling GraphQL operations.
     * Subclasses must provide a concrete implementation of this executor to define
     * how queries and mutations are processed.
     */
    protected abstract val asyncGraphQLExecutor: AbstractAsyncGraphQLExecutor

    /**
     * Closes the underlying [AbstractAsyncGraphQLExecutor] by calling [AbstractAsyncGraphQLExecutor.dispose]
     */
    override fun dispose() {
        asyncGraphQLExecutor.dispose()
    }
}
