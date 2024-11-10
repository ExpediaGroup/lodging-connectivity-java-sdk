package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxDeletePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyInput

data class DeleteSandboxPropertyResponse(
    override val data: SandboxDeletePropertyMutation.DeleteProperty,
    override val rawResponse: RawResponse<SandboxDeletePropertyMutation.Data>,
) : Response<SandboxDeletePropertyMutation.DeleteProperty, SandboxDeletePropertyMutation.Data>

fun deleteSandboxPropertyFun(graphQLExecutor: GraphQLExecutor, input: DeletePropertyInput): DeleteSandboxPropertyResponse {
    val operation = SandboxDeletePropertyMutation(input)
    val response = graphQLExecutor.execute(operation)

    return DeleteSandboxPropertyResponse(
        data = response.data.deleteProperty,
        rawResponse = response
    )
}
