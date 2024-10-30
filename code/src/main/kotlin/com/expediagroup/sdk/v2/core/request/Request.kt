package com.expediagroup.sdk.v2.core.request

import com.expediagroup.sdk.v2.core.jackson.deserialize
import com.expediagroup.sdk.v2.core.model.Operation
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

/**
 * Represents a request to be executed by the Google client.
 *
 * @param ResponseType The type of response expected from the execution of this request.
 * @param client The Google client to be used to execute the request.
 * @param method The HTTP method to be used for the request (e.g., GET, POST).
 * @param url The URL to which the request will be sent.
 * @param content The content to be sent with the request.
 * @param headers The HTTP headers to be included in the request, defaults to empty headers.
 * @param queryParams The query parameters to be included in the request, defaults to empty map.
 * @param responseType The class of the response type.
 * @param disableGzipContent Flag to enable or disable GZip content compression, defaults to true.
 */
class Request<ResponseType : Any>(
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
    /**
     * Constructs a new instance of the Request class using an AbstractGoogleClient and an Operation instance.
     *
     * @param client The Google client to be used for the request.
     * @param operation The operation to be executed, encapsulating the HTTP method, URL, content, headers, and query parameters.
     * @param responseType The type into which the response will be deserialized.
     */
    constructor(
        client: AbstractGoogleClient,
        operation: Operation<*>,
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

    /**
     * Constructs a new instance of the `Request` class using the provided Google API client,
     * GraphQL HTTP request, and the expected response type.
     *
     * @param client The Google API client used for making HTTP requests.
     * @param graphQLRequest The GraphQL HTTP request containing method, URL, body, and headers.
     * @param responseType The class of the expected response type.
     */
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

    /**
     * Executes a request and parses the response into the specified type.
     *
     * @param T The type into which the response should be parsed.
     * @param responseTypeReference A reference to the type into which the response should be parsed.
     * @return The parsed response as an object of type T.
     */
    inline fun <reified T> executeAndParseAs(responseTypeReference: TypeReference<T>): T {
        return deserialize(executeUnparsed().parseAsString(), responseTypeReference)
    }

    /**
     * Executes a request asynchronously and parses the response into the specified type.
     *
     * @param T The type into which the response will be parsed.
     * @param responseTypeReference A reference to the type into which the response should be parsed.
     * @return A CompletableFuture representing pending completion of the parsing operation,
     *         with the parsed response of the specified type.
     */
    inline fun <reified T> executeAndParseAsAsync(responseTypeReference: TypeReference<T>): CompletableFuture<T> {
        return CompletableFuture.supplyAsync({ executeAndParseAs(responseTypeReference) })
    }

    /**
     * Executes a request and parses the response into the specified type asynchronously using the provided executor.
     *
     * @param T The type into which the response should be parsed.
     * @param responseTypeReference A reference to the type into which the response should be parsed.
     * @param executor The executor to use for asynchronous execution.
     * @return A CompletableFuture containing the parsed response as an object of type T.
     */
    inline fun <reified T> executeAndParseAsAsync(
        responseTypeReference: TypeReference<T>,
        executor: Executor
    ): CompletableFuture<T> {
        return CompletableFuture.supplyAsync({ executeAndParseAs(responseTypeReference) }, executor)
    }

    /**
     * Executes a media request and returns the result as an InputStream.
     *
     * @return An InputStream containing the media data, or null if the request failed.
     */
    public override fun executeMediaAsInputStream(): InputStream? {
        return super.executeMediaAsInputStream()
    }

    /**
     * Executes a media request asynchronously and returns the result as an InputStream.
     *
     * @return A CompletableFuture containing an InputStream with the media data, or null if the request failed.
     */
    fun executeMediaAsInputStreamAsync(): CompletableFuture<InputStream?> =
        CompletableFuture.supplyAsync(::executeMediaAsInputStream)

    /**
     * Executes a media request asynchronously using the provided executor and returns the result as an InputStream.
     *
     * @param executor The executor to use for the asynchronous execution.
     * @return A CompletableFuture containing an InputStream with the media data, or null if the request failed.
     */
    fun executeMediaAsInputStreamAsync(executor: Executor): CompletableFuture<InputStream?> =
        CompletableFuture.supplyAsync(::executeMediaAsInputStream, executor)

    /**
     * Executes a request asynchronously without parsing the response.
     *
     * @param executor The executor to use for asynchronous execution.
     * @return A CompletableFuture containing the HttpResponse.
     */
    fun executeUnparsedAsync(executor: Executor): CompletableFuture<HttpResponse> =
        CompletableFuture.supplyAsync(::executeUnparsed, executor)

    /**
     * Executes a request asynchronously without parsing the response.
     *
     * @return A CompletableFuture containing the HttpResponse.
     */
    fun executeUnparsedAsync(): CompletableFuture<HttpResponse> =
        CompletableFuture.supplyAsync(::executeUnparsed)

    /**
     * Executes a request and downloads the response to the specified OutputStream asynchronously.
     *
     * @param outputStream The OutputStream to which the response will be downloaded. Can be null.
     * @return A CompletableFuture representing the pending completion of the download operation.
     */
    fun executeAndDownloadToAsync(outputStream: OutputStream?) =
        CompletableFuture.supplyAsync { super.executeAndDownloadTo(outputStream) }

    /**
     * Executes a request and downloads the response to the specified OutputStream asynchronously using the provided executor.
     *
     * @param outputStream The OutputStream to which the response will be downloaded. Can be null.
     * @param executor The executor to use for asynchronous execution.
     * @return A CompletableFuture representing the pending completion of the download operation.
     */
    fun executeAndDownloadToAsync(outputStream: OutputStream?, executor: Executor) =
        CompletableFuture.supplyAsync({ super.executeAndDownloadTo(outputStream) }, executor)

    /**
     * Executes a request without parsing the response and returns an `HttpResponse`.
     *
     * This method overrides the `executeUnparsed` method from a superclass, executing the request and handling the response.
     * If the response indicates an error, it throws an `ExpediaGroupServiceException`.
     * Any other exceptions encountered during the execution are also caught and rethrown as `ExpediaGroupServiceException`.
     *
     * @return The unparsed `HttpResponse` from the executed request.
     * @throws ExpediaGroupServiceException if the response indicates an error or if any exception occurs during execution.
     */
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

    /**
     * Checks the `HttpResponse` for an error status and throws an `ExpediaGroupServiceException` if an error is detected.
     *
     * @param response The `HttpResponse` to check for errors.
     * @throws ExpediaGroupServiceException if the response status code indicates an error.
     */
    private fun throwOnError(response: HttpResponse) {
        if (!response.isSuccessStatusCode) {
            throw com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException(
                message = response.statusMessage
            )
        }
    }
}
