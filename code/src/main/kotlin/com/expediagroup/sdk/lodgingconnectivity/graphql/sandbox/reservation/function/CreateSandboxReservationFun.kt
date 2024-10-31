package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxCreateReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CreateReservationInput

data class CreateSandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxCreateReservationMutation.Data>,
) : Response<SandboxReservationData, SandboxCreateReservationMutation.Data>

fun createSandboxReservationFun(client: GraphQLExecutor, input: CreateReservationInput): CreateSandboxReservationResponse {
    val operation = SandboxCreateReservationMutation(input)
    val response = client.execute(operation)

    return CreateSandboxReservationResponse(
        data = response.data.createReservation.reservation.sandboxReservationData,
        rawResponse = response
    )
}
