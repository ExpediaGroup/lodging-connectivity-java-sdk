package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxDeleteReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeleteReservationInput

data class DeleteSandboxReservationResponse(
    override val data: SandboxDeleteReservationMutation.DeleteReservation,
    override val rawResponse: RawResponse<SandboxDeleteReservationMutation.Data>,
) : Response<SandboxDeleteReservationMutation.DeleteReservation, SandboxDeleteReservationMutation.Data>

fun deleteSandboxReservationFun(graphQLExecutor: GraphQLExecutor, input: DeleteReservationInput): DeleteSandboxReservationResponse {
    val operation = SandboxDeleteReservationMutation(input)
    val response = graphQLExecutor.execute(operation)

    return DeleteSandboxReservationResponse(
        data = response.data.deleteReservation,
        rawResponse = response
    )
}
