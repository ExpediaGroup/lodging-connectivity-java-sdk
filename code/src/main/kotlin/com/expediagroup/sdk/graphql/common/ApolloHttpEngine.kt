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

class ApolloHttpEngine(
    private val requestExecutor: RequestExecutor
) : HttpEngine {
    private val activeRequests = ConcurrentHashMap<String, ApolloDisposable>()
    private val isDisposed = AtomicBoolean(false)

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
