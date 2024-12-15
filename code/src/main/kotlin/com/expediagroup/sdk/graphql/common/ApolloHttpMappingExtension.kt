package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.http.HttpBody
import com.apollographql.apollo.api.http.HttpHeader
import com.apollographql.apollo.api.http.HttpRequest
import com.apollographql.apollo.api.http.HttpResponse
import com.expediagroup.sdk.core.http.*
import okio.BufferedSink

fun HttpRequest.toSDKRequest(): Request {
    val headers = headers.toSDKHeaders()
    val body = body?.toSDKRequestBody()
    val method = Method.valueOf(method.name.uppercase())

    return Request.builder()
        .url(url)
        .method(method)
        .headers(headers)
        .apply { body?.let { body(it) } }
        .build()
}

fun List<HttpHeader>.toSDKHeaders(): Headers {
    return Headers.builder().apply { forEach { add(it.name, it.value) } }.build()
}

fun HttpBody.toSDKRequestBody(): RequestBody {
    return object : RequestBody() {
        override fun mediaType(): MediaType? = try {
            MediaType.parse(contentType)
        } catch (e: IllegalArgumentException) {
            null
        }

        override fun contentLength(): Long = contentLength

        override fun writeTo(sink: BufferedSink) {
            this@toSDKRequestBody.writeTo(sink)
        }
    }
}

fun Response.toApolloResponse(): HttpResponse {
    return HttpResponse.Builder(status.code)
        .apply { body?.let { body(it.source()) } }
        .headers(headers.toApolloHeaders())
        .build()
}

fun Headers.toApolloHeaders(): List<HttpHeader> {
    return entries().map { entry -> HttpHeader(entry.key, entry.value.first()) }
}

