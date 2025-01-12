package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.toResponseJson
import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.model.exception.NoDataException
import com.expediagroup.sdk.core.pipeline.ExecutionPipeline
import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import testservice.TestMutation
import testservice.TestQuery
import testservice.type.buildTestData

class AbstractGraphQLExecutorTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var executor: GraphQLExecutor

    @BeforeEach
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        val serverUrl = mockWebServer.url("/graphql").toString()

        val requestExecutor = object : AbstractRequestExecutor() {
            override val executionPipeline: ExecutionPipeline = ExecutionPipeline(emptyList(), emptyList())

        }

        executor = GraphQLExecutor(requestExecutor, serverUrl)
    }

    @AfterEach
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Nested
    inner class BlockingExecution {
        @Test
        fun `should execute graphql query successfully`() {
            // Given
            val testQueryData = TestQuery.Data {
                testQuery = buildTestData {
                    id = "Hello, world!"
                }
            }

            mockWebServer.enqueue(MockResponse().setBody(testQueryData.toResponseJson()).setResponseCode(200))

            // When
            val rawResponse = executor.execute(TestQuery())

            // Expect
            assertNull(rawResponse.errors)
            assertEquals("Hello, world!", rawResponse.data.testQuery.id)
        }

        @Test
        fun `should execute graphql mutation successfully`() {
            // Given
            val testMutationData = TestMutation.Data {
                testMutation = buildTestData {
                    id = "Hello, world!"
                }
            }

            mockWebServer.enqueue(MockResponse().setBody(testMutationData.toResponseJson()).setResponseCode(200))

            // When
            val rawResponse = executor.execute(TestMutation())

            // Expect
            assertNull(rawResponse.errors)
            assertEquals("Hello, world!", rawResponse.data.testMutation.id)
        }

        @Test
        fun `should throw ExpediaGroupServiceException if failed to get a successful response`() {
            // Given
            mockWebServer.enqueue(MockResponse().setResponseCode(500))

            // When & Expect
            assertThrows<ExpediaGroupServiceException> {
                executor.execute(TestQuery())
            }
        }

        @Test
        fun `should throw NoDataException if no data received from the server`() {
            // Given
            val errorResponse = """{"errors": [{ "message": "Some error occurred" }]}"""

            mockWebServer.enqueue(MockResponse().setBody(errorResponse).setResponseCode(200))

            // When
            val exception = assertThrows<NoDataException> {
                executor.execute(TestQuery())
            }

            // Expect
            assertEquals("No data received from the server", exception.message)
            assertEquals("Some error occurred", exception.errors[0].message)
        }

        @Test
        fun `should return partial data along with errors`() {
            // Given
            val partialDataResponse = """
                {
                  "data": { "testQuery": { "id": "id-1" } },
                  "errors": [{ "message": "Some error occurred" }]
                }
            """.trimIndent()

            mockWebServer.enqueue(MockResponse().setBody(partialDataResponse).setResponseCode(200))

            // When
            val rawResponse = executor.execute(TestQuery())

            // Expect
            assertEquals("id-1", rawResponse.data.testQuery.id)
            assertEquals("Some error occurred", rawResponse.errors?.get(0)?.message)
        }
    }
}
