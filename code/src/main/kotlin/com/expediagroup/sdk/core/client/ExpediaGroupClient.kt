package com.expediagroup.sdk.core.client

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.gapiclient.GClient
import com.expediagroup.sdk.core.gapiclient.model.Request
import com.expediagroup.sdk.core.gapiclient.util.createGClient
import com.expediagroup.sdk.core.model.Operation
import java.io.InputStream

class ExpediaGroupClient(
    namespace: String,
    configurationProvider: ConfigurationProvider,
) {
    val gClient: GClient = createGClient(
        namespace = namespace,
        configurationProvider = configurationProvider,
    )

    inline fun <reified T : Any> execute(operation: Operation<*>, enableGzipContent: Boolean = false): T? {
        val request = Request(
            gClient,
            operation,
            T::class.java
        ).apply {
            setDisableGZipContent(enableGzipContent.not())
        }

        return request.execute()
    }

    fun executeAsInputStream(operation: Operation<*>, enableGzipContent: Boolean = false): InputStream? {
        val request = Request(
            gClient,
            operation,
            Any::class.java
        ).apply {
            setDisableGZipContent(enableGzipContent.not())
        }

        return request.executeMediaAsInputStream()
    }

    fun executeUnparsed(operation: Operation<*>, enableGzipContent: Boolean = false): Any {
        val request = Request(
            gClient,
            operation,
            Any::class.java
        ).apply {
            setDisableGZipContent(enableGzipContent.not())
        }
        return request.executeUnparsed()
    }

    fun executeAndDownloadTo(
        operation: Operation<*>,
        outputStream: java.io.OutputStream?,
        enableGzipContent: Boolean = false
    ) {
        val request = Request(
            gClient,
            operation,
            Any::class.java
        ).apply {
            setDisableGZipContent(enableGzipContent.not())
        }

        request.executeAndDownloadTo(outputStream)
    }
}