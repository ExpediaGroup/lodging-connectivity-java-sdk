package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.core.extension.orFalseIfNull
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.ConfirmReservationNotificationMutation
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ConfirmReservationNotificationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections

data class ConfirmReservationNotificationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<ConfirmReservationNotificationMutation.Data>,
) : Response<ReservationData?, ConfirmReservationNotificationMutation.Data>

@JvmOverloads
fun confirmReservationNotificationOperation(
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
