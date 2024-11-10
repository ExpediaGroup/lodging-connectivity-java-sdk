package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxDeletePropertyReservationsMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model.DeleteSandboxPropertyReservationsResponse

fun deleteSandboxPropertyReservationsFun(
    graphQLExecutor: GraphQLExecutor,
    input: DeletePropertyReservationsInput
): DeleteSandboxPropertyReservationsResponse {
    val operation = SandboxDeletePropertyReservationsMutation(input)
    val response = graphQLExecutor.execute(operation)

    return DeleteSandboxPropertyReservationsResponse(
        data = response.data.deletePropertyReservations,
        rawResponse = response
    )
}
