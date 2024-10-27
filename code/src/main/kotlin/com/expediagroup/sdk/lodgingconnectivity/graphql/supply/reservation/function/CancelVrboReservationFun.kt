package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CancelVrboReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancelVrboReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections
import java.util.Optional

data class CancelVrboReservationResponse(
    override val data: Optional<ReservationData>,
    override val rawResponse: RawResponse<CancelVrboReservationMutation.Data>,
) : Response<Optional<ReservationData>, CancelVrboReservationMutation.Data>

@JvmOverloads
fun cancelVrboReservationFun(
    client: GraphQLExecutor,
    input: CancelVrboReservationInput,
    selections: ReservationSelections? = null
): CancelVrboReservationResponse {
    val operation = CancelVrboReservationMutation.builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount)
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
        .build()

    val response = client.execute(operation)

    return CancelVrboReservationResponse(
        data = response.data.cancelVrboReservation.reservation.map { it.reservationData },
        rawResponse = response
    )
}
