package com.expediagroup.sdk.rest.trait.operation

import com.fasterxml.jackson.core.type.TypeReference

interface OperationResponseTrait : OperationTrait

interface NoResponseBodyTrait : OperationResponseTrait

interface ResponseBodyTrait<BodyType> : OperationResponseTrait

interface JacksonModelResponseBodyTrait<BodyType> : ResponseBodyTrait<BodyType> {
    fun getTypeIdentifier(): TypeReference<BodyType>
}

interface ResponseBodyJacksonTypeIdentifierTrait<BodyType>: ResponseBodyTrait<BodyType>
