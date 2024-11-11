package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxDeletePropertyReservationsMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeletePropertyReservationsInput

data class DeleteSandboxPropertyReservationsResponse(
    override val data: SandboxDeletePropertyReservationsMutation.DeletePropertyReservations,
    override val rawResponse: RawResponse<SandboxDeletePropertyReservationsMutation.Data>,
) : Response<SandboxDeletePropertyReservationsMutation.DeletePropertyReservations, SandboxDeletePropertyReservationsMutation.Data>

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
