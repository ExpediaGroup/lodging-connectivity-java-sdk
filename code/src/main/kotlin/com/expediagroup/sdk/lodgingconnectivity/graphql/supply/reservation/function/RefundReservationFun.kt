package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.RefundReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RefundReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections
import java.util.Optional

data class RefundReservationResponse(
    override val data: Optional<ReservationData>,
    override val rawResponse: RawResponse<RefundReservationMutation.Data>,
) : Response<Optional<ReservationData>, RefundReservationMutation.Data>

@JvmOverloads
fun refundReservationFun(
    client: GraphQLExecutor,
    input: RefundReservationInput,
    selections: ReservationSelections? = null
): RefundReservationResponse {
    val operation = RefundReservationMutation.builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount)
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
        .build()

    val response = client.execute(operation)

    return RefundReservationResponse(
        data = response.data.refundReservation.reservation.map { it.reservationData },
        rawResponse = response
    )
}
