package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation

import com.expediagroup.sdk.core.extension.getOrThrow
import com.expediagroup.sdk.core.extension.orFalseIfNull
import com.expediagroup.sdk.core.extension.orNullIfBlank
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.paging.PageInfo
import com.expediagroup.sdk.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.PropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.PropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.constant.Constant

data class PropertyReservationsResponse(
    override val data: List<ReservationData?>,
    override val rawResponse: RawResponse<PropertyReservationsQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<ReservationData?>, PropertyReservationsQuery.Data>

@JvmOverloads
fun getReservationsOperation(
    graphQLExecutor: GraphQLExecutor,
    input: PropertyReservationsInput,
    cursor: String? = null,
    pageSize: Int? = null,
    selections: ReservationSelections? = null
): PropertyReservationsResponse {
    val operation = PropertyReservationsQuery
        .builder()
        .propertyId(input.propertyId)
        .idSource(input.idSource.getOrNull())
        .pageSize(pageSize ?: Constant.RESERVATIONS_DEFAULT_PAGE_SIZE)
        .cursor(cursor)
        .filter(input.filter.getOrNull())
        .checkOutDate(input.checkOutDate.getOrNull())
        .includeSupplierAmount(selections?.includeSupplierAmount.orFalseIfNull())
        .includePaymentInstrumentToken(selections?.includePaymentInstrumentToken.orFalseIfNull())
        .build()

    val response = graphQLExecutor.execute(operation)

    val property = response.data.property.getOrThrow {
        ExpediaGroupServiceException("Failed to fetch property ${input.propertyId}")
    }

    val reservationsPage = property.reservations

    val nextPageInfo = reservationsPage.pageInfo

    val currentPageInfo = PageInfo(
        cursor = cursor,
        nextPageCursor = nextPageInfo?.endCursor?.orNullIfBlank(),
        hasNext = nextPageInfo?.hasNextPage ?: false,
        pageSize = reservationsPage.edges.size,
        totalCount = reservationsPage.totalCount
    )

    return PropertyReservationsResponse(
        data = reservationsPage.edges.map { edgeOptional -> edgeOptional?.node?.reservationData },
        rawResponse = response,
        pageInfo = currentPageInfo
    )
}
