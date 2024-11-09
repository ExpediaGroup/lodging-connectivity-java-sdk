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
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientEnvironment
import com.expediagroup.sdk.lodgingconnectivity.configuration.SupplyApiEndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.graphql.common.DefaultGraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLClient
import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function.cancelReservationFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function.cancelReservationReconciliationFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function.cancelVrboReservationFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function.changeReservationReconciliationFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function.confirmReservationNotificationFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function.refundReservationFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.paginator.PropertyReservationsPaginator
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancelReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancelReservationReconciliationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancelVrboReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ChangeReservationReconciliationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ConfirmReservationNotificationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RefundReservationInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections

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
class ReservationClient(config: ClientConfiguration) : GraphQLClient() {
    override val graphqlExecutor: GraphQLExecutor = DefaultGraphQLExecutor(
        config.toExpediaGroupClientConfiguration(
            clientEndpoint = SupplyApiEndpointProvider.forEnvironment(
                environment = config.environment ?: ClientEnvironment.PROD
            ),
        )
    )

    override fun getInternalGraphQLExecutor(): GraphQLExecutor = this.graphqlExecutor

    @JvmOverloads
    fun getPropertyReservations(
        propertyId: String,
        selections: ReservationSelections? = null,
        pageSize: Int? = null,
        initialCursor: String? = null
    ) = run {
        PropertyReservationsPaginator(
            graphQLExecutor = graphqlExecutor,
            input = PropertyReservationsInput(propertyId),
            selections = selections,
            pageSize = pageSize,
            initialCursor = initialCursor
        )
    }

    @JvmOverloads
    fun getPropertyReservations(
        propertyId: String,
        pageSize: Int,
        initialCursor: String? = null
    ) = run {
        PropertyReservationsPaginator(
            graphQLExecutor = graphqlExecutor,
            input = PropertyReservationsInput(propertyId),
            pageSize = pageSize,
            initialCursor = initialCursor
        )
    }

    @JvmOverloads
    fun getPropertyReservations(
        input: PropertyReservationsInput,
        selections: ReservationSelections? = null,
        pageSize: Int? = null,
        initialCursor: String? = null
    ) = run {
        PropertyReservationsPaginator(
            graphQLExecutor = graphqlExecutor,
            input = input,
            selections = selections,
            pageSize = pageSize,
            initialCursor = initialCursor
        )
    }

    @JvmOverloads
    fun getPropertyReservations(
        input: PropertyReservationsInput,
        pageSize: Int,
        initialCursor: String? = null
    ) = run {
        PropertyReservationsPaginator(
            graphQLExecutor = graphqlExecutor,
            input = input,
            pageSize = pageSize,
            initialCursor = initialCursor
        )
    }

    @JvmOverloads
    fun cancelReservation(
        input: CancelReservationInput,
        selections: ReservationSelections? = null
    ) = run {
        cancelReservationFun(graphqlExecutor, input, selections)
    }

    @JvmOverloads
    fun cancelReservationReconciliation(
        input: CancelReservationReconciliationInput,
        selections: ReservationSelections? = null
    ) = run {
        cancelReservationReconciliationFun(graphqlExecutor, input, selections)
    }

    @JvmOverloads
    fun cancelVrboReservation(
        input: CancelVrboReservationInput,
        selections: ReservationSelections? = null
    ) = run {
        cancelVrboReservationFun(graphqlExecutor, input, selections)
    }

    @JvmOverloads
    fun changeReservationReconciliation(
        input: ChangeReservationReconciliationInput,
        selections: ReservationSelections? = null
    ) = run {
        changeReservationReconciliationFun(graphqlExecutor, input, selections)
    }

    @JvmOverloads
    fun confirmReservationNotification(
        input: ConfirmReservationNotificationInput,
        selections: ReservationSelections? = null
    ) = run {
        confirmReservationNotificationFun(graphqlExecutor, input, selections)
    }

    @JvmOverloads
    fun refundReservation(
        input: RefundReservationInput,
        selections: ReservationSelections? = null
    ) = run {
        refundReservationFun(graphqlExecutor, input, selections)
    }
}
