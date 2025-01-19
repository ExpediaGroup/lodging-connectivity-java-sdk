/*
 * Copyright (C) 2024 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation

import com.expediagroup.sdk.graphql.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.RawResponse
import com.expediagroup.sdk.graphql.model.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxDeleteReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeleteReservationInput

/**
 * Represents the response for [SandboxDeleteReservationMutation] GraphQL operation, containing both the processed
 * delete reservation data and the full raw GraphQL response.
 *
 * @param data The [SandboxDeleteReservationMutation.DeleteReservation] extracted from the raw response, representing
 * details of the deleted sandbox reservation.
 * @param rawResponse The raw response from the GraphQL mutation, including the complete data structure and any associated errors.
 */
data class DeleteSandboxReservationResponse(
    override val data: SandboxDeleteReservationMutation.DeleteReservation,
    override val rawResponse: RawResponse<SandboxDeleteReservationMutation.Data>,
) : Response<SandboxDeleteReservationMutation.DeleteReservation, SandboxDeleteReservationMutation.Data>

/**
 * Executes [SandboxDeleteReservationMutation] GraphQL mutation to remove an existing sandbox reservation.
 *
 * This function uses the provided [GraphQLExecutor] to execute the mutation and returns a [DeleteSandboxReservationResponse]
 * containing both the deleted reservation data and the full raw response.
 *
 * @param graphQLExecutor The [GraphQLExecutor] responsible for executing the GraphQL mutation.
 * @param input The [DeleteReservationInput] containing the details of the reservation to be deleted.
 * @return A [DeleteSandboxReservationResponse] containing the deleted reservation data and the full raw response.
 */
fun deleteSandboxReservationOperation(
    graphQLExecutor: GraphQLExecutor,
    input: DeleteReservationInput
): DeleteSandboxReservationResponse {
    val operation = SandboxDeleteReservationMutation(input)
    val response = graphQLExecutor.execute(operation)

    return DeleteSandboxReservationResponse(
        data = response.data.deleteReservation,
        rawResponse = response
    )
}
