/*
 * Copyright (C) 2024 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.graphql.paging

import java.util.stream.Stream
import kotlin.streams.asStream

/**
 * A utility for sequentially retrieving items from a paginated data source as a continuous stream.
 * Items are fetched one at a time, with new pages loaded as needed.
 *
 * Subclasses implement the `nextItem` method to define how items are retrieved from paginated sources.
 *
 * @param T The type of items contained in the paginated stream.
 */
abstract class PaginatedStream<T> {

    // Holds the current page of items fetched from the data source.
    private var currentPage: ArrayDeque<T?> = ArrayDeque()

    /**
     * Returns a [Stream] of items, sequentially fetching new items as needed from `nextItem`.
     *
     * @return A [Stream] that lazily retrieves items.
     */
    fun stream(): Stream<T> = generateSequence { nextItem() }.asStream()

    /**
     * Retrieves the next item in the paginated sequence. Subclasses must provide an implementation
     * to specify how items are fetched.
     *
     * @return The next item in the stream, or `null` if no more items are available.
     */
    protected abstract fun nextItem(): T?

    /**
     * Fetches the next page of items and updates the current page.
     *
     * @param pageSupplier A function that supplies the next page of items as a list.
     */
    protected fun fetchNextPage(pageSupplier: () -> List<T?>) {
        currentPage = ArrayDeque(pageSupplier())
    }

    /**
     * Retrieves and removes the next item from the current page, or returns `null` if the page is empty.
     *
     * @return The next item from the current page, or `null` if there are no more items.
     */
    protected fun pollCurrentPage(): T? = try {
        currentPage.removeFirst()
    } catch (e: NoSuchElementException) {
        null
    }

    /**
     * Checks if the current page is empty.
     *
     * @return `true` if the current page has no more items, otherwise `false`.
     */
    protected fun isCurrentPageEmpty(): Boolean = currentPage.isEmpty()
}
