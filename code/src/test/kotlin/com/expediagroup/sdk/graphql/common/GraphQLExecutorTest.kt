package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Query
import com.apollographql.java.client.ApolloClient
import com.expediagroup.sdk.core.client.RequestExecutor
import com.expediagroup.sdk.graphql.model.response.RawResponse
import io.mockk.mockk
import io.mockk.verify
import java.util.concurrent.CompletableFuture
import org.junit.jupiter.api.Test


class GraphQLExecutorTest {

    @Test
    fun `should close the underlying resources on dispose call`() {
        val mockRequestExecutor = mockk<RequestExecutor>(relaxed = true)
        val mockApolloClient = mockk<ApolloClient>(relaxed = true)

        val testGraphQLExecutor = object : GraphQLExecutor(mockRequestExecutor) {
            override val apolloClient = mockApolloClient
            override fun <T : Query.Data> execute(query: Query<T>) = mockk<RawResponse<T>>()
            override fun <T : Mutation.Data> execute(mutation: Mutation<T>) = mockk<RawResponse<T>>()
            override fun <T : Query.Data> executeAsync(query: Query<T>) = mockk<CompletableFuture<RawResponse<T>>>()
            override fun <T : Mutation.Data> executeAsync(mutation: Mutation<T>) =
                mockk<CompletableFuture<RawResponse<T>>>()
        }

        testGraphQLExecutor.dispose()

        verify(exactly = 1) { mockRequestExecutor.dispose() }
        verify(exactly = 1) { mockApolloClient.close() }
    }
}