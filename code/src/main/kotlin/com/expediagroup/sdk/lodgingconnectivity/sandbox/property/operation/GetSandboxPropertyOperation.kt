package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertyQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData

data class GetSandboxPropertyResponse(
    override val data: SandboxPropertyData,
    override val rawResponse: RawResponse<SandboxPropertyQuery.Data>,
) : Response<SandboxPropertyData, SandboxPropertyQuery.Data>

fun getSandboxPropertyOperation(graphQLExecutor: GraphQLExecutor, propertyId: String): GetSandboxPropertyResponse {
    val operation = SandboxPropertyQuery(propertyId)
    val response = graphQLExecutor.execute(operation)

    return GetSandboxPropertyResponse(
        data = response.data.property.sandboxPropertyData,
        rawResponse = response,
    )
}
