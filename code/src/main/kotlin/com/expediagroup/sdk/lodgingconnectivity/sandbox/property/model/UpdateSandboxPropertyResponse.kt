package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.model

import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxUpdatePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData

data class UpdateSandboxPropertyResponse(
    override val data: SandboxPropertyData,
    override val rawResponse: RawResponse<SandboxUpdatePropertyMutation.Data>,
) : Response<SandboxPropertyData, SandboxUpdatePropertyMutation.Data>
