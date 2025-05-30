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

package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation

import com.expediagroup.sdk.graphql.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.RawResponse
import com.expediagroup.sdk.graphql.paging.model.PageInfo
import com.expediagroup.sdk.graphql.paging.model.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.util.orNullIfBlank

/**
 * Represents the paginated response for [SandboxPropertyReservationsQuery] GraphQL operation, containing a list
 * of sandbox reservation data, pagination information, and the full raw GraphQL response.
 *
 * @param data A list of [SandboxReservationData] representing the sandbox reservations returned in the current page.
 * @param rawResponse The raw response from the GraphQL query, including the complete data structure and any associated errors.
 * @param pageInfo Metadata about the pagination state, including the current cursor, the cursor for the next page,
 * the page size, and whether more pages are available.
 */
data class GetSandboxReservationsResponse(
    override val data: List<SandboxReservationData>,
    override val rawResponse: RawResponse<SandboxPropertyReservationsQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<SandboxReservationData>, SandboxPropertyReservationsQuery.Data>

/**
 * Executes [SandboxPropertyReservationsQuery] GraphQL query to retrieve a paginated list of reservations for a specific property.
 *
 * This function uses the provided [GraphQLExecutor] to execute the query, with optional parameters for cursor and page size.
 * It returns a [GetSandboxReservationsResponse] containing the reservation data, pagination information, and the full raw response.
 *
 * @param graphQLExecutor The [GraphQLExecutor] responsible for executing the GraphQL query.
 * @param propertyId The unique identifier of the property for which reservations are being retrieved.
 * @param cursor An optional cursor to specify the starting point for pagination; defaults to `null` for the first page.
 * @param pageSize The number of reservations to retrieve per page; defaults to `null` to use the server's default page size.
 * @return A [GetSandboxReservationsResponse] containing the sandbox reservations data, pagination information, and the full raw response.
 */
@JvmOverloads
fun getSandboxReservationsOperation(
    graphQLExecutor: GraphQLExecutor,
    propertyId: String,
    cursor: String? = null,
    pageSize: Int? = null
): GetSandboxReservationsResponse {
    val operation = SandboxPropertyReservationsQuery
        .builder()
        .propertyId(propertyId)
        .cursor(cursor)
        .pageSize(pageSize)
        .build()

    val response = graphQLExecutor.execute(operation)

    val nextPageCursor = response.data.property.reservations.cursor.orNullIfBlank()

    val currentPageInfo = PageInfo(
        cursor = cursor,
        nextPageCursor = nextPageCursor,
        hasNext = nextPageCursor != null,
        pageSize = response.data.property.reservations.elements.size,
        totalCount = response.data.property.reservations.totalCount
    )

    return GetSandboxReservationsResponse(
        data = response.data.property.reservations.elements.map { it.sandboxReservationData },
        rawResponse = response,
        pageInfo = currentPageInfo
    )
}
