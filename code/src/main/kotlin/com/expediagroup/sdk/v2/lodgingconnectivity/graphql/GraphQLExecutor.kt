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

package com.expediagroup.sdk.v2.lodgingconnectivity.graphql

import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Query
import java.util.concurrent.CompletableFuture

interface GraphQLExecutor {
    fun <T : Query.Data> executeAsync(query: Query<T>): CompletableFuture<T>
    fun <T : Mutation.Data> executeAsync(mutation: Mutation<T>): CompletableFuture<T>
    fun <T : Query.Data> execute(query: Query<T>): T
    fun <T : Mutation.Data> execute(mutation: Mutation<T>): T
}
