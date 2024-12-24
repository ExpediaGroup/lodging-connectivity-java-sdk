package com.expediagroup.sdk.core.client

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.AsyncInterceptor
import com.expediagroup.sdk.core.interceptor.AsyncInterceptorsChainExecutor
import java.util.concurrent.CompletableFuture

abstract class AbstractAsyncRequestExecutor(protected val asyncTransport: AsyncTransport) : Disposable {
    protected abstract val interceptors: List<AsyncInterceptor>

    open fun execute(request: Request): CompletableFuture<Response> {
        val chainExecutor = AsyncInterceptorsChainExecutor(
            interceptors = interceptors,
            request = request,
            asyncTransport = this.asyncTransport
        )

        return chainExecutor.proceed(request)
    }

    override fun dispose() = asyncTransport.dispose()
}