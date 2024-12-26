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

import com.expediagroup.sdk.core.extension.orNullIfBlank
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.AbstractGraphQLExecutor
import com.expediagroup.sdk.graphql.model.paging.PageInfo
import com.expediagroup.sdk.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData
import java.util.concurrent.CompletableFuture

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
 * This function uses the provided [AbstractGraphQLExecutor] to execute the query, with optional parameters for cursor and page size.
 * It returns a [GetSandboxReservationsResponse] containing the reservation data, pagination information, and the full raw response.
 *
 * @param graphQLExecutor The [AbstractGraphQLExecutor] responsible for executing the GraphQL query.
 * @param propertyId The unique identifier of the property for which reservations are being retrieved.
 * @param cursor An optional cursor to specify the starting point for pagination; defaults to `null` for the first page.
 * @param pageSize The number of reservations to retrieve per page; defaults to `null` to use the server's default page size.
 * @return A [GetSandboxReservationsResponse] containing the sandbox reservations data, pagination information, and the full raw response.
 * @throws [ExpediaGroupServiceException] If an error occurs during the query execution.
 */
@JvmOverloads
fun getSandboxReservationsOperation(
    graphQLExecutor: AbstractGraphQLExecutor,
    propertyId: String,
    cursor: String? = null,
    pageSize: Int? = null
): CompletableFuture<GetSandboxReservationsResponse> {
    val operation = SandboxPropertyReservationsQuery
        .builder()
        .propertyId(propertyId)
        .cursor(cursor)
        .pageSize(pageSize)
        .build()

    return graphQLExecutor.execute(operation).thenApply {
        val nextPageCursor = it.data.property.reservations.cursor.orNullIfBlank()

        val currentPageInfo = PageInfo(
            cursor = cursor,
            nextPageCursor = nextPageCursor,
            hasNext = nextPageCursor != null,
            pageSize = it.data.property.reservations.elements.size,
            totalCount = it.data.property.reservations.totalCount
        )

        GetSandboxReservationsResponse(
            data = it.data.property.reservations.elements.map { reservation -> reservation.sandboxReservationData },
            rawResponse = it,
            pageInfo = currentPageInfo
        )
    }
}
