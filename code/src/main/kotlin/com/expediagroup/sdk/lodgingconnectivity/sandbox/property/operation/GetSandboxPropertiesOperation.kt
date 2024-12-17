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

package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation

import com.expediagroup.sdk.core.extension.orNullIfBlank
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.paging.PageInfo
import com.expediagroup.sdk.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData

/**
 * Represents the paginated response for [SandboxPropertiesQuery] GraphQL operation, containing the list of sandbox
 * properties, pagination information, and the full raw GraphQL response.
 *
 * @param data A list of [SandboxPropertyData] representing the sandbox properties returned in the current page.
 * @param rawResponse The raw response from the GraphQL query, including the complete data structure and any associated errors.
 * @param pageInfo Metadata about the pagination state, including the current cursor, the cursor for the next page,
 * the page size, and whether more pages are available.
 */
data class GetSandboxPropertiesResponse(
    override val data: List<SandboxPropertyData>,
    override val rawResponse: RawResponse<SandboxPropertiesQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<SandboxPropertyData>, SandboxPropertiesQuery.Data>


/**
 * Executes a [SandboxPropertiesQuery] GraphQL query to retrieve a paginated list of sandbox properties.
 *
 * This function uses the provided [GraphQLExecutor] to execute the query, with optional parameters for cursor and page size.
 * It returns a [GetSandboxPropertiesResponse] containing the sandbox properties data, pagination information,
 * and the full raw response.
 *
 * @param graphQLExecutor The [GraphQLExecutor] responsible for executing the GraphQL query.
 * @param cursor An optional cursor to specify the starting point for pagination; defaults to `null` for the first page.
 * @param pageSize The number of properties to retrieve per page; defaults to `null` to use the server's default page size.
 * @return A [GetSandboxPropertiesResponse] containing the sandbox properties data, pagination information, and the full raw response.
 * @throws [ExpediaGroupServiceException] If an error occurs during the query execution.
 */
@JvmOverloads
fun getSandboxPropertiesOperation(
    graphQLExecutor: GraphQLExecutor,
    cursor: String? = null,
    pageSize: Int? = null
): GetSandboxPropertiesResponse {
    val operation = SandboxPropertiesQuery
        .builder()
        .pageSize(pageSize)
        .cursor(cursor)
        .build()

    val response = graphQLExecutor.execute(operation)

    val nextPageCursor = response.data.properties.cursor.orNullIfBlank()

    val currentPageInfo = PageInfo(
        cursor = cursor,
        nextPageCursor = nextPageCursor,
        hasNext = nextPageCursor != null,
        pageSize = response.data.properties.elements.size,
        totalCount = response.data.properties.totalCount
    )

    return GetSandboxPropertiesResponse(
        data = response.data.properties.elements.map { it.sandboxPropertyData },
        rawResponse = response,
        pageInfo = currentPageInfo
    )
}
