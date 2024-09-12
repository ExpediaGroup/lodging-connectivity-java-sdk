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

package com.expediagroup.sdk.lodgingconnectivity.graphql

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Subscription
import com.apollographql.ktor.http.KtorHttpEngine
import com.expediagroup.sdk.core.client.ExpediaGroupClient
import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class BaseGraphQLClient(config: ExpediaGroupClientConfiguration) : GraphQLExecutor {

    private val expediaGroupClient =
        object : ExpediaGroupClient(clientConfiguration = config, namespace = "lodging-connectivity-sdk") {
            override suspend fun throwServiceException(response: HttpResponse, operationId: String) {
                throw ExpediaGroupServiceException("Service error occurred for operation $operationId.\nResponse: $response")
            }
        }

    private val apolloClient: ApolloClient = ApolloClient.Builder()
        .serverUrl(config.endpoint!!)
        .httpEngine(KtorHttpEngine(expediaGroupClient.httpClient))
        .build()

    override fun <T : Query.Data> execute(query: Query<T>): T {
        return runBlocking {
            apolloClient.query(query).execute().apply {
                if (hasErrors()) {
                    throw ExpediaGroupServiceException(errors.toString())
                }
            }.dataAssertNoErrors
        }
    }

    override fun <T : Mutation.Data> execute(mutation: Mutation<T>): T {
        return runBlocking {
            apolloClient.mutation(mutation).execute().apply {
                if (hasErrors()) {
                    throw ExpediaGroupServiceException(errors.toString())
                }
            }.dataAssertNoErrors
        }
    }

    override fun <T : Subscription.Data> execute(subscription: Subscription<T>): T {
        return runBlocking {
            apolloClient.subscription(subscription).execute().apply {
                if (hasErrors()) {
                    throw ExpediaGroupServiceException(errors.toString())
                }
            }.dataAssertNoErrors
        }
    }
}
