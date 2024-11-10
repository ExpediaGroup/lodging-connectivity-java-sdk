package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model

import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxReservationQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData

data class SandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxReservationQuery.Data>,
) : Response<SandboxReservationData, SandboxReservationQuery.Data>
