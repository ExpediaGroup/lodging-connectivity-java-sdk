///*
// * Copyright (C) 2024 Expedia, Inc.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// * http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.expediagroup.sdk.lodgingconnectivity.graphql
//
//import com.apollographql.apollo3.ApolloClient
//import com.apollographql.apollo3.annotations.ApolloExperimental
//import com.apollographql.apollo3.api.ApolloResponse
//import com.apollographql.apollo3.api.Mutation
//import com.apollographql.apollo3.api.Query
//import com.apollographql.apollo3.api.Subscription
//import com.apollographql.apollo3.network.http.HttpEngine
//import com.expediagroup.sdk.core.client.ExpediaGroupClient
//import com.expediagroup.sdk.core.client.KtorHttpEngine
//import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration
//import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
//import io.ktor.client.engine.*
//import io.ktor.client.engine.apache5.*
//import io.ktor.client.statement.*
//import kotlinx.coroutines.runBlocking
//
//
//class BaseGraphQLClient(config: ExpediaGroupClientConfiguration, private val namespace: String) :
//    ExpediaGroupClient(namespace = namespace, clientConfiguration = config),
//    GraphQLExecutor {
//
//    @OptIn(ApolloExperimental::class)
//    private val apolloClient: ApolloClient = ApolloClient.Builder()
//        .serverUrl(config.endpoint!!)
//        .httpEngine(KtorHttpEngine(httpClient))
//        .build()
//
//    class Builder : ExpediaGroupClient.Builder<Builder>() {
//        override fun build(): BaseGraphQLClient =
//            BaseGraphQLClient(
//                ExpediaGroupClientConfiguration(
//                    key,
//                    secret,
//                    endpoint,
//                    requestTimeout,
//                    connectionTimeout,
//                    socketTimeout,
//                    maskedLoggingHeaders,
//                    maskedLoggingBodyFields,
//                    authEndpoint,
//
//                ),
//                namespace = "lodging-supply"
//            )
//    }
//
//    override fun <T : Query.Data> execute(query: Query<T>): ApolloResponse<T> {
//        return runBlocking {
//            return@runBlocking apolloClient.query(query).execute()
//        }
//    }
//
//    override fun <T : Mutation.Data> execute(mutation: Mutation<T>): ApolloResponse<T> {
//        return runBlocking {
//            return@runBlocking apolloClient.mutation(mutation).execute()
//        }
//    }
//
//    override fun <T : Subscription.Data> execute(subscription: Subscription<T>): ApolloResponse<T> {
//        return runBlocking {
//            return@runBlocking apolloClient.subscription(subscription).execute()
//        }
//    }
//
//    override suspend fun throwServiceException(
//        response: HttpResponse,
//        operationId: String,
//    ) {
//        throw ExpediaGroupServiceException("Service error occurred for operation $operationId.\nResponse: $response")
//    }
//}
