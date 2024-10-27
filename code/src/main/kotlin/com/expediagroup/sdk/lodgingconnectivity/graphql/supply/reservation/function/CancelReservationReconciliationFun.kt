package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CancelReservationReconciliationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancelReservationReconciliationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections
import java.util.Optional

data class CancelReservationReconciliationResponse(
    override val data: Optional<ReservationData>,
    override val rawResponse: RawResponse<CancelReservationReconciliationMutation.Data>,
) : Response<Optional<ReservationData>, CancelReservationReconciliationMutation.Data>

@JvmOverloads
fun cancelReservationReconciliationFun(
    client: GraphQLExecutor,
    input: CancelReservationReconciliationInput,
    selections: ReservationSelections? = null
): CancelReservationReconciliationResponse {
    val operation = CancelReservationReconciliationMutation.builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount)
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
        .build()

    val response = client.execute(operation)

    return CancelReservationReconciliationResponse(
        data = response.data.cancelReservationReconciliation.reservation.map { it.reservationData },
        rawResponse = response
    )
}
