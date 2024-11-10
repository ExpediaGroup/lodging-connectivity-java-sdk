package com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.function

import com.expediagroup.sdk.core.extension.orNullIfBlank
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.model.SandboxPropertyReservationsResponse

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
