package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation

import com.expediagroup.sdk.core.extension.orNullIfBlank
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.paging.PageInfo
import com.expediagroup.sdk.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData

data class GetSandboxPropertiesResponse(
    override val data: List<SandboxPropertyData>,
    override val rawResponse: RawResponse<SandboxPropertiesQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<SandboxPropertyData>, SandboxPropertiesQuery.Data>

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
