package com.expediagroup.sdk.rest

import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import com.expediagroup.sdk.core.transport.Disposable
import com.expediagroup.sdk.rest.extension.parseRequest
import com.expediagroup.sdk.rest.extension.toRestResponse
import com.expediagroup.sdk.rest.model.Response
import com.expediagroup.sdk.rest.trait.operation.JacksonModelOperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationNoResponseBodyTrait
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URL

class RestExecutor(
    private val mapper: ObjectMapper,
    private val requestExecutor: AbstractRequestExecutor,
    private val serverUrl: String
) : Disposable by requestExecutor {

    fun execute(operation: OperationNoResponseBodyTrait): Response<Nothing?> =
        operation.parseRequest(URL(serverUrl), mapper).let(
            requestExecutor::execute
        ).toRestResponse(operation)

    fun <T : Any> execute(operation: JacksonModelOperationResponseBodyTrait<T>): Response<T> =
        operation.parseRequest(URL(serverUrl), mapper).let(
            requestExecutor::execute
        ).toRestResponse(operation, mapper)
}
