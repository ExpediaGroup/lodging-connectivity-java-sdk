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

package com.expediagroup.sdk.graphql.model.paging

import java.util.stream.Stream
import kotlin.streams.asStream

/**
 * An abstract class representing a stream of paginated data.
 * It allows iterating over pages of data items in a paginated manner, fetching and
 * providing the next item when requested. Subclasses should implement the nextItem()
 * method to define the logic for retrieving the next item in the stream.
 *
 * The class provides methods to fetch the next page of data, reset the iteration index,
 * and generate a Stream instance from the paginated data.
 *
 * @param T the type of data items in the stream
 */
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
