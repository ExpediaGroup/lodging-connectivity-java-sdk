package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.function

import com.expediagroup.sdk.core.extension.orNullIfBlank
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.model.SandboxPropertiesResponse

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
