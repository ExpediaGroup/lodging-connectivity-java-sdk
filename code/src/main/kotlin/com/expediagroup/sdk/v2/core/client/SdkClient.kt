package com.expediagroup.sdk.v2.core.client

import com.expediagroup.sdk.v2.core.configuration.FullClientConfiguration
import com.expediagroup.sdk.v2.core.request.Request
import com.expediagroup.sdk.v2.core.client.util.createApiClient
import com.expediagroup.sdk.v2.core.jackson.deserialize
import com.expediagroup.sdk.v2.core.model.Operation
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.io.InputStream

class SdkClient(
    namespace: String,
    configuration: FullClientConfiguration,
) {
    val apiClient: ApiClient = createApiClient(
        namespace = namespace,
        configuration = configuration,
    )

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

    fun executeAsInputStream(operation: Operation<*>, enableGzipContent: Boolean = false): InputStream? =
        Request(
            apiClient,
            operation,
            Any::class.java
        ).apply {
            setDisableGZipContent(enableGzipContent.not())
        }.executeAsInputStream()

    fun executeUnparsed(operation: Operation<*>, enableGzipContent: Boolean = false): Any =
        Request(
            apiClient,
            operation,
            Any::class.java
        ).apply {
            setDisableGZipContent(enableGzipContent.not())
        }.executeUnparsed()

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