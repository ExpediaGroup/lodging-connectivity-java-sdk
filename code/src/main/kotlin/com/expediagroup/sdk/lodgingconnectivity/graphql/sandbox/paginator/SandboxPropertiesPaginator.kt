package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.paginator

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.nullIfBlank
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginatedGraphQLResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.SandboxPropertiesInput
import java.util.Optional

class SandboxPropertiesPaginator(
    private val client: GraphQLExecutor,
    private val input: SandboxPropertiesInput
) : Iterator<PaginatedGraphQLResponse<SandboxPropertyData>> {
    private var cursor: String? = input.cursor.orElse(Optional.empty()).nullIfBlank()
    private val pageSize: Optional<Int> = input.pageSize.orElse(Optional.of(10))
    private var hasEnded: Boolean = false

    override fun hasNext(): Boolean = !hasEnded

    override fun next(): PaginatedGraphQLResponse<SandboxPropertyData> {
        val operation = SandboxPropertiesQuery
            .builder()
            .pageSize(pageSize)
            .cursor(Optional.ofNullable(cursor))
            .build()

        val response = client.execute(operation)
        val responseData = response.dataOrThrow()

        val currentPageInfo = PageInfo(
            cursor = cursor,
            hasNext = responseData.properties.cursor.nullIfBlank() != null,
            pageSize = pageSize.get(),
            totalCount = responseData.properties.totalCount
        )

        cursor = responseData.properties.cursor.nullIfBlank()
        hasEnded = cursor == null

        return PaginatedGraphQLResponse(
            data = responseData.properties.elements.map { it.sandboxPropertyData },
            pageInfo = currentPageInfo,
            errors = response.errors
        )
    }
}
