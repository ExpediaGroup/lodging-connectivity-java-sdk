package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.paginator

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertyReservationsTotalCountQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function.getSandboxPropertyReservations

data class SandboxReservationsPaginatedResponse(
    override val data: List<SandboxReservationData>,
    override val rawResponse: RawResponse<SandboxPropertyReservationsQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<SandboxReservationData>, SandboxPropertyReservationsQuery.Data>


class SandboxPropertyReservationsPaginator(
    private val client: GraphQLExecutor,
    private val propertyId: String,
    private val pageSize: Int? = null,
    initialCursor: String? = null
) : Iterator<SandboxReservationsPaginatedResponse> {
    private var cursor = initialCursor
    private var hasNext: Boolean = true
    private var initialized: Boolean = false

    override fun hasNext(): Boolean {
        if (!initialized) {
            initialized = true
            return hasReservationsToFetch()
        }

        return hasNext
    }

    override fun next(): SandboxReservationsPaginatedResponse {
        if (!hasNext()) {
            throw NoSuchElementException("No more pages to fetch")
        }

        val response = getSandboxPropertyReservations(
            client = client,
            propertyId = propertyId,
            cursor = cursor,
            pageSize = pageSize
        )

        cursor = response.pageInfo.nextPageCursor
        hasNext = response.pageInfo.hasNext

        return SandboxReservationsPaginatedResponse(
            data = response.data,
            pageInfo = response.pageInfo,
            rawResponse = response.rawResponse
        )
    }

    private fun hasReservationsToFetch(): Boolean = run {
        client.execute(
            SandboxPropertyReservationsTotalCountQuery(propertyId)
        ).let {
            it.data.property.reservations.totalCount > 0
        }
    }
}
