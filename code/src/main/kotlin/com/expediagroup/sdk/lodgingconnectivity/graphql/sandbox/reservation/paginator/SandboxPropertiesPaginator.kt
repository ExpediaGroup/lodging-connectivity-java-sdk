package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.paginator

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertiesTotalCountQuery
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
    private var initialized: Boolean = false

    override fun hasNext(): Boolean {
        if (!initialized) {
            initialized = true
            return hasPropertiesToFetch()
        }

        return hasNext
    }

    override fun next(): SandboxPropertiesPaginatedResponse {
        if (!hasNext()) {
            throw NoSuchElementException("No more pages to fetch")
        }

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

    private fun hasPropertiesToFetch(): Boolean = run {
        client.execute(
            SandboxPropertiesTotalCountQuery()
        ).let {
            it.data.properties.totalCount > 0
        }
    }
}
