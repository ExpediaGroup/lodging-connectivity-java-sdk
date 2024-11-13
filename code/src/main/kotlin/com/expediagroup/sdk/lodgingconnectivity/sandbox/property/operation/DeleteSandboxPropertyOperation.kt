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
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxDeletePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyInput

/**
 * Represents the response for [SandboxDeletePropertyMutation] GraphQL operation, containing both the processed
 * delete property data and the full raw GraphQL response.
 *
 * @param data The processed [SandboxDeletePropertyMutation.DeleteProperty] data extracted from the raw response,
 * representing details of the deleted sandbox property.
 * @param rawResponse The raw response from the GraphQL mutation, including the complete data structure and any associated errors.
 */
data class DeleteSandboxPropertyResponse(
    override val data: SandboxDeletePropertyMutation.DeleteProperty,
    override val rawResponse: RawResponse<SandboxDeletePropertyMutation.Data>,
) : Response<SandboxDeletePropertyMutation.DeleteProperty, SandboxDeletePropertyMutation.Data>

/**
 * Executes [SandboxDeletePropertyMutation] GraphQL mutation to delete an existing sandbox property with the specified input data.
 *
 * This function uses the provided [GraphQLExecutor] to execute the mutation and returns a [DeleteSandboxPropertyResponse]
 * containing both the targeted delete property data and the full raw response.
 *
 * @param graphQLExecutor The [GraphQLExecutor] responsible for executing the GraphQL mutation.
 * @param input The [DeletePropertyInput] containing the details of the property to be deleted.
 * @return A [DeleteSandboxPropertyResponse] containing the deleted property data and the full raw response.
 * @throws ExpediaGroupServiceException If an error occurs during the mutation execution.
 */
fun deleteSandboxPropertyOperation(
    graphQLExecutor: GraphQLExecutor,
    input: DeletePropertyInput
): DeleteSandboxPropertyResponse {
    val operation = SandboxDeletePropertyMutation(input)
    val response = graphQLExecutor.execute(operation)

    return DeleteSandboxPropertyResponse(
        data = response.data.deleteProperty,
        rawResponse = response
    )
}
