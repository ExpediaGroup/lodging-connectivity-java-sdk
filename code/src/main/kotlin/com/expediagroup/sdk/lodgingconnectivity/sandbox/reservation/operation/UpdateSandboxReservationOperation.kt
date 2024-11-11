package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxUpdateReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdateReservationInput

data class UpdateSandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxUpdateReservationMutation.Data>,
) : Response<SandboxReservationData, SandboxUpdateReservationMutation.Data>

fun updateSandboxReservationOperation(
    graphQLExecutor: GraphQLExecutor,
    input: UpdateReservationInput
): UpdateSandboxReservationResponse {
    val operation = SandboxUpdateReservationMutation(input)
    val response = graphQLExecutor.execute(operation)

    return UpdateSandboxReservationResponse(
        data = response.data.updateReservation.reservation.sandboxReservationData,
        rawResponse = response
    )
}
