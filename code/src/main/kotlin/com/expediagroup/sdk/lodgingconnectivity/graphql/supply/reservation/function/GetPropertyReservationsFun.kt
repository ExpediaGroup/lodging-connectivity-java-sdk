package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.orNullIfBlank
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginationControl
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.constant.Constant
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

data class GetPropertyReservationsResponse(
    override val data: List<Optional<ReservationData>>,
    override val rawResponse: RawResponse<PropertyReservationsQuery.Data>,
    val currentPageInfo: PageInfo,
    val nextPagePaginationControl: PaginationControl? = null
) : Response<List<Optional<ReservationData>>, PropertyReservationsQuery.Data>

@JvmOverloads
fun getPropertyReservationsFun(
    client: GraphQLExecutor,
    input: PropertyReservationsInput,
    paginationControl: PaginationControl? = null,
    selections: ReservationSelections? = null
): GetPropertyReservationsResponse {
    val pageSize: Int = paginationControl?.pageSize ?: Constant.RESERVATIONS_DEFAULT_PAGE_SIZE

    val operation = PropertyReservationsQuery
        .builder()
        .propertyId(input.propertyId)
        .idSource(input.idSource.orElse(Optional.empty()))
        .pageSize(pageSize)
        .cursor(Optional.ofNullable(paginationControl?.cursor))
        .filter(input.filter.orElse(Optional.empty()))
        .checkOutDate(input.checkOutDate.orElse(Optional.empty()))
        .includeSupplierAmount(selections?.includeSupplierAmount)
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken)
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
            cursor = nextPageInfo.endCursor.orNullIfBlank()
        )
    } else null

    return GetPropertyReservationsResponse(
        data = reservationsPage.edges.map { edgeOptional -> edgeOptional.map { it.node.reservationData } },
        rawResponse = response,
        currentPageInfo = currentPageInfo,
        nextPagePaginationControl = nextPagePaginationControl
    )
}
