package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.graphql.common.AbstractAsyncGraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.configuration.ApiEndpoint
import com.expediagroup.sdk.core.transport.Disposable

abstract class AsyncGraphQLClient : Disposable {

    /**
     * The API endpoint that the client is configured to communicate with. Includes the primary API endpoint
     * and the authentication endpoint.
     */
    protected abstract val apiEndpoint: ApiEndpoint

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
