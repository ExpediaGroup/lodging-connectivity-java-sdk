package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxCancelReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model.CancelSandboxReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CancelReservationInput

fun cancelSandboxReservationFun(graphQLExecutor: GraphQLExecutor, input: CancelReservationInput): CancelSandboxReservationResponse {
    val operation = SandboxCancelReservationMutation(input)
    val response = graphQLExecutor.execute(operation)

    return CancelSandboxReservationResponse(
        data = response.data.cancelReservation.reservation.sandboxReservationData,
        rawResponse = response
    )
}
