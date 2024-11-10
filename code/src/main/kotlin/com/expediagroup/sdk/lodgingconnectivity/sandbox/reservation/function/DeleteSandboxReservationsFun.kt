package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxDeletePropertyReservationsMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model.DeleteSandboxReservationsResponse

fun deleteSandboxReservationsFun(
    graphQLExecutor: GraphQLExecutor,
    input: DeletePropertyReservationsInput
): DeleteSandboxReservationsResponse {
    val operation = SandboxDeletePropertyReservationsMutation(input)
    val response = graphQLExecutor.execute(operation)

    return DeleteSandboxReservationsResponse(
        data = response.data.deletePropertyReservations,
        rawResponse = response
    )
}
