/*
 * Copyright (C) 2024 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation

import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxPropertyQuery
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData

/**
 * Represents the response for [SandboxPropertyQuery] GraphQL operation, containing both the processed
 * sandbox property data and the full raw GraphQL response.
 *
 * @param data The processed [SandboxPropertyData] extracted from the raw response, representing
 * details of the requested sandbox property.
 * @param rawResponse The raw response from the GraphQL query, including the complete data structure
 * and any associated errors.
 */
data class GetSandboxPropertyResponse(
    override val data: SandboxPropertyData,
    override val rawResponse: RawResponse<SandboxPropertyQuery.Data>,
) : Response<SandboxPropertyData, SandboxPropertyQuery.Data>

/**
 * Executes a [SandboxPropertyQuery] GraphQL query to retrieve details about a specific sandbox property.
 *
 * This function uses the provided [GraphQLExecutor] to execute the query and returns a [GetSandboxPropertyResponse]
 * containing both the targeted sandbox property data and the full raw response.
 *
 * @param graphQLExecutor The [GraphQLExecutor] responsible for executing the GraphQL query.
 * @param propertyId The unique identifier of the sandbox property to retrieve.
 * @return A [GetSandboxPropertyResponse] containing the requested sandbox property data and the full raw response.
 * @throws ExpediaGroupServiceException If an error occurs during the query execution.
 */
fun getSandboxPropertyOperation(graphQLExecutor: GraphQLExecutor, propertyId: String): GetSandboxPropertyResponse {
    val operation = SandboxPropertyQuery(propertyId)
    val response = graphQLExecutor.execute(operation)

    return GetSandboxPropertyResponse(
        data = response.data.property.sandboxPropertyData,
        rawResponse = response,
    )
}
