package com.expediagroup.sdk.v2.core.client

import com.expediagroup.sdk.v2.core.configuration.FullClientConfiguration
import com.expediagroup.sdk.v2.core.gapiclient.GClient
import com.expediagroup.sdk.v2.core.gapiclient.model.GRequest
import com.expediagroup.sdk.v2.core.gapiclient.util.createGClient
import com.expediagroup.sdk.v2.core.jackson.deserialize
import com.expediagroup.sdk.v2.core.model.Operation
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.io.InputStream

class ExpediaGroupClient(
    namespace: String,
    configuration: FullClientConfiguration,
) {
    val gClient: GClient = createGClient(
        namespace = namespace,
        configuration = configuration,
    )

    inline fun <reified T : Any> execute(
        operation: Operation<*>,
        enableGzipContent: Boolean = false,
        typeReference: TypeReference<T> = jacksonTypeRef<T>()
    ): T? =
        GRequest(
            gClient,
            operation,
            T::class.java
        ).setDisableGZipContent(
            enableGzipContent.not()
        ).executeUnparsed().let {
            deserialize(it.parseAsString(), typeReference)
        }

    fun executeAsInputStream(operation: Operation<*>, enableGzipContent: Boolean = false): InputStream? =
        GRequest(
            gClient,
            operation,
            Any::class.java
        ).apply {
            setDisableGZipContent(enableGzipContent.not())
        }.executeAsInputStream()

    fun executeUnparsed(operation: Operation<*>, enableGzipContent: Boolean = false): Any =
        GRequest(
            gClient,
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
        val gRequest = GRequest(
            gClient,
            operation,
            Any::class.java
        ).apply {
            setDisableGZipContent(enableGzipContent.not())
        }

        gRequest.executeAndDownloadTo(outputStream)
    }
}