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

package com.expediagroup.sdk.lodgingconnectivity.supply.reservation

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.DefaultGraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.common.GraphQLClient
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.common.RequestExecutor
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientEnvironment
import com.expediagroup.sdk.lodgingconnectivity.configuration.EndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.CancelReservationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.CancelReservationReconciliationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.CancelVrboReservationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ChangeReservationReconciliationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ConfirmReservationNotificationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.PropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.RefundReservationInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.CancelReservationReconciliationResponse
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.CancelReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.CancelVrboReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.ChangeReservationReconciliationResponse
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.ConfirmReservationNotificationResponse
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.RefundReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.cancelReservationOperation
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.cancelReservationReconciliationOperation
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.cancelVrboReservationOperation
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.changeReservationReconciliationOperation
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.confirmReservationNotificationOperation
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.refundReservationOperation
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.paginator.ReservationsPaginator
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.stream.ReservationsStream

/**
 * A client for interacting with EG Lodging Connectivity Reservations GraphQL API
 *
 * Endpoint is automatically determined based on the environment configuration (e.g., [ClientEnvironment.PROD] (default) or [ClientEnvironment.TEST])
 *
 * In addition, this client can be configured to target the sandbox environment by passing[ClientEnvironment.SANDBOX_PROD] or
 * [ClientEnvironment.SANDBOX_TEST] to the `environment` configuration option.
 *
 * @constructor Creates a new instance of `ReservationClient` using the provided configuration.
 * @param config The `ClientConfiguration` that includes API credentials and other optional parameters such as environment and
 * timeouts
 */
class ReservationClient(config: ClientConfiguration) : GraphQLClient() {

    override val apiEndpoint = EndpointProvider.getSupplyApiEndpoint(config.environment)

    override val graphQLExecutor: GraphQLExecutor = DefaultGraphQLExecutor(
        requestExecutor = RequestExecutor(config, apiEndpoint),
        serverUrl = apiEndpoint.endpoint
    )

    /**
     * Creates a paginator for retrieving paginated reservation data for a specified property.
     *
     * @param propertyId The unique identifier of the property.
     * @param selections An optional [ReservationSelections] specifying additional fields to include in the response.
     * @param pageSize The number of reservations to retrieve per page; defaults to server’s setting if not provided.
     * @param initialCursor An optional cursor to specify the starting point for pagination; defaults to the first page.
     * @return A [ReservationsPaginator] to fetch reservations page by page.
     */
    @JvmOverloads
    fun getReservationsPaginator(
        propertyId: String,
        selections: ReservationSelections? = null,
        pageSize: Int? = null,
        initialCursor: String? = null
    ): ReservationsPaginator = run {
        ReservationsPaginator(
            graphQLExecutor = graphQLExecutor,
            input = PropertyReservationsInput(propertyId),
            selections = selections,
            pageSize = pageSize,
            initialCursor = initialCursor
        )
    }

    /**
     * Creates a paginator for retrieving paginated reservation data for a specified property.
     *
     * @param propertyId The unique identifier of the property.
     * @param pageSize The number of reservations to retrieve per page; defaults to server’s setting if not provided.
     * @param initialCursor An optional cursor to specify the starting point for pagination; defaults to the first page.
     * @return A [ReservationsPaginator] to fetch reservations page by page.
     */
    @JvmOverloads
    fun getReservationsPaginator(
        propertyId: String,
        pageSize: Int,
        initialCursor: String? = null
    ): ReservationsPaginator = run {
        ReservationsPaginator(
            graphQLExecutor = graphQLExecutor,
            input = PropertyReservationsInput(propertyId),
            pageSize = pageSize,
            initialCursor = initialCursor
        )
    }

    /**
     * Creates a paginator for retrieving paginated reservation data for a specified property.
     *
     * @param input The [PropertyReservationsInput] specifying propertyId with additional filtering options.
     * @param selections An optional [ReservationSelections] specifying additional fields to include in the response.
     * @param pageSize The number of reservations to retrieve per page; defaults to server’s setting if not provided.
     * @param initialCursor An optional cursor to specify the starting point for pagination; defaults to the first page.
     * @return A [ReservationsPaginator] to fetch reservations page by page.
     */
    @JvmOverloads
    fun getReservationsPaginator(
        input: PropertyReservationsInput,
        selections: ReservationSelections? = null,
        pageSize: Int? = null,
        initialCursor: String? = null
    ): ReservationsPaginator = run {
        ReservationsPaginator(
            graphQLExecutor = graphQLExecutor,
            input = input,
            selections = selections,
            pageSize = pageSize,
            initialCursor = initialCursor
        )
    }

    /**
     * Creates a paginator for retrieving paginated reservation data for a specified property.
     *
     * @param input The [PropertyReservationsInput] specifying propertyId with additional filtering options.
     * @param pageSize The number of reservations to retrieve per page; defaults to server’s setting if not provided.
     * @param initialCursor An optional cursor to specify the starting point for pagination; defaults to the first page.
     * @return A [ReservationsPaginator] to fetch reservations page by page.
     */
    @JvmOverloads
    fun getReservationsPaginator(
        input: PropertyReservationsInput,
        pageSize: Int,
        initialCursor: String? = null
    ): ReservationsPaginator = run {
        ReservationsPaginator(
            graphQLExecutor = graphQLExecutor,
            input = input,
            pageSize = pageSize,
            initialCursor = initialCursor
        )
    }

    /**
     * Provides a streaming interface for sequentially accessing reservations for a specific property.
     *
     * @param propertyId The unique identifier of the property.
     * @return A [ReservationsStream] to stream through reservations one at a time.
     */
    fun getReservationsStream(propertyId: String): ReservationsStream = run {
        ReservationsStream(getReservationsPaginator(propertyId))
    }

    /**
     * Provides a streaming interface for sequentially accessing reservations for a specific property.
     *
     * @param input The [PropertyReservationsInput] specifying the property and filter criteria.
     * @return A [ReservationsStream] to stream through reservations one at a time.
     */
    fun getReservationsStream(input: PropertyReservationsInput): ReservationsStream = run {
        ReservationsStream(getReservationsPaginator(input))
    }

    /**
     * Cancels a reservation.
     *
     * @param input The [CancelReservationInput] containing the details of the reservation to be canceled.
     * @param selections An optional [ReservationSelections] specifying additional fields to include in the response.
     * @return A [CancelReservationResponse] containing the canceled reservation data (if available) and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    @JvmOverloads
    fun cancelReservation(
        input: CancelReservationInput,
        selections: ReservationSelections? = null
    ): CancelReservationResponse = run {
        cancelReservationOperation(graphQLExecutor, input, selections)
    }

    /**
     * Cancels the reconciliation of a reservation.
     *
     * @param input The [CancelReservationReconciliationInput] containing the details of the reservation reconciliation to be canceled.
     * @param selections An optional [ReservationSelections] specifying additional fields to include in the response.
     * @return A [CancelReservationReconciliationResponse] containing the canceled reconciliation data (if available) and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    @JvmOverloads
    fun cancelReservationReconciliation(
        input: CancelReservationReconciliationInput,
        selections: ReservationSelections? = null
    ): CancelReservationReconciliationResponse = run {
        cancelReservationReconciliationOperation(graphQLExecutor, input, selections)
    }

    /**
     * Cancels a VRBO reservation.
     *
     * @param input The [CancelVrboReservationInput] containing the details of the VRBO reservation to be canceled.
     * @param selections An optional [ReservationSelections] specifying additional fields to include in the response.
     * @return A [CancelVrboReservationResponse] containing the canceled reservation data (if available) and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    @JvmOverloads
    fun cancelVrboReservation(
        input: CancelVrboReservationInput,
        selections: ReservationSelections? = null
    ): CancelVrboReservationResponse = run {
        cancelVrboReservationOperation(graphQLExecutor, input, selections)
    }

    /**
     * Updates the reconciliation details for a reservation.
     *
     * @param input The [ChangeReservationReconciliationInput] containing the new reconciliation details for the reservation.
     * @param selections An optional [ReservationSelections] specifying additional fields to include in the response.
     * @return A [ChangeReservationReconciliationResponse] containing the updated reconciliation data (if available) and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    @JvmOverloads
    fun changeReservationReconciliation(
        input: ChangeReservationReconciliationInput,
        selections: ReservationSelections? = null
    ): ChangeReservationReconciliationResponse = run {
        changeReservationReconciliationOperation(graphQLExecutor, input, selections)
    }

    /**
     * Confirms a reservation notification.
     *
     * @param input The [ConfirmReservationNotificationInput] containing the details of the reservation notification to confirm.
     * @param selections An optional [ReservationSelections] specifying additional fields to include in the response.
     * @return A [ConfirmReservationNotificationResponse] containing the confirmed reservation data (if available) and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    @JvmOverloads
    fun confirmReservationNotification(
        input: ConfirmReservationNotificationInput,
        selections: ReservationSelections? = null
    ): ConfirmReservationNotificationResponse = run {
        confirmReservationNotificationOperation(graphQLExecutor, input, selections)
    }

    /**
     * Initiates a refund for a reservation.
     *
     * @param input The [RefundReservationInput] containing the details of the reservation to be refunded.
     * @param selections An optional [ReservationSelections] specifying additional fields to include in the response.
     * @return A [RefundReservationResponse] containing the refunded reservation data (if available) and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    @JvmOverloads
    fun refundReservation(
        input: RefundReservationInput,
        selections: ReservationSelections? = null
    ): RefundReservationResponse = run {
        refundReservationOperation(graphQLExecutor, input, selections)
    }
}
