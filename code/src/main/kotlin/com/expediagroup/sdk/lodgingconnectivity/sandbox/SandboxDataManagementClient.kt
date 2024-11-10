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

import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientEnvironment
import com.expediagroup.sdk.lodgingconnectivity.configuration.SandboxApiEndpointProvider
import com.expediagroup.sdk.graphql.common.DefaultGraphQLExecutor
import com.expediagroup.sdk.graphql.common.GraphQLClient
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function.cancelSandboxReservationFun
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function.changeSandboxReservationStayDatesFun
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function.createSandboxReservationFun
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function.deleteSandboxPropertyReservationsFun
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function.deleteSandboxReservationFun
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function.getSandboxPropertyReservations
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function.getSandboxReservationFun
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function.updateSandboxReservationFun
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.paginator.SandboxPropertyReservationsPaginator
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CancelReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.ChangeReservationStayDatesInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreateReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeleteReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdateReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.function.createSandboxPropertyFun
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.function.deleteSandboxPropertyFun
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.function.getSandboxPropertiesFun
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.function.getSandboxPropertyFun
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.function.updateSandboxPropertyFun
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.paginator.SandboxPropertiesPaginator

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
        getSandboxPropertiesFun(graphQLExecutor)
    }

    @JvmOverloads
    fun getPropertiesPaginator(pageSize: Int, initialCursor: String? = null) = run {
        SandboxPropertiesPaginator(graphQLExecutor, pageSize, initialCursor)
    }

    fun getPropertyReservations(propertyId: String) = run {
        getSandboxPropertyReservations(graphQLExecutor, propertyId)
    }

    @JvmOverloads
    fun getPropertyReservations(propertyId: String, pageSize: Int, initialCursor: String? = null) = run {
        SandboxPropertyReservationsPaginator(graphQLExecutor, propertyId, pageSize, initialCursor)
    }

    fun getProperty(propertyId: String) = run {
        getSandboxPropertyFun(graphQLExecutor, propertyId)
    }

    fun getReservation(reservationId: String) = run {
        getSandboxReservationFun(graphQLExecutor, reservationId)
    }

    fun createProperty() = run {
        createSandboxPropertyFun(graphQLExecutor, CreatePropertyInput())
    }

    fun createProperty(input: CreatePropertyInput) = run {
        createSandboxPropertyFun(graphQLExecutor, input)
    }

    fun updateProperty(input: UpdatePropertyInput) = run {
        updateSandboxPropertyFun(graphQLExecutor, input)
    }

    fun deleteProperty(propertyId: String) = run {
        deleteSandboxPropertyFun(graphQLExecutor, DeletePropertyInput(id = propertyId))
    }

    fun createReservation(propertyId: String) = run {
        createSandboxReservationFun(graphQLExecutor, CreateReservationInput(propertyId = propertyId))
    }

    fun createReservation(input: CreateReservationInput) = run {
        createSandboxReservationFun(graphQLExecutor, input)
    }

    fun updateReservation(input: UpdateReservationInput) = run {
        updateSandboxReservationFun(graphQLExecutor, input)
    }

    fun changeReservationStayDates(input: ChangeReservationStayDatesInput) = run {
        changeSandboxReservationStayDatesFun(graphQLExecutor, input)
    }

    fun cancelReservation(reservationId: String) = run {
        cancelSandboxReservationFun(graphQLExecutor, CancelReservationInput(id = reservationId))
    }

    fun cancelReservation(input: CancelReservationInput) = run {
        cancelSandboxReservationFun(graphQLExecutor, input)
    }

    fun deleteReservation(reservationId: String) = run {
        deleteSandboxReservationFun(graphQLExecutor, DeleteReservationInput(id = reservationId))
    }

    fun deleteReservation(input: DeleteReservationInput) = run {
        deleteSandboxReservationFun(graphQLExecutor, input)
    }

    fun deletePropertyReservations(propertyId: String) = run {
        deleteSandboxPropertyReservationsFun(
            graphQLExecutor,
            DeletePropertyReservationsInput(propertyId = propertyId)
        )
    }

    fun deletePropertyReservations(input: DeletePropertyReservationsInput) = run {
        deleteSandboxPropertyReservationsFun(graphQLExecutor, input)
    }
}