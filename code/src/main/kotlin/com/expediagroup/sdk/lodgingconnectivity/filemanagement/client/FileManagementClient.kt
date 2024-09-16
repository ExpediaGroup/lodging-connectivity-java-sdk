package com.expediagroup.sdk.lodgingconnectivity.filemanagement.client

import com.expediagroup.sdk.core.client.ExpediaGroupClient
import com.expediagroup.sdk.core.configuration.provider.ExpediaGroupConfigurationProvider
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.EndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.models.FileUploadRequest
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.models.Upload201Response
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.operations.FileDownloadOperation
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.operations.FileDownloadOperationParams
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.operations.FileUploadOperation
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.operations.FileUploadOperationParams
import java.io.*

class FileManagementClient(
    configuration: ClientConfiguration
) {
    private val client = ExpediaGroupClient(
        namespace = "filemanagement",
        configurationProvider = configuration.toExpediaGroupClientConfiguration(
            endpointProvider = EndpointProvider::getFileManagementClientEndpoint,
            authEndpointProvider = EndpointProvider::getAuthEndpoint
        ).toProvider()
            .withDefaultsConfigurationProvider(ExpediaGroupConfigurationProvider)
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

        class Builder {
            private val configurationBuilder = ClientConfiguration.builder()

            fun key(key: String): Builder = apply { configurationBuilder.key(key) }
            fun secret(secret: String): Builder = apply { configurationBuilder.secret(secret) }
            fun requestTimeout(requestTimeout: Long): Builder =
                apply { configurationBuilder.requestTimeout(requestTimeout) }

            fun connectionTimeout(connectionTimeout: Long): Builder =
                apply { configurationBuilder.connectionTimeout(connectionTimeout) }

            fun socketTimeout(socketTimeout: Long): Builder =
                apply { configurationBuilder.socketTimeout(socketTimeout) }

            fun maskedLoggingHeaders(maskedLoggingHeaders: Set<String>): Builder =
                apply { configurationBuilder.maskedLoggingHeaders(maskedLoggingHeaders) }

            fun maskedLoggingBodyFields(maskedLoggingBodyFields: Set<String>): Builder =
                apply { configurationBuilder.maskedLoggingBodyFields(maskedLoggingBodyFields) }

            fun maxConnTotal(maxConnTotal: Int): Builder = apply { configurationBuilder.maxConnTotal(maxConnTotal) }
            fun maxConnPerRoute(maxConnPerRoute: Int): Builder =
                apply { configurationBuilder.maxConnPerRoute(maxConnPerRoute) }

            fun build(): FileManagementClient =
                FileManagementClient(configurationBuilder.build())
        }
    }
}

