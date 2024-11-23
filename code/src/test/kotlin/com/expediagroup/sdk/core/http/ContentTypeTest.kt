package com.expediagroup.sdk.core.http

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContentTypeTest {
    @Test
    fun `should return the corresponding enum value from MIME string`() {
        val contentType = ContentType.fromMimeType("application/json")
        assertEquals(contentType, ContentType.APPLICATION_JSON)
    }

    @Test
    fun `should return null when the MIME string does not map to any of the enum values`() {
        val contentType = ContentType.fromMimeType("foo/bar")
        assertEquals(contentType, null)
    }

}
