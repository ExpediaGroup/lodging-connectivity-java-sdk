package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxUpdatePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdatePropertyInput

data class UpdateSandboxPropertyResponse(
    override val data: SandboxPropertyData,
    override val rawResponse: RawResponse<SandboxUpdatePropertyMutation.Data>,
) : Response<SandboxPropertyData, SandboxUpdatePropertyMutation.Data>

fun updateSandboxPropertyFun(graphQLExecutor: GraphQLExecutor, input: UpdatePropertyInput): UpdateSandboxPropertyResponse {
    val operation = SandboxUpdatePropertyMutation(input)
    val response = graphQLExecutor.execute(operation)

    return UpdateSandboxPropertyResponse(
        data = response.data.updateProperty.property.sandboxPropertyData,
        rawResponse = response
    )
}
