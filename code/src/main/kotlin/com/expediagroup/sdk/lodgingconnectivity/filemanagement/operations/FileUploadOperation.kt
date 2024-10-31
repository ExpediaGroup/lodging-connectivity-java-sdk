package com.expediagroup.sdk.lodgingconnectivity.filemanagement.operations

import com.expediagroup.sdk.core.http.BlobTypeDetector
import com.expediagroup.sdk.core.model.OperationParams
import com.expediagroup.sdk.core.model.Operation
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.models.FileUploadRequest
import com.google.api.client.http.*
import com.google.api.client.http.MultipartContent.Part
import org.apache.tika.mime.MimeTypes
import java.io.File
import java.io.InputStream
import java.util.*


class FileUploadOperation(
    requestBody: FileUploadRequest,
    params: FileUploadOperationParams,
    private var fileContentType: String? = null,
    private var fileExtension: String? = null,
) : Operation<FileUploadRequest>(
    url = "/supply-lodging/v1/files",
    method = "POST",
    operationId = "uploadFile",
    requestBody = requestBody,
    params = params,
    isUpload = true,
) {
    init {
        if (fileContentType == null) {
            when (requestBody.content) {
                is File -> fileContentType = BlobTypeDetector.getInstance().detect(requestBody.content)
                is InputStream -> fileContentType = BlobTypeDetector.getInstance().detect(requestBody.content)
                else -> throw IllegalArgumentException("Unsupported content type")
            }
        }

        if (fileExtension == null) {
            when (requestBody.content) {
                is File -> fileExtension = requestBody.content.extension
                is InputStream -> fileExtension = MimeTypes.getDefaultMimeTypes().forName(fileContentType).extension
                else -> throw IllegalArgumentException("Unsupported content type")
            }
        }
    }

    override fun getHttpContent(): HttpContent {
        return MultipartContent().apply {
            // Set the overall media type for the multipart content
            setMediaType(HttpMediaType("multipart/form-data").apply {
                setBoundary("__END_OF_PART__${UUID.randomUUID()}")
            })

            val fileName = when (requestBody?.content) {
                is File -> requestBody.content.name
                is InputStream -> "file.$fileExtension"
                else -> throw IllegalArgumentException("Unsupported content type")
            }

            // Add the file part
            addPart(Part().apply {
                headers = HttpHeaders().apply {
                    setContentType("application/octet-stream")
                    set("Content-Disposition", "form-data; name=\"content\"; filename=\"$fileName\"")
                }

                content = when (requestBody.content) {
                    is File -> FileContent(fileContentType, requestBody.content.absoluteFile)
                    is InputStream -> InputStreamContent(fileContentType, requestBody.content)
                    else -> throw IllegalArgumentException("Unsupported content type")
                }.apply {
                    setBoundary("__END_OF_PART__${UUID.randomUUID()}")
                }
            })
        }
    }
}

class FileUploadOperationParams(
    val type: String? = null,
    val value: String? = null,
) : OperationParams {
    override fun getHeaders(): Map<String, String> = emptyMap()

    override fun getQueryParams(): Map<String, Iterable<String>> =
        buildMap {
            if (!type.isNullOrBlank()) put("type", listOf(type))
            if (!value.isNullOrBlank()) put("value", listOf(value))
        }

    override fun getPathParams(): Map<String, String> =
        emptyMap()
}
