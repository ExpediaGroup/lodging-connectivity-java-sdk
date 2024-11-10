package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxChangeReservationStayDatesMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.ChangeReservationStayDatesInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model.ChangeSandboxReservationStayDatesResponse

fun changeSandboxReservationStayDatesFun(
    graphQLExecutor: GraphQLExecutor,
    input: ChangeReservationStayDatesInput
): ChangeSandboxReservationStayDatesResponse {
    val operation = SandboxChangeReservationStayDatesMutation(input)
    val response = graphQLExecutor.execute(operation)

    return ChangeSandboxReservationStayDatesResponse(
        data = response.data.changeReservationStayDates.reservation.sandboxReservationData,
        rawResponse = response
    )
}
