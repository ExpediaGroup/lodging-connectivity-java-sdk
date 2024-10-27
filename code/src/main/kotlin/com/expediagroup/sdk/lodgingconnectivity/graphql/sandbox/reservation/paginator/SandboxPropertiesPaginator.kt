package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.paginator

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginationControl
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.getSandboxPropertiesFun

data class SandboxPropertiesPaginatedResponse(
    override val data: List<SandboxPropertyData>,
    override val rawResponse: RawResponse<SandboxPropertiesQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<SandboxPropertyData>, SandboxPropertiesQuery.Data>

class SandboxPropertiesPaginator(
    private val client: GraphQLExecutor,
    initialPaginationControl: PaginationControl
) : Iterator<SandboxPropertiesPaginatedResponse> {
    private var paginationControl = initialPaginationControl
    private var hasEnded: Boolean = false

    override fun hasNext(): Boolean = !hasEnded

    override fun next(): SandboxPropertiesPaginatedResponse {
        val response = getSandboxPropertiesFun(client, paginationControl)

        if (response.nextPagePaginationControl == null) {
            throw ExpediaGroupServiceException("Failed to fetch next page info for sandbox properties")
        }

        paginationControl = response.nextPagePaginationControl
        hasEnded = !response.currentPageInfo.hasNext

        return SandboxPropertiesPaginatedResponse(
            data = response.data,
            rawResponse = response.rawResponse,
            pageInfo = response.currentPageInfo
        )
    }
}
