package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxCancelReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CancelReservationInput

data class CancelSandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxCancelReservationMutation.Data>,
) : Response<SandboxReservationData, SandboxCancelReservationMutation.Data>

fun cancelSandboxReservationOperation(graphQLExecutor: GraphQLExecutor, input: CancelReservationInput): CancelSandboxReservationResponse {
    val operation = SandboxCancelReservationMutation(input)
    val response = graphQLExecutor.execute(operation)

    return CancelSandboxReservationResponse(
        data = response.data.cancelReservation.reservation.sandboxReservationData,
        rawResponse = response
    )
}
