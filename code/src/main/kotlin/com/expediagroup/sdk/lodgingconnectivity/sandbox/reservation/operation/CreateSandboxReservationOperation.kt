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
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxCreateReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreateReservationInput

/**
 * Represents the response for [SandboxCreateReservationMutation] GraphQL operation, containing both the processed
 * sandbox reservation data and the full raw GraphQL response.
 *
 * @param data The [SandboxReservationData] extracted from the raw response, representing details of the newly created sandbox reservation.
 * @param rawResponse The raw response from the GraphQL mutation, including the complete data structure and any associated errors.
 */
data class CreateSandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxCreateReservationMutation.Data>,
) : Response<SandboxReservationData, SandboxCreateReservationMutation.Data>

/**
 * Executes [SandboxCreateReservationMutation] GraphQL mutation to create a new sandbox reservation with the specified input data.
 *
 * This function uses the provided [AbstractGraphQLExecutor] to execute the mutation and returns a [CreateSandboxReservationResponse]
 * containing both the created reservation data and the full raw response.
 *
 * @param graphQLExecutor The [AbstractGraphQLExecutor] responsible for executing the GraphQL mutation.
 * @param input The [CreateReservationInput] containing the details for the new reservation.
 * @return A [CreateSandboxReservationResponse] containing the created reservation data and the full raw response.
 * @throws [ExpediaGroupServiceException] If an error occurs during the mutation execution.
 */
fun createSandboxReservationOperation(graphQLExecutor: AbstractGraphQLExecutor, input: CreateReservationInput): CreateSandboxReservationResponse {
    val operation = SandboxCreateReservationMutation(input)
    val response = graphQLExecutor.execute(operation)

    return CreateSandboxReservationResponse(
        data = response.data.createReservation.reservation.sandboxReservationData,
        rawResponse = response
    )
}
