package com.expediagroup.sdk.core.common

import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.Status
import com.expediagroup.sdk.core.interceptor.Interceptor
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RequestHeadersInterceptorTest {

    @Test
    fun `should add User-Agent header to the request`() {
        // Given
        val metadata = MetadataLoader.load("expedia-group-test-sdk")
        val interceptor = RequestHeadersInterceptor(metadata)

        val chain = object : Interceptor.Chain {
            override fun request(): Request = Request.builder()
                .url("https://example.com")
                .method(Method.GET)
                .build()

            override fun proceed(request: Request): Response = Response
                .builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .status(Status.OK)
                .message("OK")
                .build()
        }

        // When
        val response = interceptor.intercept(chain)
        val userAgentHeader = response.request.headers.get("User-Agent")!!

        // Expect
        assertTrue(userAgentHeader.contains("expedia-group-test-sdk/1.0.0-SNAPSHOT"))
        assertTrue(userAgentHeader.contains("Provider/com.expediagroup;"))
    }
}
