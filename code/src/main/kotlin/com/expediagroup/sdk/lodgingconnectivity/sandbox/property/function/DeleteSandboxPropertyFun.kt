package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxDeletePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.model.DeleteSandboxPropertyResponse

fun deleteSandboxPropertyFun(graphQLExecutor: GraphQLExecutor, input: DeletePropertyInput): DeleteSandboxPropertyResponse {
    val operation = SandboxDeletePropertyMutation(input)
    val response = graphQLExecutor.execute(operation)

    return DeleteSandboxPropertyResponse(
        data = response.data.deleteProperty,
        rawResponse = response
    )
}
