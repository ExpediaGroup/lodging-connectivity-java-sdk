/*
 * Copyright (C) 2024 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.okhttp

import com.expediagroup.sdk.client.AsyncTransport
import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.http.Response
import java.io.IOException
import java.util.concurrent.CompletableFuture
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient

class OkHttpAsyncTransport(
    private val okHttpClient: OkHttpClient
) : AsyncTransport {

    override fun execute(request: Request): CompletableFuture<Response> {
        val future = CompletableFuture<Response>()

        request.toOkHttpRequest().let {
            okHttpClient.newCall(it).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    future.completeExceptionally(e)
                }

                override fun onResponse(call: Call, response: okhttp3.Response) {
                    future.complete(response.toSDKResponse(request))
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
