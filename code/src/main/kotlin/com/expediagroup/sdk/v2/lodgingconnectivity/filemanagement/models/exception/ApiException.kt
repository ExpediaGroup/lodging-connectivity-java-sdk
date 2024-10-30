/*
 * Copyright (C) 2022 Expedia, Inc.
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

package com.expediagroup.sdk.v2.lodgingconnectivity.filemanagement.models.exception

import com.expediagroup.sdk.core.model.getTransactionId
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupApiException
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceDefaultErrorException
import com.expediagroup.sdk.v2.lodgingconnectivity.filemanagement.models.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

internal open class HttpStatusCodeRange(
    private val statusCode: String,
    val getException: (HttpResponse) -> ExpediaGroupApiException
) : Comparable<HttpStatusCodeRange> {
    open fun matches(statusCode: String): Boolean = if (isRangeDefinition()) this.statusCode.first() == statusCode.first() else this.statusCode == statusCode
    open fun isRangeDefinition(): Boolean = statusCode.matches(Regex("^[1-5]XX$"))
    override fun compareTo(other: HttpStatusCodeRange): Int = (if (this.isRangeDefinition()) 1 else 0).compareTo(if (other.isRangeDefinition()) 1 else 0)
}

internal object DefaultHttpStatusCodeRange : HttpStatusCodeRange(
    "DefaultHttpStatusCodeRange",
    { ExpediaGroupServiceDefaultErrorException(it.status.value, runBlocking { it.bodyAsText() }, it.request.headers.getTransactionId()) }
) {
    override fun matches(statusCode: String): Boolean = true
    override fun isRangeDefinition(): Boolean = true
}

internal object ErrorObjectMapper {
    private val defaultHttpStatusCodeRanges = listOf(DefaultHttpStatusCodeRange)
    private val httpStatusCodeRanges: Map< String, List< HttpStatusCodeRange > > = mapOf(
                        Pair(
                            "download",
                            listOf(
                                        HttpStatusCodeRange("400") { ExpediaGroupApiGenericErrorException(it.status.value, fetchErrorObject(it) as GenericError, it.headers.getTransactionId()) },
                                        HttpStatusCodeRange("401") { ExpediaGroupApiGenericErrorException(it.status.value, fetchErrorObject(it) as GenericError, it.headers.getTransactionId()) },
                                        HttpStatusCodeRange("403") { ExpediaGroupApiGenericErrorException(it.status.value, fetchErrorObject(it) as GenericError, it.headers.getTransactionId()) },
                                        HttpStatusCodeRange("500") { ExpediaGroupApiGenericErrorException(it.status.value, fetchErrorObject(it) as GenericError, it.headers.getTransactionId()) },
                                        HttpStatusCodeRange("503") { ExpediaGroupApiGenericErrorException(it.status.value, fetchErrorObject(it) as GenericError, it.headers.getTransactionId()) },
                                DefaultHttpStatusCodeRange
                            )
                        ),
                        Pair(
                            "upload",
                            listOf(
                                        HttpStatusCodeRange("400") { ExpediaGroupApiGenericErrorException(it.status.value, fetchErrorObject(it) as GenericError, it.headers.getTransactionId()) },
                                        HttpStatusCodeRange("401") { ExpediaGroupApiGenericErrorException(it.status.value, fetchErrorObject(it) as GenericError, it.headers.getTransactionId()) },
                                        HttpStatusCodeRange("403") { ExpediaGroupApiGenericErrorException(it.status.value, fetchErrorObject(it) as GenericError, it.headers.getTransactionId()) },
                                        HttpStatusCodeRange("500") { ExpediaGroupApiGenericErrorException(it.status.value, fetchErrorObject(it) as GenericError, it.headers.getTransactionId()) },
                                        HttpStatusCodeRange("503") { ExpediaGroupApiGenericErrorException(it.status.value, fetchErrorObject(it) as GenericError, it.headers.getTransactionId()) },
                                DefaultHttpStatusCodeRange
                            )
                        )
    )

    fun process(httpResponse: HttpResponse, operationId: String): ExpediaGroupApiException =
        httpStatusCodeRanges.getOrDefault(operationId, defaultHttpStatusCodeRanges).filter { it.matches(httpResponse.status.value.toString()) }.min().getException(httpResponse)

    private inline fun <reified T> fetchErrorObject(httpResponse: HttpResponse): T = runBlocking {
        runCatching { httpResponse.body<T>() }.getOrElse { throw ExpediaGroupServiceDefaultErrorException(httpResponse.status.value, httpResponse.bodyAsText(), httpResponse.request.headers.getTransactionId()) }
    }
}

        class ExpediaGroupApiGenericErrorException(code: Int, override val errorObject: GenericError, transactionId: String?) : ExpediaGroupApiException(code, errorObject, transactionId)
