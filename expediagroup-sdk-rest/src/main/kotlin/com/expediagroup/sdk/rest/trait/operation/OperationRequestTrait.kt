package com.expediagroup.sdk.rest.trait.operation

interface OperationRequestTrait : OperationTrait

interface ContentTypeTrait : OperationRequestTrait {
    fun getContentType(): String
}

interface HttpMethodTrait : OperationRequestTrait {
    fun getHttpMethod(): String
}

interface UrlQueryParamsTrait : OperationRequestTrait {
    fun getUrlQueryParams(): Map<String, List<String>>
}

interface UrlPathTrait : OperationRequestTrait {
    fun getUrlPath(): String
}

interface HeadersTrait : OperationRequestTrait {
    fun getHeaders(): Map<String, List<String>>
}

interface OperationRequestBodyTrait<T> : OperationRequestTrait {
    fun getRequestBody(): T
}
