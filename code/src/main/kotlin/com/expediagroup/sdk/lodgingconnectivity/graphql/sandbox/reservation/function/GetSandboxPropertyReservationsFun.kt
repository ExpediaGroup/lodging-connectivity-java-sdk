package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.extension.orNullIfBlank
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData

data class SandboxPropertyReservationsResponse(
    override val data: List<SandboxReservationData>,
    override val rawResponse: RawResponse<SandboxPropertyReservationsQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<SandboxReservationData>, SandboxPropertyReservationsQuery.Data>

@JvmOverloads
fun getSandboxPropertyReservations(
    graphQLExecutor: GraphQLExecutor,
    propertyId: String,
    cursor: String? = null,
    pageSize: Int? = null
): SandboxPropertyReservationsResponse {
    val operation = SandboxPropertyReservationsQuery
        .builder()
        .propertyId(propertyId)
        .cursor(cursor)
        .pageSize(pageSize)
        .build()

    val response = graphQLExecutor.execute(operation)

    val nextPageCursor = response.data.property.reservations.cursor.orNullIfBlank()

    val currentPageInfo = PageInfo(
        cursor = cursor,
        nextPageCursor = nextPageCursor,
        hasNext = nextPageCursor != null,
        pageSize = response.data.property.reservations.elements.size,
        totalCount = response.data.property.reservations.totalCount
    )

    return SandboxPropertyReservationsResponse(
        data = response.data.property.reservations.elements.map { it.sandboxReservationData },
        rawResponse = response,
        pageInfo = currentPageInfo
    )
}
