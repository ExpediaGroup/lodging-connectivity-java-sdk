package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model

import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxCancelReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData

data class CancelSandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxCancelReservationMutation.Data>,
) : Response<SandboxReservationData, SandboxCancelReservationMutation.Data>
