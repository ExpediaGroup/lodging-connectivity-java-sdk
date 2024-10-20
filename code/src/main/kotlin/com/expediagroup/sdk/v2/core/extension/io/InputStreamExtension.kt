package com.expediagroup.sdk.v2.core.extension.io

import okio.Buffer
import java.io.InputStream

fun InputStream.toBuffer(contentLength: Int, exhaustStream: Boolean = true): Buffer {
    val buffer = Buffer()

    synchronized(this) {

        if (!exhaustStream) {
            this.mark(contentLength)
        }

        return buffer.readFrom(this, contentLength.toLong()).also {
            if (!exhaustStream) {
                this.reset()
            }
        }
    }
}
