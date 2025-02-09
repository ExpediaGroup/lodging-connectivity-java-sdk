package com.expediagroup.sdk.rest

import com.expediagroup.sdk.core.transport.Disposable

abstract class RestClient: Disposable {
    protected abstract val restExecutor: RestExecutor

    override fun dispose() {
        restExecutor.dispose()
    }
}
