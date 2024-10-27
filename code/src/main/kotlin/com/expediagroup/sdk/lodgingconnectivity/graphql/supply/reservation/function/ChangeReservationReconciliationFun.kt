package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.ChangeReservationReconciliationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ChangeReservationReconciliationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections
import java.util.Optional

data class ChangeReservationReconciliationResponse(
    override val data: Optional<ReservationData>,
    override val rawResponse: RawResponse<ChangeReservationReconciliationMutation.Data>,
) : Response<Optional<ReservationData>, ChangeReservationReconciliationMutation.Data>

@JvmOverloads
fun changeReservationReconciliationFun(
    client: GraphQLExecutor,
    input: ChangeReservationReconciliationInput,
    selections: ReservationSelections? = null
): ChangeReservationReconciliationResponse {
    val operation = ChangeReservationReconciliationMutation.builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount)
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
        .build()

    val response = client.execute(operation)

    return ChangeReservationReconciliationResponse(
        data = response.data.changeReservationReconciliation.reservation.map { it.reservationData },
        rawResponse = response
    )
}
