package com.expediagroup.sdk.rest.trait.operation

import com.fasterxml.jackson.core.type.TypeReference

interface OperationResponseTrait : OperationTrait

interface OperationNoResponseBodyTrait : OperationResponseTrait

interface OperationResponseBodyTrait<BodyType> : OperationResponseTrait

interface JacksonModelOperationResponseBodyTrait<BodyType> : OperationResponseBodyTrait<BodyType> {
    fun getTypeIdentifier(): TypeReference<BodyType>
}

interface OperationResponseBodyJacksonTypeIdentifierTrait<BodyType>: OperationResponseBodyTrait<BodyType>
