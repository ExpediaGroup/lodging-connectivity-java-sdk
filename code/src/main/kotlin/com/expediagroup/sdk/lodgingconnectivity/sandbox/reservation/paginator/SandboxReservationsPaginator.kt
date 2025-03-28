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

package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.paginator

import com.expediagroup.sdk.graphql.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.RawResponse
import com.expediagroup.sdk.graphql.paging.Paginator
import com.expediagroup.sdk.graphql.paging.model.PageInfo
import com.expediagroup.sdk.graphql.paging.model.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertyReservationsTotalCountQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.getSandboxReservationsOperation

/**
 * Represents a paginated response for [SandboxPropertyReservationsQuery] GraphQL operation, containing a list
 * of sandbox reservation data, pagination details, and the full raw GraphQL response.
 *
 * @param data A list of [SandboxReservationData] representing the sandbox reservations in the current page.
 * @param rawResponse The raw response from the GraphQL query, including the complete data structure and any associated errors.
 * @param pageInfo Metadata about the pagination state, including the current cursor, the cursor for the next page,
 * the page size, and whether more pages are available.
 */
data class SandboxReservationsPaginatedResponse(
    override val data: List<SandboxReservationData>,
    override val rawResponse: RawResponse<SandboxPropertyReservationsQuery.Data>,
    override val pageInfo: PageInfo,
) : PaginatedResponse<List<SandboxReservationData>, SandboxPropertyReservationsQuery.Data>

/**
 * Provides an iterator to retrieve sandbox reservations in a paginated manner using the [SandboxPropertyReservationsQuery]
 * GraphQL operation, allowing seamless iteration over pages of reservations for a specified property.
 *
 * This paginator uses the specified [GraphQLExecutor] to fetch pages based on a cursor and optional page size,
 * managing the pagination state automatically.
 *
 * @param graphQLExecutor The [GraphQLExecutor] used to execute GraphQL queries.
 * @param propertyId The unique identifier of the property for which reservations are being retrieved.
 * @param pageSize The number of reservations to retrieve per page; defaults to `null` to use the server's default page size.
 * @param initialCursor An optional cursor to specify the starting point for pagination; defaults to `null` for the first page.
 * @constructor Creates a [SandboxReservationsPaginator] with the specified executor, property ID, page size, and initial cursor.
 */
class SandboxReservationsPaginator
    @JvmOverloads
    constructor(
        private val graphQLExecutor: GraphQLExecutor,
        private val propertyId: String,
        private val pageSize: Int? = null,
        initialCursor: String? = null,
    ) : Paginator<SandboxReservationsPaginatedResponse>() {
        private var cursor = initialCursor

        /**
         * Retrieves the next page of sandbox reservations.
         *
         * This method executes a "Get Sandbox Reservations" query to fetch the next page of reservations,
         * updating the pagination state and cursor for subsequent requests.
         *
         * @return A [SandboxReservationsPaginatedResponse] containing the sandbox reservations, raw response, and pagination details.
         * @throws NoSuchElementException If no more pages are available to fetch.
         */
        override fun next(): SandboxReservationsPaginatedResponse {
            if (!hasNext()) {
                throw NoSuchElementException("No more pages to fetch")
            }

            val response =
                getSandboxReservationsOperation(
                    graphQLExecutor = graphQLExecutor,
                    propertyId = propertyId,
                    cursor = cursor,
                    pageSize = pageSize,
                )

            cursor = response.pageInfo.nextPageCursor
            hasNext = response.pageInfo.hasNext

            return SandboxReservationsPaginatedResponse(
                data = response.data,
                pageInfo = response.pageInfo,
                rawResponse = response.rawResponse,
            )
        }

        override fun hasPagesToFetch(): Boolean =
            graphQLExecutor
                .execute(
                    SandboxPropertyReservationsTotalCountQuery(propertyId),
                ).let {
                    it.data.property.reservations.totalCount > 0
                }
    }
