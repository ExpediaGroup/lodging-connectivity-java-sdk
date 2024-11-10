package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertyQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.model.SandboxPropertyResponse

fun getSandboxPropertyFun(graphQLExecutor: GraphQLExecutor, propertyId: String): SandboxPropertyResponse {
    val operation = SandboxPropertyQuery(propertyId)
    val response = graphQLExecutor.execute(operation)

    return SandboxPropertyResponse(
        data = response.data.property.sandboxPropertyData,
        rawResponse = response,
    )
}
