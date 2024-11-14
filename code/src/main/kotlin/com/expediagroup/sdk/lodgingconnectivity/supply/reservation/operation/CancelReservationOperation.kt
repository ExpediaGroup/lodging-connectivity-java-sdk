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

package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation

import com.expediagroup.sdk.core.extension.orFalseIfNull
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.CancelReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.CancelReservationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections

/**
 * Represents the response for [CancelReservationMutation] GraphQL operation, containing both the processed
 * reservation data after cancellation (if available) and the full raw GraphQL response.
 *
 * @param data The [ReservationData] extracted from the raw response, representing details of the canceled reservation,
 * or `null` if no reservation data is returned.
 * @param rawResponse The raw response from the GraphQL mutation, including the complete data structure and any associated errors.
 */
data class CancelReservationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<CancelReservationMutation.Data>,
) : Response<ReservationData?, CancelReservationMutation.Data>

/**
 * Executes [CancelReservationMutation] GraphQL mutation to cancel an existing reservation.
 *
 * This function uses the provided [GraphQLExecutor] to execute the mutation and returns a [CancelReservationResponse]
 * containing both the canceled reservation data (if available) and the full raw response. Optional selection parameters
 * allow the inclusion of additional reservation details in the response.
 *
 * @param graphQLExecutor The [GraphQLExecutor] responsible for executing the GraphQL mutation.
 * @param input The [CancelReservationInput] containing the details of the reservation to be canceled.
 * @param selections An optional [ReservationSelections] specifying additional fields to include in the response, such as
 * supplier amount and payment instrument token; defaults to `null`.
 * @return A [CancelReservationResponse] containing the canceled reservation data (if available) and the full raw response.
 * @throws ExpediaGroupServiceException If an error occurs during the mutation execution.
 */
@JvmOverloads
fun cancelReservationOperation(
    graphQLExecutor: GraphQLExecutor,
    input: CancelReservationInput,
    selections: ReservationSelections? = null
): CancelReservationResponse {
    val operation = CancelReservationMutation
        .builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount.orFalseIfNull())
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken.orFalseIfNull())
        .build()

    val response = graphQLExecutor.execute(operation)

    return CancelReservationResponse(
        data = response.data.cancelReservation.reservation?.reservationData,
        rawResponse = response
    )
}
