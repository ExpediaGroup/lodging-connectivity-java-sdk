package com.expediagroup.sdk.core.apache.extension

import okio.Buffer
import org.apache.http.HttpEntity
import org.apache.http.entity.ByteArrayEntity
import org.apache.http.entity.ContentType
import org.apache.http.entity.HttpEntityWrapper

fun HttpEntity.readByteArrayAndReset(): Pair<ByteArray, ByteArrayEntity> =
    HttpEntityWrapper(this).let { wrapper ->
        Buffer().apply {
            wrapper.writeTo(outputStream())
        }.readByteArray().let { byteArray: ByteArray ->
            Pair(byteArray, ByteArrayEntity(byteArray, ContentType.get(this)))
        }
    }
