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

import com.expediagroup.sdk.core.transport.Disposable

/**
 * Abstract base class for building high-level asynchronous GraphQL clients.
 */
abstract class AsyncGraphQLClient : Disposable {

    /**
     * The [AsyncGraphQLClient] used to execute GraphQL operations.
     *
     * This executor provides the core logic for converting operations into SDK requests,
     * sending them to the server, and processing the responses.
     */
    protected abstract val asyncGraphQLExecutor: AsyncGraphQLClient

    /**
     * Releases any resources associated with the client.
     */
    override fun dispose() {
        asyncGraphQLExecutor.dispose()
    }
}
