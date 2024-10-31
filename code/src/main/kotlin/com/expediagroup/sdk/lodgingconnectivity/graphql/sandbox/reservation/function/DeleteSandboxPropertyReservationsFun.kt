package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxDeletePropertyReservationsMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeletePropertyReservationsInput

data class DeleteSandboxPropertyReservationsResponse(
    override val data: SandboxDeletePropertyReservationsMutation.DeletePropertyReservations,
    override val rawResponse: RawResponse<SandboxDeletePropertyReservationsMutation.Data>,
) : Response<SandboxDeletePropertyReservationsMutation.DeletePropertyReservations, SandboxDeletePropertyReservationsMutation.Data>


fun deleteSandboxPropertyReservationsFun(
    client: GraphQLExecutor,
    input: DeletePropertyReservationsInput
): DeleteSandboxPropertyReservationsResponse {
    val operation = SandboxDeletePropertyReservationsMutation(input)
    val response = client.execute(operation)

    return DeleteSandboxPropertyReservationsResponse(
        data = response.data.deletePropertyReservations,
        rawResponse = response
    )
}
