package com.expediagroup.sdk.rest

import com.expediagroup.sdk.core.transport.Disposable

/**
 * Abstract class representing an asynchronous REST client.
 *
 * This class provides a base implementation for an asynchronous REST client that uses an AsyncRestExecutor
 * to perform HTTP requests. It implements the Disposable interface to ensure that
 * resources are properly released when the client is no longer needed.
 */
abstract class AsyncRestClient : Disposable {

    /**
     * The AsyncRestExecutor used to execute asynchronous REST operations.
     */
    protected abstract val restExecutor: AsyncRestExecutor

    /**
     * Disposes of the resources used by the AsyncRestExecutor.
     *
     * This method is called to release any resources held by the AsyncRestExecutor
     * when the AsyncRestClient is no longer needed.
     */
    override fun dispose() {
        restExecutor.dispose()
    }
}
