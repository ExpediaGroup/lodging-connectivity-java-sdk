package com.expediagroup.sdk.core.client

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import java.util.concurrent.CompletableFuture

interface AsyncTransport {
    fun execute(request: Request): CompletableFuture<Response>
}