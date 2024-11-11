package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxDeletePropertyReservationsMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyReservationsInput

data class DeleteSandboxReservationsResponse(
    override val data: SandboxDeletePropertyReservationsMutation.DeletePropertyReservations,
    override val rawResponse: RawResponse<SandboxDeletePropertyReservationsMutation.Data>,
) : Response<SandboxDeletePropertyReservationsMutation.DeletePropertyReservations, SandboxDeletePropertyReservationsMutation.Data>

fun deleteSandboxReservationsOperation(
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
