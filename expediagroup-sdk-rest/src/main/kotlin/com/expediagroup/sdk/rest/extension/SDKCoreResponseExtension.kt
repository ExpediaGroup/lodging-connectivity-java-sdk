package com.expediagroup.sdk.rest.extension

import com.expediagroup.sdk.core.http.Response as SDKCoreResponse
import com.expediagroup.sdk.rest.model.Response
import com.expediagroup.sdk.rest.trait.operation.OperationNoResponseBodyTrait
import com.expediagroup.sdk.rest.trait.operation.OperationResponseBodyTrait
import com.expediagroup.sdk.rest.trait.serialization.DeserializeResponseBodyTrait

/**
 * Extension function to parse the body of an SDKCoreResponse as a specific type.
 *
 * @param T the type of the response body
 * @param operation the operation that defines the response body type
 * @param deserializer the deserializer to use for parsing the response body
 * @return the parsed response body of type T
 */
internal fun <T : Any> SDKCoreResponse.parseBodyAs(
    operation: OperationResponseBodyTrait<T>,
    deserializer: DeserializeResponseBodyTrait
): T {
    require(body != null) { "Response body is null!" }
    require(body!!.source().isOpen ) { "Response body is closed!" }
    require(body!!.contentLength() != 0L) { "Response body is empty!" }
    require(body!!.source().exhausted().not()) { "Response body is exhausted!" }

    return deserializer.deserialize(body!!.source().inputStream(), operation)
}

/**
 * Extension function to convert an SDKCoreResponse to a RestResponse.
 *
 * @param T the type of the response body
 * @param operation the operation that defines the response body type
 * @param deserializer the deserializer to use for parsing the response body
 * @return a Response object containing the parsed response body and headers
 */
internal fun <T : Any> SDKCoreResponse.toRestResponse(
    operation: OperationResponseBodyTrait<T>,
    deserializer: DeserializeResponseBodyTrait
): Response<T> {
    return Response(
        data = parseBodyAs(operation, deserializer),
        headers = headers
    )
}

/**
 * Extension function to convert an SDKCoreResponse to a RestResponse with empty body.
 *
 * @return a Response object containing null data and headers
 */
@Suppress("UNUSED_PARAMETER")
internal fun SDKCoreResponse.toRestResponse(operation: OperationNoResponseBodyTrait): Response<Nothing?> {
    return Response(
        data = null,
        headers = headers
    )
}
