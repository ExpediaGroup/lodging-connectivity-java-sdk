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

package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation

import com.expediagroup.sdk.core.common.getOrThrow
import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.AbstractGraphQLExecutor
import com.expediagroup.sdk.graphql.model.paging.PageInfo
import com.expediagroup.sdk.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.common.orFalseIfNull
import com.expediagroup.sdk.lodgingconnectivity.common.orNullIfBlank
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.PropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.PropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.constant.Constant

/**
 * Represents the paginated response for [PropertyReservationsQuery] GraphQL operation, containing a list
 * of reservation data, pagination information, and the full raw GraphQL response.
 *
 * @param data A list of nullable [ReservationData?] representing the reservations for the specified property in the current page.
 * @param rawResponse The raw response from the GraphQL query, including the complete data structure and any associated errors.
 * @param pageInfo Metadata about the pagination state, including the current cursor, the cursor for the next page,
 * the page size, and whether more pages are available.
 */
data class PropertyReservationsResponse(
    override val data: List<ReservationData?>,
    override val rawResponse: RawResponse<PropertyReservationsQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<ReservationData?>, PropertyReservationsQuery.Data>

/**
 * Executes [PropertyReservationsQuery] GraphQL query to retrieve a paginated list of reservations for a specific property.
 *
 * This function uses the provided [AbstractGraphQLExecutor] to execute the query, with optional parameters for cursor,
 * page size, and selection of additional reservation details. It returns a [PropertyReservationsResponse]
 * containing the reservation data, pagination information, and the full raw response.
 *
 * @param graphQLExecutor The [AbstractGraphQLExecutor] responsible for executing the GraphQL query.
 * @param input The [PropertyReservationsInput] containing the property ID and filter criteria for the reservations.
 * @param cursor An optional cursor to specify the starting point for pagination; defaults to `null` for the first page.
 * @param pageSize The number of reservations to retrieve per page; defaults to a predefined page size if not provided.
 * @param selections An optional [ReservationSelections] specifying additional fields to include in the response,
 * such as supplier amount and payment instrument token; defaults to `null`.
 * @return A [PropertyReservationsResponse] containing the reservation data, pagination information, and the full raw response.
 * @throws [ExpediaGroupServiceException] If the property data is not available in the response.
 */
@JvmOverloads
fun getReservationsOperation(
    graphQLExecutor: AbstractGraphQLExecutor,
    input: PropertyReservationsInput,
    cursor: String? = null,
    pageSize: Int? = null,
    selections: ReservationSelections? = null
): PropertyReservationsResponse {
    val operation = PropertyReservationsQuery
        .builder()
        .propertyId(input.propertyId)
        .idSource(input.idSource.getOrNull())
        .pageSize(pageSize ?: Constant.RESERVATIONS_DEFAULT_PAGE_SIZE)
        .cursor(cursor)
        .filter(input.filter.getOrNull())
        .checkOutDate(input.checkOutDate.getOrNull())
        .includeSupplierAmount(selections?.includeSupplierAmount.orFalseIfNull())
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken.orFalseIfNull())
        .build()

    val response = graphQLExecutor.execute(operation)

    val property = response.data.property.getOrThrow {
        ExpediaGroupServiceException("Failed to fetch property ${input.propertyId}")
    }

    val reservationsPage = property.reservations

    val nextPageInfo = reservationsPage.pageInfo

    val currentPageInfo = PageInfo(
        cursor = cursor,
        nextPageCursor = nextPageInfo?.endCursor?.orNullIfBlank(),
        hasNext = nextPageInfo?.hasNextPage ?: false,
        pageSize = reservationsPage.edges.size,
        totalCount = reservationsPage.totalCount
    )

    return PropertyReservationsResponse(
        data = reservationsPage.edges.map { edgeOptional -> edgeOptional?.node?.reservationData },
        rawResponse = response,
        pageInfo = currentPageInfo
    )
}
