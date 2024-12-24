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

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.AbstractGraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxDeletePropertyReservationsMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyReservationsInput

/**
 * Represents the response for [SandboxDeletePropertyReservationsMutation] GraphQL operation, containing both the processed
 * deletion data for multiple reservations and the full raw GraphQL response.
 *
 * @param data The [SandboxDeletePropertyReservationsMutation.DeletePropertyReservations] extracted from the raw response,
 * representing details of the deleted reservations.
 * @param rawResponse The raw response from the GraphQL mutation, including the complete data structure and any associated errors.
 */
data class DeleteSandboxReservationsResponse(
    override val data: SandboxDeletePropertyReservationsMutation.DeletePropertyReservations,
    override val rawResponse: RawResponse<SandboxDeletePropertyReservationsMutation.Data>,
) : Response<SandboxDeletePropertyReservationsMutation.DeletePropertyReservations, SandboxDeletePropertyReservationsMutation.Data>

/**
 * Executes [SandboxDeletePropertyReservationsMutation] GraphQL mutation to remove multiple reservations for a specified property.
 *
 * This function uses the provided [AbstractGraphQLExecutor] to execute the mutation and returns a [DeleteSandboxReservationsResponse]
 * containing both the data for the deleted reservations and the full raw response.
 *
 * @param graphQLExecutor The [AbstractGraphQLExecutor] responsible for executing the GraphQL mutation.
 * @param input The [DeletePropertyReservationsInput] containing the details of the reservations to be deleted.
 * @return A [DeleteSandboxReservationsResponse] containing data for the deleted reservations and the full raw response.
 * @throws [ExpediaGroupServiceException] If an error occurs during the mutation execution.
 */
fun deleteSandboxReservationsOperation(
    graphQLExecutor: AbstractGraphQLExecutor,
    input: DeletePropertyReservationsInput
): DeleteSandboxReservationsResponse {
    val operation = SandboxDeletePropertyReservationsMutation(input)
    val response = graphQLExecutor.execute(operation)

    return DeleteSandboxReservationsResponse(
        data = response.data.deletePropertyReservations,
        rawResponse = response
    )
}
