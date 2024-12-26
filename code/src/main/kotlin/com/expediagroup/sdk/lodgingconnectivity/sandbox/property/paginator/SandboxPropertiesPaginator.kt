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

import com.expediagroup.sdk.graphql.common.AbstractAsyncGraphQLExecutor
import com.expediagroup.sdk.graphql.common.AbstractGraphQLExecutor
import com.expediagroup.sdk.graphql.model.paging.PageInfo
import com.expediagroup.sdk.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertiesTotalCountQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.getSandboxPropertiesOperation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.getSandboxPropertiesOperationAsync
import java.util.concurrent.CompletableFuture

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
    override val pageInfo: PageInfo
) : PaginatedResponse<List<SandboxPropertyData>, SandboxPropertiesQuery.Data>

/**
 * Provides an iterator to retrieve sandbox properties in a paginated manner using the [SandboxPropertiesQuery]
 * GraphQL operation, allowing seamless iteration over pages of properties.
 *
 * This paginator uses the specified [AbstractGraphQLExecutor] to fetch pages based on a cursor and optional page size,
 * providing automatic handling of pagination state.
 *
 * @param graphQLExecutor The [AbstractGraphQLExecutor] used to execute GraphQL queries.
 * @param pageSize The number of properties to retrieve per page; defaults to `null` to use the server's default page size.
 * @param initialCursor An optional cursor to specify the starting point for pagination; defaults to `null` for the first page.
 * @constructor Creates a [SandboxPropertiesPaginator] with the specified executor, page size, and initial cursor.
 */
class SandboxPropertiesPaginator @JvmOverloads constructor(
    private val graphQLExecutor: AbstractGraphQLExecutor,
    private val pageSize: Int? = null,
    initialCursor: String? = null
) : Iterator<SandboxPropertiesPaginatedResponse> {
    private var cursor: String? = initialCursor
    private var hasNext: Boolean = true
    private var initialized: Boolean = false

    /**
     * Checks if there are more pages to fetch.
     *
     * This method returns `true` if additional pages are available; otherwise, it returns `false`.
     * It initializes the paginator by checking if there are properties to fetch when called for the first time.
     *
     * @return `true` if there are more pages to fetch, `false` otherwise.
     */
    override fun hasNext(): Boolean {
        if (!initialized) {
            initialized = true
            return hasPropertiesToFetch()
        }

        return hasNext
    }

    /**
     * Retrieves the next page of sandbox properties.
     *
     * This method executes a [SandboxPropertiesQuery] query to fetch the next page of properties,
     * updating the pagination state and cursor for subsequent requests.
     *
     * @return A [SandboxPropertiesPaginatedResponse] containing the sandbox properties, raw response, and pagination details.
     * @throws NoSuchElementException If no more pages are available to fetch.
     * @throws ExpediaGroupServiceException If an error occurs during the query execution.
     */
    override fun next(): SandboxPropertiesPaginatedResponse {
        if (!hasNext()) {
            throw NoSuchElementException("No more pages to fetch")
        }

        val response = getSandboxPropertiesOperation(
            graphQLExecutor = graphQLExecutor,
            cursor = cursor,
            pageSize = pageSize
        )

        cursor = response.pageInfo.nextPageCursor
        hasNext = response.pageInfo.hasNext

        return SandboxPropertiesPaginatedResponse(
            data = response.data,
            rawResponse = response.rawResponse,
            pageInfo = response.pageInfo
        )
    }

    /**
     * Checks if there are any properties available to fetch, initializing the paginator if necessary.
     *
     * @return `true` if there are properties available, `false` otherwise.
     */
    private fun hasPropertiesToFetch(): Boolean = run {
        graphQLExecutor.execute(
            SandboxPropertiesTotalCountQuery()
        ).let {
            it.data.properties.totalCount > 0
        }
    }
}

class SandboxPropertiesAsyncPaginator @JvmOverloads constructor(
    private val graphQLExecutor: AbstractAsyncGraphQLExecutor,
    private val pageSize: Int? = null,
    initialCursor: String? = null
) : Iterator<CompletableFuture<SandboxPropertiesPaginatedResponse>> {
    private var cursor: String? = initialCursor
    private var hasNext: Boolean = true
    private var initialized: Boolean = false

    /**
     * Checks if there are more pages to fetch.
     *
     * This method returns `true` if additional pages are available; otherwise, it returns `false`.
     * It initializes the paginator by checking if there are properties to fetch when called for the first time.
     *
     * @return `true` if there are more pages to fetch, `false` otherwise.
     */
    override fun hasNext(): Boolean {
        if (!initialized) {
            initialized = true
            return hasPropertiesToFetch()
        }

        return hasNext
    }

    /**
     * Retrieves the next page of sandbox properties.
     *
     * This method executes a [SandboxPropertiesQuery] query to fetch the next page of properties,
     * updating the pagination state and cursor for subsequent requests.
     *
     * @return A [SandboxPropertiesPaginatedResponse] containing the sandbox properties, raw response, and pagination details.
     * @throws NoSuchElementException If no more pages are available to fetch.
     * @throws ExpediaGroupServiceException If an error occurs during the query execution.
     */
    override fun next(): CompletableFuture<SandboxPropertiesPaginatedResponse> {
        if (!hasNext()) {
            throw NoSuchElementException("No more pages to fetch")
        }

        return getSandboxPropertiesOperationAsync(
            graphQLExecutor = graphQLExecutor,
            cursor = cursor,
            pageSize = pageSize
        ).thenApply {
            cursor = it.pageInfo.nextPageCursor
            hasNext = it.pageInfo.hasNext

            SandboxPropertiesPaginatedResponse(
                data = it.data,
                rawResponse = it.rawResponse,
                pageInfo = it.pageInfo
            )
        }
    }

    /**
     * Checks if there are any properties available to fetch, initializing the paginator if necessary.
     *
     * @return `true` if there are properties available, `false` otherwise.
     */
    private fun hasPropertiesToFetch(): Boolean = run {
        graphQLExecutor.execute(
            SandboxPropertiesTotalCountQuery()
        ).join().let {
            it.data.properties.totalCount > 0
        }
    }
}
