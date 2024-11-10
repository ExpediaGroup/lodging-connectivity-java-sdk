package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxCreatePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.model.CreateSandboxPropertyResponse

fun createSandboxPropertyFun(graphQLExecutor: GraphQLExecutor, input: CreatePropertyInput): CreateSandboxPropertyResponse {
    val operation = SandboxCreatePropertyMutation(input)
    val response = graphQLExecutor.execute(operation)

    return CreateSandboxPropertyResponse(
        data = response.data.createProperty.property.sandboxPropertyData,
        rawResponse = response
    )
}
