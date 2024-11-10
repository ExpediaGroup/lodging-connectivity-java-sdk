package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxUpdatePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.model.UpdateSandboxPropertyResponse

fun updateSandboxPropertyFun(graphQLExecutor: GraphQLExecutor, input: UpdatePropertyInput): UpdateSandboxPropertyResponse {
    val operation = SandboxUpdatePropertyMutation(input)
    val response = graphQLExecutor.execute(operation)

    return UpdateSandboxPropertyResponse(
        data = response.data.updateProperty.property.sandboxPropertyData,
        rawResponse = response
    )
}
