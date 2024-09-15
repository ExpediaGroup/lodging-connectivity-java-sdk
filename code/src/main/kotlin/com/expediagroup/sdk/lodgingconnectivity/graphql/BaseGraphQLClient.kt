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

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Mutation
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.Subscription
import com.expediagroup.sdk.core.client.DefaultClientBuilder
import com.expediagroup.sdk.core.configuration.ClientConfiguration
import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration
import com.expediagroup.sdk.core.configuration.provider.ExpediaGroupConfigurationProvider
import com.expediagroup.sdk.core.gapiclient.GClientHttpEngine
import com.expediagroup.sdk.core.gapiclient.util.createGClientHttpEngine
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

class BaseGraphQLClient(config: ClientConfiguration, private val namespace: String) : GraphQLExecutor {
    private val engine: GClientHttpEngine = createGClientHttpEngine(
        namespace = namespace,
        configurationProvider = config.toProvider().withDefaultsConfigurationProvider(ExpediaGroupConfigurationProvider)
    )

    companion object {
        @JvmStatic
        fun builder() = ExpediaGroupClientConfiguration.Builder()
    }

    private val apolloClient: ApolloClient = ApolloClient.Builder()
        .serverUrl(config.endpoint!!)
        .httpEngine(engine)
        .build()

    class Builder : DefaultClientBuilder<BaseGraphQLClient>() {
        private var configurationBuilder: ExpediaGroupClientConfiguration.Builder =
            ExpediaGroupClientConfiguration.Builder()

        override fun build(): BaseGraphQLClient {
            return BaseGraphQLClient(configurationBuilder.build(), "lodging-supply")
        }
    }

    override fun <T : Query.Data> execute(query: Query<T>): ApolloResponse<T> {
        return runBlocking {
            return@runBlocking coroutineScope {
                return@coroutineScope apolloClient.query(query).execute()
            }
        }
    }

    override fun <T : Mutation.Data> execute(mutation: Mutation<T>): ApolloResponse<T> {
        return runBlocking {
            return@runBlocking coroutineScope {
                return@coroutineScope apolloClient.mutation(mutation).execute()
            }
        }.also {
            println("Query executed")
        }
    }

    override fun <T : Subscription.Data> execute(subscription: Subscription<T>): ApolloResponse<T> {
        return runBlocking {
            return@runBlocking apolloClient.subscription(subscription).execute()
        }.also {
            println("Query executed")
        }
    }

//    override suspend fun throwServiceException(
//        response: HttpResponse,
//        operationId: String,
//    ) {
//        throw ExpediaGroupServiceException("Service error occurred for operation $operationId.\nResponse: $response")
//    }
}

