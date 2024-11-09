package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxUpdatePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.UpdatePropertyInput

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
