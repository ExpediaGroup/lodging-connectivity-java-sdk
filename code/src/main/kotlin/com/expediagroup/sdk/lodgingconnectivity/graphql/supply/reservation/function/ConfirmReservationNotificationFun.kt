package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.orFalseIfNull
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.ConfirmReservationNotificationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ConfirmReservationNotificationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections

data class ConfirmReservationNotificationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<ConfirmReservationNotificationMutation.Data>,
) : Response<ReservationData?, ConfirmReservationNotificationMutation.Data>

@JvmOverloads
fun confirmReservationNotificationFun(
    graphQLExecutor: GraphQLExecutor,
    input: ConfirmReservationNotificationInput,
    selections: ReservationSelections? = null
): ConfirmReservationNotificationResponse {
    val operation = ConfirmReservationNotificationMutation
        .builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount.orFalseIfNull())
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken.orFalseIfNull())
        .build()

    val response = graphQLExecutor.execute(operation)

    return ConfirmReservationNotificationResponse(
        data = response.data.confirmReservationNotification.reservation?.reservationData,
        rawResponse = response
    )
}
