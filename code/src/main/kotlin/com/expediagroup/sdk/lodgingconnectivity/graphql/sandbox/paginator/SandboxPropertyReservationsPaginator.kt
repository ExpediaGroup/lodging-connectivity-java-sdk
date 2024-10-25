package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.paginator

import com.expediagroup.sdk.lodgingconnectivity.graphql.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.nullIfBlank
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PaginatedGraphQLResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.SandboxPropertyReservationsInput
import java.util.Optional

class SandboxPropertyReservationsPaginator(
    private val client: GraphQLExecutor,
    private val input: SandboxPropertyReservationsInput
) : Iterator<PaginatedGraphQLResponse<SandboxReservationData>> {
    private var cursor: String? = input.cursor.orElse(Optional.empty()).nullIfBlank()
    private val pageSize: Optional<Int> = input.pageSize.orElse(Optional.of(10))
    private var hasEnded: Boolean = false

    override fun hasNext(): Boolean = !hasEnded

    override fun next(): PaginatedGraphQLResponse<SandboxReservationData> {
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
            hasNext = responseData.property.reservations.cursor.nullIfBlank() != null,
            totalCount = responseData.property.reservations.totalCount
        )

        cursor = responseData.property.reservations.cursor.nullIfBlank()
        hasEnded = cursor == null

        return PaginatedGraphQLResponse(
            data = responseData.property.reservations.elements.map { it.sandboxReservationData },
            pageInfo = currentPageInfo,
            errors = response.errors
        )
    }
}
