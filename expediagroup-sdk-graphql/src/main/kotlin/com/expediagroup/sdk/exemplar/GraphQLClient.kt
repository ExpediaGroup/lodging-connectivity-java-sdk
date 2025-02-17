package com.expediagroup.sdk.exemplar

import com.expediagroup.sdk.core.transport.Disposable

/**
 * Abstract base class for building high-level synchronous GraphQL clients.
 */
abstract class GraphQLClient : Disposable {
    protected abstract val graphQLExecutor: GraphQLExecutor

    override fun dispose() {
        graphQLExecutor.dispose()
    }
}
