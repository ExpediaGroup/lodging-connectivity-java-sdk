package mocks

import com.google.api.client.http.LowLevelHttpRequest
import com.google.api.client.testing.http.MockHttpTransport
import com.google.api.client.testing.http.MockLowLevelHttpRequest
import com.google.api.client.testing.http.MockLowLevelHttpResponse
import java.util.Queue

class MockTransport(
    private val authResponse: MockLowLevelHttpResponse,
    private val apiResponse: MockLowLevelHttpResponse
): MockHttpTransport() {
    override fun buildRequest(method: String?, url: String?): LowLevelHttpRequest {
        requireNotNull(url)
        requireNotNull(method)

        val request: MockLowLevelHttpRequest = super.buildRequest(method, url) as MockLowLevelHttpRequest

        request.response = if (request.url.equals(Endpoint.AUTHENTICATION_ENDPOINT)) {
            apiResponse
        } else {
            apiResponse
        }

        return request
    }
}

class QueuedMockTransport(
    private val authResponses: Queue<MockLowLevelHttpResponse>,
    private val apiResponses: Queue<MockLowLevelHttpResponse>
): MockHttpTransport() {
    private var mockTransport: MockTransport? = null

    init {
        require(authResponses.isNotEmpty()) { "authResponses must not be empty" }
        require(apiResponses.isNotEmpty()) { "apiResponses must not be empty" }
    }

    private fun resetTransport() {
        val authResponse = authResponses.poll()
        val apiResponse = apiResponses.poll()

        mockTransport = MockTransport(authResponse, apiResponse)
    }

    override fun buildRequest(method: String?, url: String?): LowLevelHttpRequest {
        resetTransport()

        return mockTransport!!.buildRequest(method, url)
    }
}
