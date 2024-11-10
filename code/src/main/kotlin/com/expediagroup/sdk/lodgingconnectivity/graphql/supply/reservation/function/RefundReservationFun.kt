package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.extension.orFalseIfNull
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.RefundReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RefundReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections

data class RefundReservationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<RefundReservationMutation.Data>,
) : Response<ReservationData?, RefundReservationMutation.Data>

@JvmOverloads
fun refundReservationFun(
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
