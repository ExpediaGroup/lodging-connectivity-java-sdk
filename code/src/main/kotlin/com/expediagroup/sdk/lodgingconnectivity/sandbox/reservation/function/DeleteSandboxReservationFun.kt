package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxDeleteReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeleteReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model.DeleteSandboxReservationResponse

fun deleteSandboxReservationFun(graphQLExecutor: GraphQLExecutor, input: DeleteReservationInput): DeleteSandboxReservationResponse {
    val operation = SandboxDeleteReservationMutation(input)
    val response = graphQLExecutor.execute(operation)

    return DeleteSandboxReservationResponse(
        data = response.data.deleteReservation,
        rawResponse = response
    )
}
