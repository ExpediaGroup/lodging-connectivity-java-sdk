package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxReservationQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model.SandboxReservationResponse

fun getSandboxReservationFun(graphQLExecutor: GraphQLExecutor, reservationId: String): SandboxReservationResponse {
    val operation = SandboxReservationQuery(reservationId)
    val response = graphQLExecutor.execute(operation)

    return SandboxReservationResponse(
        data = response.data.reservation.sandboxReservationData,
        rawResponse = response
    )
}
