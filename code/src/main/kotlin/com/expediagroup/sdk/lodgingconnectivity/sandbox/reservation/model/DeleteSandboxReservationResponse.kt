package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model

import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxDeleteReservationMutation

data class DeleteSandboxReservationResponse(
    override val data: SandboxDeleteReservationMutation.DeleteReservation,
    override val rawResponse: RawResponse<SandboxDeleteReservationMutation.Data>,
) : Response<SandboxDeleteReservationMutation.DeleteReservation, SandboxDeleteReservationMutation.Data>
