package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.paginator

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginationControl
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertyReservationsQuery
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
    initialPaginationControl: PaginationControl
) : Iterator<SandboxReservationsPaginatedResponse> {
    private var paginationControl = initialPaginationControl
    private var hasEnded: Boolean = false

    override fun hasNext(): Boolean = !hasEnded

    override fun next(): SandboxReservationsPaginatedResponse {
        val response = getSandboxPropertyReservations(client, propertyId)

        if (response.nextPagePaginationControl == null) {
            throw ExpediaGroupServiceException("Failed to fetch reservations next page info for sandbox property $propertyId")
        }

        paginationControl = response.nextPagePaginationControl
        hasEnded = !response.currentPageInfo.hasNext

        return SandboxReservationsPaginatedResponse(
            data = response.data,
            pageInfo = response.currentPageInfo,
            rawResponse = response.rawResponse
        )
    }
}
