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
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

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
        return deserialize(executeUnparsed().parseAsString(), responseTypeReference)
    }

    inline fun <reified T> executeAndParseAsAsync(responseTypeReference: TypeReference<T>): CompletableFuture<T> {
        return CompletableFuture.supplyAsync({ executeAndParseAs(responseTypeReference) })
    }

    inline fun <reified T> executeAndParseAsAsync(
        responseTypeReference: TypeReference<T>,
        executor: Executor
    ): CompletableFuture<T> {
        return CompletableFuture.supplyAsync({ executeAndParseAs(responseTypeReference) }, executor)
    }

    public override fun executeMediaAsInputStream(): InputStream? {
        return super.executeMediaAsInputStream()
    }

    fun executeMediaAsInputStreamAsync(): CompletableFuture<InputStream?> =
        CompletableFuture.supplyAsync(::executeMediaAsInputStream)

    fun executeMediaAsInputStreamAsync(executor: Executor): CompletableFuture<InputStream?> =
        CompletableFuture.supplyAsync(::executeMediaAsInputStream, executor)

    fun executeUnparsedAsync(executor: Executor): CompletableFuture<HttpResponse> =
        CompletableFuture.supplyAsync(::executeUnparsed, executor)

    fun executeUnparsedAsync(): CompletableFuture<HttpResponse> =
        CompletableFuture.supplyAsync(::executeUnparsed)

    fun executeAndDownloadToAsync(outputStream: OutputStream?) =
        CompletableFuture.supplyAsync { super.executeAndDownloadTo(outputStream) }

    fun executeAndDownloadToAsync(outputStream: OutputStream?, executor: Executor) =
        CompletableFuture.supplyAsync({ super.executeAndDownloadTo(outputStream) }, executor)

    override fun executeUnparsed(): HttpResponse {
        try {
            return super.executeUnparsed().also {
                throwOnError(it)
            }
        } catch (e: Exception) {
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