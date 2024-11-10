package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.extension.orNullIfBlank
import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxPropertyData

data class SandboxPropertiesResponse(
    override val data: List<SandboxPropertyData>,
    override val rawResponse: RawResponse<SandboxPropertiesQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<SandboxPropertyData>, SandboxPropertiesQuery.Data>

@JvmOverloads
fun getSandboxPropertiesFun(
    graphQLExecutor: GraphQLExecutor,
    cursor: String? = null,
    pageSize: Int? = null
): SandboxPropertiesResponse {
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

    return SandboxPropertiesResponse(
        data = response.data.properties.elements.map { it.sandboxPropertyData },
        rawResponse = response,
        pageInfo = currentPageInfo
    )
}
