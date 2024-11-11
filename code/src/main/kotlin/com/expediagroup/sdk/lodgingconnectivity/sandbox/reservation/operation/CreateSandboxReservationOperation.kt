package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxCreateReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreateReservationInput

data class CreateSandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxCreateReservationMutation.Data>,
) : Response<SandboxReservationData, SandboxCreateReservationMutation.Data>

fun createSandboxReservationOperation(graphQLExecutor: GraphQLExecutor, input: CreateReservationInput): CreateSandboxReservationResponse {
    val operation = SandboxCreateReservationMutation(input)
    val response = graphQLExecutor.execute(operation)

    return CreateSandboxReservationResponse(
        data = response.data.createReservation.reservation.sandboxReservationData,
        rawResponse = response
    )
}
