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

package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.paginator

import com.expediagroup.sdk.core.extension.getOrThrow
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.AbstractGraphQLExecutor
import com.expediagroup.sdk.graphql.model.paging.PageInfo
import com.expediagroup.sdk.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.PropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.PropertyReservationsTotalCountQuery
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.PropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.constant.Constant
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.getReservationsOperation

/**
 * Represents a paginated response for [PropertyReservationsQuery] GraphQL operation, containing a list
 * of reservation data, pagination information, and the full raw GraphQL response.
 *
 * @param data A list of nullable [ReservationData] representing the reservations for the specified property in the current page.
 * @param rawResponse The raw response from the GraphQL query, including the complete data structure and any associated errors.
 * @param pageInfo Metadata about the pagination state, including the current cursor, the cursor for the next page,
 * the page size, and whether more pages are available.
 */
data class ReservationsPaginatedResponse(
    override val data: List<ReservationData?>,
    override val rawResponse: RawResponse<PropertyReservationsQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<ReservationData?>, PropertyReservationsQuery.Data>


/**
 * Provides an iterator to retrieve property reservations in a paginated manner using [PropertyReservationsQuery]
 * GraphQL operation, allowing seamless iteration over pages of reservations for a specified property.
 *
 * This paginator uses the specified [AbstractGraphQLExecutor] to fetch pages based on cursor, page size, and optional reservation
 * field selections, managing the pagination state automatically.
 *
 * @param graphQLExecutor The [AbstractGraphQLExecutor] used to execute GraphQL queries.
 * @param input The [PropertyReservationsInput] specifying the property ID and filter criteria for retrieving reservations.
 * @param selections An optional [ReservationSelections] specifying additional fields to include in the response, such as
 * supplier amount and payment instrument token; defaults to `null`.
 * @param pageSize The number of reservations to retrieve per page; defaults to `null` to use the server's default page size.
 * @param initialCursor An optional cursor to specify the starting point for pagination; defaults to `null` for the first page.
 * @constructor Creates a [ReservationsPaginator] with the specified executor, input parameters, and initial cursor.
 */
class ReservationsPaginator @JvmOverloads constructor(
    private val graphQLExecutor: AbstractGraphQLExecutor,
    private val input: PropertyReservationsInput,
    private val selections: ReservationSelections? = null,
    private val pageSize: Int? = null,
    initialCursor: String? = null
) : Iterator<ReservationsPaginatedResponse> {
    private var cursor: String? = initialCursor
    private var hasNext: Boolean = true
    private var initialized: Boolean = false

    /**
     * Checks if there are more pages to fetch.
     *
     * This method returns `true` if additional pages are available; otherwise, it returns `false`.
     * It initializes the paginator by checking if there are reservations to fetch when called for the first time.
     *
     * @return `true` if there are more pages to fetch, `false` otherwise.
     */
    override fun hasNext(): Boolean {
        if (!initialized) {
            initialized = true
            return hasReservationsToFetch()
        }

        return hasNext
    }

    /**
     * Retrieves the next page of property reservations.
     *
     * This method executes [PropertyReservationsQuery] query to fetch the next page of reservations,
     * updating the pagination state and cursor for subsequent requests.
     *
     * @return A [ReservationsPaginatedResponse] containing the property reservations, raw response, and pagination details.
     * @throws NoSuchElementException If no more pages are available to fetch.
     * @throws [ExpediaGroupServiceException] If an error occurs during the query execution.
     */
    override fun next(): ReservationsPaginatedResponse {
        if (!hasNext()) {
            throw NoSuchElementException("No more pages to fetch")
        }

        val response = getReservationsOperation(
            graphQLExecutor = graphQLExecutor,
            input = input,
            selections = selections,
            cursor = cursor,
            pageSize = pageSize
        )

        cursor = response.pageInfo.nextPageCursor
        hasNext = response.pageInfo.hasNext

        return ReservationsPaginatedResponse(
            data = response.data,
            pageInfo = response.pageInfo,
            rawResponse = response.rawResponse,
        )
    }

    /**
     * Checks if there are any reservations available to fetch, initializing the paginator if necessary.
     *
     * @return `true` if there are reservations available, `false` otherwise.
     * @throws [ExpediaGroupServiceException] If an error occurs during the query execution.
     */
    private fun hasReservationsToFetch(): Boolean = run {
        graphQLExecutor.execute(
            PropertyReservationsTotalCountQuery
                .builder()
                .propertyId(input.propertyId)
                .idSource(input.idSource.getOrNull())
                .pageSize(pageSize ?: Constant.RESERVATIONS_DEFAULT_PAGE_SIZE)
                .cursor(cursor)
                .build()
        ).let {
            it.data.property.getOrThrow {
                ExpediaGroupServiceException("Failed to fetch property ${input.propertyId}")
            }
        }.let {
            val totalCount = it.reservations.totalCount ?: 0
            totalCount > 0
        }
    }
}
