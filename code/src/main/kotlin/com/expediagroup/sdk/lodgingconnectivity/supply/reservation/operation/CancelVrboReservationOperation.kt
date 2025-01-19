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

import com.expediagroup.sdk.graphql.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.RawResponse
import com.expediagroup.sdk.graphql.model.Response
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.CancelVrboReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.CancelVrboReservationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections
import com.expediagroup.sdk.lodgingconnectivity.util.orFalseIfNull

/**
 * Represents the response for [CancelVrboReservationMutation] GraphQL operation, containing both the processed
 * reservation data after cancellation (if available) and the full raw GraphQL response.
 *
 * @param data The [ReservationData] extracted from the raw response, representing details of the VRBO reservation
 * after cancellation, or `null` if no reservation data is returned.
 * @param rawResponse The raw response from the GraphQL mutation, including the complete data structure and any associated errors.
 */
data class CancelVrboReservationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<CancelVrboReservationMutation.Data>,
) : Response<ReservationData?, CancelVrboReservationMutation.Data>

/**
 * Executes [CancelVrboReservationMutation] GraphQL mutation to cancel an existing VRBO reservation.
 *
 * This function uses the provided [GraphQLExecutor] to execute the mutation and returns a [CancelVrboReservationResponse]
 * containing both the canceled reservation data (if available) and the full raw response. Optional selection parameters
 * allow the inclusion of additional reservation details in the response.
 *
 * @param graphQLExecutor The [GraphQLExecutor] responsible for executing the GraphQL mutation.
 * @param input The [CancelVrboReservationInput] containing the details of the VRBO reservation to be canceled.
 * @param selections An optional [ReservationSelections] specifying additional fields to include in the response, such as
 * supplier amount and payment instrument token; defaults to `null`.
 * @return A [CancelVrboReservationResponse] containing the canceled reservation data (if available) and the full raw response.
 */
@JvmOverloads
fun cancelVrboReservationOperation(
    graphQLExecutor: GraphQLExecutor,
    input: CancelVrboReservationInput,
    selections: ReservationSelections? = null
): CancelVrboReservationResponse {
    val operation = CancelVrboReservationMutation
        .builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount.orFalseIfNull())
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken.orFalseIfNull())
        .build()

    val response = graphQLExecutor.execute(operation)

    return CancelVrboReservationResponse(
        data = response.data.cancelVrboReservation.reservation?.reservationData,
        rawResponse = response
    )
}
