package com.expediagroup.sdk.v2.core.logging

import okio.Buffer
import java.io.InputStream

class NonConsumingInputStream(
    private val inputStream: InputStream,
) {
    private val buffer = Buffer()

    init {
//        buffer.readFrom()
    }

}