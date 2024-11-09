package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertyQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxPropertyData

data class SandboxPropertyResponse(
    override val data: SandboxPropertyData,
    override val rawResponse: RawResponse<SandboxPropertyQuery.Data>,
) : Response<SandboxPropertyData, SandboxPropertyQuery.Data>

fun getSandboxPropertyFun(graphQLExecutor: GraphQLExecutor, propertyId: String): SandboxPropertyResponse {
    val operation = SandboxPropertyQuery(propertyId)
    val response = graphQLExecutor.execute(operation)

    return SandboxPropertyResponse(
        data = response.data.property.sandboxPropertyData,
        rawResponse = response,
    )
}
