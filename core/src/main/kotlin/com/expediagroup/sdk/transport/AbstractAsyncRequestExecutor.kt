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

package com.expediagroup.sdk.transport

import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.http.Response
import com.expediagroup.sdk.loader.AsyncTransportLoader
import com.expediagroup.sdk.pipeline.ExecutionPipeline
import java.util.concurrent.CompletableFuture

abstract class AbstractAsyncRequestExecutor(asyncTransport: AsyncTransport? = null) : Disposable {
    protected val asyncTransport: AsyncTransport = asyncTransport ?: AsyncTransportLoader.load()

    abstract val executionPipeline: ExecutionPipeline

    fun execute(request: Request): CompletableFuture<Response> = executionPipeline
        .startRequestPipeline(request).let {
            asyncTransport.execute(it).thenApply { request -> executionPipeline.startResponsePipeline(request) }
        }

    override fun dispose() = asyncTransport.dispose()
}
