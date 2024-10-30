package com.expediagroup.sdk.lodgingconnectivity.graphql.common

abstract class GraphQLClient {
    protected abstract val graphqlExecutor: GraphQLExecutor

    abstract fun getInternalGraphQLExecutor(): GraphQLExecutor
}
