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

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxUpdatePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdatePropertyInput

/**
 * Represents the response for [SandboxUpdatePropertyMutation] GraphQL operation, containing both the processed
 * sandbox property data and the full raw GraphQL response.
 *
 * @param data The updated [SandboxPropertyData] extracted from the raw response, representing the details
 * of the sandbox property after the update.
 * @param rawResponse The raw response from the GraphQL mutation, including the complete data structure
 * and any associated errors.
 */
data class UpdateSandboxPropertyResponse(
    override val data: SandboxPropertyData,
    override val rawResponse: RawResponse<SandboxUpdatePropertyMutation.Data>,
) : Response<SandboxPropertyData, SandboxUpdatePropertyMutation.Data>

/**
 * Executes [SandboxUpdatePropertyMutation] GraphQL mutation to modify the details of an existing sandbox property.
 *
 * This function uses the provided [GraphQLExecutor] to execute the mutation and returns an [UpdateSandboxPropertyResponse]
 * containing both the updated sandbox property data and the full raw response.
 *
 * @param graphQLExecutor The [GraphQLExecutor] responsible for executing the GraphQL mutation.
 * @param input The [UpdatePropertyInput] containing the details of the property update.
 * @return An [UpdateSandboxPropertyResponse] containing the updated sandbox property data and the full raw response.
 * @throws [ExpediaGroupServiceException] If an error occurs during the mutation execution.
 */
fun updateSandboxPropertyOperation(
    graphQLExecutor: GraphQLExecutor,
    input: UpdatePropertyInput
): UpdateSandboxPropertyResponse {
    val operation = SandboxUpdatePropertyMutation(input)
    val response = graphQLExecutor.execute(operation)

    return UpdateSandboxPropertyResponse(
        data = response.data.updateProperty.property.sandboxPropertyData,
        rawResponse = response
    )
}
