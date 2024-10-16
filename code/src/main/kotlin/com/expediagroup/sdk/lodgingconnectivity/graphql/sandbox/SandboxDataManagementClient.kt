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
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData
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
class SandboxDataManagementClient(config: ClientConfiguration) {
    private val baseGraphQLClient: BaseGraphQLClient = BaseGraphQLClient(
        config.toExpediaGroupClientConfiguration(
            endpointProvider = EndpointProvider::getSandboxDataManagementClientEndpoint,
            authEndpointProvider = EndpointProvider::getAuthEndpoint,
            defaultEnvironment = ClientEnvironment.SANDBOX_PROD
        )
    )

    fun createProperty(input: CreatePropertyInput): SandboxCreatePropertyMutation.Property {
        val operation = SandboxCreatePropertyMutation(input)
        val response = baseGraphQLClient.execute(operation)
        return response.createProperty.property
    }

    fun updateProperty(input: UpdatePropertyInput): SandboxUpdatePropertyMutation.Property {
        val operation = SandboxUpdatePropertyMutation(input)
        val response = baseGraphQLClient.execute(operation)
        return response.updateProperty.property
    }

    fun deleteProperty(input: DeletePropertyInput): SandboxDeletePropertyMutation.DeleteProperty {
        val operation = SandboxDeletePropertyMutation(input)
        val response = baseGraphQLClient.execute(operation)
        return response.deleteProperty
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

    fun deleteReservation(input: DeleteReservationInput): SandboxDeleteReservationMutation.DeleteReservation {
        val operation = SandboxDeleteReservationMutation(input)
        val response = baseGraphQLClient.execute(operation)
        return response.deleteReservation
    }

    fun deletePropertyReservations(input: DeletePropertyReservationsInput): SandboxDeletePropertyReservationsMutation.DeletePropertyReservations {
        val operation = SandboxDeletePropertyReservationsMutation(input)
        val response = baseGraphQLClient.execute(operation)
        return response.deletePropertyReservations
    }
}
