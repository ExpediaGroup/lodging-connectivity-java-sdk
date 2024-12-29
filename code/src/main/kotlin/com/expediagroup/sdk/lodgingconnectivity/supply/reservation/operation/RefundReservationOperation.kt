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

import com.expediagroup.sdk.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.AbstractGraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.common.orFalseIfNull
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.RefundReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.RefundReservationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections

/**
 * Represents the response for [RefundReservationMutation] GraphQL operation, containing both the processed
 * reservation data after the refund (if available) and the full raw GraphQL response.
 *
 * @param data The [ReservationData] extracted from the raw response, representing details of the reservation
 * after the refund process, or `null` if no reservation data is returned.
 * @param rawResponse The raw response from the GraphQL mutation, including the complete data structure and any associated errors.
 */
data class RefundReservationResponse(
    override val data: ReservationData?,
    override val rawResponse: RawResponse<RefundReservationMutation.Data>,
) : Response<ReservationData?, RefundReservationMutation.Data>

/**
 * Executes [RefundReservationMutation] GraphQL mutation to initiate a refund on an existing reservation.
 *
 * This function uses the provided [AbstractGraphQLExecutor] to execute the mutation and returns a [RefundReservationResponse]
 * containing both the refunded reservation data (if available) and the full raw response. Optional selection parameters
 * allow the inclusion of additional reservation details in the response.
 *
 * @param graphQLExecutor The [AbstractGraphQLExecutor] responsible for executing the GraphQL mutation.
 * @param input The [RefundReservationInput] containing the details of the reservation to be refunded.
 * @param selections An optional [ReservationSelections] specifying additional fields to include in the response, such as
 * supplier amount and payment instrument token; defaults to `null`.
 * @return A [RefundReservationResponse] containing the refunded reservation data (if available) and the full raw response.
 * @throws [ExpediaGroupServiceException] If an error occurs during the mutation execution.
 */
@JvmOverloads
fun refundReservationOperation(
    graphQLExecutor: AbstractGraphQLExecutor,
    input: RefundReservationInput,
    selections: ReservationSelections? = null
): RefundReservationResponse {
    val operation = RefundReservationMutation
        .builder()
        .input(input)
        .includeSupplierAmount(selections?.includeSupplierAmount.orFalseIfNull())
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken.orFalseIfNull())
        .build()

    val response = graphQLExecutor.execute(operation)

    return RefundReservationResponse(
        data = response.data.refundReservation.reservation?.reservationData,
        rawResponse = response
    )
}
