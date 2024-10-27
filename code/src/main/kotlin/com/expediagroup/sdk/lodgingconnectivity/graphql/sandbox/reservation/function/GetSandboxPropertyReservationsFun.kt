package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.reservation.function

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.nullIfBlank
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginationControl
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData
import java.util.Optional

data class SandboxPropertyReservationsResponse(
    override val data: List<SandboxReservationData>,
    override val rawResponse: RawResponse<SandboxPropertyReservationsQuery.Data>,
    val currentPageInfo: PageInfo,
    val nextPagePaginationControl: PaginationControl? = null
) : Response<List<SandboxReservationData>, SandboxPropertyReservationsQuery.Data>

@JvmOverloads
fun getSandboxPropertyReservations(
    client: GraphQLExecutor,
    propertyId: String,
    paginationControl: PaginationControl? = null
): SandboxPropertyReservationsResponse {
    val operation = SandboxPropertyReservationsQuery
        .builder()
        .propertyId(propertyId)
        .cursor(Optional.ofNullable(paginationControl?.cursor))
        .pageSize(Optional.ofNullable(paginationControl?.pageSize))
        .build()

    val response = client.execute(operation)

    val currentPageInfo = PageInfo(
        pageSize = response.data.property.reservations.elements.size,
        hasNext = response.data.property.reservations.cursor.nullIfBlank() != null,
        cursor = paginationControl?.cursor,
        totalCount = response.data.property.reservations.totalCount
    )

    val nextPagePaginationControl = PaginationControl(
        cursor = response.data.property.reservations.cursor.nullIfBlank(),
        pageSize = paginationControl?.pageSize ?: currentPageInfo.pageSize
    )

    return SandboxPropertyReservationsResponse(
        data = response.data.property.reservations.elements.map { it.sandboxReservationData },
        rawResponse = response,
        currentPageInfo = currentPageInfo,
        nextPagePaginationControl = nextPagePaginationControl
    )
}