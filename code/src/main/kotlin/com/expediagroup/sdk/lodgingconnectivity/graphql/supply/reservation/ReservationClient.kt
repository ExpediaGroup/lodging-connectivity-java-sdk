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

package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation

import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.EndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.graphql.BaseGraphQLClient
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.GraphQLResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.paginator.PropertyReservationsPaginator
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.paginator.PropertyReservationsSummariesPaginator
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CancelReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CancelReservationReconciliationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CancelVrboReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.ChangeReservationReconciliationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.ConfirmReservationNotificationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.RefundReservationMutation
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancelReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancelReservationReconciliationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancelVrboReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ChangeReservationReconciliationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ConfirmReservationNotificationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PropertyReservationsSummaryInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RefundReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections
import java.util.Optional

/**
 * A client for interacting with EG Lodging Connectivity Reservations GraphQL API
 *
 * This client is configured with a `ClientConfiguration` that includes authentication details,
 * and it automatically determines the appropriate API endpoints based on the environment (e.g., production or test).
 *
 * In addition, this client can be configured to target the sandbox environment by passing `ClientEnvironment.SANDBOX_PROD` or
 * `ClientEnvironment.SANDBOX_TEST` to the `environment` configuration option.
 *
 * @constructor Creates a new instance of `ReservationClient` using the provided configuration.
 * @param config The `ClientConfiguration` that includes API credentials and other optional parameters such as environment,
 * timeouts, and logging masking options.
 *
 * Example usage:
 * ```
 * ReservationClient(
 *     ClientConfiguration
 *         .builder()
 *         .key("API_KEY")
 *         .secret("API_SECRET")
 *         .build()
 * )
 * ```
 */
class ReservationClient(config: ClientConfiguration) {
    private val baseGraphQlClient: BaseGraphQLClient = BaseGraphQLClient(
        config.toExpediaGroupClientConfiguration(
            endpointProvider = EndpointProvider::getReservationClientEndpoint,
            authEndpointProvider = EndpointProvider::getAuthEndpoint
        )
    )

    @JvmOverloads
    fun getPropertyReservations(
        input: PropertyReservationsInput,
        selections: ReservationSelections? = null
    ): PropertyReservationsPaginator = PropertyReservationsPaginator(baseGraphQlClient, input, selections)

    fun getPropertyReservationsSummaries(input: PropertyReservationsSummaryInput):
            PropertyReservationsSummariesPaginator = PropertyReservationsSummariesPaginator(baseGraphQlClient, input)

    @JvmOverloads
    fun cancelReservation(
        input: CancelReservationInput,
        selections: ReservationSelections? = null
    ): GraphQLResponse<Optional<ReservationData>> {
        val operation = CancelReservationMutation.builder()
            .input(input)
            .includeSupplierAmount(selections?.includeSupplierAmount)
            .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
            .build()

        val response = baseGraphQlClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.cancelReservation.reservation.map { it.reservationData },
            errors = response.errors
        )
    }

    @JvmOverloads
    fun cancelReservationReconciliation(
        input: CancelReservationReconciliationInput,
        selections: ReservationSelections? = null
    ): GraphQLResponse<Optional<ReservationData>> {
        val operation = CancelReservationReconciliationMutation.builder()
            .input(input)
            .includeSupplierAmount(selections?.includeSupplierAmount)
            .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
            .build()

        val response = baseGraphQlClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.cancelReservationReconciliation.reservation.map { it.reservationData },
            errors = response.errors
        )
    }

    @JvmOverloads
    fun cancelVrboReservation(
        input: CancelVrboReservationInput,
        selections: ReservationSelections? = null
    ): GraphQLResponse<Optional<ReservationData>> {
        val operation = CancelVrboReservationMutation.builder()
            .input(input)
            .includeSupplierAmount(selections?.includeSupplierAmount)
            .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
            .build()

        val response = baseGraphQlClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.cancelVrboReservation.reservation.map { it.reservationData },
            errors = response.errors
        )
    }

    @JvmOverloads
    fun changeReservationReconciliation(
        input: ChangeReservationReconciliationInput,
        selections: ReservationSelections? = null
    ): GraphQLResponse<Optional<ReservationData>> {
        val operation = ChangeReservationReconciliationMutation.builder()
            .input(input)
            .includeSupplierAmount(selections?.includeSupplierAmount)
            .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
            .build()

        val response = baseGraphQlClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.changeReservationReconciliation.reservation.map { it.reservationData },
            errors = response.errors
        )
    }

    @JvmOverloads
    fun confirmReservationNotification(
        input: ConfirmReservationNotificationInput,
        selections: ReservationSelections? = null
    ): GraphQLResponse<Optional<ReservationData>> {
        val operation = ConfirmReservationNotificationMutation.builder()
            .input(input)
            .includeSupplierAmount(selections?.includeSupplierAmount)
            .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
            .build()

        val response = baseGraphQlClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.confirmReservationNotification.reservation.map { it.reservationData },
            errors = response.errors
        )
    }

    @JvmOverloads
    fun refundReservation(
        input: RefundReservationInput,
        selections: ReservationSelections? = null
    ): GraphQLResponse<Optional<ReservationData>> {
        val operation = RefundReservationMutation.builder()
            .input(input)
            .includeSupplierAmount(selections?.includeSupplierAmount)
            .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
            .build()

        val response = baseGraphQlClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.refundReservation.reservation.map { it.reservationData },
            errors = response.errors
        )
    }
}
