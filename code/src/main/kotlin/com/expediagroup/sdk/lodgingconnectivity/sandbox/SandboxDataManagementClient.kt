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

import com.expediagroup.sdk.graphql.common.DefaultGraphQLExecutor
import com.expediagroup.sdk.graphql.common.GraphQLClient
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientEnvironment
import com.expediagroup.sdk.lodgingconnectivity.configuration.SandboxApiEndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CancelReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.ChangeReservationStayDatesInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreateReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeleteReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdateReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.createSandboxPropertyOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.deleteSandboxPropertyOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.getSandboxPropertiesOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.getSandboxPropertyOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.updateSandboxPropertyOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.paginator.SandboxPropertiesPaginator
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
 * This client is configured with a `ClientConfiguration` that includes authentication details,
 * and it automatically determines the appropriate API endpoints based on the environment (e.g., production or test).
 *
 * @constructor Creates a new instance of `SandboxDataManagementClient` using the provided configuration.
 * @param config The `ClientConfiguration` that includes API credentials and other optional parameters such as environment,
 * timeouts, and logging masking options.
 *
 * Example usage:
 * ```
 * SandboxDataManagementClient(
 *     ClientConfiguration
 *         .builder()
 *         .key("API_KEY")
 *         .secret("API_SECRET")
 *         .build()
 * )
 * ```
 */
class SandboxDataManagementClient(config: ClientConfiguration) : GraphQLClient() {
    override val graphQLExecutor: GraphQLExecutor = DefaultGraphQLExecutor(
        config.toExpediaGroupClientConfiguration(
            apiEndpoint = SandboxApiEndpointProvider.forEnvironment(
                environment = config.environment ?: ClientEnvironment.SANDBOX_PROD
            ),
        )
    )

    fun getProperties() = run {
        getSandboxPropertiesOperation(graphQLExecutor)
    }

    @JvmOverloads
    fun getPropertiesPaginator(pageSize: Int, initialCursor: String? = null) = run {
        SandboxPropertiesPaginator(graphQLExecutor, pageSize, initialCursor)
    }

    fun getReservations(propertyId: String) = run {
        getSandboxReservationsOperation(graphQLExecutor, propertyId)
    }

    @JvmOverloads
    fun getReservationsPaginator(propertyId: String, pageSize: Int, initialCursor: String? = null) = run {
        SandboxReservationsPaginator(graphQLExecutor, propertyId, pageSize, initialCursor)
    }

    fun getProperty(propertyId: String) = run {
        getSandboxPropertyOperation(graphQLExecutor, propertyId)
    }

    fun getReservation(reservationId: String) = run {
        getSandboxReservationOperation(graphQLExecutor, reservationId)
    }

    fun createProperty() = run {
        createSandboxPropertyOperation(graphQLExecutor, CreatePropertyInput())
    }

    fun createProperty(input: CreatePropertyInput) = run {
        createSandboxPropertyOperation(graphQLExecutor, input)
    }

    fun updateProperty(input: UpdatePropertyInput) = run {
        updateSandboxPropertyOperation(graphQLExecutor, input)
    }

    fun deleteProperty(propertyId: String) = run {
        deleteSandboxPropertyOperation(graphQLExecutor, DeletePropertyInput(id = propertyId))
    }

    fun createReservation(propertyId: String) = run {
        createSandboxReservationOperation(graphQLExecutor, CreateReservationInput(propertyId = propertyId))
    }

    fun createReservation(input: CreateReservationInput) = run {
        createSandboxReservationOperation(graphQLExecutor, input)
    }

    fun updateReservation(input: UpdateReservationInput) = run {
        updateSandboxReservationOperation(graphQLExecutor, input)
    }

    fun changeReservationStayDates(input: ChangeReservationStayDatesInput) = run {
        changeSandboxReservationStayDatesOperation(graphQLExecutor, input)
    }

    fun cancelReservation(reservationId: String) = run {
        cancelSandboxReservationOperation(graphQLExecutor, CancelReservationInput(id = reservationId))
    }

    fun cancelReservation(input: CancelReservationInput) = run {
        cancelSandboxReservationOperation(graphQLExecutor, input)
    }

    fun deleteReservation(reservationId: String) = run {
        deleteSandboxReservationOperation(graphQLExecutor, DeleteReservationInput(id = reservationId))
    }

    fun deleteReservation(input: DeleteReservationInput) = run {
        deleteSandboxReservationOperation(graphQLExecutor, input)
    }

    fun deleteReservations(propertyId: String) = run {
        deleteSandboxReservationsOperation(
            graphQLExecutor,
            DeletePropertyReservationsInput(propertyId = propertyId)
        )
    }

    fun deleteReservations(input: DeletePropertyReservationsInput) = run {
        deleteSandboxReservationsOperation(graphQLExecutor, input)
    }
}
