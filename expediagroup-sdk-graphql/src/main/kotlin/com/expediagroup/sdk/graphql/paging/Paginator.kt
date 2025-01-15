package com.expediagroup.sdk.graphql.paging

abstract class Paginator<T : PaginatedResponse<*, *>> : Iterator<T> {
    protected var hasNext: Boolean = true
    private var initialized: Boolean = false

    override fun hasNext(): Boolean {
        if (!initialized) {
            initialized = true
            return hasPagesToFetch()
        }

        return hasNext
    }

    protected abstract fun hasPagesToFetch(): Boolean
}
