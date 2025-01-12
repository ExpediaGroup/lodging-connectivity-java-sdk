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

import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.AbstractGraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxReservationQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData

/**
 * Represents the response for [SandboxReservationQuery] GraphQL operation, containing both the processed
 * sandbox reservation data and the full raw GraphQL response.
 *
 * @param data The [SandboxReservationData] extracted from the raw response, representing details of the requested sandbox reservation.
 * @param rawResponse The raw response from the GraphQL query, including the complete data structure and any associated errors.
 */
data class GetSandboxReservationResponse(
    override val data: SandboxReservationData,
    override val rawResponse: RawResponse<SandboxReservationQuery.Data>,
) : Response<SandboxReservationData, SandboxReservationQuery.Data>

/**
 * Executes [SandboxReservationQuery] GraphQL query to retrieve details about a specific sandbox reservation.
 *
 * This function uses the provided [AbstractGraphQLExecutor] to execute the query and returns a [GetSandboxReservationResponse]
 * containing both the targeted reservation data and the full raw response.
 *
 * @param graphQLExecutor The [AbstractGraphQLExecutor] responsible for executing the GraphQL query.
 * @param reservationId The unique identifier of the sandbox reservation to retrieve.
 * @return A [GetSandboxReservationResponse] containing the requested reservation data and the full raw response.
 * @throws [ExpediaGroupServiceException] If an error occurs during the query execution.
 */
fun getSandboxReservationOperation(graphQLExecutor: AbstractGraphQLExecutor, reservationId: String): GetSandboxReservationResponse {
    val operation = SandboxReservationQuery(reservationId)
    val response = graphQLExecutor.execute(operation)

    return GetSandboxReservationResponse(
        data = response.data.reservation.sandboxReservationData,
        rawResponse = response
    )
}
