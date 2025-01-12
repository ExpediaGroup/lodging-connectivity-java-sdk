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
import com.expediagroup.sdk.core.transport.AbstractAsyncRequestExecutor
import com.expediagroup.sdk.core.transport.Disposable
import com.expediagroup.sdk.graphql.model.response.RawResponse
import java.util.concurrent.CompletableFuture

abstract class AbstractAsyncGraphQLExecutor(
    protected val asyncRequestExecutor: AbstractAsyncRequestExecutor
) : Disposable {

    abstract fun <T : Operation.Data> execute(operation: Operation<T>): CompletableFuture<RawResponse<T>>

    override fun dispose() {
        asyncRequestExecutor.dispose()
    }
}
