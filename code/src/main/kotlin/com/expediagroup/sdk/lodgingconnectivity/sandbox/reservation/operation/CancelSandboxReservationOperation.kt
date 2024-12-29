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

import com.expediagroup.sdk.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.AbstractGraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxCancelReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CancelReservationInput

/**
 * Represents the response for [SandboxCancelReservationMutation] GraphQL operation, containing both the processed
 * sandbox reservation data and the full raw GraphQL response.
 *
 * @param data The [SandboxReservationData] extracted from the raw response, representing details
 * of the sandbox reservation after cancellation.
 * @param rawResponse The raw response from the GraphQL mutation, including the complete data structure
 * and any associated errors.
 */
data class CancelSandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxCancelReservationMutation.Data>,
) : Response<SandboxReservationData, SandboxCancelReservationMutation.Data>

/**
 * Executes [SandboxCancelReservationMutation] GraphQL mutation to cancel an existing sandbox reservation.
 *
 * This function uses the provided [AbstractGraphQLExecutor] to execute the mutation and returns a [CancelSandboxReservationResponse]
 * containing both the updated reservation data and the full raw response.
 *
 * @param graphQLExecutor The [AbstractGraphQLExecutor] responsible for executing the GraphQL mutation.
 * @param input The [CancelReservationInput] containing the details of the reservation to be canceled.
 * @return A [CancelSandboxReservationResponse] containing the canceled reservation data and the full raw response.
 * @throws [ExpediaGroupServiceException] If an error occurs during the mutation execution.
 */
fun cancelSandboxReservationOperation(graphQLExecutor: AbstractGraphQLExecutor, input: CancelReservationInput): CancelSandboxReservationResponse {
    val operation = SandboxCancelReservationMutation(input)
    val response = graphQLExecutor.execute(operation)

    return CancelSandboxReservationResponse(
        data = response.data.cancelReservation.reservation.sandboxReservationData,
        rawResponse = response
    )
}
