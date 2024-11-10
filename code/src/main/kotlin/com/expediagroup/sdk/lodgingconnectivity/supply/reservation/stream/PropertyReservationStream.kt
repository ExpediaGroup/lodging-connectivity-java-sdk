package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.stream

import com.expediagroup.sdk.graphql.model.paging.PaginatedStream
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.paginator.PropertyReservationsPaginator


class PropertyReservationStream(
    private val paginator: PropertyReservationsPaginator
) : PaginatedStream<ReservationData?>() {
    override fun nextItem(): ReservationData? {
        while (true) {
            if (index < page.size) {
                return page[index++]
            }

            if (paginator.hasNext()) {
                resetIndex()
                fetchNextPage {
                    paginator.next().data
                }
            } else {
                return null
            }
        }
    }
}
