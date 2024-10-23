package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.paginator

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginatedGraphQLResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.SandboxPropertiesInput
import java.util.Optional

class SandboxPropertiesPaginator(
    val client: GraphQLExecutor,
    val input: SandboxPropertiesInput
) : Iterator<PaginatedGraphQLResponse<List<SandboxPropertyData>>> {
    var cursor: String? = getCursorOrNull(input.cursor.orElse(Optional.empty()))
    val pageSize: Optional<Int> = input.pageSize.orElse(Optional.of(10))

    override fun hasNext(): Boolean = cursor != null

    override fun next(): PaginatedGraphQLResponse<List<SandboxPropertyData>> {
        val operation = SandboxPropertiesQuery
            .builder()
            .pageSize(pageSize)
            .cursor(Optional.ofNullable(cursor))
            .build()

        val response = client.execute(operation)
        val responseData = response.dataOrThrow()

        val currentPageInfo = PageInfo(
            cursor = cursor,
            hasNext = hasNext(),
            pageSize = pageSize.get(),
            totalCount = responseData.properties.totalCount
        )

        cursor = getCursorOrNull(responseData.properties.cursor)

        return PaginatedGraphQLResponse(
            data = responseData.properties.elements.map { it.sandboxPropertyData },
            pageInfo = currentPageInfo,
            errors = response.errors
        )
    }

    private fun getCursorOrNull(cursor: Optional<String>): String? {
        if (cursor.isPresent) {
            val cursorValue = cursor.get()

            if (cursorValue.isBlank()) {
                return null
            }

            return cursorValue
        }

        return null
    }
}
