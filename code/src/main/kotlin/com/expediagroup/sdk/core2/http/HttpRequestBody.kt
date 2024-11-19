package com.expediagroup.sdk.core2.http

import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.URLEncoder
import java.nio.charset.Charset

/**
 * Represents an HTTP request body.
 *
 * This class is immutable and thread-safe.
 */
abstract class HttpRequestBody {

    /**
     * Returns the media type of the request body.
     */
    abstract fun contentType(): MediaType?

    /**
     * Returns the number of bytes that will be written to [writeTo], or -1 if unknown.
     */
    open fun contentLength(): Long = -1

    /**
     * Writes the request body to the given [outputStream].
     *
     * @param outputStream the output stream to write to.
     * @throws IOException if an I/O error occurs.
     */
    @Throws(IOException::class)
    abstract fun writeTo(outputStream: OutputStream)

    companion object {
        /**
         * Creates a new request body from [content] and [mediaType].
         *
         * @param mediaType the media type, or null if unknown.
         * @param content the content as a byte array.
         * @return a new [HttpRequestBody] instance.
         * @throws IllegalArgumentException if [content] is null.
         */
        fun create(mediaType: MediaType?, content: ByteArray): HttpRequestBody {
            return object : HttpRequestBody() {
                override fun contentType(): MediaType? = mediaType

                override fun contentLength(): Long = content.size.toLong()

                @Throws(IOException::class)
                override fun writeTo(outputStream: OutputStream) {
                    outputStream.use { out ->
                        out.write(content)
                    }
                }
            }
        }

        /**
         * Creates a new request body from [content] and [mediaType].
         *
         * @param mediaType the media type, or null if unknown.
         * @param content the content as a string.
         * @param charset the character set to use; defaults to UTF-8.
         * @return a new [HttpRequestBody] instance.
         * @throws IllegalArgumentException if [content] is null.
         */
        fun create(
            mediaType: MediaType?,
            content: String,
            charset: Charset = Charsets.UTF_8
        ): HttpRequestBody {

            val finalMediaType = if (mediaType != null && mediaType.charset == null) {
                mediaType.withCharset(charset)
            } else {
                mediaType
            }

            val bytes = content.toByteArray(charset)
            return create(finalMediaType, bytes)
        }

        /**
         * Creates a new request body that reads from the given [file].
         *
         * @param mediaType the media type, or null if unknown.
         * @param file the file to read from.
         * @return a new [HttpRequestBody] instance.
         * @throws IllegalArgumentException if [file] does not exist.
         */
        fun create(mediaType: MediaType?, file: File): HttpRequestBody {
            require(file.exists()) { "file does not exist: ${file.path}" }

            return object : HttpRequestBody() {
                override fun contentType(): MediaType? = mediaType

                override fun contentLength(): Long = file.length()

                @Throws(IOException::class)
                override fun writeTo(outputStream: OutputStream) {
                    file.inputStream().use { input ->
                        input.copyTo(outputStream)
                    }
                }
            }
        }

        /**
         * Creates a new request body that reads from the given [inputStream].
         *
         * @param mediaType the media type, or null if unknown.
         * @param contentLength the length of the content, or -1 if unknown.
         * @param inputStream the input stream to read from.
         * @return a new [HttpRequestBody] instance.
         */
        fun create(
            mediaType: MediaType?,
            contentLength: Long = -1,
            inputStream: InputStream
        ): HttpRequestBody {
            return object : HttpRequestBody() {
                override fun contentType(): MediaType? = mediaType

                override fun contentLength(): Long = contentLength

                @Throws(IOException::class)
                override fun writeTo(outputStream: OutputStream) {
                    inputStream.use { input ->
                        input.copyTo(outputStream)
                    }
                }
            }
        }

        /**
         * Creates a new request body for form data with content type "application/x-www-form-urlencoded".
         *
         * @param formData The form data as a map of parameter names and values.
         * @param charset The character set to use; defaults to UTF-8.
         * @return A new [HttpRequestBody] instance.
         * @throws IllegalArgumentException If [formData] is null.
         */
        fun create(
            formData: Map<String, String>,
            charset: Charset = Charsets.UTF_8
        ): HttpRequestBody {

            val mediaType = MediaType.parse(ContentType.APPLICATION_FORM_URLENCODED.mimeType)?.withCharset(charset)
                ?: throw IllegalStateException("Failed to parse media type")

            val encodedForm = formData.map { (key, value) ->
                "${encode(key, charset)}=${encode(value, charset)}"
            }.joinToString("&")

            val contentBytes = encodedForm.toByteArray(charset)

            return create(mediaType, contentBytes)
        }

        private fun encode(value: String, charset: Charset): String {
            return URLEncoder.encode(value, charset.name())
                .replace("+", "%20")
                .replace("*", "%2A")
                .replace("%7E", "~")
        }
    }
}
