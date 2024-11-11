package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation

import com.expediagroup.sdk.core.extension.orFalseIfNull
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.CancelReservationReconciliationMutation
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.CancelReservationReconciliationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections

data class CancelReservationReconciliationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<CancelReservationReconciliationMutation.Data>,
) : Response<ReservationData?, CancelReservationReconciliationMutation.Data>

@JvmOverloads
fun cancelReservationReconciliationOperation(
    graphQLExecutor: GraphQLExecutor,
    input: CancelReservationReconciliationInput,
    selections: ReservationSelections? = null
): CancelReservationReconciliationResponse {
    val operation = CancelReservationReconciliationMutation
        .builder()
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
