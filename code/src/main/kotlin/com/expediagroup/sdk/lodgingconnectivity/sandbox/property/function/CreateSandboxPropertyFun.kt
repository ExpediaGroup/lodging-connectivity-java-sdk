package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxCreatePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreatePropertyInput

data class CreateSandboxPropertyResponse(
    override val data: SandboxPropertyData,
    override val rawResponse: RawResponse<SandboxCreatePropertyMutation.Data>,
) : Response<SandboxPropertyData, SandboxCreatePropertyMutation.Data>

fun createSandboxPropertyFun(graphQLExecutor: GraphQLExecutor, input: CreatePropertyInput): CreateSandboxPropertyResponse {
    val operation = SandboxCreatePropertyMutation(input)
    val response = graphQLExecutor.execute(operation)

    return CreateSandboxPropertyResponse(
        data = response.data.createProperty.property.sandboxPropertyData,
        rawResponse = response
    )
}
