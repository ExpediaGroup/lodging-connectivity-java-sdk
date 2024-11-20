package com.expediagroup.sdk.core2.okhttp

import com.expediagroup.sdk.core2.client.HttpClient
import com.expediagroup.sdk.core2.http.HttpHeaders
import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpResponse
import com.expediagroup.sdk.core2.http.HttpResponseBody.Companion.create
import com.expediagroup.sdk.core2.http.MediaType.Companion.parse
import com.expediagroup.sdk.core2.http.Protocol
import java.io.IOException
import okhttp3.Headers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import okio.BufferedSink

class OkHttpClientAdapter(private val okHttpClient: OkHttpClient) : HttpClient {
    override fun execute(request: HttpRequest): HttpResponse {
        val okHttpRequest = toOkHttpRequest(request)
        val okHttpResponse = okHttpClient.newCall(okHttpRequest).execute()
        return toSdkHttpResponse(okHttpResponse, request)
    }

    private fun toOkHttpRequest(sdkHttpRequest: HttpRequest): Request {
        val okHttpRequestBuilder: Request.Builder = Request.Builder()
        val okHttpHeadersBuilder: Headers.Builder = Headers.Builder()

        sdkHttpRequest.headers.names().forEach {
            val headerValues = sdkHttpRequest.headers.values(it)

            headerValues.forEach { value ->
                okHttpHeadersBuilder.add(it, value)
            }
        }

        val okHttpRequestBody = sdkHttpRequest.body?.let {
            object : RequestBody() {
                override fun contentType(): okhttp3.MediaType? {
                    return it.contentType()?.toString()?.toMediaTypeOrNull()
                }

                override fun contentLength(): Long {
                    return it.contentLength()
                }

                @Throws(IOException::class)
                override fun writeTo(sink: BufferedSink) {
                    it.writeTo(sink)
                }
            }
        }

        okHttpRequestBuilder.url(sdkHttpRequest.url.toUrl())
        okHttpRequestBuilder.headers(okHttpHeadersBuilder.build())
        okHttpRequestBuilder.method(sdkHttpRequest.method, okHttpRequestBody)
        okHttpRequestBuilder.tag(sdkHttpRequest.tags)

        return okHttpRequestBuilder.build()
    }

    private fun toSdkHttpResponse(okHttpResponse: Response, sdkHttpRequest: HttpRequest): HttpResponse {
        val sdkResponseBuilder = HttpResponse.Builder()
        val sdkHeaders = HttpHeaders.Builder()

        okHttpResponse.headers.toMultimap().forEach {
            sdkHeaders.add(it.key, it.value)
        }

        okHttpResponse.body?.let {
            sdkResponseBuilder.body(
                create(
                    source = it.source(),
                    contentLength = it.contentLength(),
                    mediaType = it.contentType()?.let { okMediaType -> parse(okMediaType.toString()) }
                )
            )
        }

        sdkResponseBuilder.headers(sdkHeaders.build())
        sdkResponseBuilder.request(sdkHttpRequest)
        sdkResponseBuilder.protocol(Protocol.valueOf(okHttpResponse.protocol.name))
        sdkResponseBuilder.code(okHttpResponse.code)
        sdkResponseBuilder.message(okHttpResponse.message)

        return sdkResponseBuilder.build()
    }
}
