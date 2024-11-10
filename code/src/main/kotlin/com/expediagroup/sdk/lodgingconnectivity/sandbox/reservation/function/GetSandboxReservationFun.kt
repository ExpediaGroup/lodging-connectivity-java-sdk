package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxReservationQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData

data class GetSandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxReservationQuery.Data>,
) : Response<SandboxReservationData, SandboxReservationQuery.Data>

fun getSandboxReservationFun(graphQLExecutor: GraphQLExecutor, reservationId: String): GetSandboxReservationResponse {
    val operation = SandboxReservationQuery(reservationId)
    val response = graphQLExecutor.execute(operation)

    return GetSandboxReservationResponse(
        data = response.data.reservation.sandboxReservationData,
        rawResponse = response
    )
}
