package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxReservationQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData

data class GetSandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxReservationQuery.Data>,
) : Response<SandboxReservationData, SandboxReservationQuery.Data>

fun getSandboxReservationFun(client: GraphQLExecutor, reservationId: String): GetSandboxReservationResponse {
    val operation = SandboxReservationQuery(reservationId)
    val response = client.execute(operation)

    return GetSandboxReservationResponse(
        data = response.data.reservation.sandboxReservationData,
        rawResponse = response
    )
}
