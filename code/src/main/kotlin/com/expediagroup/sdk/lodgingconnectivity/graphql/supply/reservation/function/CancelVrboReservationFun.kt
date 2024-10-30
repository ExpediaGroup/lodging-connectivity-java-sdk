@file:JvmName("CancelVrboReservationRequest")

package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.falseIfNull
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CancelVrboReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancelVrboReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections

data class CancelVrboReservationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<CancelVrboReservationMutation.Data>,
) : Response<ReservationData?, CancelVrboReservationMutation.Data>

@JvmOverloads
@JvmName("execute")
fun cancelVrboReservationFun(
    graphQLExecutor: GraphQLExecutor,
    input: CancelVrboReservationInput,
    selections: ReservationSelections? = null
): CancelVrboReservationResponse {
    val operation = CancelVrboReservationMutation
        .Builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount.falseIfNull())
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken.falseIfNull())
        .build()

    val response = graphQLExecutor.execute(operation)

    return CancelVrboReservationResponse(
        data = response.data.cancelVrboReservation.reservation?.reservationData,
        rawResponse = response
    )
}
