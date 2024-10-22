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

package com.expediagroup.sdk.lodgingconnectivity.graphql.supply

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.EndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.graphql.BaseGraphQLClient
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.PaginatedReservationsData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.PaginatedReservationsSummaries
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
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode.Op

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
    ): Iterator<PaginatedReservationsData> {
        return object : Iterator<PaginatedReservationsData> {
            var hasEnded = false
            var cursor: Optional<String> = input.cursor.getOrDefault(Optional.empty())

            override fun hasNext(): Boolean = !hasEnded

            override fun next(): PaginatedReservationsData {
                val operation = PropertyReservationsQuery
                    .builder()
                    .propertyId(input.propertyId)
                    .idSource(input.idSource.orElse(Optional.empty()))
                    .pageSize(input.pageSize.orElse(10))
                    .cursor(input.cursor.orElse(Optional.empty()))
                    .filter(input.filter.orElse(Optional.empty()))
                    .checkOutDate(input.checkOutDate.orElse(Optional.empty()))
                    .includeSupplierAmount(selections?.includeSupplierAmount)
                    .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
                    .build()

                val response = baseGraphQlClient.execute(operation)

                if (!response.property.isPresent) {
                    throw ExpediaGroupServiceException("Failed to fetch property ${input.propertyId}")
                }

                val paginatedReservationsData = response.property.get().reservations.paginatedReservationsData

                if (paginatedReservationsData.pageInfo.isPresent) {
                    throw ExpediaGroupServiceException("Failed to fetch reservations next page info for property ${input.propertyId}")
                }

                cursor = paginatedReservationsData.pageInfo.get().endCursor
                hasEnded = cursor.getOrNull()?.isBlank() ?: true

                return paginatedReservationsData
            }
        }
    }

    fun getPropertyReservationsSummaries(input: PropertyReservationsSummaryInput): Iterator<PaginatedReservationsSummaries> {
        return object : Iterator<PaginatedReservationsSummaries> {
            var hasEnded = false
            var cursor: Optional<String> = input.cursor.getOrDefault(Optional.empty())

            override fun hasNext(): Boolean = !hasEnded

            override fun next(): PaginatedReservationsSummaries {
                val operation = PropertyReservationsSummaryQuery
                    .builder()
                    .propertyId(input.propertyId)
                    .idSource(input.idSource.orElse(Optional.empty()))
                    .pageSize(input.pageSize.orElse(10))
                    .cursor(input.cursor.orElse(Optional.empty()))
                    .filter(input.filter.orElse(Optional.empty()))
                    .checkOutDate(input.checkOutDate.orElse(Optional.empty()))
                    .build()

                val response = baseGraphQlClient.execute(operation)

                if (!response.property.isPresent) {
                    throw ExpediaGroupServiceException("Failed to fetch property ${input.propertyId}")
                }

                val paginatedReservationsSummaries = response.property.get().reservations.paginatedReservationsSummaries

                if (paginatedReservationsSummaries.pageInfo.isPresent) {
                    throw ExpediaGroupServiceException("Failed to fetch reservations next page info for property ${input.propertyId}")
                }

                cursor = paginatedReservationsSummaries.pageInfo.get().endCursor
                hasEnded = cursor.getOrNull()?.isBlank() ?: true

                return paginatedReservationsSummaries
            }
        }
    }

    @JvmOverloads
    fun cancelReservation(
        input: CancelReservationInput,
        selections: ReservationSelections? = null
    ): Optional<ReservationData> {
        val operation = CancelReservationMutation
            .builder()
            .input(input)
            .includeSupplierAmount(selections?.includeSupplierAmount)
            .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
            .build()

        val response = baseGraphQlClient.execute(operation)

        return response.cancelReservation.reservation.map { it.reservationData }
    }

    @JvmOverloads
    fun cancelReservationReconciliation(
        input: CancelReservationReconciliationInput,
        selections: ReservationSelections? = null
    ): Optional<ReservationData> {
        val operation = CancelReservationReconciliationMutation
            .builder()
            .input(input)
            .includeSupplierAmount(selections?.includeSupplierAmount)
            .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
            .build()

        val response = baseGraphQlClient.execute(operation)

        return response.cancelReservationReconciliation.reservation.map { it.reservationData }
    }

    @JvmOverloads
    fun cancelVrboReservation(
        input: CancelVrboReservationInput,
        selections: ReservationSelections? = null
    ): Optional<ReservationData> {
        val operation = CancelVrboReservationMutation
            .builder()
            .input(input)
            .includeSupplierAmount(selections?.includeSupplierAmount)
            .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
            .build()

        val response = baseGraphQlClient.execute(operation)

        return response.cancelVrboReservation.reservation.map { it.reservationData }
    }

    @JvmOverloads
    fun changeReservationReconciliation(
        input: ChangeReservationReconciliationInput,
        selections: ReservationSelections? = null
    ): Optional<ReservationData> {
        val operation = ChangeReservationReconciliationMutation
            .builder()
            .input(input)
            .includeSupplierAmount(selections?.includeSupplierAmount)
            .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
            .build()

        val response = baseGraphQlClient.execute(operation)

        return response.changeReservationReconciliation.reservation.map { it.reservationData }
    }

    @JvmOverloads
    fun confirmReservationNotification(
        input: ConfirmReservationNotificationInput,
        selections: ReservationSelections? = null
    ): Optional<ReservationData> {
        val operation = ConfirmReservationNotificationMutation
            .builder()
            .input(input)
            .includeSupplierAmount(selections?.includeSupplierAmount)
            .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
            .build()

        val response = baseGraphQlClient.execute(operation)

        return response.confirmReservationNotification.reservation.map { it.reservationData }
    }

    @JvmOverloads
    fun refundReservation(
        input: RefundReservationInput,
        selections: ReservationSelections? = null
    ): Optional<ReservationData> {
        val operation = RefundReservationMutation
            .builder()
            .input(input)
            .includeSupplierAmount(selections?.includeSupplierAmount)
            .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
            .build()

        val response = baseGraphQlClient.execute(operation)

        return response.refundReservation.reservation.map { it.reservationData }
    }
}
