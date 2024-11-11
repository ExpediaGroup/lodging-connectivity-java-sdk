package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.core.extension.orFalseIfNull
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.RefundReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.RefundReservationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections

data class RefundReservationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<RefundReservationMutation.Data>,
) : Response<ReservationData?, RefundReservationMutation.Data>

@JvmOverloads
fun refundReservationOperation(
    graphQLExecutor: GraphQLExecutor,
    input: RefundReservationInput,
    selections: ReservationSelections? = null
): RefundReservationResponse {
    val operation = RefundReservationMutation
        .builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount.orFalseIfNull())
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken.orFalseIfNull())
        .build()

    val response = graphQLExecutor.execute(operation)

    return RefundReservationResponse(
        data = response.data.refundReservation.reservation?.reservationData,
        rawResponse = response
    )
}
