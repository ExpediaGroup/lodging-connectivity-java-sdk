package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.paginator

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginatedGraphQLResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyReservationsSummaryQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationSummaryData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PropertyReservationsSummaryInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections
import java.util.Optional
import kotlin.jvm.optionals.getOrElse
import kotlin.jvm.optionals.getOrNull

class PropertyReservationsSummariesPaginator(
    val client: GraphQLExecutor,
    val input: PropertyReservationsSummaryInput,
    val selections: ReservationSelections? = null
) : Iterator<PaginatedGraphQLResponse<List<Optional<ReservationSummaryData>>>> {
    var cursor: String? = getCursorOrNull(input.cursor.getOrElse { Optional.empty() })
    val pageSize: Int = input.pageSize.orElse(10)

    override fun hasNext(): Boolean = cursor != null

    override fun next(): PaginatedGraphQLResponse<List<Optional<ReservationSummaryData>>> {
        val operation = PropertyReservationsSummaryQuery
            .builder()
            .propertyId(input.propertyId)
            .idSource(input.idSource.orElse(Optional.empty()))
            .pageSize(pageSize)
            .cursor(Optional.ofNullable(cursor))
            .filter(input.filter.orElse(Optional.empty()))
            .checkOutDate(input.checkOutDate.orElse(Optional.empty()))
            .build()

        val response = client.execute(operation)
        val responseData = response.dataOrThrow()

        val property = responseData.property.orElseThrow {
            ExpediaGroupServiceException("Failed to fetch property ${input.propertyId}")
        }

        val reservationsPage = property.reservations.paginatedReservationsSummariesData

        val nextPageInfo = reservationsPage.pageInfo.orElseThrow {
            ExpediaGroupServiceException("Failed to fetch reservations next page info for property ${input.propertyId}")
        }

        val currentPageInfo = PageInfo(
            cursor = cursor,
            hasNext = hasNext(),
            pageSize = pageSize,
            totalCount = reservationsPage.totalCount.getOrNull()
        )

        cursor = getCursorOrNull(nextPageInfo.endCursor)

        return PaginatedGraphQLResponse(
            data = reservationsPage.edges.map { edgeOptional -> edgeOptional.map { it.node.reservationSummaryData } },
            errors = response.errors,
            pageInfo = currentPageInfo
        )
    }

    private fun getCursorOrNull(cursor: Optional<String>): String? {
        if (cursor.isPresent) {
            val cursorValue = cursor.get()

            if (cursorValue.isBlank()) {
                return null
            }

            return cursorValue
        }

        return null
    }
}
