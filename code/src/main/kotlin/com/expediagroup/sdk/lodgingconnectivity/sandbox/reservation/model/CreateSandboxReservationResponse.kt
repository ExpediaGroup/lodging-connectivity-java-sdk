package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model

import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxCreateReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData

data class CreateSandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxCreateReservationMutation.Data>,
) : Response<SandboxReservationData, SandboxCreateReservationMutation.Data>
