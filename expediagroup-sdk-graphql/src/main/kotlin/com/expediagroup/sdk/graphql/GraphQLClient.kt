package com.expediagroup.sdk.graphql

import com.expediagroup.sdk.core.transport.Disposable

/**
 * Abstract base class for building high-level synchronous GraphQL clients.
 */
abstract class GraphQLClient : Disposable {

    /**
     * The [GraphQLExecutor] used to execute GraphQL operations.
     *
     * This executor provides the core logic for converting operations into SDK requests,
     * sending them to the server, and processing the responses.
     */
    protected abstract val graphQLExecutor: GraphQLExecutor

    /**
     * Releases any resources associated with the client.
     */
    override fun dispose() {
        graphQLExecutor.dispose()
    }
}
