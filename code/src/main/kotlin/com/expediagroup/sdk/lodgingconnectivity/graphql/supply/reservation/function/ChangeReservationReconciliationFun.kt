package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.ChangeReservationReconciliationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ChangeReservationReconciliationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections

data class ChangeReservationReconciliationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<ChangeReservationReconciliationMutation.Data>,
) : Response<ReservationData?, ChangeReservationReconciliationMutation.Data>

@JvmOverloads
fun changeReservationReconciliationFun(
    client: GraphQLExecutor,
    input: ChangeReservationReconciliationInput,
    selections: ReservationSelections? = null
): ChangeReservationReconciliationResponse {
    val operation = ChangeReservationReconciliationMutation
        .Builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount ?: false)
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken ?: false)
        .build()

    val response = client.execute(operation)

    return ChangeReservationReconciliationResponse(
        data = response.data.changeReservationReconciliation.reservation?.reservationData,
        rawResponse = response
    )
}
