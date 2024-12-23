package com.expediagroup.sdk.core.client

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor
import java.util.concurrent.CompletableFuture

abstract class AsyncRequestExecutor(asyncTransport: AsyncTransport) {
    protected abstract val interceptors: List<Interceptor>

    protected abstract fun execute(request: Request): CompletableFuture<Response>
}