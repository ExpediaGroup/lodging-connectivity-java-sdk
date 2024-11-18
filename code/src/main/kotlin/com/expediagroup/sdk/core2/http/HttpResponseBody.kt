package com.expediagroup.sdk.core2.http

import java.io.*
import java.nio.charset.Charset

/**
 * Represents the body of an HTTP response.
 *
 * This class is immutable but not thread-safe.
 */
abstract class HttpResponseBody : Closeable {

    /**
     * Returns the media type of the response body, or null if unknown.
     */
    abstract fun contentType(): MediaType?

    /**
     * Returns the content length, or -1 if unknown.
     */
    abstract fun contentLength(): Long

    /**
     * Returns an [InputStream] to read the response body.
     *
     * Note: The stream can be read only once. Multiple calls will return the same stream.
     *
     * @return The input stream.
     */
    abstract fun byteStream(): InputStream

    /**
     * Reads the response body as a byte array.
     *
     * @return The response body as a byte array.
     * @throws IOException If an I/O error occurs.
     */
    @Throws(IOException::class)
    fun bytes(): ByteArray {
        return byteStream().use { it.readBytes() }
    }

    /**
     * Reads the response body as a string using the specified charset.
     *
     * @param charset The character set to use, or null to use the charset from the content type or UTF-8.
     * @return The response body as a string.
     * @throws IOException If an I/O error occurs.
     */
    @Throws(IOException::class)
    fun string(charset: Charset? = null): String {
        val charsetToUse = charset ?: contentType()?.charset ?: Charsets.UTF_8
        return byteStream().use { it.reader(charsetToUse).readText() }
    }

    /**
     * Closes the response body and releases any resources.
     *
     * @throws IOException If an I/O error occurs.
     */
    @Throws(IOException::class)
    override fun close() {
        byteStream().close()
    }

    companion object {
        /**
         * Creates a new response body from [content] and [mediaType].
         *
         * @param content The content as a byte array.
         * @param mediaType The media type, or null if unknown.
         * @return A new [HttpResponseBody] instance.
         */
        fun create(content: ByteArray, mediaType: MediaType? = null): HttpResponseBody {
            return object : HttpResponseBody() {
                private val byteArrayInputStream = ByteArrayInputStream(content)

                override fun contentType(): MediaType? = mediaType

                override fun contentLength(): Long = content.size.toLong()

                override fun byteStream(): InputStream = byteArrayInputStream
            }
        }

        /**
         * Creates a new response body from [content] and [mediaType].
         *
         * @param content The content as a string.
         * @param mediaType The media type, or null if unknown.
         * @return A new [HttpResponseBody] instance.
         */
        fun create(content: String, mediaType: MediaType? = null): HttpResponseBody {
            val charset = mediaType?.charset ?: Charsets.UTF_8

            val finalMediaType = if (mediaType != null && mediaType.charset == null) {
                mediaType.withCharset(charset)
            } else {
                mediaType
            }

            val bytes = content.toByteArray(charset)
            return create(bytes, finalMediaType)
        }

        /**
         * Creates a new response body from an [InputStream] and [mediaType].
         *
         * @param contentLength The length of the content, or -1 if unknown.
         * @param inputStream The input stream to read from.
         * @param mediaType The media type, or null if unknown.
         * @return A new [HttpResponseBody] instance.
         */
        fun create(contentLength: Long, inputStream: InputStream, mediaType: MediaType? = null): HttpResponseBody {
            return object : HttpResponseBody() {
                private val stream = inputStream

                override fun contentType(): MediaType? = mediaType

                override fun contentLength(): Long = inputStream.available().toLong()

                override fun byteStream(): InputStream = stream
            }
        }
    }
}
