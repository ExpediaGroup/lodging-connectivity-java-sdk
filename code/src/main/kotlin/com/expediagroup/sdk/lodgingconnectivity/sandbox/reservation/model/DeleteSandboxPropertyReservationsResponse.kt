package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model

import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxDeletePropertyReservationsMutation

data class DeleteSandboxPropertyReservationsResponse(
    override val data: SandboxDeletePropertyReservationsMutation.DeletePropertyReservations,
    override val rawResponse: RawResponse<SandboxDeletePropertyReservationsMutation.Data>,
) : Response<SandboxDeletePropertyReservationsMutation.DeletePropertyReservations, SandboxDeletePropertyReservationsMutation.Data>
