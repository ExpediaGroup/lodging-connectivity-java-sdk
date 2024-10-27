package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.nullIfBlank
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginationControl
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxPropertyData
import java.util.Optional

data class SandboxPropertiesResponse(
    override val data: List<SandboxPropertyData>,
    override val rawResponse: RawResponse<SandboxPropertiesQuery.Data>,
    val currentPageInfo: PageInfo,
    val nextPagePaginationControl: PaginationControl? = null
) : Response<List<SandboxPropertyData>, SandboxPropertiesQuery.Data>

@JvmOverloads
fun getSandboxPropertiesFun(
    client: GraphQLExecutor,
    paginationControl: PaginationControl? = null
): SandboxPropertiesResponse {
    val operation = SandboxPropertiesQuery
        .builder()
        .pageSize(Optional.ofNullable(paginationControl?.pageSize))
        .cursor(Optional.ofNullable(paginationControl?.cursor))
        .build()

    val response = client.execute(operation)

    val currentPageInfo = PageInfo(
        pageSize = response.data.properties.elements.size,
        hasNext = response.data.properties.cursor.nullIfBlank() != null,
        cursor = paginationControl?.cursor,
        totalCount = response.data.properties.totalCount
    )

    val nextPagePaginationControl = PaginationControl(
        cursor = response.data.properties.cursor.nullIfBlank(),
        pageSize = paginationControl?.pageSize ?: currentPageInfo.pageSize
    )

    return SandboxPropertiesResponse(
        data = response.data.properties.elements.map { it.sandboxPropertyData },
        rawResponse = response,
        currentPageInfo = currentPageInfo,
        nextPagePaginationControl = nextPagePaginationControl
    )
}
