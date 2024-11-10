package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.model

import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxCreatePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData

data class CreateSandboxPropertyResponse(
    override val data: SandboxPropertyData,
    override val rawResponse: RawResponse<SandboxCreatePropertyMutation.Data>,
) : Response<SandboxPropertyData, SandboxCreatePropertyMutation.Data>
