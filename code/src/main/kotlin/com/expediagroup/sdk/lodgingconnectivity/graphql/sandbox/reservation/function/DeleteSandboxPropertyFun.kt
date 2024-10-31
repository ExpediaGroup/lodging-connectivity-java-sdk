package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxDeletePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeletePropertyInput

data class DeleteSandboxPropertyResponse(
    override val data: SandboxDeletePropertyMutation.DeleteProperty,
    override val rawResponse: RawResponse<SandboxDeletePropertyMutation.Data>,
) : Response<SandboxDeletePropertyMutation.DeleteProperty, SandboxDeletePropertyMutation.Data>

fun deleteSandboxPropertyFun(client: GraphQLExecutor, input: DeletePropertyInput): DeleteSandboxPropertyResponse {
    val operation = SandboxDeletePropertyMutation(input)
    val response = client.execute(operation)

    return DeleteSandboxPropertyResponse(
        data = response.data.deleteProperty,
        rawResponse = response
    )
}
