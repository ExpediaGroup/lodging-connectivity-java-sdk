package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.paginator

import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging.PageInfo
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyReservationsSummaryQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.fragment.ReservationSummaryData
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.reservation.function.getPropertyReservationsSummaryFun
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PropertyReservationsInput

data class ReservationsSummaryPaginatedResponse(
    override val data: List<ReservationSummaryData?>,
    override val rawResponse: RawResponse<PropertyReservationsSummaryQuery.Data>,
    override val pageInfo: PageInfo,
) : PaginatedResponse<List<ReservationSummaryData?>, PropertyReservationsSummaryQuery.Data>

class PropertyReservationsSummariesPaginator @JvmOverloads constructor(
    private val graphQLExecutor: GraphQLExecutor,
    private val input: PropertyReservationsInput,
    private val pageSize: Int? = null,
    initialCursor: String? = null
) : Iterator<ReservationsSummaryPaginatedResponse> {
    private var cursor: String? = initialCursor
    private var hasNext: Boolean = true

    override fun hasNext(): Boolean = hasNext

    override fun next(): ReservationsSummaryPaginatedResponse {
        val response = getPropertyReservationsSummaryFun(
            graphQLExecutor = graphQLExecutor,
            input = input,
            cursor = cursor,
            pageSize = pageSize
        )

        cursor = response.pageInfo.nextPageCursor
        hasNext = response.pageInfo.hasNext

        return ReservationsSummaryPaginatedResponse(
            data = response.data,
            pageInfo = response.pageInfo,
            rawResponse = response.rawResponse,
        )
    }
}
