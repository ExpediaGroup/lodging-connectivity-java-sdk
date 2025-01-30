package com.expediagroup.sdk.rest.extension

import java.io.IOException
import java.net.MalformedURLException
import java.net.URL

import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody

import com.expediagroup.sdk.rest.trait.operation.ContentTypeTrait
import com.expediagroup.sdk.rest.trait.operation.HeadersTrait
import com.expediagroup.sdk.rest.trait.operation.HttpMethodTrait
import com.expediagroup.sdk.rest.trait.operation.OperationRequestBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationRequestTrait
import com.expediagroup.sdk.rest.trait.operation.UrlPathTrait
import com.expediagroup.sdk.rest.trait.operation.UrlQueryParamsTrait
import com.expediagroup.sdk.rest.trait.serialization.SerializeRequestBodyTrait

/**
 * Extension function to parse an operation request into an HTTP request.
 *
 * This function takes an operation request and converts it into an HTTP request
 * by setting the HTTP method, headers, body, and URL based on the traits of the operation.
 *
 * @param serverUrl the base server URL
 * @param serializer instance used to serialize the request body to an InputStream
 * @return the constructed HTTP request
 * @throws IllegalArgumentException if the request body is invalid
 * @throws IllegalStateException if the HTTP method or URL is not set
 * @throws IOException if an I/O error occurs
 */
@Throws(
    IllegalArgumentException::class,
    IllegalStateException::class,
    IOException::class
)
internal fun OperationRequestTrait.parseRequest(
    serverUrl: URL,
    serializer: SerializeRequestBodyTrait
): Request {
    require(this is HttpMethodTrait && this.getHttpMethod().isNotBlank()) {
        "Operation must implement HttpMethodTrait trait!"
    }

    val builder = Request.builder().method(this.parseMethod())

    if (this is HeadersTrait && this.getHeaders().entries().isNotEmpty()) {
        builder.headers(this.getHeaders())
    }

    if (this is OperationRequestBodyTrait<*> && getRequestBody() != null) {
        builder.body(this.parseRequestBody(serializer))
    }

    builder.url(
        if (this is UrlPathTrait && this.getUrlPath().isNotBlank()) {
            this.parseURL(serverUrl)
        } else {
            serverUrl
        }
    )

    return builder.build()
}

/**
 * Extension function to parse the URL of an operation request.
 *
 * This function constructs the full URL by combining the base URL with the path and query parameters
 * from the operation request.
 *
 * @param base the base URL
 * @return the constructed URL
 * @throws MalformedURLException if the constructed URL is invalid
 */
@Throws(MalformedURLException::class)
internal fun UrlPathTrait.parseURL(base: URL): URL =
    URL(
        StringBuilder().apply {
            append(base.toString().trim('/'))

            if (this@parseURL.getUrlPath().isNotBlank()) {
                append(this@parseURL.getUrlPath())
            }

            if (this@parseURL is UrlQueryParamsTrait && this@parseURL.getUrlQueryParams().isNotEmpty()) {
                append("?")
                this@parseURL.getUrlQueryParams().forEach { (key, values) ->
                    if (key.isBlank()) {
                        return@forEach
                    }
                    values.forEach { value -> append("$key=$value&") }
                }
                deleteCharAt(length - 1)
            }
        }.toString()
    )

/**
 * Extension function to parse the HTTP method of an operation request.
 *
 * This function converts the HTTP method from the operation request into the Method enum.
 *
 * @return the HTTP method
 * @throws IllegalArgumentException if the HTTP method is invalid
 */
@Throws(IllegalArgumentException::class)
internal fun HttpMethodTrait.parseMethod(): Method =
    Method.valueOf(getHttpMethod().uppercase())

/**
 * Extension function to parse the media type of operation request.
 *
 * This function converts the content type from the operation request into the MediaType object.
 *
 * @return the media type
 * @throws IllegalArgumentException if the content type is invalid
 */
@Throws(IllegalArgumentException::class)
internal fun ContentTypeTrait.parseMediaType(): MediaType =
    MediaType.parse(getContentType())

/**
 * Extension function to parse the request body of an operation request.
 *
 * This function serializes the request body and constructs the RequestBody object.
 *
 * @param serializer instance used to serialize the request body to an InputStream
 * @return the constructed request body
 * @throws IllegalStateException if the request body cannot be serialized
 * @throws IOException if an I/O error occurs
 */
@Throws(
    IllegalStateException::class,
    IOException::class
)
internal fun OperationRequestBodyTrait<*>.parseRequestBody(
    serializer: SerializeRequestBodyTrait
): RequestBody {
    require(getRequestBody() != null) { "Request body is required!" }

    val inputStream = serializer.serialize(getRequestBody()!!)

    return RequestBody.create(
        inputStream = inputStream,
        mediaType = parseMediaType(),
        contentLength = inputStream.available().toLong()
    )
}
