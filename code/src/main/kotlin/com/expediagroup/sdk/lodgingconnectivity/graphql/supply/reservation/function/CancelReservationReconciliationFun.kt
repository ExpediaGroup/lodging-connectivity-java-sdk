package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.orFalseIfNull
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CancelReservationReconciliationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancelReservationReconciliationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections

data class CancelReservationReconciliationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<CancelReservationReconciliationMutation.Data>,
) : Response<ReservationData?, CancelReservationReconciliationMutation.Data>

@JvmOverloads
fun cancelReservationReconciliationFun(
    graphQLExecutor: GraphQLExecutor,
    input: CancelReservationReconciliationInput,
    selections: ReservationSelections? = null
): CancelReservationReconciliationResponse {
    val operation = CancelReservationReconciliationMutation
        .Builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount.orFalseIfNull())
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken.orFalseIfNull())
        .build()

    val response = graphQLExecutor.execute(operation)

    return CancelReservationReconciliationResponse(
        data = response.data.cancelReservationReconciliation.reservation?.reservationData,
        rawResponse = response
    )
}
