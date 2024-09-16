package com.expediagroup.sdk.core.apache.extension

import org.apache.http.HttpEntityEnclosingRequest

fun HttpEntityEnclosingRequest.safeReadByteArray(): ByteArray =
    entity.readByteArray().let { (byteArray, entity) ->
        this.entity = entity
        return byteArray
    }
