package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.nullIfBlank
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginationControl
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyReservationsSummaryQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationSummaryData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.constant.Constant
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PropertyReservationsInput
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

data class ReservationsSummaryResponse(
    override val data: List<Optional<ReservationSummaryData>>,
    override val rawResponse: RawResponse<PropertyReservationsSummaryQuery.Data>,
    val currentPageInfo: PageInfo,
    val nextPagePaginationControl: PaginationControl? = null
) : Response<List<Optional<ReservationSummaryData>>, PropertyReservationsSummaryQuery.Data>

@JvmOverloads
fun getPropertyReservationsSummaryFun(
    client: GraphQLExecutor,
    input: PropertyReservationsInput,
    paginationControl: PaginationControl? = null,
): ReservationsSummaryResponse {
    val pageSize: Int = paginationControl?.pageSize ?: Constant.RESERVATIONS_DEFAULT_PAGE_SIZE

    val operation = PropertyReservationsSummaryQuery
        .builder()
        .propertyId(input.propertyId)
        .idSource(input.idSource.orElse(Optional.empty()))
        .pageSize(pageSize)
        .cursor(Optional.ofNullable(paginationControl?.cursor))
        .filter(input.filter.orElse(Optional.empty()))
        .checkOutDate(input.checkOutDate.orElse(Optional.empty()))
        .build()

    val response = client.execute(operation)

    val property = response.data.property.orElseThrow {
        ExpediaGroupServiceException("Failed to fetch property ${input.propertyId}")
    }

    val reservationsPage = property.reservations

    val nextPageInfo = reservationsPage.pageInfo.getOrNull()

    val currentPageInfo = PageInfo(
        cursor = paginationControl?.cursor,
        hasNext = nextPageInfo?.hasNextPage ?: false,
        pageSize = reservationsPage.edges.size,
        totalCount = reservationsPage.totalCount.getOrNull()
    )

    val nextPagePaginationControl = if (nextPageInfo != null) {
        PaginationControl(
            pageSize = pageSize,
            cursor = nextPageInfo.endCursor.nullIfBlank()
        )
    } else null

    return ReservationsSummaryResponse(
        data = reservationsPage.edges.map { edgeOptional -> edgeOptional.map { it.node.reservationSummaryData } },
        rawResponse = response,
        currentPageInfo = currentPageInfo,
        nextPagePaginationControl = nextPagePaginationControl,
    )
}
