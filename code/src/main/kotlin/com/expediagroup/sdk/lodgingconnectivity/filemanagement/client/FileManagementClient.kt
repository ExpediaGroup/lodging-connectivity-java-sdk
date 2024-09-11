///*
// * Copyright (C) 2022 Expedia, Inc.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// * http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.expediagroup.sdk.lodgingconnectivity.filemanagement.client
//
//
//import com.expediagroup.sdk.core.client.ExpediaGroupClient
//import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration
//import com.expediagroup.sdk.core.model.Response
//import com.expediagroup.sdk.core.model.exception.handle
//import com.expediagroup.sdk.core.plugin.logging.ExpediaGroupLoggerFactory
//import com.expediagroup.sdk.lodgingconnectivity.filemanagement.models.Upload201Response
//import com.expediagroup.sdk.lodgingconnectivity.filemanagement.models.exception.*
//import com.fasterxml.jackson.databind.ObjectMapper
//import io.ktor.client.plugins.onUpload
//import io.ktor.client.request.forms.MultiPartFormDataContent
//import io.ktor.client.request.forms.formData
//import io.ktor.client.request.prepareRequest
//import io.ktor.client.request.request
//import io.ktor.client.request.url
//import io.ktor.client.statement.HttpResponse
//import io.ktor.client.statement.bodyAsText
//import io.ktor.http.ContentType
//import io.ktor.http.Headers
//import io.ktor.http.HttpHeaders
//import io.ktor.http.HttpMethod
//import io.ktor.util.InternalAPI
//import io.ktor.utils.io.jvm.javaio.toInputStream
//import java.io.File
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.future.future
//
///**
// *
// */
//class FileManagementClient(clientConfiguration: ExpediaGroupClientConfiguration) :
//    ExpediaGroupClient("filemanagement", clientConfiguration) {
//
//    companion object {
//        @JvmStatic
//        private val log = ExpediaGroupLoggerFactory.getLogger(this::class.java)
//        private val mapper = ObjectMapper()
//    }
//
//    override suspend fun throwServiceException(response: HttpResponse, operationId: String) {
//        throw ErrorObjectMapper.process(response, operationId)
//    }
//
//    private suspend inline fun kdownload(
//        id: kotlin.String,
//        type: kotlin.String? = null,
//        `value`: kotlin.String? = null
//    ): ByteArray {
//        return kdownloadWithResponse(id, type, `value`).body
//    }
//
//    @OptIn(InternalAPI::class)
//    private suspend inline fun kdownloadWithResponse(
//        id: kotlin.String,
//        type: kotlin.String? = null,
//        `value`: kotlin.String? = null,
//    ): Response<ByteArray> {
//        return httpClient.prepareRequest {
//            method = HttpMethod.parse("GET")
//            url("supply-lodging/v1/files/{id}/content".replace("{" + "id" + "}", "$id"))
//            appendHeaders()
//            type?.also { url.parameters.append("type", it.toString()) }
//            `value`?.also { url.parameters.append("value", it.toString()) }
//        }.execute { httpResponse ->
//            throwIfError(httpResponse, "download")
//            return@execute Response(
//                httpResponse.status.value,
//                httpResponse.content.toInputStream().readAllBytes(),
//                httpResponse.headers.entries()
//            )
//        }
//    }
//
//    /**
//     *
//     * API that can be used to download file using identifier associated to it
//     * @param id
//     * @param type  (optional)
//     * @param `value`  (optional)
//     * @throws ExpediaGroupApiGenericErrorException
//     * @return java.io.File
//     */
//    @Throws(
//        ExpediaGroupApiGenericErrorException::class
//    )
//    @JvmOverloads
//    fun download(id: kotlin.String, type: kotlin.String? = null, `value`: kotlin.String? = null): ByteArray {
//        return downloadWithResponse(id, type, `value`).body
//    }
//
//    /**
//     *
//     * API that can be used to download file using identifier associated to it
//     * @param id
//     * @param type  (optional)
//     * @param `value`  (optional)
//     * @throws ExpediaGroupApiGenericErrorException
//     * @return a [Response] object with a body of type java.io.File
//     */
//    @Throws(
//        ExpediaGroupApiGenericErrorException::class
//    )
//    @JvmOverloads
//    fun downloadWithResponse(
//        id: kotlin.String,
//        type: kotlin.String? = null,
//        `value`: kotlin.String? = null
//    ): Response<ByteArray> {
//        try {
//            return GlobalScope.future(Dispatchers.IO) {
//                kdownloadWithResponse(id, type, `value`)
//            }.get()
//        } catch (exception: Exception) {
//            exception.handle()
//        }
//    }
//
//    private suspend inline fun kupload(
//        content: File? = null,
//        type: kotlin.String? = null,
//        `value`: kotlin.String? = null
//    ): Upload201Response {
//        return kuploadWithResponse(content, type, value).body
//    }
//
//    @OptIn(InternalAPI::class)
//    private suspend fun kuploadWithResponse(
//        content: File? = null,
//        type: kotlin.String? = null,
//        `value`: kotlin.String? = null
//    ): Response<Upload201Response> {
//        val response = httpClient.request {
//            println("Request Sending...")
//            method = HttpMethod.parse("POST")
//            url("supply-lodging/v1/files")
//            appendHeaders()
//            type?.also { url.parameters.append("type", it.toString()) }
//            `value`?.also { url.parameters.append("value", it.toString()) }
//            body = MultiPartFormDataContent(
//                formData {
//                    append("content", content!!.readBytes(), Headers.build {
//                        append(HttpHeaders.ContentType, ContentType.Application.OctetStream.toString())
//                        append(HttpHeaders.ContentDisposition, "filename=\"${content.name}\"")
//                    })
//                }
//            )
//
//            onUpload { bytesSentTotal, contentLength ->
//                log.info("Uploaded $bytesSentTotal bytes from $contentLength of file ${content?.name}")
//            }
//        }
//        throwIfError(response, "upload")
//        val responseBody = mapper.readValue(response.bodyAsText(), Upload201Response::class.java)
//        return Response(response.status.value, responseBody, response.headers.entries())
//    }
//
//    /**
//     *
//     * API that can be used to upload file and get identifier associated to it
//     * @param content Content of the resource (optional)
//     * @throws ExpediaGroupApiGenericErrorException
//     * @return Upload201Response
//     */
//    @Throws(
//        ExpediaGroupApiGenericErrorException::class
//    )
//
//    @JvmOverloads
//    fun upload(
//        content: File,
//        type: kotlin.String? = null,
//        `value`: kotlin.String? = null
//    ): Upload201Response {
//        return uploadWithResponse(content, type, value).body
//    }
//
//    /**
//     *
//     * API that can be used to upload file and get identifier associated to it
//     * @param content Content of the resource (optional)
//     * @throws ExpediaGroupApiGenericErrorException
//     * @return a [Response] object with a body of type Upload201Response
//     */
//    @Throws(
//        ExpediaGroupApiGenericErrorException::class
//    )
//    @JvmOverloads
//    fun uploadWithResponse(
//        content: File? = null,
//        type: kotlin.String? = null,
//        `value`: kotlin.String? = null
//    ): Response<Upload201Response> {
//        try {
//            return GlobalScope.future(Dispatchers.IO) {
//                kuploadWithResponse(content, type, value)
//            }.get()
//        } catch (exception: Exception) {
//            exception.handle()
//        }
//    }
//
//}
//
