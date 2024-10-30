package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.paginator

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.getSandboxPropertiesFun

data class SandboxPropertiesPaginatedResponse(
    override val data: List<SandboxPropertyData>,
    override val rawResponse: RawResponse<SandboxPropertiesQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<SandboxPropertyData>, SandboxPropertiesQuery.Data>

class SandboxPropertiesPaginator @JvmOverloads constructor(
    private val graphQLExecutor: GraphQLExecutor,
    private val pageSize: Int? = null,
    initialCursor: String? = null
) : Iterator<SandboxPropertiesPaginatedResponse> {
    private var cursor: String? = initialCursor
    private var hasNext: Boolean = true

    override fun hasNext(): Boolean = hasNext

    override fun next(): SandboxPropertiesPaginatedResponse {
        val response = getSandboxPropertiesFun(
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
}
