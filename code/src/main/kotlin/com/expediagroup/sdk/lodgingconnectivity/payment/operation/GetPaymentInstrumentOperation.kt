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

package com.expediagroup.sdk.lodgingconnectivity.payment.operation

import com.expediagroup.sdk.core.extension.getOrThrow
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.AbstractGraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.payment.operation.fragment.PaymentInstrumentData

/**
 * Represents the response for a [PaymentInstrumentQuery] GraphQL operation, containing both
 * the processed payment instrument data and the full raw GraphQL response.
 *
 * @param data The processed [PaymentInstrumentData] extracted from the raw response, representing
 * the details of the payment instrument.
 * @param rawResponse The raw response from the GraphQL query, including the complete data structure
 * and any associated errors.
 */
data class GetPaymentInstrumentResponse(
    override val data: PaymentInstrumentData,
    override val rawResponse: RawResponse<PaymentInstrumentQuery.Data>,
) : Response<PaymentInstrumentData, PaymentInstrumentQuery.Data>

/**
 * Executes [PaymentInstrumentQuery] GraphQL operation to retrieve details about a specific payment instrument.
 *
 * This function uses the provided [AbstractGraphQLExecutor] to execute the operation and returns a [GetPaymentInstrumentResponse]
 * containing both the targeted payment instrument data and the full raw response. If the payment instrument
 * data is missing or null, an [ExpediaGroupServiceException] is thrown.
 *
 * @param graphQLExecutor The [AbstractGraphQLExecutor] responsible for executing the GraphQL query.
 * @param token The token identifying the payment instrument to be retrieved.
 * @return A [GetPaymentInstrumentResponse] containing the requested payment instrument data and the full raw response.
 * @throws [ExpediaGroupServiceException] If the payment instrument data is not found in the response.
 */
fun getPaymentInstrumentOperation(graphQLExecutor: AbstractGraphQLExecutor, token: String): GetPaymentInstrumentResponse {
    val operation = PaymentInstrumentQuery(token)
    val response = graphQLExecutor.execute(operation)

    val paymentInstrument = response.data.paymentInstrument.getOrThrow {
        ExpediaGroupServiceException("Couldn't fetch payment instrument")
    }

    return GetPaymentInstrumentResponse(
        data = paymentInstrument.paymentInstrumentData,
        rawResponse = response
    )
}
