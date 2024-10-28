package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.paginator

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginationControl
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyReservationsSummaryQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationSummaryData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function.getPropertyReservationsSummaryFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PropertyReservationsInput
import java.util.Optional

data class ReservationsSummaryPaginatedResponse(
    override val data: List<Optional<ReservationSummaryData>>,
    override val rawResponse: RawResponse<PropertyReservationsSummaryQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<Optional<ReservationSummaryData>>, PropertyReservationsSummaryQuery.Data>

class PropertyReservationsSummariesPaginator(
    private val client: GraphQLExecutor,
    private val input: PropertyReservationsInput,
    initialPaginationControl: PaginationControl? = null
) : Iterator<ReservationsSummaryPaginatedResponse> {
    private var paginationControl = initialPaginationControl
    private var hasEnded: Boolean = false

    override fun hasNext(): Boolean = !hasEnded

    override fun next(): ReservationsSummaryPaginatedResponse {
        val response = getPropertyReservationsSummaryFun(client, input, paginationControl)

        if (response.nextPagePaginationControl == null) {
            throw ExpediaGroupServiceException("Failed to fetch reservations next page info for property ${input.propertyId}")
        }

        paginationControl = response.nextPagePaginationControl
        hasEnded = !response.currentPageInfo.hasNext

        return ReservationsSummaryPaginatedResponse(
            data = response.data,
            pageInfo = response.currentPageInfo,
            rawResponse = response.rawResponse
        )
    }
}
