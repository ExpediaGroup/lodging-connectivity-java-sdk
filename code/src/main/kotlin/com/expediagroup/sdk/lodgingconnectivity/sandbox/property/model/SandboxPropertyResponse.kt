package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.model

import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertyQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData

data class SandboxPropertyResponse(
    override val data: SandboxPropertyData,
    override val rawResponse: RawResponse<SandboxPropertyQuery.Data>,
) : Response<SandboxPropertyData, SandboxPropertyQuery.Data>
