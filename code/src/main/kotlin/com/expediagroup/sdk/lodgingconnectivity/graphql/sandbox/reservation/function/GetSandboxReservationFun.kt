@file:JvmName("SandboxReservationRequest")

package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxReservationQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData

data class SandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxReservationQuery.Data>,
) : Response<SandboxReservationData, SandboxReservationQuery.Data>

@JvmName("execute")
fun getSandboxReservationFun(graphQLExecutor: GraphQLExecutor, reservationId: String): SandboxReservationResponse {
    val operation = SandboxReservationQuery(reservationId)
    val response = graphQLExecutor.execute(operation)

    return SandboxReservationResponse(
        data = response.data.reservation.sandboxReservationData,
        rawResponse = response
    )
}
