package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.core.extension.orFalseIfNull
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.ChangeReservationReconciliationMutation
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ChangeReservationReconciliationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections

data class ChangeReservationReconciliationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<ChangeReservationReconciliationMutation.Data>,
) : Response<ReservationData?, ChangeReservationReconciliationMutation.Data>

@JvmOverloads
fun changeReservationReconciliationOperation(
    graphQLExecutor: GraphQLExecutor,
    input: ChangeReservationReconciliationInput,
    selections: ReservationSelections? = null
): ChangeReservationReconciliationResponse {
    val operation = ChangeReservationReconciliationMutation
        .builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount.orFalseIfNull())
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken.orFalseIfNull())
        .build()

    val response = graphQLExecutor.execute(operation)

    return ChangeReservationReconciliationResponse(
        data = response.data.changeReservationReconciliation.reservation?.reservationData,
        rawResponse = response
    )
}
