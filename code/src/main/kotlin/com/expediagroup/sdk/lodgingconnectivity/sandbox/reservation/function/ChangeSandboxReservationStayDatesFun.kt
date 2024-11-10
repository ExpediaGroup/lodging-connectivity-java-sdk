package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxChangeReservationStayDatesMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.ChangeReservationStayDatesInput

data class ChangeSandboxReservationStayDatesResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxChangeReservationStayDatesMutation.Data>,
) : Response<SandboxReservationData, SandboxChangeReservationStayDatesMutation.Data>

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
