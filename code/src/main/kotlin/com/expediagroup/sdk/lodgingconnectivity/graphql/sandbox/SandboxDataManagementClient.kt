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
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.GraphQLResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.paginator.SandboxPropertiesPaginator
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.paginator.SandboxPropertyReservationsPaginator
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

    fun getProperties(): GraphQLResponse<List<SandboxPropertyData>> {
        val operation = SandboxPropertiesQuery.builder().build()

        val response = baseGraphQLClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.properties.elements.map { it.sandboxPropertyData },
            errors = response.errors
        )
    }

    fun getProperties(input: SandboxPropertiesInput): SandboxPropertiesPaginator =
        SandboxPropertiesPaginator(baseGraphQLClient, input)

    fun getPropertyReservations(propertyId: String): GraphQLResponse<List<SandboxReservationData>> {
        val operation = SandboxPropertyReservationsQuery
            .builder()
            .propertyId(propertyId)
            .build()

        val response = baseGraphQLClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.property.reservations.elements.map { it.sandboxReservationData },
            errors = response.errors
        )
    }

    fun getPropertyReservations(input: SandboxPropertyReservationsInput): SandboxPropertyReservationsPaginator =
        SandboxPropertyReservationsPaginator(baseGraphQLClient, input)

    fun getProperty(propertyId: String): GraphQLResponse<SandboxPropertyData> {
        val operation = SandboxPropertyQuery(propertyId)
        val response = baseGraphQLClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.property.sandboxPropertyData,
            errors = response.errors
        )
    }

    fun getReservation(reservationId: String): GraphQLResponse<SandboxReservationData> {
        val operation = SandboxReservationQuery(reservationId)
        val response = baseGraphQLClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.reservation.sandboxReservationData,
            errors = response.errors
        )
    }

    fun createProperty(input: CreatePropertyInput): GraphQLResponse<SandboxPropertyData> {
        val operation = SandboxCreatePropertyMutation(input)
        val response = baseGraphQLClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.createProperty.property.sandboxPropertyData,
            errors = response.errors
        )
    }

    fun updateProperty(input: UpdatePropertyInput): GraphQLResponse<SandboxPropertyData> {
        val operation = SandboxUpdatePropertyMutation(input)
        val response = baseGraphQLClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.updateProperty.property.sandboxPropertyData,
            errors = response.errors
        )
    }

    fun deleteProperty(propertyId: String): GraphQLResponse<Optional<String>> {
        val operation = SandboxDeletePropertyMutation(DeletePropertyInput.builder().id(propertyId).build())
        val response = baseGraphQLClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.deleteProperty.clientMutationId,
            errors = response.errors
        )
    }

    fun createReservation(input: CreateReservationInput): GraphQLResponse<SandboxReservationData> {
        val operation = SandboxCreateReservationMutation(input)
        val response = baseGraphQLClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.createReservation.reservation.sandboxReservationData,
            errors = response.errors
        )
    }

    fun updateReservation(input: UpdateReservationInput): GraphQLResponse<SandboxReservationData> {
        val operation = SandboxUpdateReservationMutation(input)
        val response = baseGraphQLClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.updateReservation.reservation.sandboxReservationData,
            errors = response.errors
        )
    }

    fun changeReservationStayDates(input: ChangeReservationStayDatesInput): GraphQLResponse<SandboxReservationData> {
        val operation = SandboxChangeReservationStayDatesMutation(input)
        val response = baseGraphQLClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.changeReservationStayDates.reservation.sandboxReservationData,
            errors = response.errors
        )
    }

    fun cancelReservation(input: CancelReservationInput): GraphQLResponse<SandboxReservationData> {
        val operation = SandboxCancelReservationMutation(input)
        val response = baseGraphQLClient.execute(operation)
        val responseData = response.dataOrThrow()

        return GraphQLResponse(
            data = responseData.cancelReservation.reservation.sandboxReservationData,
            errors = response.errors
        )
    }

    fun deleteReservation(reservationId: String) {
        val operation = SandboxDeleteReservationMutation(DeleteReservationInput.builder().id(reservationId).build())
        baseGraphQLClient.execute(operation)
    }

    fun deletePropertyReservations(input: DeletePropertyReservationsInput) {
        val operation = SandboxDeletePropertyReservationsMutation(input)
        baseGraphQLClient.execute(operation)
    }
}
