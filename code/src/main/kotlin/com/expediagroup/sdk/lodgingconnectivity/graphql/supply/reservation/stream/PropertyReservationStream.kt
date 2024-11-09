package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.stream

import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginatedStream
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.paginator.PropertyReservationsPaginator


class PropertyReservationStream(
    private val paginator: PropertyReservationsPaginator
) : PaginatedStream<ReservationData?>() {
    private var reservationsPage: List<ReservationData?> = emptyList()
    private var index = 0

    override fun nextItem(): ReservationData? {
        while (true) {
            if (index < reservationsPage.size) {
                return reservationsPage[index++]
            }

            if (paginator.hasNext()) {
                fetchNextPageAndResetIndex()
            } else {
                return null
            }
        }
    }

    private fun fetchNextPageAndResetIndex() {
        reservationsPage = paginator.next().data
        index = 0
    }
}
