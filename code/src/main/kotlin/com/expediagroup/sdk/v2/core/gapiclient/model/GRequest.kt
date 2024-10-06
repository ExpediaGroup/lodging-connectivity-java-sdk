package com.expediagroup.sdk.v2.core.gapiclient.model

import com.expediagroup.sdk.v2.core.jackson.deserialize
import com.fasterxml.jackson.core.type.TypeReference
import com.google.api.client.googleapis.services.AbstractGoogleClient
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest
import com.google.api.client.http.HttpContent
import com.google.api.client.http.HttpHeaders
import com.google.api.client.http.HttpResponse
import com.google.api.client.http.InputStreamContent
import okio.Buffer
import java.io.InputStream
import java.io.OutputStream

class GRequest<ResponseType : Any>(
    private val client: AbstractGoogleClient,
    method: String,
    url: String,
    content: HttpContent?,
    headers: HttpHeaders? = HttpHeaders(),
    queryParams: Map<String, Iterable<Any>>? = emptyMap(),
    responseType: Class<ResponseType>,
    disableGzipContent: Boolean = true
) : AbstractGoogleClientRequest<ResponseType>(
    client,
    method,
    url,
    content,
    responseType
) {
    constructor(
        client: AbstractGoogleClient,
        operation: com.expediagroup.sdk.v2.core.model.Operation<*>,
        responseType: Class<ResponseType>
    ) : this(
        client = client,
        method = operation.method,
        url = operation.url,
        content = operation.getHttpContent(),
        headers = HttpHeaders().apply { operation.params?.getHeaders()?.let { putAll(it) } },
        queryParams = operation.params?.getQueryParams(),
        responseType = responseType
    )

    constructor(
        client: AbstractGoogleClient,
        graphQLRequest: com.apollographql.apollo.api.http.HttpRequest,
        responseType: Class<ResponseType>
    ) : this(
        client = client,
        method = graphQLRequest.method.toString().uppercase(),
        url = graphQLRequest.url,
        content = graphQLRequest.body?.let {
            val buffer = Buffer()
            it.writeTo(buffer)

            return@let InputStreamContent(graphQLRequest.body?.contentType, buffer.inputStream())
        },
        headers = graphQLRequest.headers.let {
            return@let HttpHeaders().apply {
                it.forEach { (key, value) -> put(key, value) }
            }
        },
        responseType = responseType
    )

    init {
        this.disableGZipContent = disableGzipContent
        client.googleClientRequestInitializer.initialize(this)

        headers?.forEach { (key, value) ->
            requestHeaders.put(key, value)
        }

        queryParams?.forEach { (key, value) ->
            put(key, value)
        }
    }

    inline fun <reified T> executeAndParseAs(responseTypeReference: TypeReference<T>): T {
        return deserialize(executeUnparsed().apply {  }.parseAsString(), responseTypeReference)
    }

    public override fun executeMediaAsInputStream(): InputStream? {
        return super.executeMediaAsInputStream()
    }

    override fun executeAndDownloadTo(outputStream: OutputStream?) {
        super.executeAndDownloadTo(outputStream)
    }

    override fun executeUnparsed(): HttpResponse {
        try {
            return super.executeUnparsed()
        } catch (e: Exception) {
            e.printStackTrace()
            throw com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException(
                message = e.message
            )
        }
    }

    private fun throwOnError(response: HttpResponse) {
        if (!response.isSuccessStatusCode) {
            throw com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException(
                message = response.statusMessage
            )
        }
    }
}