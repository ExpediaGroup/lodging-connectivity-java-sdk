package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxCancelReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CancelReservationInput

data class CancelSandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxCancelReservationMutation.Data>,
) : Response<SandboxReservationData, SandboxCancelReservationMutation.Data>

fun cancelSandboxReservationFun(graphQLExecutor: GraphQLExecutor, input: CancelReservationInput): CancelSandboxReservationResponse {
    val operation = SandboxCancelReservationMutation(input)
    val response = graphQLExecutor.execute(operation)

    return CancelSandboxReservationResponse(
        data = response.data.cancelReservation.reservation.sandboxReservationData,
        rawResponse = response
    )
}
