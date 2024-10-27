package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CancelReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancelReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections
import java.util.Optional

data class CancelReservationResponse(
    override val data: Optional<ReservationData>,
    override val rawResponse: RawResponse<CancelReservationMutation.Data>,
) : Response<Optional<ReservationData>, CancelReservationMutation.Data>

@JvmOverloads
fun cancelReservationFun(
    client: GraphQLExecutor,
    input: CancelReservationInput,
    selections: ReservationSelections? = null
): CancelReservationResponse {
    val operation = CancelReservationMutation.builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount)
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
        .build()

    val response = client.execute(operation)

    return CancelReservationResponse(
        data = response.data.cancelReservation.reservation.map { it.reservationData },
        rawResponse = response
    )
}
