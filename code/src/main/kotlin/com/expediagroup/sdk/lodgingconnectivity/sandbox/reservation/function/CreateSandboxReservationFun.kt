package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxCreateReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreateReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model.CreateSandboxReservationResponse

fun createSandboxReservationFun(graphQLExecutor: GraphQLExecutor, input: CreateReservationInput): CreateSandboxReservationResponse {
    val operation = SandboxCreateReservationMutation(input)
    val response = graphQLExecutor.execute(operation)

    return CreateSandboxReservationResponse(
        data = response.data.createReservation.reservation.sandboxReservationData,
        rawResponse = response
    )
}
