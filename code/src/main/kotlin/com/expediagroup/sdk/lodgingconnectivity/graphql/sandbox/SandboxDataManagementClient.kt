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

package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox

import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientEnvironment
import com.expediagroup.sdk.lodgingconnectivity.configuration.SandboxApiEndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.graphql.common.DefaultGraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLClient
import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.cancelSandboxReservationFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.changeSandboxReservationStayDatesFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.createSandboxPropertyFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.createSandboxReservationFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.deleteSandboxPropertyFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.deleteSandboxPropertyReservationsFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.deleteSandboxReservationFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.getSandboxPropertiesFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.getSandboxPropertyFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.getSandboxPropertyReservations
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.getSandboxReservationFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.updateSandboxPropertyFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.updateSandboxReservationFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.paginator.SandboxPropertiesPaginator
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.paginator.SandboxPropertyReservationsPaginator
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CancelReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.ChangeReservationStayDatesInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CreatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CreateReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeletePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeletePropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeleteReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.UpdatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.UpdateReservationInput

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
    override val graphqlExecutor: GraphQLExecutor = DefaultGraphQLExecutor(
        config.toExpediaGroupClientConfiguration(
            clientEndpoint = SandboxApiEndpointProvider.forEnvironment(environment = config.environment ?: ClientEnvironment.SANDBOX_PROD),
        )
    )

    override fun getInternalGraphQLExecutor(): GraphQLExecutor = this.graphqlExecutor

    fun getProperties() = run {
        getSandboxPropertiesFun(graphqlExecutor)
    }

    @JvmOverloads
    fun getProperties(pageSize: Int, initialCursor: String? = null) = run {
        SandboxPropertiesPaginator(graphqlExecutor, pageSize, initialCursor)
    }

    fun getPropertyReservations(propertyId: String) = run {
        getSandboxPropertyReservations(graphqlExecutor, propertyId)
    }

    @JvmOverloads
    fun getPropertyReservations(propertyId: String, pageSize: Int, initialCursor: String? = null) = run {
        SandboxPropertyReservationsPaginator(graphqlExecutor, propertyId, pageSize, initialCursor)
    }

    fun getProperty(propertyId: String) = run {
        getSandboxPropertyFun(graphqlExecutor, propertyId)
    }

    fun getReservation(reservationId: String) = run {
        getSandboxReservationFun(graphqlExecutor, reservationId)
    }

    fun createProperty() = run {
        createSandboxPropertyFun(graphqlExecutor, CreatePropertyInput())
    }

    fun createProperty(input: CreatePropertyInput) = run {
        createSandboxPropertyFun(graphqlExecutor, input)
    }

    fun updateProperty(input: UpdatePropertyInput) = run {
        updateSandboxPropertyFun(graphqlExecutor, input)
    }

    fun deleteProperty(propertyId: String) = run {
        deleteSandboxPropertyFun(graphqlExecutor, DeletePropertyInput(id = propertyId))
    }

    fun createReservation(propertyId: String) = run {
        createSandboxReservationFun(graphqlExecutor, CreateReservationInput(propertyId = propertyId))
    }

    fun createReservation(input: CreateReservationInput) = run {
        createSandboxReservationFun(graphqlExecutor, input)
    }

    fun updateReservation(input: UpdateReservationInput) = run {
        updateSandboxReservationFun(graphqlExecutor, input)
    }

    fun changeReservationStayDates(input: ChangeReservationStayDatesInput) = run {
        changeSandboxReservationStayDatesFun(graphqlExecutor, input)
    }

    fun cancelReservation(reservationId: String) = run {
        cancelSandboxReservationFun(graphqlExecutor, CancelReservationInput(id = reservationId))
    }

    fun cancelReservation(input: CancelReservationInput) = run {
        cancelSandboxReservationFun(graphqlExecutor, input)
    }

    fun deleteReservation(reservationId: String) = run {
        deleteSandboxReservationFun(graphqlExecutor, DeleteReservationInput(id = reservationId))
    }

    fun deleteReservation(input: DeleteReservationInput) = run {
        deleteSandboxReservationFun(graphqlExecutor, input)
    }

    fun deletePropertyReservations(propertyId: String) = run {
        deleteSandboxPropertyReservationsFun(
            graphqlExecutor,
            DeletePropertyReservationsInput(propertyId = propertyId)
        )
    }

    fun deletePropertyReservations(input: DeletePropertyReservationsInput) = run {
        deleteSandboxPropertyReservationsFun(graphqlExecutor, input)
    }
}
