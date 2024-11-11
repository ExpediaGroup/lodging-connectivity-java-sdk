package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.orFalseIfNull
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
