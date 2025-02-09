package com.expediagroup.sdk.rest

import com.expediagroup.sdk.core.transport.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.core.transport.Disposable
import com.expediagroup.sdk.rest.extension.parseRequest
import com.expediagroup.sdk.rest.extension.toRestResponse
import com.expediagroup.sdk.rest.model.Response
import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationNoResponseBodyTrait
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URL
import java.util.concurrent.CompletableFuture

class AsyncRestExecutor(
    private val mapper: ObjectMapper,
    private val requestExecutor: AbstractAsyncRequestExecutor,
    private val serverUrl: String
) : Disposable by requestExecutor {

    fun execute(operation: OperationNoResponseBodyTrait): CompletableFuture<Response<Nothing?>> {
        val future = CompletableFuture<Response<Nothing?>>()

        operation.parseRequest(URL(serverUrl), mapper).let(
            requestExecutor::execute
        ).thenApply { response ->
            future.complete(response.toRestResponse(operation))
        }.exceptionally { throwable ->
            future.completeExceptionally(throwable)
        }

        return future
    }


    fun <T : Any> execute(operation: JacksonModelOperationResponseBodyTrait<T>): CompletableFuture<Response<T>> {
        val future = CompletableFuture<Response<T>>()

        operation.parseRequest(URL(serverUrl), mapper).let(
            requestExecutor::execute
        ).thenApply { response ->
            future.complete(response.toRestResponse(operation, mapper))
        }.exceptionally { throwable ->
            future.completeExceptionally(throwable)
        }

        return future
    }
}
