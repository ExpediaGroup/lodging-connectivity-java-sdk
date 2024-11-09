package com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging

import java.util.stream.Stream
import kotlin.streams.asStream

abstract class PaginatedStream<T> {
    protected var page: List<T?> = emptyList()
    protected var index = 0

    fun stream(): Stream<T> = generateSequence { nextItem() }.asStream()

    protected abstract fun nextItem(): T?

    protected fun fetchNextPage(cb: () -> List<T?>) {
        page = cb()
    }

    protected fun resetIndex() {
        index = 0
    }
}
