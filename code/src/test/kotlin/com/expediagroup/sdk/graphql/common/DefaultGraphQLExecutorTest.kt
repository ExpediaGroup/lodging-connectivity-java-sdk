package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.toResponseJson
import com.expediagroup.sdk.core.client.RequestExecutor
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor
import com.expediagroup.sdk.core.okhttp.BaseOkHttpClient
import com.expediagroup.sdk.core.okhttp.OkHttpTransport
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import testservice.TestQuery
import testservice.type.buildTestData

class DefaultGraphQLExecutorTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var executor: DefaultGraphQLExecutor

    @BeforeEach
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        val serverUrl = mockWebServer.url("/graphql").toString()

        val requestExecutor = object : RequestExecutor(OkHttpTransport(BaseOkHttpClient.getInstance())) {
            override val interceptors: List<Interceptor> = emptyList()
            override fun execute(request: Request): Response = transport.execute(request)
        }

        executor = DefaultGraphQLExecutor(requestExecutor, serverUrl)
    }

    @AfterEach
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `should execute graphql query successfully against mock server`() {
        // Given
        val testQueryData = TestQuery.Data {
            testQuery = buildTestData {
                id = "Hello, world!"
            }
        }

        mockWebServer.enqueue(MockResponse().setBody(testQueryData.toResponseJson()).setResponseCode(200))

        // When
        val future = executor.executeAsync(TestQuery())
        val rawResponse = future.get()

        // Then
        assertNull(rawResponse.errors)
        assertEquals("Hello, world!", rawResponse.data.testQuery.id)
    }
}