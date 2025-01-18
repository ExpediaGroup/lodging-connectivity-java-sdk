package com.expediagroup.sdk.graphql

import com.expediagroup.sdk.core.transport.Disposable

/**
 * Abstract base class for building high-level synchronous GraphQL clients.
 */
@Suppress("MemberVisibilityCanBePrivate")
abstract class GraphQLClient(
    protected val graphQLExecutor: GraphQLExecutor
) : Disposable by graphQLExecutor
