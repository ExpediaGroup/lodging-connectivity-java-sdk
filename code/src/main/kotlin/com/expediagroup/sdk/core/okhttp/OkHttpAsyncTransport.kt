package com.expediagroup.sdk.core.okhttp

import com.expediagroup.sdk.core.client.AsyncTransport
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import java.io.IOException
import java.util.concurrent.CompletableFuture
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient

class OkHttpAsyncTransport(private val okHttpClient: OkHttpClient) : AsyncTransport {

    override fun execute(request: Request): CompletableFuture<Response> {
        val future = CompletableFuture<Response>()

        request.toOkHttpRequest().let {
            okHttpClient.newCall(it).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    future.completeExceptionally(e)
                }

                override fun onResponse(call: Call, response: okhttp3.Response) {
                    future.complete(response.toSDKResponse(request));
                }
            })
        }

        return future
    }

    override fun dispose() {
        okHttpClient.dispatcher.executorService.shutdown()
        okHttpClient.connectionPool.evictAll()
    }
}