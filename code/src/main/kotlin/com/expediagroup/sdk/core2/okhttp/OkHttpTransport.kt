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

package com.expediagroup.sdk.core2.okhttp

import com.expediagroup.sdk.core2.client.Transport
import com.expediagroup.sdk.core2.http.ResponseBody.Companion.create
import com.expediagroup.sdk.core2.http.MediaType.Companion.parse
import com.expediagroup.sdk.core2.http.Protocol
import java.io.IOException
import okhttp3.Headers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import okio.BufferedSink

typealias OkHttpRequest = Request
typealias OkHttpRequestBuilder = Request.Builder
typealias OkHttpRequestBody = RequestBody
typealias OkHttpResponse = Response
typealias OkHttpResponseBody = ResponseBody
typealias OkHttpHeaders = Headers
typealias OkHttpHeadersBuilder = Headers.Builder

typealias SdkRequest = com.expediagroup.sdk.core2.http.Request
typealias SdkRequestBody = com.expediagroup.sdk.core2.http.RequestBody
typealias SdkResponse = com.expediagroup.sdk.core2.http.Response
typealias SdkResponseBuilder = com.expediagroup.sdk.core2.http.Response.Builder
typealias SdkHeaders = com.expediagroup.sdk.core2.http.Headers
typealias SdkHeadersBuilder = com.expediagroup.sdk.core2.http.Headers.Builder

class OkHttpTransport(
    private val okHttpClient: OkHttpClient
) : Transport {

    @Throws(IOException::class)
    override fun execute(request: SdkRequest): SdkResponse {
        val okHttpRequest = toOkHttpRequest(request)
        val okHttpResponse = okHttpClient.newCall(okHttpRequest).execute()
        return toSdkHttpResponse(okHttpResponse, request)
    }

    private fun toOkHttpRequest(sdkRequest: SdkRequest): OkHttpRequest {
        return OkHttpRequestBuilder().apply {
            url(sdkRequest.url.toUrl())
            headers(buildHeaders(sdkRequest.headers))
            method(sdkRequest.method, createRequestBody(sdkRequest.body))
            tag(sdkRequest.tags)
        }.build()
    }

    private fun buildHeaders(headers: SdkHeaders): OkHttpHeaders {
        return OkHttpHeadersBuilder().apply {
            headers.entries().forEach { (name, values) ->
                values.forEach { value -> add(name, value) }
            }
        }.build()
    }

    private fun createRequestBody(body: SdkRequestBody?): OkHttpRequestBody? {
        return body?.let {
            object : OkHttpRequestBody() {
                override fun contentType() = it.contentType()?.toString()?.toMediaTypeOrNull()
                override fun contentLength() = it.contentLength()

                @Throws(IOException::class)
                override fun writeTo(sink: BufferedSink) = it.writeTo(sink)
            }
        }
    }

    private fun toSdkHttpResponse(okHttpResponse: OkHttpResponse, sdkRequest: SdkRequest): SdkResponse {
        return SdkResponseBuilder().apply {
            headers(buildSdkHeaders(okHttpResponse.headers))
            okHttpResponse.body?.let { buildResponseBody(it) }?.let { body(it) }
            request(sdkRequest)
            protocol(Protocol.valueOf(okHttpResponse.protocol.name))
            code(okHttpResponse.code)
            message(okHttpResponse.message)
        }.build()
    }

    private fun buildSdkHeaders(headers: OkHttpHeaders): SdkHeaders {
        return SdkHeadersBuilder().apply {
            headers.toMultimap().forEach { (key, values) -> add(key, values) }
        }.build()
    }

    private fun buildResponseBody(body: OkHttpResponseBody) = body.run {
        create(
            source = source(),
            contentLength = contentLength(),
            mediaType = contentType()?.toString()?.let(::parse)
        )
    }
}
