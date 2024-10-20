package com.expediagroup.sdk.v2.core.extension.client

import com.google.api.client.http.HttpRequest
import com.google.api.client.http.InputStreamContent
import okio.Buffer

fun HttpRequest.getContentBuffer(resetContent: Boolean = true) : Buffer =
    Buffer().let { buffer ->
        synchronized(this) {
            content.writeTo(buffer.outputStream())

            if (resetContent) {
                content = InputStreamContent(headers.contentType, buffer.clone().inputStream())
            }

        }

        return@let buffer
    }
