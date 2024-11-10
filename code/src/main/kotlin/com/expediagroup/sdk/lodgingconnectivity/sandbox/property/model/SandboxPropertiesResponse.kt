package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.model

import com.expediagroup.sdk.graphql.model.paging.PageInfo
import com.expediagroup.sdk.graphql.model.response.PaginatedResponse
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertiesQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData

data class SandboxPropertiesResponse(
    override val data: List<SandboxPropertyData>,
    override val rawResponse: RawResponse<SandboxPropertiesQuery.Data>,
    override val pageInfo: PageInfo
) : PaginatedResponse<List<SandboxPropertyData>, SandboxPropertiesQuery.Data>
