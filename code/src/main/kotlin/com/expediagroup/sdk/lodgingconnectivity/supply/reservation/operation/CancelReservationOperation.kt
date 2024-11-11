package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation

import com.expediagroup.sdk.core.extension.orFalseIfNull
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.CancelReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.CancelReservationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections

data class CancelReservationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<CancelReservationMutation.Data>,
) : Response<ReservationData?, CancelReservationMutation.Data>

@JvmOverloads
fun cancelReservationOperation(
    graphQLExecutor: GraphQLExecutor,
    input: CancelReservationInput,
    selections: ReservationSelections? = null
): CancelReservationResponse {
    val operation = CancelReservationMutation
        .builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount.orFalseIfNull())
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken.orFalseIfNull())
        .build()

    val response = graphQLExecutor.execute(operation)

    return CancelReservationResponse(
        data = response.data.cancelReservation.reservation?.reservationData,
        rawResponse = response
    )
}
