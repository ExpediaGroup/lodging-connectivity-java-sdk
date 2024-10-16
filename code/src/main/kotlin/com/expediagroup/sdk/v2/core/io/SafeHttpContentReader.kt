package com.expediagroup.sdk.v2.core.io

import com.google.api.client.http.HttpRequest
import com.google.api.client.http.InputStreamContent
import okio.Buffer

/**
 * SafeHttpContentReader is designed to safely capture and read the content of an HttpRequest.
 *
 * @constructor
 * Creates an instance of SafeHttpContentReader by initializing the buffer with the request content.
 * The content of the request is copied and converted into a cloneable buffer for safe reading.
 *
 * @param request the HttpRequest whose content needs to be read safely.
 */
class SafeHttpContentReader(request: HttpRequest) {
    private val buffer = Buffer()

    init {
        synchronized(request) {
            request.content.writeTo(buffer.outputStream())
            request.content = InputStreamContent(request.headers.contentType, buffer.clone().inputStream())
        }
    }

    /**
     * Reads the content of the buffer as a UTF-8 encoded string.
     *
     * @return the content of the buffer as a UTF-8 string
     */
    fun readUtf8(): String = buffer.clone().readUtf8()

    /**
     * Reads the entire content of the buffer and returns it as a byte array.
     *
     * @return a byte array containing the content of the buffer
     */
    fun readByteArray(): ByteArray = buffer.clone().readByteArray()
}