package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation

import com.expediagroup.sdk.core.extension.orFalseIfNull
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.CancelVrboReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.CancelVrboReservationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections

data class CancelVrboReservationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<CancelVrboReservationMutation.Data>,
) : Response<ReservationData?, CancelVrboReservationMutation.Data>

@JvmOverloads
fun cancelVrboReservationOperation(
    graphQLExecutor: GraphQLExecutor,
    input: CancelVrboReservationInput,
    selections: ReservationSelections? = null
): CancelVrboReservationResponse {
    val operation = CancelVrboReservationMutation
        .builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount.orFalseIfNull())
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken.orFalseIfNull())
        .build()

    val response = graphQLExecutor.execute(operation)

    return CancelVrboReservationResponse(
        data = response.data.cancelVrboReservation.reservation?.reservationData,
        rawResponse = response
    )
}
