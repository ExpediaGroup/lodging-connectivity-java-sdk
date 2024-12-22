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

package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.http.HttpRequest
import com.apollographql.apollo.exception.ApolloNetworkException
import com.apollographql.java.client.ApolloDisposable
import com.apollographql.java.client.network.http.HttpCallback
import com.apollographql.java.client.network.http.HttpEngine
import com.expediagroup.sdk.core.client.RequestExecutor
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicBoolean

/**
 * An implementation of Apollo's [HttpEngine] that delegates HTTP execution to a provided [RequestExecutor].
 *
 * @param requestExecutor The [RequestExecutor] used to execute HTTP requests. It is expected that the provided
 * executor takes a request from the Apollo SDK request object model and produces a suitable HTTP response.
 */
class ApolloHttpEngine(
    private val requestExecutor: RequestExecutor
) : HttpEngine {
    private val activeRequests = ConcurrentHashMap<String, ApolloDisposable>()
    private val isDisposed = AtomicBoolean(false)

    /**
     * Executes the given [request] using the [requestExecutor]. If the engine has already been disposed,
     * the callback will receive an [ApolloNetworkException] indicating that the engine is no longer available.
     */
    override fun execute(request: HttpRequest, callback: HttpCallback, disposable: ApolloDisposable) {
        if (isDisposed.get()) {
            callback.onFailure(ApolloNetworkException("HTTP engine has been disposed"))
            return
        }

        val requestId = UUID.randomUUID().toString().also { activeRequests[it] = disposable }

        try {
            runCatching {
                requestExecutor.execute(request.toSDKRequest())
            }.onSuccess { response ->
                if (!isDisposed.get()) {
                    callback.onResponse(response.toApolloResponse())
                }
            }.onFailure { exception ->
                callback.onFailure(ApolloNetworkException("Unexpected error occurred", exception))
            }
        } finally {
            activeRequests.remove(requestId)
        }
    }

    override fun dispose() {
        if (isDisposed.compareAndSet(false, true)) {
            activeRequests.values.forEach { it.dispose() }
            activeRequests.clear()
        }
    }
}
