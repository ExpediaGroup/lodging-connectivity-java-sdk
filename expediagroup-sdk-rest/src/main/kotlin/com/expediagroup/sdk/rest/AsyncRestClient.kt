package com.expediagroup.sdk.rest

import com.expediagroup.sdk.core.transport.Disposable

abstract class AsyncRestClient : Disposable {
    protected abstract val restExecutor: AsyncRestExecutor

    override fun dispose() {
        restExecutor.dispose()
    }
}
