package com.expediagroup.sdk.pipeline

import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.http.Response

fun interface RequestPipelineStep : (Request) -> Request

fun interface ResponsePipelineStep : (Response) -> Response

class ExecutionPipeline(
    private val requestPipeline: List<RequestPipelineStep>,
    private val responsePipeline: List<ResponsePipelineStep>
) {
    fun startRequestPipeline(request: Request): Request {
        return requestPipeline.fold(request) { req, step -> step(req) }
    }

    fun startResponsePipeline(response: Response): Response {
        return responsePipeline.fold(response) { res, step -> step(res) }
    }
}
