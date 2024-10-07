package com.expediagroup.sdk.v2.core.apache.extension

import org.apache.http.HttpEntityEnclosingRequest

fun HttpEntityEnclosingRequest.readByteArrayAndCloneEntity(): ByteArray =
    entity.readByteArrayAndCloneEntity().let { (byteArray, entity) ->
        this.entity = entity
        return byteArray
    }
