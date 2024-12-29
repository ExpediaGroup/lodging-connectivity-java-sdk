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
        var req = request

        requestPipeline.forEach {
            req = it.invoke(req)
        }

        return req
    }

    fun startResponsePipeline(response: Response): Response {
        var res = response

        responsePipeline.forEach {
            res = it.invoke(res)
        }

        return res
    }
}
