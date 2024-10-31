package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxUpdateReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.UpdateReservationInput

data class UpdateSandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxUpdateReservationMutation.Data>,
) : Response<SandboxReservationData, SandboxUpdateReservationMutation.Data>

fun updateSandboxReservationFun(client: GraphQLExecutor, input: UpdateReservationInput): UpdateSandboxReservationResponse {
    val operation = SandboxUpdateReservationMutation(input)
    val response = client.execute(operation)

    return UpdateSandboxReservationResponse(
        data = response.data.updateReservation.reservation.sandboxReservationData,
        rawResponse = response
    )
}
