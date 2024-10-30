package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.getOrThrow
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.nullIfBlank
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyReservationsSummaryQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationSummaryData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.constant.Constant
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PropertyReservationsInput

data class ReservationsSummaryResponse(
    override val data: List<ReservationSummaryData?>,
    override val rawResponse: RawResponse<PropertyReservationsSummaryQuery.Data>,
    override val pageInfo: PageInfo,
) : PaginatedResponse<List<ReservationSummaryData?>, PropertyReservationsSummaryQuery.Data>

@JvmOverloads
fun getPropertyReservationsSummaryFun(
    client: GraphQLExecutor,
    input: PropertyReservationsInput,
    cursor: String? = null,
    pageSize: Int? = null
): ReservationsSummaryResponse {
    val operation = PropertyReservationsSummaryQuery
        .Builder()
        .propertyId(input.propertyId)
        .idSource(input.idSource.getOrNull())
        .pageSize(pageSize ?: Constant.RESERVATIONS_DEFAULT_PAGE_SIZE)
        .cursor(cursor)
        .filter(input.filter.getOrNull())
        .checkOutDate(input.checkOutDate.getOrNull())
        .build()

    val response = client.execute(operation)

    val property = response.data.property.getOrThrow {
        ExpediaGroupServiceException("Failed to fetch property ${input.propertyId}")
    }

    val reservationsPage = property.reservations

    val nextPageInfo = reservationsPage.pageInfo

    val currentPageInfo = PageInfo(
        cursor = cursor,
        nextPageCursor = nextPageInfo?.endCursor?.nullIfBlank(),
        hasNext = nextPageInfo?.hasNextPage ?: false,
        pageSize = reservationsPage.edges.size,
        totalCount = reservationsPage.totalCount
    )

    return ReservationsSummaryResponse(
        data = reservationsPage.edges.map { edgeOptional -> edgeOptional?.node?.reservationSummaryData },
        rawResponse = response,
        pageInfo = currentPageInfo
    )
}
