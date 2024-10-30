@file:JvmName("DeleteSandboxReservationRequest")

package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxDeleteReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeleteReservationInput

data class DeleteSandboxReservationResponse(
    override val data: SandboxDeleteReservationMutation.DeleteReservation,
    override val rawResponse: RawResponse<SandboxDeleteReservationMutation.Data>,
) : Response<SandboxDeleteReservationMutation.DeleteReservation, SandboxDeleteReservationMutation.Data>

@JvmName("execute")
fun deleteSandboxReservationFun(graphQLExecutor: GraphQLExecutor, input: DeleteReservationInput): DeleteSandboxReservationResponse {
    val operation = SandboxDeleteReservationMutation(input)
    val response = graphQLExecutor.execute(operation)

    return DeleteSandboxReservationResponse(
        data = response.data.deleteReservation,
        rawResponse = response
    )
}
