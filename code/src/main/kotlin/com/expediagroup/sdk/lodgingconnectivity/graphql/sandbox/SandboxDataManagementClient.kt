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
import com.expediagroup.sdk.lodgingconnectivity.configuration.EndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.graphql.BaseGraphQLClient
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxPaginatedProperties
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxPaginatedReservationsData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxProperty
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CancelReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.ChangeReservationStayDatesInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CreatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CreateReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeletePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeletePropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeleteReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.SandboxPropertiesInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.SandboxPropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.UpdatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.UpdateReservationInput
import java.util.Optional
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull
import okhttp3.internal.toImmutableList

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
class SandboxDataManagementClient(config: ClientConfiguration) {
    private val baseGraphQLClient: BaseGraphQLClient = BaseGraphQLClient(
        config.toExpediaGroupClientConfiguration(
            endpointProvider = EndpointProvider::getSandboxDataManagementClientEndpoint,
            authEndpointProvider = EndpointProvider::getAuthEndpoint,
            defaultEnvironment = ClientEnvironment.SANDBOX_PROD
        )
    )

    fun getProperties(): List<SandboxProperty> {
        val operation = SandboxPropertiesQuery.builder().build()
        val response = baseGraphQLClient.execute(operation)
        return response.properties.sandboxPaginatedProperties.elements.map { it.sandboxProperty }
    }

    fun getPropertiesPaginated(input: SandboxPropertiesInput): Iterator<SandboxPaginatedProperties> {
        return object : Iterator<SandboxPaginatedProperties> {
            var hasEnded = false
            var cursor: Optional<String> = input.cursor.getOrDefault(Optional.empty())

            override fun hasNext(): Boolean = !hasEnded

            override fun next(): SandboxPaginatedProperties {
                val operation = SandboxPropertiesQuery
                    .builder()
                    .pageSize(input.pageSize.getOrDefault(Optional.empty()))
                    .cursor(cursor)
                    .build()

                val response = baseGraphQLClient.execute(operation)
                cursor = response.properties.sandboxPaginatedProperties.cursor
                hasEnded = cursor.getOrNull()?.isBlank() ?: true
                return response.properties.sandboxPaginatedProperties
            }
        }
    }

    fun getPropertyReservations(propertyId: String): List<SandboxReservationData> {
        val operation = SandboxPropertyReservationsQuery
            .builder()
            .propertyId(propertyId)
            .build()

        val response = baseGraphQLClient.execute(operation)

        return response.property.reservations.sandboxPaginatedReservationsData.elements.map { it.sandboxReservationData }
    }

    fun getPropertyReservationsPaginated(input: SandboxPropertyReservationsInput): Iterator<SandboxPaginatedReservationsData> {
        return object : Iterator<SandboxPaginatedReservationsData> {
            var hasEnded = false
            var cursor: Optional<String> = input.cursor.getOrDefault(Optional.empty())

            override fun hasNext(): Boolean = !hasEnded

            override fun next(): SandboxPaginatedReservationsData {
                val operation = SandboxPropertyReservationsQuery
                    .builder()
                    .propertyId(input.propertyId)
                    .pageSize(input.pageSize.getOrDefault(Optional.empty()))
                    .cursor(cursor)
                    .build()

                val response = baseGraphQLClient.execute(operation)
                val paginatedReservations = response.property.reservations.sandboxPaginatedReservationsData
                cursor = paginatedReservations.cursor
                hasEnded = cursor.getOrNull()?.isBlank() ?: true
                return paginatedReservations
            }
        }
    }

    fun getProperty(id: String): SandboxProperty {
        val operation = SandboxPropertyQuery(id, Optional.empty())
        val response = baseGraphQLClient.execute(operation)
        return response.property.sandboxProperty
    }

    fun getReservation(id: String): SandboxReservationData {
        val operation = SandboxReservationQuery(id)
        val response = baseGraphQLClient.execute(operation)
        return response.reservation.sandboxReservationData
    }

    fun createProperty(input: CreatePropertyInput): SandboxProperty {
        val operation = SandboxCreatePropertyMutation(input)
        val response = baseGraphQLClient.execute(operation)
        return response.createProperty.property.sandboxProperty
    }

    fun updateProperty(input: UpdatePropertyInput): SandboxProperty {
        val operation = SandboxUpdatePropertyMutation(input)
        val response = baseGraphQLClient.execute(operation)
        return response.updateProperty.property.sandboxProperty
    }

    fun deleteProperty(id: String) {
        val operation = SandboxDeletePropertyMutation(DeletePropertyInput.builder().id(id).build())
        baseGraphQLClient.execute(operation)
    }

    fun createReservation(input: CreateReservationInput): SandboxReservationData {
        val operation = SandboxCreateReservationMutation(input)
        val response = baseGraphQLClient.execute(operation)
        return response.createReservation.reservation.sandboxReservationData
    }

    fun updateReservation(input: UpdateReservationInput): SandboxReservationData {
        val operation = SandboxUpdateReservationMutation(input)
        val response = baseGraphQLClient.execute(operation)
        return response.updateReservation.reservation.sandboxReservationData
    }

    fun changeReservationStayDates(input: ChangeReservationStayDatesInput): SandboxReservationData {
        val operation = SandboxChangeReservationStayDatesMutation(input)
        val response = baseGraphQLClient.execute(operation)
        return response.changeReservationStayDates.reservation.sandboxReservationData
    }

    fun cancelReservation(input: CancelReservationInput): SandboxReservationData {
        val operation = SandboxCancelReservationMutation(input)
        val response = baseGraphQLClient.execute(operation)
        return response.cancelReservation.reservation.sandboxReservationData
    }

    fun deleteReservation(id: String) {
        val operation = SandboxDeleteReservationMutation(DeleteReservationInput.builder().id(id).build())
        baseGraphQLClient.execute(operation)
    }

    fun deletePropertyReservations(input: DeletePropertyReservationsInput) {
        val operation = SandboxDeletePropertyReservationsMutation(input)
        baseGraphQLClient.execute(operation)
    }
}
