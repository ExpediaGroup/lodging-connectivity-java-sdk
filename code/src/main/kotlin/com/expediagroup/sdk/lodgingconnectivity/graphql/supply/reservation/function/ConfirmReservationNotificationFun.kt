package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.ConfirmReservationNotificationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ConfirmReservationNotificationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections
import java.util.Optional

data class ConfirmReservationNotificationResponse(
    override val data: Optional<ReservationData>,
    override val rawResponse: RawResponse<ConfirmReservationNotificationMutation.Data>,
) : Response<Optional<ReservationData>, ConfirmReservationNotificationMutation.Data>

@JvmOverloads
fun confirmReservationNotificationFun(
    client: GraphQLExecutor,
    input: ConfirmReservationNotificationInput,
    selections: ReservationSelections? = null
): ConfirmReservationNotificationResponse {
    val operation = ConfirmReservationNotificationMutation.builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount)
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
        .build()

    val response = client.execute(operation)

    return ConfirmReservationNotificationResponse(
        data = response.data.confirmReservationNotification.reservation.map { it.reservationData },
        rawResponse = response
    )
}
