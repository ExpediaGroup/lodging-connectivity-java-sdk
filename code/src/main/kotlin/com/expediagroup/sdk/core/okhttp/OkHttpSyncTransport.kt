package com.expediagroup.sdk.core.okhttp

import com.expediagroup.sdk.core.client.SyncTransport
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import okhttp3.OkHttpClient

class OkHttpSyncTransport(
    private val okHttpClient: OkHttpClient
): SyncTransport {

    override fun execute(request: Request): Response {
        return request.toOkHttpRequest().let { okHttpClient.newCall(it).execute() }.toSDKResponse(request)
    }

    override fun dispose() {
        okHttpClient.dispatcher.executorService.shutdown()
        okHttpClient.connectionPool.evictAll()
    }
}