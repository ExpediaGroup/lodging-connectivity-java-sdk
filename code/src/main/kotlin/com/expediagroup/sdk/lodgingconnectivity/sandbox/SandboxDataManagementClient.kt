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

package com.expediagroup.sdk.lodgingconnectivity.sandbox

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.DefaultGraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.common.GraphQLClient
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.common.DefaultRequestExecutor
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientEnvironment
import com.expediagroup.sdk.lodgingconnectivity.configuration.LodgingConnectivityLogMasking
import com.expediagroup.sdk.lodgingconnectivity.configuration.EndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CancelReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.ChangeReservationStayDatesInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreateReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeleteReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdateReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.CreateSandboxPropertyResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.DeleteSandboxPropertyResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.GetSandboxPropertiesResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.GetSandboxPropertyResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.UpdateSandboxPropertyResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.createSandboxPropertyOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.deleteSandboxPropertyOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.getSandboxPropertiesOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.getSandboxPropertyOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.updateSandboxPropertyOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.paginator.SandboxPropertiesPaginator
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.CancelSandboxReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.ChangeSandboxReservationStayDatesResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.CreateSandboxReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.DeleteSandboxReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.DeleteSandboxReservationsResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.GetSandboxReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.GetSandboxReservationsResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.UpdateSandboxReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.cancelSandboxReservationOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.changeSandboxReservationStayDatesOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.createSandboxReservationOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.deleteSandboxReservationOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.deleteSandboxReservationsOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.getSandboxReservationOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.getSandboxReservationsOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.updateSandboxReservationOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.paginator.SandboxReservationsPaginator

/**
 * A client for interacting with EG Lodging Connectivity Sandbox GraphQL API.
 *
 * The `SandboxDataManagementClient` provides a comprehensive API for creating, retrieving, updating, and deleting
 * sandbox properties and reservations.
 *
 * Endpoint is automatically determined based on the environment configuration (e.g., [ClientEnvironment.SANDBOX_PROD] or [ClientEnvironment.SANDBOX_TEST])
 *
 * @constructor Creates a new instance of `SandboxDataManagementClient` using the provided configuration.
 * @param config The `ClientConfiguration` that includes API credentials and other optional parameters such as environment
 * or timeouts.
 */
class SandboxDataManagementClient(config: ClientConfiguration) : GraphQLClient() {
    init {
        LodgingConnectivityLogMasking.enable()
    }
    
    override val apiEndpoint = EndpointProvider.getSandboxApiEndpoint(config.environment)

    override val graphQLExecutor: GraphQLExecutor = DefaultGraphQLExecutor(
        requestExecutor = DefaultRequestExecutor(config, apiEndpoint),
        serverUrl = apiEndpoint.endpoint
    )

    /**
     * Retrieves all sandbox properties in one page.
     *
     * @return A [GetSandboxPropertiesResponse] containing the sandbox properties data, pagination information, and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun getProperties(): GetSandboxPropertiesResponse = run {
        getSandboxPropertiesOperation(graphQLExecutor)
    }

    /**
     * Creates a paginator for fetching sandbox properties page-by-page.
     *
     * @param pageSize The number of properties to retrieve per page.
     * @param initialCursor An optional initial cursor to specify the starting point.
     * @return A [SandboxPropertiesPaginator] for iterating through properties.
     */
    @JvmOverloads
    fun getPropertiesPaginator(pageSize: Int, initialCursor: String? = null): SandboxPropertiesPaginator = run {
        SandboxPropertiesPaginator(graphQLExecutor, pageSize, initialCursor)
    }

    /**
     * Retrieves all reservations for a specific sandbox property.
     *
     * @param propertyId The unique identifier of the property.
     * @return A [GetSandboxReservationsResponse] containing the sandbox reservations data, pagination information, and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun getReservations(propertyId: String): GetSandboxReservationsResponse = run {
        getSandboxReservationsOperation(graphQLExecutor, propertyId)
    }

    /**
     * Creates a paginator for fetching reservations page-by-page for a specific sandbox property.
     *
     * @param propertyId The unique identifier of the sandbox property.
     * @param pageSize The number of reservations to retrieve per page.
     * @param initialCursor An optional initial cursor to specify the starting point.
     * @return A [SandboxReservationsPaginator] for iterating through reservations.
     */
    @JvmOverloads
    fun getReservationsPaginator(
        propertyId: String,
        pageSize: Int,
        initialCursor: String? = null
    ): SandboxReservationsPaginator = run {
        SandboxReservationsPaginator(graphQLExecutor, propertyId, pageSize, initialCursor)
    }

    /**
     * Retrieves details of a specific sandbox property.
     *
     * @param propertyId The unique identifier of the property.
     * @return A [GetSandboxPropertyResponse] containing the requested sandbox property data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun getProperty(propertyId: String): GetSandboxPropertyResponse = run {
        getSandboxPropertyOperation(graphQLExecutor, propertyId)
    }

    /**
     * Retrieves details of a specific sandbox reservation.
     *
     * @param reservationId The unique identifier of the reservation.
     * @return A [GetSandboxReservationResponse] containing the requested reservation data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun getReservation(reservationId: String): GetSandboxReservationResponse = run {
        getSandboxReservationOperation(graphQLExecutor, reservationId)
    }

    /**
     * Creates a new sandbox property with default name.
     *
     * @return A [CreateSandboxPropertyResponse] containing the created sandbox property data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun createProperty(): CreateSandboxPropertyResponse = run {
        createSandboxPropertyOperation(graphQLExecutor, CreatePropertyInput())
    }

    /**
     * Creates a new sandbox property with the specified input.
     *
     * @param input The [CreatePropertyInput] specifying the details of the property to be created.
     * @return A [CreateSandboxPropertyResponse] containing the created sandbox property data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun createProperty(input: CreatePropertyInput): CreateSandboxPropertyResponse = run {
        createSandboxPropertyOperation(graphQLExecutor, input)
    }

    /**
     * Updates an existing sandbox property.
     *
     * @param input The [UpdatePropertyInput] containing the updated property details.
     * @return An [UpdateSandboxPropertyResponse] containing the updated sandbox property data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun updateProperty(input: UpdatePropertyInput): UpdateSandboxPropertyResponse = run {
        updateSandboxPropertyOperation(graphQLExecutor, input)
    }

    /**
     * Deletes a specified sandbox property.
     *
     * @param propertyId The unique identifier of the property to be deleted.
     * @return A [DeleteSandboxPropertyResponse] containing the deleted property data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun deleteProperty(propertyId: String): DeleteSandboxPropertyResponse = run {
        deleteSandboxPropertyOperation(graphQLExecutor, DeletePropertyInput(id = propertyId))
    }

    /**
     * Creates a new sandbox reservation for a specific property.
     *
     * @param propertyId The unique identifier of the property.
     * @return A [CreateSandboxReservationResponse] containing the created reservation data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun createReservation(propertyId: String): CreateSandboxReservationResponse = run {
        createSandboxReservationOperation(graphQLExecutor, CreateReservationInput(propertyId = propertyId))
    }

    /**
     * Creates a new sandbox reservation with the specified input.
     *
     * @param input The [CreateReservationInput] containing the reservation details.
     * @return A [CreateSandboxReservationResponse] containing the created reservation data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun createReservation(input: CreateReservationInput): CreateSandboxReservationResponse = run {
        createSandboxReservationOperation(graphQLExecutor, input)
    }

    /**
     * Updates an existing sandbox reservation.
     *
     * @param input The [UpdateReservationInput] with the updated reservation details.
     * @return An [UpdateSandboxReservationResponse] containing the updated reservation data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun updateReservation(input: UpdateReservationInput): UpdateSandboxReservationResponse = run {
        updateSandboxReservationOperation(graphQLExecutor, input)
    }

    /**
     * Changes the stay dates for an existing sandbox reservation.
     *
     * @param input The [ChangeReservationStayDatesInput] specifying the new stay dates.
     * @return A [ChangeSandboxReservationStayDatesResponse] containing the updated reservation data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun changeReservationStayDates(
        input: ChangeReservationStayDatesInput
    ): ChangeSandboxReservationStayDatesResponse = run {
        changeSandboxReservationStayDatesOperation(graphQLExecutor, input)
    }

    /**
     * Cancels a specific sandbox reservation.
     *
     * @param reservationId The unique identifier of the reservation to be canceled.
     * @return A [CancelSandboxReservationResponse] containing the canceled reservation data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun cancelReservation(reservationId: String): CancelSandboxReservationResponse = run {
        cancelSandboxReservationOperation(graphQLExecutor, CancelReservationInput(id = reservationId))
    }

    /**
     * Cancels a sandbox reservation with the specified input.
     *
     * @param input The [CancelReservationInput] containing reservation details for cancellation.
     * @return A [CancelSandboxReservationResponse] containing the canceled reservation data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun cancelReservation(input: CancelReservationInput): CancelSandboxReservationResponse = run {
        cancelSandboxReservationOperation(graphQLExecutor, input)
    }

    /**
     * Deletes a specific sandbox reservation.
     *
     * @param reservationId The unique identifier of the reservation to be deleted.
     * @return A [DeleteSandboxReservationResponse] containing the deleted reservation data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun deleteReservation(reservationId: String): DeleteSandboxReservationResponse = run {
        deleteSandboxReservationOperation(graphQLExecutor, DeleteReservationInput(id = reservationId))
    }

    /**
     * Deletes a sandbox reservation with the specified input.
     *
     * @param input The [DeleteReservationInput] specifying the reservation to delete.
     * @return A [DeleteSandboxReservationResponse] containing the deleted reservation data and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun deleteReservation(input: DeleteReservationInput): DeleteSandboxReservationResponse = run {
        deleteSandboxReservationOperation(graphQLExecutor, input)
    }

    /**
     * Deletes all reservations for a specified property.
     *
     * @param propertyId The unique identifier of the property.
     * @return A [DeleteSandboxReservationsResponse] containing data for the deleted reservations and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun deleteReservations(propertyId: String): DeleteSandboxReservationsResponse = run {
        deleteSandboxReservationsOperation(
            graphQLExecutor,
            DeletePropertyReservationsInput(propertyId = propertyId)
        )
    }

    /**
     * Deletes all reservations for a specified property.
     *
     * @param input The [DeletePropertyReservationsInput] specifying the reservations to delete.
     * @return A [DeleteSandboxReservationsResponse] containing data for the deleted reservations and the full raw response.
     * @throws [ExpediaGroupServiceException] If an error occurs during the operation execution.
     */
    fun deleteReservations(input: DeletePropertyReservationsInput): DeleteSandboxReservationsResponse = run {
        deleteSandboxReservationsOperation(graphQLExecutor, input)
    }
}
