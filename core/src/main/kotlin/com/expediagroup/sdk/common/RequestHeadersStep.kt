package com.expediagroup.sdk.common

import com.expediagroup.sdk.http.Request
import com.expediagroup.sdk.transport.RequestPipelineStep

class RequestHeadersStep : RequestPipelineStep {
    val metadata = MetadataLoader.load()

    override fun invoke(request: Request): Request = request.newBuilder()
        .setHeader("User-Agent", metadata.asUserAgentString())
        .build()
}