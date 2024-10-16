package com.expediagroup.sdk.v2.core.io

import okio.Buffer
import java.io.InputStream


/**
 * The SafeInputStreamReader class provides a way to safely read from an InputStream with a given content length.
 *
 * @param inputStream The InputStream from which the data will be read.
 * @param contentLength The length of the content to be read from the stream.
 */
class SafeInputStreamReader(inputStream: InputStream, val contentLength: Int) {
    private val buffer = Buffer()

    init {
        synchronized(inputStream) {
            inputStream.mark(contentLength)
            buffer.readFrom(inputStream, contentLength.toLong())
            inputStream.reset()
        }
    }

    /**
     * Reads the contents of the buffer as a UTF-8 encoded string.
     *
     * @return The contents of the buffer as a UTF-8 string.
     */
    fun readUtf8(): String = buffer.clone().readUtf8()

    /**
     * Reads the contents of the buffer and returns it as a byte array.
     *
     * @return A byte array containing the contents of the buffer.
     */
    fun readByteArray(): ByteArray = buffer.clone().readByteArray()
}