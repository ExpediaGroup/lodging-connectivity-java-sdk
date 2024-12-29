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

import com.expediagroup.sdk.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.AbstractGraphQLExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.SandboxCreatePropertyMutation
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxPropertyData
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreatePropertyInput

/**
 * Represents the response for [SandboxCreatePropertyMutation] GraphQL operation, containing both the processed
 * sandbox property data and the full raw GraphQL response.
 *
 * @param data The processed [SandboxPropertyData] extracted from the raw response, representing the created sandbox property details.
 * @param rawResponse The raw response from the GraphQL mutation, including the complete data structure and any associated errors.
 */
data class CreateSandboxPropertyResponse(
    override val data: SandboxPropertyData,
    override val rawResponse: RawResponse<SandboxCreatePropertyMutation.Data>,
) : Response<SandboxPropertyData, SandboxCreatePropertyMutation.Data>

/**
 * Executes a [SandboxCreatePropertyMutation] GraphQL mutation to create a new sandbox property with the specified input data.
 *
 * This function uses the provided [AbstractGraphQLExecutor] to execute the mutation and returns a [CreateSandboxPropertyResponse]
 * containing both the targeted sandbox property data and the full raw response.
 *
 * @param graphQLExecutor The [AbstractGraphQLExecutor] responsible for executing the GraphQL mutation.
 * @param input The [CreatePropertyInput] containing the details for the property to be created.
 * @return A [CreateSandboxPropertyResponse] containing the created sandbox property data and the full raw response.
 * @throws [ExpediaGroupServiceException] If an error occurs during the mutation execution.
 */
fun createSandboxPropertyOperation(
    graphQLExecutor: AbstractGraphQLExecutor,
    input: CreatePropertyInput
): CreateSandboxPropertyResponse {
    val operation = SandboxCreatePropertyMutation(input)
    val response = graphQLExecutor.execute(operation)

    return CreateSandboxPropertyResponse(
        data = response.data.createProperty.property.sandboxPropertyData,
        rawResponse = response
    )
}
