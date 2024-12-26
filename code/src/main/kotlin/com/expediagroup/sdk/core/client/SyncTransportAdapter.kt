package com.expediagroup.sdk.core.client

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import java.util.concurrent.CompletableFuture

class SyncTransportAdapter(private val syncTransport: SyncTransport) : Transport {

    override fun execute(request: Request): CompletableFuture<Response> {
        return CompletableFuture.completedFuture(syncTransport.execute(request))
    }

    override fun dispose() {
        syncTransport.dispose()
    }
}