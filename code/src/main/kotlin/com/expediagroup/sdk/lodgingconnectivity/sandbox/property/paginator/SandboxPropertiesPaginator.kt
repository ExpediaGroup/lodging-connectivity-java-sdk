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

package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.paginator

import com.expediagroup.sdk.graphql.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.RawResponse
import com.expediagroup.sdk.exemplar.paging.Paginator
import com.expediagroup.sdk.graphql.paging.model.PageInfo
import com.expediagroup.sdk.graphql.paging.model.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertiesTotalCountQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.getSandboxPropertiesOperation

/**
 * Represents a paginated response for [SandboxPropertiesQuery] GraphQL operation, containing
 * a list of sandbox properties, pagination details, and the full raw GraphQL response.
 *
 * @param data A list of [SandboxPropertyData] representing the sandbox properties in the current page.
 * @param rawResponse The raw response from the GraphQL query, including the complete data structure and any associated errors.
 * @param pageInfo Metadata about the pagination state, including the current cursor, the cursor for the next page,
 * the page size, and whether more pages are available.
 */
data class SandboxPropertiesPaginatedResponse(
    override val data: List<SandboxPropertyData>,
    override val rawResponse: RawResponse<SandboxPropertiesQuery.Data>,
    override val pageInfo: PageInfo,
) : PaginatedResponse<List<SandboxPropertyData>, SandboxPropertiesQuery.Data>

/**
 * Provides an iterator to retrieve sandbox properties in a paginated manner using the [SandboxPropertiesQuery]
 * GraphQL operation, allowing seamless iteration over pages of properties.
 *
 * This paginator uses the specified [GraphQLExecutor] to fetch pages based on a cursor and optional page size,
 * providing automatic handling of pagination state.
 *
 * @param graphQLExecutor The [GraphQLExecutor] used to execute GraphQL queries.
 * @param pageSize The number of properties to retrieve per page; defaults to `null` to use the server's default page size.
 * @param initialCursor An optional cursor to specify the starting point for pagination; defaults to `null` for the first page.
 * @constructor Creates a [SandboxPropertiesPaginator] with the specified executor, page size, and initial cursor.
 */
class SandboxPropertiesPaginator
    @JvmOverloads
    constructor(
        private val graphQLExecutor: GraphQLExecutor,
        private val pageSize: Int? = null,
        initialCursor: String? = null,
    ) : com.expediagroup.sdk.exemplar.paging.Paginator<SandboxPropertiesPaginatedResponse>() {
        private var cursor: String? = initialCursor

        /**
         * Retrieves the next page of sandbox properties.
         *
         * This method executes a [SandboxPropertiesQuery] query to fetch the next page of properties,
         * updating the pagination state and cursor for subsequent requests.
         *
         * @return A [SandboxPropertiesPaginatedResponse] containing the sandbox properties, raw response, and pagination details.
         * @throws NoSuchElementException If no more pages are available to fetch.
         */
        override fun next(): SandboxPropertiesPaginatedResponse {
            if (!hasNext()) {
                throw NoSuchElementException("No more pages to fetch")
            }

            val response =
                getSandboxPropertiesOperation(
                    graphQLExecutor = graphQLExecutor,
                    cursor = cursor,
                    pageSize = pageSize,
                )

            cursor = response.pageInfo.nextPageCursor
            hasNext = response.pageInfo.hasNext

            return SandboxPropertiesPaginatedResponse(
                data = response.data,
                rawResponse = response.rawResponse,
                pageInfo = response.pageInfo,
            )
        }

        /**
         * Checks if there are any properties available to fetch, initializing the paginator if necessary.
         *
         * @return `true` if there are properties available, `false` otherwise.
         */
        override fun hasPagesToFetch(): Boolean =
            graphQLExecutor
                .execute(
                    SandboxPropertiesTotalCountQuery(),
                ).let {
                    it.data.properties.totalCount > 0
                }
    }
