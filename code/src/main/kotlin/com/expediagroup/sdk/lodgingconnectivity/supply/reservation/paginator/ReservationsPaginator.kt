package com.expediagroup.sdk.lodgingconnectivity.supply.reservation.paginator

import com.expediagroup.sdk.core.extension.getOrThrow
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.paging.PageInfo
import com.expediagroup.sdk.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.PropertyReservationsQuery
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.PropertyReservationsTotalCountQuery
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.fragment.ReservationData
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.PropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.supply.operation.type.ReservationSelections
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.constant.Constant
import com.expediagroup.sdk.lodgingconnectivity.supply.reservation.operation.getReservationsOperation

data class ReservationsPaginatedResponse(
    override val data: List<ReservationData?>,
    override val rawResponse: RawResponse<PropertyReservationsQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<ReservationData?>, PropertyReservationsQuery.Data>


class ReservationsPaginator @JvmOverloads constructor(
    private val graphQLExecutor: GraphQLExecutor,
    private val input: PropertyReservationsInput,
    private val selections: ReservationSelections? = null,
    private val pageSize: Int? = null,
    initialCursor: String? = null
) : Iterator<ReservationsPaginatedResponse> {
    private var cursor: String? = initialCursor
    private var hasNext: Boolean = true
    private var initialized: Boolean = false

    override fun hasNext(): Boolean {
        if (!initialized) {
            initialized = true
            return hasReservationsToFetch()
        }

        return hasNext
    }

    override fun next(): ReservationsPaginatedResponse {
        if (!hasNext()) {
            throw NoSuchElementException("No more pages to fetch")
        }

        val response = getReservationsOperation(
            graphQLExecutor = graphQLExecutor,
            input = input,
            selections = selections,
            cursor = cursor,
            pageSize = pageSize
        )

        cursor = response.pageInfo.nextPageCursor
        hasNext = response.pageInfo.hasNext

        return ReservationsPaginatedResponse(
            data = response.data,
            pageInfo = response.pageInfo,
            rawResponse = response.rawResponse,
        )
    }

    private fun hasReservationsToFetch(): Boolean = run {
        graphQLExecutor.execute(
            PropertyReservationsTotalCountQuery
                .builder()
                .propertyId(input.propertyId)
                .idSource(input.idSource.getOrNull())
                .pageSize(pageSize ?: Constant.RESERVATIONS_DEFAULT_PAGE_SIZE)
                .cursor(cursor)
                .build()
        ).let {
            it.data.property.getOrThrow {
                ExpediaGroupServiceException("Failed to fetch property ${input.propertyId}")
            }
        }.let {
            val totalCount = it.reservations.totalCount ?: 0
            totalCount > 0
        }
    }
}
