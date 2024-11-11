package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.stream

import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginatedStream
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.paginator.PropertyReservationsPaginator


class PropertyReservationStream(
    private val paginator: PropertyReservationsPaginator
) : PaginatedStream<ReservationData?>() {
    override fun nextItem(): ReservationData? {
        if (isCurrentPageEmpty()) {
            if (!paginator.hasNext()) {
                return null
            }

            fetchNextPage {
                paginator.next().data
            }
        }
        return pollCurrentPage()
    }
}
