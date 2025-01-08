/*
 * Copyright (C) 2024 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.stream

import com.expediagroup.sdk.graphql.model.paging.PaginatedStream
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.paginator.ReservationsPaginator

/**
 * Provides a streaming interface for sequentially accessing reservations through a paginated stream.
 *
 * The `ReservationsStream` uses a [ReservationsPaginator] to fetch reservations page by page, allowing
 * items to be retrieved one at a time without manually handling pagination logic.
 *
 * @param paginator The [ReservationsPaginator] responsible for retrieving reservations in a paginated format.
 */
class ReservationsStream(
    private val paginator: ReservationsPaginator,
) : PaginatedStream<ReservationData?>() {
    /**
     * Retrieves the next reservation item from the stream.
     *
     * This method fetches the next page of reservations from the paginator if the current page is exhausted.
     * Returns `null` if there are no more items to retrieve.
     *
     * @return The next [ReservationData] item in the stream, or `null` if no more items are available.
     */
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
