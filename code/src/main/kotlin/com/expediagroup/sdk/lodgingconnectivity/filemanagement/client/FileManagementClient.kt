package com.expediagroup.sdk.lodgingconnectivity.filemanagement.client

import com.expediagroup.sdk.core.client.SdkClient
import com.expediagroup.sdk.core.configuration.DefaultClientBuilder
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientEnvironment
import com.expediagroup.sdk.lodgingconnectivity.configuration.EndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.configuration.FileManagementApiEndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.models.FileUploadRequest
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.models.Upload201Response
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.operations.FileDownloadOperation
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.operations.FileDownloadOperationParams
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.operations.FileUploadOperation
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.operations.FileUploadOperationParams
import java.io.IOException
import java.io.OutputStream
import java.io.InputStream
import java.io.File

class FileManagementClient(
    configuration: ClientConfiguration
) {
    private val client = SdkClient(
        configuration = configuration.toFullClientConfiguration(
            FileManagementApiEndpointProvider.forEnvironment(
                environment = configuration.environment ?: ClientEnvironment.PROD
            )
        )
    )

    @Throws(IOException::class)
    private fun buildOperation(
        id: String,
        type: String? = null,
        value: String? = null
    ) = FileDownloadOperation(
        params = FileDownloadOperationParams(
            id = id,
            type = type,
            value = value
        )
    )


    @Throws(IOException::class)
    @JvmOverloads
    fun download(
        id: String,
        downloadTo: OutputStream,
        type: String? = null,
        value: String? = null
    ) =
        buildOperation(
            id = id,
            type = type,
            value = value
        ).let {
            client.executeAndDownloadTo(it, downloadTo)
        }

    @Throws(IOException::class)
    @JvmOverloads
    fun download(
        id: String,
        type: String? = null,
        value: String? = null
    ): InputStream? {
        buildOperation(
            id = id,
            type = type,
            value = value
        ).let {
            return client.executeAsInputStream(it)
        }
    }

    @Throws(IOException::class)
    @JvmOverloads
    fun upload(
        file: File,
        type: String? = null,
        value: String? = null,
    ): Upload201Response {
        val params = FileUploadOperationParams(
            type = type,
            value = value
        )

        val body = FileUploadRequest(file)

        val operation = FileUploadOperation(
            requestBody = body,
            params = params,
        )

        return client.execute<Upload201Response>(operation, false) as Upload201Response
    }

    @Throws(IOException::class)
    @JvmOverloads
    fun upload(
        stream: InputStream,
        type: String? = null,
        value: String? = null,
        fileContentType: String? = null,
        fileExtension: String? = null
    ): Upload201Response {
        val params = FileUploadOperationParams(
            type = type,
            value = value
        )

        val body = FileUploadRequest(stream)

        val operation = FileUploadOperation(
            requestBody = body,
            params = params,
            fileContentType = fileContentType,
            fileExtension = fileExtension
        )

        return client.execute<Upload201Response>(
            operation = operation,
            enableGzipContent = false,
        ) as Upload201Response
    }

    companion object {
        @JvmStatic
        fun builder(): Builder = Builder()

        class Builder : DefaultClientBuilder<FileManagementClient>() {
            private val configurationBuilder = ClientConfiguration.builder()

            override fun build(): FileManagementClient =
                FileManagementClient(configurationBuilder.build())
        }
    }
}
