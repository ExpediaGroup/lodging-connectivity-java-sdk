package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.paginator

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginatedGraphQLResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections
import java.util.Optional
import kotlin.jvm.optionals.getOrElse
import kotlin.jvm.optionals.getOrNull

class PropertyReservationsPaginator(
    val client: GraphQLExecutor,
    val input: PropertyReservationsInput,
    val selections: ReservationSelections? = null
) : Iterator<PaginatedGraphQLResponse<List<Optional<ReservationData>>>> {
    var cursor: String? = getCursorOrNull(input.cursor.getOrElse { Optional.empty() })
    val pageSize: Int = input.pageSize.orElse(10)

    override fun hasNext(): Boolean = cursor != null

    override fun next(): PaginatedGraphQLResponse<List<Optional<ReservationData>>> {
        val operation = PropertyReservationsQuery
            .builder()
            .propertyId(input.propertyId)
            .idSource(input.idSource.orElse(Optional.empty()))
            .pageSize(pageSize)
            .cursor(Optional.ofNullable(cursor))
            .filter(input.filter.orElse(Optional.empty()))
            .checkOutDate(input.checkOutDate.orElse(Optional.empty()))
            .includeSupplierAmount(selections?.includeSupplierAmount)
            .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
            .build()

        val response = client.execute(operation)
        val responseData = response.dataOrThrow()

        val property = responseData.property.orElseThrow {
            ExpediaGroupServiceException("Failed to fetch property ${input.propertyId}")
        }

        val reservationsPage = property.reservations.paginatedReservationsData

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
            data = reservationsPage.edges.map { edgeOptional -> edgeOptional.map { it.node.reservationData } },
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
