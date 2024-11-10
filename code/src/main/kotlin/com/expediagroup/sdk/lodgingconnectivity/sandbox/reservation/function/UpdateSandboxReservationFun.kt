package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxUpdateReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdateReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model.UpdateSandboxReservationResponse

fun updateSandboxReservationFun(graphQLExecutor: GraphQLExecutor, input: UpdateReservationInput): UpdateSandboxReservationResponse {
    val operation = SandboxUpdateReservationMutation(input)
    val response = graphQLExecutor.execute(operation)

    return UpdateSandboxReservationResponse(
        data = response.data.updateReservation.reservation.sandboxReservationData,
        rawResponse = response
    )
}
