package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxCreatePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CreatePropertyInput

data class CreateSandboxPropertyResponse(
    override val data: SandboxPropertyData,
    override val rawResponse: RawResponse<SandboxCreatePropertyMutation.Data>,
) : Response<SandboxPropertyData, SandboxCreatePropertyMutation.Data>

fun createSandboxPropertyFun(client: GraphQLExecutor, input: CreatePropertyInput): CreateSandboxPropertyResponse {
    val operation = SandboxCreatePropertyMutation(input)
    val response = client.execute(operation)

    return CreateSandboxPropertyResponse(
        data = response.data.createProperty.property.sandboxPropertyData,
        rawResponse = response
    )
}
