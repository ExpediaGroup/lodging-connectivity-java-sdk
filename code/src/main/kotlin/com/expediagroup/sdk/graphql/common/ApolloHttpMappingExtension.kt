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

import com.apollographql.apollo.api.http.HttpBody
import com.apollographql.apollo.api.http.HttpHeader
import com.apollographql.apollo.api.http.HttpRequest
import com.apollographql.apollo.api.http.HttpResponse
import com.expediagroup.sdk.core.http.Headers
import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.http.Response
import okio.Buffer
import okio.BufferedSink

fun HttpRequest.toSDKRequest(): Request {
    val headers = headers.toSDKHeaders()
    val body = body?.toSDKRequestBody()
    val method = Method.valueOf(method.name.uppercase())

    return Request
        .builder()
        .url(url)
        .method(method)
        .headers(headers)
        .apply { body?.let { body(it) } }
        .build()
}

fun List<HttpHeader>.toSDKHeaders(): Headers = Headers.builder().apply { forEach { add(it.name, it.value) } }.build()

fun HttpBody.toSDKRequestBody(): RequestBody =
    object : RequestBody() {
        override fun mediaType(): MediaType? =
            try {
                MediaType.parse(contentType)
            } catch (e: IllegalArgumentException) {
                null
            }

        override fun contentLength(): Long = contentLength

        override fun writeTo(sink: BufferedSink) {
            this@toSDKRequestBody.writeTo(sink)
        }
    }

fun Response.toApolloResponse(): HttpResponse =
    use {
        HttpResponse
            .Builder(status.code)
            .apply {
                body?.let {
                    val clonedBody =
                        Buffer().apply {
                            it.source().use { source -> source.readAll(this) }
                        }
                    body(clonedBody)
                }
            }.headers(headers.toApolloHeaders())
            .build()
    }

fun Headers.toApolloHeaders(): List<HttpHeader> = entries().map { entry -> HttpHeader(entry.key, entry.value.first()) }
