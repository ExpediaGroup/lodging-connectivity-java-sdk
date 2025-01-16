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

package com.expediagroup.sdk.graphql

import com.apollographql.apollo.api.Operation
import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import com.expediagroup.sdk.core.transport.Disposable
import com.expediagroup.sdk.graphql.model.RawResponse

/**
 * Abstract base class for executing synchronous GraphQL operations.
 *
 * This class wraps the [AbstractRequestExecutor] provided by the SDK Core module
 * and provides a higher-level abstraction for executing GraphQL operations using Apollo's `Operation`.
 *
 * @property requestExecutor The underlying asynchronous request executor responsible for executing raw SDK requests.
 */
abstract class AbstractGraphQLExecutor(
    protected val requestExecutor: AbstractRequestExecutor
) : Disposable {

    /**
     * Executes the given GraphQL operation.
     *
     * This method maps the Apollo `Operation` to the core SDKS's request model,
     * sends it via the provided `requestExecutor`, and processes the response into a `RawResponse`.
     *
     * @param T The type of the data returned by the GraphQL operation. Must extend `Operation.Data`.
     * @param operation The Apollo `Operation` to be executed.
     * @return A `RawResponse` containing the response of the operation.
     */
    abstract fun <T : Operation.Data> execute(operation: Operation<T>): RawResponse<T>

    /**
     * Closes the underlying [AbstractRequestExecutor]
     */
    override fun dispose() {
        requestExecutor.dispose()
    }
}
