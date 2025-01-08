package com.expediagroup.sdk.graphql.common

import com.apollographql.apollo.api.toResponseJson
import com.expediagroup.sdk.core.client.AbstractRequestExecutor
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.core.okhttp.BaseOkHttpClient
import com.expediagroup.sdk.core.okhttp.OkHttpTransport
import com.expediagroup.sdk.graphql.model.exception.NoDataException
import io.mockk.mockk
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import testservice.TestMutation
import testservice.TestQuery
import testservice.type.buildTestData
import java.lang.reflect.InvocationTargetException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.jvm.isAccessible

class DefaultAbstractGraphQLExecutorTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var executor: GraphQLExecutor

    @BeforeEach
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        val serverUrl = mockWebServer.url("/graphql").toString()

        val requestExecutor =
            object : AbstractRequestExecutor(OkHttpTransport(BaseOkHttpClient.getInstance())) {
                override val interceptors: List<Interceptor> = emptyList()

                override fun execute(request: Request): Response = transport.execute(request)
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
            val testQueryData =
                TestQuery.Data {
                    testQuery =
                        buildTestData {
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
            val testMutationData =
                TestMutation.Data {
                    testMutation =
                        buildTestData {
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
            val exception =
                assertThrows<NoDataException> {
                    executor.execute(TestQuery())
                }

            // Expect
            assertEquals("No data received from the server", exception.message)
            assertEquals("Some error occurred", exception.errors[0].message)
        }

        @Test
        fun `should return partial data along with errors`() {
            // Given
            val partialDataResponse =
                """
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

        @Test // Impossible case
        fun `should throw ExpediaGroupServiceException if no data received from the server and errors list is empty`() {
            // Given
            val partialDataResponse =
                """
                {
                  "data": null,
                  "errors": []
                }
                """.trimIndent()

            mockWebServer.enqueue(MockResponse().setBody(partialDataResponse).setResponseCode(200))

            // When & Expect
            assertThrows<ExpediaGroupServiceException> {
                executor.execute(TestQuery())
            }
        }
    }

    @Nested
    inner class NonBlockingExecution {
        @Test
        fun `should execute graphql query successfully`() {
            // Given
            val testQueryData =
                TestQuery.Data {
                    testQuery =
                        buildTestData {
                            id = "Hello, world!"
                        }
                }

            mockWebServer.enqueue(MockResponse().setBody(testQueryData.toResponseJson()).setResponseCode(200))

            // When
            val future = executor.executeAsync(TestQuery())

            // Expect
            assertFalse(future.isDone) // Asserts that the execution isn't blocking
            assertEquals(
                "Hello, world!",
                future
                    .get()
                    .data.testQuery.id,
            )
        }

        @Test
        fun `should execute graphql mutation successfully`() {
            val testMutationData =
                TestMutation.Data {
                    testMutation =
                        buildTestData {
                            id = "Hello, world!"
                        }
                }

            mockWebServer.enqueue(MockResponse().setBody(testMutationData.toResponseJson()).setResponseCode(200))

            // When
            val future = executor.executeAsync(TestMutation())

            // Expect
            assertFalse(future.isDone) // Asserts that the execution isn't blocking
            assertEquals(
                "Hello, world!",
                future
                    .get()
                    .data.testMutation.id,
            )
        }

        @Test
        fun `should throw ExecutionException with ExpediaGroupServiceException as a cause if failed to get successful response`() {
            // Given
            mockWebServer.enqueue(MockResponse().setResponseCode(500))

            // When & Expect
            val exception =
                assertThrows<ExecutionException> {
                    executor.executeAsync(TestQuery()).get()
                }

            assertInstanceOf(ExpediaGroupServiceException::class.java, exception.cause)
            assertEquals(ExpediaGroupServiceException::class.java, exception.cause!!::class.java)
        }

        @Test
        fun `should throw ExecutionException with NoDataException as a cause if no data received from the server`() {
            // Given
            val errorResponse = """{"errors": [{ "message": "Some error occurred" }]}"""

            mockWebServer.enqueue(MockResponse().setBody(errorResponse).setResponseCode(200))

            // When & Expect
            val exception =
                assertThrows<ExecutionException> {
                    executor.executeAsync(TestQuery()).get()
                }

            assertInstanceOf(NoDataException::class.java, exception.cause)
            assertEquals(NoDataException::class.java, exception.cause!!::class.java)
        }
    }

    @Nested
    inner class ReflectionTests {
        @Test
        fun `getOrThrowDomainException throws ExecutionException if the underlying cause is not NoDataException or ExpediaGroupServiceException`() {
            // Given
            val future = CompletableFuture<String>()
            val underlyingCause = RuntimeException("something went wrong")
            future.completeExceptionally(ExecutionException(underlyingCause))

            val mockExecutor = GraphQLExecutor(mockk(), "https://example.com/graphql")

            val extensionFunction =
                GraphQLExecutor::class
                    .declaredFunctions
                    .first { it.name == "getOrThrowDomainException" }
                    .apply { isAccessible = true }

            // When & Expect
            assertThrows<ExecutionException> {
                try {
                    extensionFunction.call(mockExecutor, future)
                } catch (e: InvocationTargetException) {
                    throw e.targetException
                }
            }
        }

        @Test
        fun `getOrThrowDomainException wraps InterruptedException with ExpediaGroupServiceException when thread interruption occurs`() {
            val future = CompletableFuture<String>()
            val mockExecutor = GraphQLExecutor(mockk(), "https://example.com/graphql")

            val extensionFunction =
                GraphQLExecutor::class
                    .declaredFunctions
                    .first { it.name == "getOrThrowDomainException" }
                    .apply { isAccessible = true }

            // When
            Thread.currentThread().interrupt()

            val thrown =
                assertThrows<ExpediaGroupServiceException> {
                    try {
                        extensionFunction.call(mockExecutor, future)
                    } catch (e: InvocationTargetException) {
                        throw e.targetException
                    }
                }

            assertEquals("Interrupted while waiting for response", thrown.message)
            assertTrue(thrown.cause is InterruptedException)

            Thread.interrupted()
        }
    }
}
