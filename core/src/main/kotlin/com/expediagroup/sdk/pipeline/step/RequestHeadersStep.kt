package com.expediagroup.sdk.pipeline.step

import com.expediagroup.sdk.common.MetadataLoader
import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.pipeline.RequestPipelineStep

class RequestHeadersStep : RequestPipelineStep {
    val metadata = MetadataLoader.load()

    override fun invoke(request: Request): Request = request.newBuilder()
        .setHeader("User-Agent", metadata.asUserAgentString())
        .build()
}