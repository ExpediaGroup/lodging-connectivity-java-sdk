package com.expediagroup.sdk.core.gapiclient.model

import com.expediagroup.sdk.core.jackson.deserialize
import com.expediagroup.sdk.core.model.Operation
import com.fasterxml.jackson.core.type.TypeReference
import com.google.api.client.googleapis.services.AbstractGoogleClient
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest
import com.google.api.client.http.AbstractInputStreamContent
import com.google.api.client.http.HttpContent
import com.google.api.client.http.HttpRequest
import com.google.api.client.http.HttpResponse
import com.google.api.client.http.MultipartContent
import java.io.InputStream
import java.io.OutputStream

class Request <ResponseType>(
    client: AbstractGoogleClient,
    operation: Operation<*>,
    responseType: Class<ResponseType>
): AbstractGoogleClientRequest<ResponseType>(
    client,
    operation.method,
    operation.url,
    operation.getHttpContent(),
    responseType
) {
    init {
        operation.params?.getHeaders()?.forEach{ (key, value) ->
            requestHeaders.put(key, value)
        }

        operation.params?.getQueryParams()?.forEach{ (key, value) ->
            put(key, value)
        }

        requestHeaders.setUserAgent("expediagroup-sdk-${requestHeaders.userAgent}")
    }

    override fun buildHttpRequest(): HttpRequest {
        val req = super.buildHttpRequest()
        println("build req called")
        req.url.remove("alt", "media")
        return req
    }

    override fun executeMedia(): HttpResponse {
        return buildHttpRequest().also {
            println(it)
        }.execute()
    }

    fun buildHttpRequest(content: HttpContent): HttpRequest {
        return super.buildHttpRequest().setContent(content)
    }

    override fun execute(): ResponseType? {
        super.executeMedia()
        return null
    }

    inline fun  <reified T> executeAndParseAs(responseTypeReference: TypeReference<T>): T {
        return deserialize(executeUnparsed().parseAsString(), responseTypeReference)
    }

    public override fun executeMediaAsInputStream(): InputStream? {
        return super.executeMediaAsInputStream()
    }

    public override fun executeUnparsed(): HttpResponse {
        return buildHttpRequest().execute()
    }

    public override fun executeAndDownloadTo(outputStream: OutputStream?) {
        super.executeAndDownloadTo(outputStream)
    }
}