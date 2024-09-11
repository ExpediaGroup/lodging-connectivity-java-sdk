package com.expediagroup.sdk.lodgingconnectivity.filemanagement.operations

import com.expediagroup.sdk.core.model.Operation
import com.expediagroup.sdk.core.model.OperationParams
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.models.FileUploadRequest
import com.google.api.client.http.*
import com.google.api.client.http.MultipartContent.Part
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.util.UUID


class FileUploadOperation(
    requestBody: FileUploadRequest,
    params: FileUploadOperationParams,
) : Operation<FileUploadRequest>(
    url = "/supply-lodging/v1/files",
    method = "POST",
    operationId = "uploadFile",
    requestBody = requestBody,
    params = params,
    isUpload = true,
) {
    override fun getHttpContent(): HttpContent {
       return MultipartContent().apply {
            // Set the overall media type for the multipart content
            setMediaType(HttpMediaType("multipart/form-data").apply {
                setBoundary("__END_OF_PART__")
                println(this.build())
            })


           val fileName = when(requestBody?.content) {
               is File -> requestBody.content.name
               else -> throw IllegalArgumentException("Unsupported content type")
           }

            // Add the file part
            addPart(Part().apply {
                headers = HttpHeaders().apply {
                    setContentType("application/octet-stream")
                    set("Content-Disposition", "form-data; name=\"content\"; filename=\"$fileName\"")
                }

                // Set the content based on type (File or InputStream)
                content = when (requestBody.content) {
                    is File -> FileContent("application/octet-stream", requestBody.content.absoluteFile)
                    else -> throw IllegalArgumentException("Unsupported content type")
                }.apply {
                    setBoundary("__END_OF_PART__")
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