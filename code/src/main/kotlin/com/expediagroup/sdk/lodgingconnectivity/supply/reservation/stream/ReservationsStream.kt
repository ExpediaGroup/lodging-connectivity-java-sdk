package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.stream

import com.expediagroup.sdk.graphql.model.paging.PaginatedStream
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.paginator.ReservationsPaginator

class ReservationsStream(private val paginator: ReservationsPaginator) : PaginatedStream<ReservationData?>() {
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
