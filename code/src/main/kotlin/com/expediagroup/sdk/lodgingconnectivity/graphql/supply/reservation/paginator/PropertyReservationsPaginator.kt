package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.paginator

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginationControl
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function.getPropertyReservationsFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections
import java.util.Optional

data class ReservationsPaginatedResponse(
    override val data: List<Optional<ReservationData>>,
    override val rawResponse: RawResponse<PropertyReservationsQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<Optional<ReservationData>>, PropertyReservationsQuery.Data>


class PropertyReservationsPaginator(
    private val client: GraphQLExecutor,
    private val input: PropertyReservationsInput,
    private val selections: ReservationSelections? = null,
    initialPaginationControl: PaginationControl? = null
) : Iterator<ReservationsPaginatedResponse> {
    private var paginationControl = initialPaginationControl
    private var hasEnded: Boolean = false

    override fun hasNext(): Boolean = !hasEnded

    override fun next(): ReservationsPaginatedResponse {
        val response = getPropertyReservationsFun(client, input, paginationControl, selections)

        if (response.nextPagePaginationControl == null) {
            throw ExpediaGroupServiceException("Failed to fetch reservations next page info for property ${input.propertyId}")
        }

        paginationControl = response.nextPagePaginationControl
        hasEnded = !response.currentPageInfo.hasNext

        return ReservationsPaginatedResponse(
            data = response.data,
            pageInfo = response.currentPageInfo,
            rawResponse = response.rawResponse
        )
    }
}
