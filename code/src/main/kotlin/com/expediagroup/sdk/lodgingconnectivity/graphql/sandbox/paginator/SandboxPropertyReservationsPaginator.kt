package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.paginator

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginatedGraphQLResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.SandboxPropertyReservationsInput
import java.util.Optional

class SandboxPropertyReservationsPaginator(
    val client: GraphQLExecutor,
    val input: SandboxPropertyReservationsInput
) : Iterator<PaginatedGraphQLResponse<List<SandboxReservationData>>> {
    var cursor: String? = getCursorOrNull(input.cursor.orElse(Optional.empty()))
    val pageSize: Optional<Int> = input.pageSize.orElse(Optional.of(10))

    override fun hasNext(): Boolean = cursor != null

    override fun next(): PaginatedGraphQLResponse<List<SandboxReservationData>> {
        val operation = SandboxPropertyReservationsQuery
            .builder()
            .propertyId(input.propertyId)
            .pageSize(pageSize)
            .cursor(Optional.ofNullable(cursor))
            .build()

        val response = client.execute(operation)
        val responseData = response.dataOrThrow()

        val currentPageInfo = PageInfo(
            cursor = cursor,
            pageSize = pageSize.get(),
            hasNext = hasNext(),
            totalCount = responseData.property.reservations.sandboxPaginatedReservationsData.totalCount
        )

        cursor = getCursorOrNull(responseData.property.reservations.sandboxPaginatedReservationsData.cursor)

        return PaginatedGraphQLResponse(
            data = responseData.property.reservations.sandboxPaginatedReservationsData.elements.map { it.sandboxReservationData },
            pageInfo = currentPageInfo,
            errors = response.errors
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
