package com.expediagroup.sdk.lodgingconnectivity.graphql.model.paging

import java.util.stream.Stream
import kotlin.streams.asStream

abstract class PaginatedStream<T> {
    fun stream(): Stream<T> = generateSequence { nextItem() }.asStream()

    protected abstract fun nextItem(): T?
}
