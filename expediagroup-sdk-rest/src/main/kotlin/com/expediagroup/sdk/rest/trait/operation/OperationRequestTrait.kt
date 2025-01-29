package com.expediagroup.sdk.rest.trait.operation

/**
 * Marker interface for operation requests.
 */
interface OperationRequestTrait : OperationTrait

/**
 * Interface for operations that have a content type.
 */
interface ContentTypeTrait : OperationRequestTrait {
    /**
     * Get the content type of the request.
     *
     * @return the content type as a String
     */
    fun getContentType(): String
}

/**
 * Interface for operations that have an HTTP method.
 */
interface HttpMethodTrait : OperationRequestTrait {
    /**
     * Get the HTTP method of the request.
     *
     * @return the HTTP method as a String
     */
    fun getHttpMethod(): String
}

/**
 * Interface for operations that have URL query parameters.
 */
interface UrlQueryParamsTrait : OperationRequestTrait {
    /**
     * Get the URL query parameters of the request.
     *
     * @return a map of query parameters where the key is the parameter name and the value is a list of parameter values
     */
    fun getUrlQueryParams(): Map<String, List<String>>
}

/**
 * Interface for operations that have a URL path.
 */
interface UrlPathTrait : OperationRequestTrait {
    /**
     * Get the URL path of the request.
     *
     * @return the URL path as a String
     */
    fun getUrlPath(): String
}

/**
 * Interface for operations that have headers.
 */
interface HeadersTrait : OperationRequestTrait {
    /**
     * Get the headers of the request.
     *
     * @return a map of headers where the key is the header name and the value is a list of header values
     */
    fun getHeaders(): Map<String, List<String>>
}

/**
 * Interface for operations that have a request body.
 *
 * @param T the type of the request body
 */
interface OperationRequestBodyTrait<T> : OperationRequestTrait, ContentTypeTrait {
    /**
     * Get the request body.
     *
     * @return the request body of type T
     */
    fun getRequestBody(): T
}
