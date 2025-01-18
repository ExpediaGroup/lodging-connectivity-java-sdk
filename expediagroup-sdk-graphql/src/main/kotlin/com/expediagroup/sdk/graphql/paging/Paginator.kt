package com.expediagroup.sdk.graphql.paging

import com.expediagroup.sdk.graphql.paging.model.PaginatedResponse

abstract class Paginator<T : PaginatedResponse<*, *>> : Iterator<T> {
    protected var hasNext: Boolean = true
    private var initialized: Boolean = false

    override fun hasNext(): Boolean {
        if (!initialized) {
            initialized = true
            return hasPagesToFetch().also { hasNext = it }
        }

        return hasNext
    }

    protected abstract fun hasPagesToFetch(): Boolean
}
