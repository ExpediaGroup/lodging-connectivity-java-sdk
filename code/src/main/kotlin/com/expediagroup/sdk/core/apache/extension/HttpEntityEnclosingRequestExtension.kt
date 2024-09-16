package com.expediagroup.sdk.core.apache.extension

import org.apache.http.HttpEntityEnclosingRequest

fun HttpEntityEnclosingRequest.readByteArrayAndReset(): ByteArray =
    entity.readByteArrayAndReset().let { (byteArray, entity) ->
        this.entity = entity
        return byteArray
    }
