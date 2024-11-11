package com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging

import java.util.stream.Stream
import kotlin.streams.asStream

abstract class PaginatedStream<T> {
    private var currentPage: ArrayDeque<T?> = ArrayDeque()

    fun stream(): Stream<T> = generateSequence { nextItem() }.asStream()

    protected abstract fun nextItem(): T?

    protected fun fetchNextPage(pageSupplier: () -> List<T?>) {
        currentPage = ArrayDeque(pageSupplier())
    }

    protected fun pollCurrentPage(): T? = currentPage.removeFirst()

    protected fun isCurrentPageEmpty(): Boolean = currentPage.isEmpty()
}
