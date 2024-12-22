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

package com.expediagroup.sdk.lodgingconnectivity.payment

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.DefaultGraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.common.GraphQLClient
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.RequestExecutorImpl
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientEnvironment
import com.expediagroup.sdk.lodgingconnectivity.configuration.EndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.payment.operation.GetPaymentInstrumentResponse
import com.expediagroup.sdk.lodgingconnectivity.payment.operation.PaymentInstrumentQuery
import com.expediagroup.sdk.lodgingconnectivity.payment.operation.getPaymentInstrumentOperation

/**
 * A client for interacting with EG Lodging Connectivity Payment PCI GraphQL API.
 *
 * Endpoint is automatically determined based on the environment configuration (e.g., [ClientEnvironment.PROD] or [ClientEnvironment.TEST])
 *
 * @constructor Creates a new instance of `PaymentClient` using the provided configuration.
 * @param config The `ClientConfiguration` that includes API credentials and other optional parameters such as environment
 * or timeouts.
 */
class PaymentClient(config: ClientConfiguration) : GraphQLClient() {
    override val apiEndpoint = EndpointProvider.getPaymentApiEndpoint(config.environment)

    override val graphQLExecutor: GraphQLExecutor = DefaultGraphQLExecutor(
        requestExecutor = RequestExecutorImpl(config, apiEndpoint),
        serverUrl = apiEndpoint.endpoint
    )

    /**
     * Retrieves the payment instrument details associated with the specified token.
     *
     * This function executes a [PaymentInstrumentQuery] GraphQL operation using the client’s configured
     * [GraphQLExecutor]. It returns a [GetPaymentInstrumentResponse] containing both the targeted payment
     * instrument data and the full raw response.
     *
     * @param token The token identifying the payment instrument to be retrieved.
     * @return A [GetPaymentInstrumentResponse] containing the requested payment instrument data and the full raw response.
     * @throws ExpediaGroupServiceException If the payment instrument data is not found in the response.
     */
    fun getPaymentInstrument(token: String): GetPaymentInstrumentResponse = run {
        getPaymentInstrumentOperation(graphQLExecutor, token)
    }
}
