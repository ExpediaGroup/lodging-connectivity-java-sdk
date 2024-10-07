package com.expediagroup.sdk.v2.lodgingconnectivity.filemanagement.operations

import com.expediagroup.sdk.core.model.Nothing
import com.expediagroup.sdk.v2.core.model.Operation
import com.expediagroup.sdk.v2.core.model.OperationParams

class FileDownloadOperation(
    params: FileDownloadOperationParams,
) : Operation<Nothing>(
    url = "/supply-lodging/v1/files/${params.id}/content",
    method = "GET",
    operationId = "downloadFile",
    requestBody = null,
    params = params,
)

class FileDownloadOperationParams(
    val id: String,
    val type: String?,
    val value: String?,
) : OperationParams {
    override fun getHeaders(): Map<String, String> = emptyMap()

    override fun getQueryParams(): Map<String, Iterable<String>> = buildMap {
        if (!type.isNullOrBlank()) put("type", listOf(type))
        if (!value.isNullOrBlank()) put("value", listOf(value))
    }

    override fun getPathParams(): Map<String, String> = buildMap {
        put("id", id)
    }
}