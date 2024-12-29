package com.expediagroup.sdk.core.util.pipeline

import com.expediagroup.sdk.core.client.RequestPipelineStep
import com.expediagroup.sdk.core.common.MetadataLoader
import com.expediagroup.sdk.core.http.Request

class RequestHeadersStep : RequestPipelineStep {
    val metadata = MetadataLoader.load()

    override fun invoke(request: Request): Request = request.newBuilder()
        .setHeader("User-Agent", metadata.asUserAgentString())
        .build()
}