package com.expediagroup.sdk.core.pipeline.step

import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Request
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RequestHeadersStepTest {
    private lateinit var requestHeadersStep: RequestHeadersStep

    @BeforeEach
    fun setUp() {
        requestHeadersStep = RequestHeadersStep()
    }

    @Test
    fun `should add user-agent header`() {
        val testRequest =
            Request
                .builder()
                .url("https://example.com")
                .method(Method.POST)
                .build()

        val result = requestHeadersStep.invoke(testRequest)

        assertEquals(
            result.headers.values("user-agent"),
            listOf("expedia-group-test-sdk/1.0.0 (Provider/com.expediagroup; Java/1.8.0_432; Vendor/Azul Systems, Inc.; OS/Mac OS X - 15.2; Arch/aarch64; Locale/en_AE)"),
        )
    }
}
