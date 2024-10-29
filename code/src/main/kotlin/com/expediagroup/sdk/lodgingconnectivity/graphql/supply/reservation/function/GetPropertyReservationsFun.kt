package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.orNullIfBlank
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.constant.Constant
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationSelections
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

data class PropertyReservationsResponse(
    override val data: List<Optional<ReservationData>>,
    override val rawResponse: RawResponse<PropertyReservationsQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<Optional<ReservationData>>, PropertyReservationsQuery.Data>

@JvmOverloads
fun getPropertyReservationsFun(
    client: GraphQLExecutor,
    input: PropertyReservationsInput,
    cursor: String? = null,
    pageSize: Int? = null,
    selections: ReservationSelections? = null
): PropertyReservationsResponse {
    val operation = PropertyReservationsQuery
        .builder()
        .propertyId(input.propertyId)
        .idSource(input.idSource.orElse(Optional.empty()))
        .pageSize(pageSize ?: Constant.RESERVATIONS_DEFAULT_PAGE_SIZE)
        .cursor(Optional.ofNullable(cursor))
        .filter(input.filter.orElse(Optional.empty()))
        .checkOutDate(input.checkOutDate.orElse(Optional.empty()))
        .includeSupplierAmount(selections?.includeSupplierAmount ?: false)
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken ?: false)
        .build()

    val response = client.execute(operation)

    val property = response.data.property.orElseThrow {
        ExpediaGroupServiceException("Failed to fetch property ${input.propertyId}")
    }

    val reservationsPage = property.reservations

    val nextPageInfo = reservationsPage.pageInfo.getOrNull()

    val currentPageInfo = PageInfo(
        cursor = cursor,
        nextPageCursor = nextPageInfo?.endCursor?.orNullIfBlank(),
        hasNext = nextPageInfo?.hasNextPage ?: false,
        pageSize = reservationsPage.edges.size,
        totalCount = reservationsPage.totalCount.getOrNull()
    )

    return PropertyReservationsResponse(
        data = reservationsPage.edges.map { edgeOptional -> edgeOptional.map { it.node.reservationData } },
        rawResponse = response,
        pageInfo = currentPageInfo
    )
}
