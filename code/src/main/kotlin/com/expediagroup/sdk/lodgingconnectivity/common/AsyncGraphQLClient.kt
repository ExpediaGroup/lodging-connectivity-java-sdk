package com.expediagroup.sdk.lodgingconnectivity.common

import com.expediagroup.sdk.core.client.Disposable
import com.expediagroup.sdk.graphql.common.AbstractAsyncGraphQLExecutor
import com.expediagroup.sdk.graphql.common.AbstractGraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.configuration.ApiEndpoint

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
     * Closes the underlying [AbstractGraphQLExecutor] by calling [AbstractGraphQLExecutor.dispose]
     */
    override fun dispose() {
        asyncGraphQLExecutor.dispose()
    }
}
