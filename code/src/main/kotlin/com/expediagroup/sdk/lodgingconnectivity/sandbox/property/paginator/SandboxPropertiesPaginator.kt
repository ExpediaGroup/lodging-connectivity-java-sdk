package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.paginator

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.paging.PageInfo
import com.expediagroup.sdk.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertiesTotalCountQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.getSandboxPropertiesOperation

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

        val response = getSandboxPropertiesOperation(
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
        graphQLExecutor.execute(
            SandboxPropertiesTotalCountQuery()
        ).let {
            it.data.properties.totalCount > 0
        }
    }
}
