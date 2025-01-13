package com.expediagroup.sdk.graphql

import com.expediagroup.sdk.core.transport.Disposable

/**
 * Abstract base class for GraphQL clients that defines the core structure for executing GraphQL operations.
 * Classes extending `GraphQLClient` are expected to provide an implementation of the [AbstractGraphQLExecutor].
 *
 * This design allows subclasses to define custom logic for executing GraphQL queries and mutations
 * while relying on the `graphQLExecutor` to perform the actual request handling.
 */
abstract class GraphQLClient : Disposable {
    /**
     * The executor responsible for handling GraphQL operations.
     * Subclasses must provide a concrete implementation of this executor to define
     * how queries and mutations are processed.
     */
    protected abstract val graphQLExecutor: AbstractGraphQLExecutor

    /**
     * Closes the underlying [AbstractGraphQLExecutor] by calling [AbstractGraphQLExecutor.dispose]
     */
    override fun dispose() {
        graphQLExecutor.dispose()
    }
}
