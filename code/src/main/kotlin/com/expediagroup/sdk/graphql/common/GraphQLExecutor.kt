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

package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.Operation
import com.expediagroup.sdk.core.client.AbstractRequestExecutor
import com.expediagroup.sdk.core.client.Disposable
import com.expediagroup.sdk.graphql.model.response.RawResponse

/**
 * Abstract base class for executing GraphQL operations, providing a structure for executing queries and mutations
 * and returning the full response data along with any errors.
 *
 * This class is designed to handle the execution of GraphQL operations and return a [RawResponse] containing
 * the complete, unprocessed data and error details. Subclasses should implement specific behaviors for how
 * requests are sent and processed.
 */
abstract class GraphQLExecutor(
    protected val requestExecutor: AbstractRequestExecutor
) : Disposable {

    abstract fun <T : Operation.Data> execute(operation: Operation<T>): RawResponse<T>

    /**
     * Closes the underlying [AbstractRequestExecutor]
     */
    override fun dispose() {
        requestExecutor.dispose()
    }
}
