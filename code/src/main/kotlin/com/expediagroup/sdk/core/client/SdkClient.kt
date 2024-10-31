package com.expediagroup.sdk.core.client

import com.expediagroup.sdk.core.configuration.FullClientConfiguration
import com.expediagroup.sdk.core.request.Request
import com.expediagroup.sdk.core.client.util.createApiClient
import com.expediagroup.sdk.core.jackson.deserialize
import com.expediagroup.sdk.core.model.Operation
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.io.InputStream

/**
 * SdkClient is a wrapper for creating and executing API requests.
 *
 * @param configuration The client configuration implementing `FullClientConfiguration`.
 */
class SdkClient(
    configuration: FullClientConfiguration,
) {
    val apiClient: ApiClient = createApiClient(
        configuration = configuration,
    )

    /**
     * Executes a given operation and deserializes the response into the specified type.
     *
     * @param T The type into which the response will be deserialized.
     * @param operation The operation to be executed.
     * @param enableGzipContent Flag to enable or disable GZip content.
     * @param typeReference A reference to the type into which the response should be deserialized.
     * @return The deserialized response of the operation, or null if the deserialization fails.
     */
    inline fun <reified T : Any> execute(
        operation: Operation<*>,
        enableGzipContent: Boolean = false,
        typeReference: TypeReference<T> = jacksonTypeRef<T>()
    ): T? =
        Request(
            apiClient,
            operation,
            T::class.java
        ).setDisableGZipContent(
            enableGzipContent.not()
        ).executeUnparsed().let {
            deserialize(it.parseAsString(), typeReference)
        }

    /**
     * Executes a given operation and returns the response as an InputStream.
     *
     * @param operation The operation to be executed.
     * @param enableGzipContent Flag to enable or disable GZip content.
     * @return The InputStream representing the response of the operation, or null if the operation fails.
     */
    fun executeAsInputStream(operation: Operation<*>, enableGzipContent: Boolean = false): InputStream? =
        Request(
            apiClient,
            operation,
            Any::class.java
        ).apply {
            setDisableGZipContent(enableGzipContent.not())
        }.executeAsInputStream()

    /**
     * Executes a given operation without parsing the response and returns the raw result.
     *
     * @param operation The operation to be executed.
     * @param enableGzipContent Flag to enable or disable GZip content.
     * @return The raw response of the operation.
     */
    fun executeUnparsed(operation: Operation<*>, enableGzipContent: Boolean = false): Any =
        Request(
            apiClient,
            operation,
            Any::class.java
        ).apply {
            setDisableGZipContent(enableGzipContent.not())
        }.executeUnparsed()

    /**
     * Executes a given operation and downloads the response to an OutputStream.
     *
     * @param operation The operation to be executed.
     * @param outputStream The OutputStream to which the response will be written.
     * @param enableGzipContent Flag to enable or disable GZip content compression.
     */
    fun executeAndDownloadTo(
        operation: Operation<*>,
        outputStream: java.io.OutputStream?,
        enableGzipContent: Boolean = false
    ) {
        val request = Request(
            apiClient,
            operation,
            Any::class.java
        ).apply {
            setDisableGZipContent(enableGzipContent.not())
        }

        request.executeAndDownloadTo(outputStream)
    }
}
